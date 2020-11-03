package com.example.dcs;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginPage extends AppCompatActivity {

    private EditText Email;
    private EditText Password;
    private Button Login;
    private Button userRegistration;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        Email = (EditText)findViewById(R.id.userlogemail);
        Password = (EditText)findViewById(R.id.userlogpassword);
        Login = (Button)findViewById(R.id.userlogin);
        userRegistration = (Button) findViewById(R.id.usercreatelog);


        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        if(user != null){
            startActivity(new Intent(LoginPage.this, IntractionPage.class));
            finish();
        }

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Email.getText().toString(), Password.getText().toString());
            }
        });

        userRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginPage.this, RegisterPage.class));
                finish();
            }
        });
    }

    private void validate(String userName, String userPassword) {

        progressDialog.setMessage("MAINTAIN SOCIAL DISTANCING");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(LoginPage.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginPage.this, AppointmentStatus.class));
                }else{
                    Toast.makeText(LoginPage.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
        });
    }



}

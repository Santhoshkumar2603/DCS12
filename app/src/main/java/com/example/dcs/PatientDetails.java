package com.example.dcs;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PatientDetails extends AppCompatActivity {

    EditText editTextpatname;
    EditText editTextpatemail;
    EditText editTextpatphno;

    Button buttonaddpat;



    private static final String TAG = "busticketbooking";

    List<ptdetails> patdetails;
    DatabaseReference databasepatients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);


        databasepatients = FirebaseDatabase.getInstance().getReference("patients");

        //getting views
        editTextpatname = (EditText) findViewById(R.id.newpatenname);
        editTextpatemail = (EditText) findViewById(R.id.newpatenmail);
        buttonaddpat = (Button) findViewById(R.id.newpatreg);
        editTextpatphno=(EditText) findViewById(R.id.newpatphno);

        //list to store name of the booker
        patdetails = new ArrayList<>();

        //checking whether they can book the ticket


        //adding an onclicklistener to button
        buttonaddpat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //the method is defined below
                //this method is actually performing the write operation
                addBus();
            }
        });

    }

    private void addBus() {
        //getting the values to save
        String name = editTextpatname.getText().toString().trim();
        String email = editTextpatemail.getText().toString().trim();
        String phoneno = editTextpatphno.getText().toString();


        //checking if the value is provided
        if (!TextUtils.isEmpty(name)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our name
            String id = databasepatients.push().getKey();

            //creating an name Object
            ptdetails patdetail = new ptdetails(id,name,email,phoneno);

            //Saving the name
            databasepatients.child(id).setValue(patdetail);

            //setting edittext to blank again
            editTextpatname.setText("");
            editTextpatemail.setText("");
            editTextpatphno.setText("");

            //displaying a success toast
            Toast.makeText(this, "YOU ARE REGISTERED SUCCESSFULLY", Toast.LENGTH_LONG).show();
            startActivity(new Intent(PatientDetails.this, AppointmentFixing.class));
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter the deatils", Toast.LENGTH_LONG).show();
        }
    }

}

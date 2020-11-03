package com.example.dcs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class AppointmentFixing extends AppCompatActivity {

    EditText appointername,appointerage,appointerdob,appointerphone,appointeraddress,appointmenttime,appointmentdate;
    Spinner appointerbloodgrp,appointmentdprt,appointergender;
    Button fixtheappointment;
    List<Appointmentpatient> appointment;
    DatabaseReference databaseappointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_fixing);

        appointername = (EditText) findViewById(R.id.editTextappointername);
        appointerage = (EditText) findViewById(R.id.editTextappointerage);
        appointerdob = (EditText) findViewById(R.id.editTextappointerdob);
        appointerphone = (EditText) findViewById(R.id.editTextappointerphone);
        appointeraddress = (EditText) findViewById(R.id.editTextappointeraddress);
        appointmenttime = (EditText) findViewById(R.id.editTextappointertime);
        appointmentdate = (EditText) findViewById(R.id.editTextappointerdate);
        appointerbloodgrp = (Spinner) findViewById(R.id.appointerbloodgrp);
        appointmentdprt = (Spinner) findViewById(R.id.appointerbookdprt);
        appointergender =(Spinner) findViewById(R.id.appointergender);
        fixtheappointment = (Button) findViewById(R.id.fixtheappointer);

        databaseappointment = FirebaseDatabase.getInstance().getReference("AppointmentFixing");

        appointment = new ArrayList<>();

        //checking whether they can book the ticket


        //adding an onclicklistener to button
        fixtheappointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //the method is defined below
                //this method is actually performing the write operation
                    fixappointment();
            }
        });

    }

    private void fixappointment() {
        //getting the values to save
        String name = appointername.getText().toString().trim();
        String age = appointerage.getText().toString().trim();
        String Dob = appointerdob.getText().toString().trim();
        String phone = appointerphone.getText().toString().trim();
        String address = appointeraddress.getText().toString().trim();
        String time = appointmenttime.getText().toString().trim();
        String date = appointmentdate.getText().toString().trim();
        String gender = appointergender.getSelectedItem().toString();
        String Deprt = appointmentdprt.getSelectedItem().toString();
        String bloodgrp = appointerbloodgrp.getSelectedItem().toString();

        //checking if the value is provided
        if (!TextUtils.isEmpty(name)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our name
            String id = databaseappointment.push().getKey();

            //creating an name Object
            Appointmentpatient appointmentpatient = new Appointmentpatient(id, name,age,Dob,phone,address,bloodgrp,gender,Deprt,time,date);

            //Saving the name
            databaseappointment.child(id).setValue(appointmentpatient);

            //setting edittext to blank again
            appointername.setText("");
            appointerage.setText("");
            appointerdob.setText("");
            appointerphone.setText("");
            appointeraddress.setText("");
            appointmenttime.setText("");
            appointmentdate.setText("");


            //displaying a success toast
            Toast.makeText(this, "Appointment Fixed", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter all details", Toast.LENGTH_LONG).show();
        }
    }




}
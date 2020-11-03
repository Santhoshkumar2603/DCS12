package com.example.dcs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AppointmentStatus extends AppCompatActivity {


    public ListView listViewBusestime;
    List<Appointmentpatient> busestime;
    DatabaseReference  databaseBustime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_status);

        databaseBustime = FirebaseDatabase.getInstance().getReference("AppointmentFixing");
        listViewBusestime = (ListView) findViewById(R.id.listViewappoints);

        busestime = new ArrayList<>();

    }

    @Override
    protected void onStart() {
        super.onStart();
        //attaching value event listener
        databaseBustime.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                busestime.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    Appointmentpatient busno = postSnapshot.getValue(Appointmentpatient.class);
                    //adding artist to the list
                    busestime.add(busno);
                }

                //creating adapter
                Appointmentpatientlist BustimeAdapter = new Appointmentpatientlist(AppointmentStatus.this, busestime);
                //attaching adapter to the listview
                listViewBusestime.setAdapter(BustimeAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
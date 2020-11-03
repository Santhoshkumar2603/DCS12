package com.example.dcs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class IntractionPage extends AppCompatActivity {

    EditText editTextbusstop1;

    Button   sendbtn;
    public ListView listViewBusestime;
    List<MsgConv> busestime;
    DatabaseReference databaseBustime;
    private TextView badge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intraction_page);

        databaseBustime = FirebaseDatabase.getInstance().getReference("patdocconv");
        listViewBusestime = (ListView) findViewById(R.id.listViewmsg);

        //getting views
        editTextbusstop1 = (EditText) findViewById(R.id.chattext);
        badge = (TextView) findViewById(R.id.badgecount);
        sendbtn=(Button)findViewById(R.id.sendbtn);
        //list to store name of the booker
        busestime = new ArrayList<>();

        //checking whether they can book the ticket


        //adding an onclicklistener to button
       sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //the method is defined below
                //this method is actually performing the write operation

                addBustime();

            }
            });

    }


    private void addBustime() {
        //getting the values to save
        String busstop1 = editTextbusstop1.getText().toString().trim();
        //checking if the value is provided
        if (!TextUtils.isEmpty(busstop1)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our name
            String id = databaseBustime.push().getKey();

            //creating an name Object
            MsgConv msgConv = new MsgConv(id, busstop1);

            //Saving the name
            databaseBustime.child(id).setValue(msgConv);

            //setting edittext to blank again
            editTextbusstop1.setText("");

            //displaying a success toast
        }
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
                    MsgConv busno = postSnapshot.getValue(MsgConv.class);
                    //adding artist to the list
                    busestime.add(busno);
                }

                badge.setText(dataSnapshot.getChildrenCount()+"");
                //creating adapter
                ConvMsg BustimeAdapter = new ConvMsg(IntractionPage.this, busestime);
                //attaching adapter to the listview
                listViewBusestime.setAdapter(BustimeAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
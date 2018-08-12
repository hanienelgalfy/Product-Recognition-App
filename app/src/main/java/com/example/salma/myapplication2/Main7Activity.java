package com.example.salma.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Main7Activity extends AppCompatActivity {

    EditText name;
    Button search;
    DatabaseReference databaseInputs;
    ArrayList RetrievedInput1 ;
    ArrayList RetrievedInput2 ;
    Intent i ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        name = findViewById(R.id.editTextproduct);
        search = findViewById(R.id.searchproduct);
        databaseInputs = FirebaseDatabase.getInstance().getReference("inputs");
        i =new Intent(this ,Main6Activity.class);
    }

    public void showPrice(View view){
        RetrievedInput1 = new ArrayList() ;
        RetrievedInput2 = new ArrayList() ;
        databaseInputs.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot InputSnapshot :dataSnapshot.getChildren()){
                    Inputs input= InputSnapshot.getValue(Inputs.class);
                    RetrievedInput1.add(input.getInput1()) ;
                    RetrievedInput2.add(input.getInput2()) ;
                    // I1.getText().toString().trim()


                }





                i.putExtra("FromUserInput1" ,name.getText().toString().trim()) ;
                i.putStringArrayListExtra("RetrievedInput1", RetrievedInput1);
                i.putStringArrayListExtra("RetrievedInput2", RetrievedInput2);
                startActivity(i) ;



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}

package com.example.salma.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class Main6Activity extends Activity {
    ListView  lv ;
    ArrayList RetrievedInput1 ;
    ArrayList RetrievedInput2 ;
    TextView textView2 ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        lv = findViewById(R.id.lv);
        textView2 =findViewById(R.id. textView2 );
        Intent i = getIntent();
        RetrievedInput1 = new ArrayList<String>();

        RetrievedInput1 = i.getStringArrayListExtra("RetrievedInput1");
        RetrievedInput2 = new ArrayList<String>();

        RetrievedInput2 = i.getStringArrayListExtra("RetrievedInput2");
        String FromUserInput1 =i.getExtras().getString("FromUserInput1").toString() ;
        ArrayList <Integer>index = new ArrayList<Integer>();
        for(int x=0 ;x< RetrievedInput1.size() ;x++){
            if(FromUserInput1.equals(RetrievedInput1.get(x)))
                index.add(x) ;
        }
        ArrayList<Integer> Values = new ArrayList<Integer>();

            for (int j = 0; j < index.size(); j++) {

                Values.add(Integer.parseInt(RetrievedInput2.get(index.get(j)).toString()));
            }
            int minVal = Collections.min(Values);


            final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Values);
            lv.setAdapter(adapter);
            textView2.setText("minimum Price :" + minVal);


    }



}

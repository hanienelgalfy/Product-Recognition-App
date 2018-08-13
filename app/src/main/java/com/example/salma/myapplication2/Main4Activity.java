package com.example.salma.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Main4Activity extends AppCompatActivity {

    Button search ;
    Button add ;
    Intent i ;
    Intent x ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        search = findViewById(R.id.searchFor);
        add =findViewById(R.id.addProduct);
        i = new Intent(this ,Main5Activity.class);
        x =new Intent(this ,Main7Activity.class);


    }
    public void Search(View view){

        startActivity(x) ;

    }
    public void addproduct(View view){
        startActivity(i) ;
    }
}


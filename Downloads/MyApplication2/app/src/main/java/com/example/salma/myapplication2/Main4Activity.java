package com.example.salma.myapplication2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class Main4Activity extends AppCompatActivity {

    Button search ;
    Button add ;
    Button scan ;
    Intent i ;
    Intent x ;
    Intent z ;
    final Activity activity=this ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        search = findViewById(R.id.searchFor);
        add =findViewById(R.id.addProduct);
        scan = findViewById(R.id.scan);
        i = new Intent(this ,Main5Activity.class);
        x =new Intent(this ,Main7Activity.class);


    }
    public void Search(View view){

        startActivity(x) ;

    }
    public void addproduct(View view){
        startActivity(i) ;
    }
    public void scan(View view){
        IntentIntegrator integrator =new IntentIntegrator(activity) ;
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES) ;
        integrator.setPrompt("Scan") ;
        integrator.setCameraId(0);
        integrator.setBeepEnabled(false) ;
        integrator.setBarcodeImageEnabled(false) ;
        integrator.initiateScan();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){
            if(result.getContents()==null){
                Toast.makeText(this, "You cancelled the scanning", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}


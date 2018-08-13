package com.example.salma.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button signIn ;
    Button SignUp ;
    Intent i ;
    Intent x ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signIn = findViewById(R.id.signIn);
        SignUp =findViewById(R.id.signUp);
        i = new Intent(this ,Main2Activity.class);
        x =new Intent(this ,Main3Activity.class);


    }
public void SignIn(View view){

    startActivity(i) ;

}
public void signUp(View view){
    startActivity(x) ;
}
}

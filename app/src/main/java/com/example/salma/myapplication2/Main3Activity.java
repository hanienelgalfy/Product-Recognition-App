package com.example.salma.myapplication2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main3Activity extends AppCompatActivity {
 Intent i ;
    EditText email;
     EditText username;
     EditText age;
     EditText password;
    ProgressDialog progressDialog;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        i = new Intent(this ,Main4Activity.class);
       progressDialog = new ProgressDialog(this);
       firebaseAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
         age = findViewById(R.id.age);
        password = findViewById(R.id.password);
       // Button signup = (findViewById(R.id.signup1));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }
    public void registerUser(){
        String email2 =email.getText().toString().trim();
        String username2 =username.getText().toString().trim();
        String age2 =age.getText().toString().trim();
        String password2 =password.getText().toString().trim();

        if(TextUtils.isEmpty(email2) ){
            Toast.makeText(this,"Please enter email", Toast.LENGTH_SHORT ).show();
               return;}

        if(TextUtils.isEmpty(username2) ){
            Toast.makeText(this,"Please enter username", Toast.LENGTH_SHORT ).show();
                 return;}
        if(TextUtils.isEmpty(age2) ){
            Toast.makeText(this,"Please enter age", Toast.LENGTH_SHORT ).show();
                  return;}
        if(TextUtils.isEmpty(password2) ){
            Toast.makeText(this,"Please enter password", Toast.LENGTH_SHORT ).show();
                return;}

                progressDialog.setMessage("Registering User ....");
                progressDialog.show();
                firebaseAuth.createUserWithEmailAndPassword(email2,password2)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(Main3Activity.this, "Registered Successfully" , Toast.LENGTH_SHORT).show();
                                    startActivity(i) ;
                                }else
                                    Toast.makeText(Main3Activity.this,"Could not register .. please try again",  Toast.LENGTH_SHORT).show();
                            }
                        });

        }


    public void signup1(View view){

      registerUser();



    }
}

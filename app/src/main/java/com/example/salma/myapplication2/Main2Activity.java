package com.example.salma.myapplication2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity {
    Intent  i;
    Intent  i2;
    EditText email;
    EditText etpassword;
    ProgressDialog progressDialog;

    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        i  = new Intent(this ,Main4Activity.class);
        i2 = new Intent(this ,Main3Activity.class);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
//        if(firebaseAuth.getCurrentUser()!= null){
//            startActivity(i) ;
//        }
         email = findViewById(R.id.editText);
         etpassword = findViewById(R.id.editText2);
        Button signIn =findViewById(R.id.signin1);
        TextView etregister = findViewById(R.id.textView);


    }

    public void login(){
        String email2 = email.getText().toString().trim();
        String password =  etpassword.getText().toString().trim();

        if(TextUtils.isEmpty(email2) ){
            Toast.makeText(this,"Please enter username", Toast.LENGTH_SHORT ).show();
            return;}

        if(TextUtils.isEmpty(password) ){
            Toast.makeText(this,"Please enter password", Toast.LENGTH_SHORT ).show();
            return;}

        progressDialog.setMessage("signing in ....");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email2,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            finish();
                            startActivity(i) ;
                        }

                    }
                });


    }
    public void signin1(View view){

        login();
        startActivity(i) ;


    }
    public void signup(View view){

        startActivity(i2) ;

    }
}

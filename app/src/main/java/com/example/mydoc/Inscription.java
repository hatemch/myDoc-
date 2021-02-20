package com.example.mydoc;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Inscription extends AppCompatActivity {

    FirebaseAuth auth;
    EditText eMail, password;
    Button inscription ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_inscription );

         eMail = (EditText) findViewById( R.id.email ) ;
         password = (EditText) findViewById( R.id.password ) ;
         inscription = (Button) findViewById( R.id.inscrir)  ;

        auth = FirebaseAuth.getInstance();


    }

    public void  createUser(View v)
    {
        if (eMail.getText().toString().equals( "" ) && password.getText().toString().equals( "" )) {
            Toast.makeText( getApplicationContext(), "Blank not allowed", Toast.LENGTH_SHORT ).show();
        } else {
            String email = eMail.getText().toString();
            String mpassword = password.getText().toString();

            auth.createUserWithEmailAndPassword( email, mpassword).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText( getApplicationContext(), "User created successfully", Toast.LENGTH_SHORT ).show();
                        Intent i = new Intent( getApplicationContext(), MainActivity.class );
                        startActivity( i );
                    } else {
                        Toast.makeText( getApplicationContext(), "User could not be created", Toast.LENGTH_SHORT ).show();
                    }
                }
            } );

        }
    }
}

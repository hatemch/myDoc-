package com.example.mydoc;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
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

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    Button b1, b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        b1 = (Button) findViewById( R.id.btDocteur );

        b3 = (Button) findViewById( R.id.btPatient );

        auth = FirebaseAuth.getInstance();


 /* fragment pour l'authentification de secretaire */

      /*  b2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder( MainActivity.this );
                View mView = getLayoutInflater().inflate( R.layout.login_secretaire, null );

                final EditText mEmail = (EditText) mView.findViewById(R.id.email);
                final EditText mPassword = (EditText) mView.findViewById(R.id.password);
                Button mLogin = (Button) mView.findViewById(R.id.login);
                mLogin.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (mEmail.getText().toString().equals("") && mPassword.getText().toString().equals(""))
                        {
                            Toast.makeText( getApplicationContext(), "Blank fields not allowed",Toast.LENGTH_SHORT ).show();
                        }
                        else
                        {
                            auth.signInWithEmailAndPassword( mEmail.getText().toString(),mPassword.getText().toString() ).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful())
                                    {
                                        Toast.makeText( getApplicationContext(), "User logged in successfully", Toast.LENGTH_SHORT ).show();
                                        Intent i = new Intent( getApplicationContext(),EspaceSecretaire.class );
                                        startActivity(i);
                                    }
                                    else
                                    {
                                        Toast.makeText( getApplicationContext(),"User could not be logged in",Toast.LENGTH_SHORT ).show();
                                    }
                                }
                            } );
                        }

                    }
                } );

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();

            }


        } );*/

        /* fragment pour l'authentification de docteur */

        b1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder( MainActivity.this );
                View mView = getLayoutInflater().inflate( R.layout.login_docteur, null );

                final EditText mEmail = (EditText) mView.findViewById(R.id.email);
                final EditText mPassword = (EditText) mView.findViewById(R.id.password);
                Button mLogin = (Button) mView.findViewById(R.id.login);
                mLogin.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (mEmail.getText().toString().equals("") && mPassword.getText().toString().equals(""))
                        {
                            Toast.makeText( getApplicationContext(), "Blank fields not allowed",Toast.LENGTH_SHORT ).show();
                        }
                        else
                        {
                            auth.signInWithEmailAndPassword( mEmail.getText().toString(),mPassword.getText().toString() ).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful())
                                    {
                                        Toast.makeText( getApplicationContext(), "User logged in successfully", Toast.LENGTH_SHORT ).show();
                                        Intent i = new Intent( getApplicationContext(),EspaceDocteur.class );
                                        startActivity(i);
                                    }
                                    else
                                    {
                                        Toast.makeText( getApplicationContext(),"User could not be logged in",Toast.LENGTH_SHORT ).show();
                                    }
                                }
                            } );
                        }

                    }
                } );

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();

            }


        } );

        /* fragment pour l'authentification de patient */

        b3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder( MainActivity.this );
                View mView = getLayoutInflater().inflate( R.layout.login_patient, null );

                final EditText mEmail = (EditText) mView.findViewById(R.id.email);
                final EditText mPassword = (EditText) mView.findViewById(R.id.password);
                Button mLogin = (Button) mView.findViewById(R.id.login);
                Button mInscription = (Button) mView.findViewById( R.id.inscription ) ;

                //connecter et verification des champs

                mLogin.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (mEmail.getText().toString().equals("") && mPassword.getText().toString().equals(""))
                        {
                            Toast.makeText( getApplicationContext(), "Blank fields not allowed",Toast.LENGTH_SHORT ).show();
                        }
                        else
                        {
                            auth.signInWithEmailAndPassword( mEmail.getText().toString(),mPassword.getText().toString() ).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful())
                                    {
                                        Toast.makeText( getApplicationContext(), "User logged in successfully", Toast.LENGTH_SHORT ).show();
                                        Intent i = new Intent( getApplicationContext(),EspacePatient.class );
                                        startActivity(i);
                                    }
                                    else
                                    {
                                        Toast.makeText( getApplicationContext(),"User could not be logged in",Toast.LENGTH_SHORT ).show();
                                    }
                                }
                            } );
                        }

                    }
                } );

                //inscription des patient

                mInscription.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent i = new Intent(getApplicationContext(),Inscription.class);
                        startActivity( i );

                    }
                } );


                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();

            }


        } );




    }


    }


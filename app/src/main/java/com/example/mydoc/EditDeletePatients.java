package com.example.mydoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class EditDeletePatients extends AppCompatActivity {

    FirebaseDatabase database ;
    private DatabaseReference databaseReference ;

    EditText editTextNom ;
    EditText editTextPrenom;
    EditText editTextCin;
    EditText editTextEmail ;
    EditText editTextAge ;
    EditText editTextAdresse ;
    EditText editTextPhone ;

    Button buttonRetour ;
    Button buttonEdit ;
    Button buttonDelete ;

    private String key ;
    private String nom ;
    private String prenom ;
    private String eMail ;
    private String phone ;
    private String cin ;
    private String age ;
    private String adrese ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_edit_delete_patients );

        key = getIntent().getStringExtra( "Key" );
        nom = getIntent().getStringExtra( "Nom" );
        prenom = getIntent().getStringExtra( "Prenom" );
        eMail = getIntent().getStringExtra( "Email" );
        phone = getIntent().getStringExtra( "Phone" );
        age = getIntent().getStringExtra( "Age" );
        cin = getIntent().getStringExtra( "Cin" );
        adrese = getIntent().getStringExtra( "Adresse" );



        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference( "Patient");

        editTextNom = (EditText) findViewById( R.id.editTextNom );
        editTextNom.setText( nom );

        editTextPrenom = (EditText) findViewById( R.id.editTextPrenom );
        editTextPrenom.setText( prenom );

        editTextCin = (EditText) findViewById( R.id.editTextCin );
        editTextCin.setText( cin );

        editTextEmail = (EditText) findViewById( R.id.editTextEmail );
        editTextEmail.setText( eMail );

        editTextAge = (EditText) findViewById( R.id.editTextAge );
        editTextAge.setText( age );

        editTextAdresse = (EditText) findViewById( R.id.editTextAdresse );
        editTextAdresse.setText( adrese );

        editTextPhone = (EditText) findViewById( R.id.editTextPhone );
        editTextPhone.setText( phone );

        buttonEdit = (Button) findViewById( R.id.buttonEdit );
        buttonDelete = (Button) findViewById( R.id.buttonDelete );
        buttonRetour = (Button) findViewById( R.id.buttonRetour );

        buttonEdit.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Patient patient = new Patient( );
                patient.setNom( editTextNom.getText().toString() );
                patient.setPrenom( editTextPrenom.getText().toString() );
                patient.setEmail( editTextEmail.getText().toString() );
                patient.setAge( editTextAge.getText().toString() );
                patient.setAdresse( editTextAdresse.getText().toString() );
                patient.setTel( editTextPhone.getText().toString() );
                patient.setCin( editTextCin.getText().toString() );

                new FirebaseDatabaseHelper().upDatePatient( key, patient, new FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Patient> patients, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {

                        Toast.makeText( EditDeletePatients.this, "Patient has been updated succesfully ...", Toast.LENGTH_LONG ).show();

                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                } );

            }
        } );

        buttonDelete.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FirebaseDatabaseHelper().deletePatient( key, new FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Patient> patients, List<String> Keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {

                        Toast.makeText( EditDeletePatients.this, "Patient has been deleted succesfuly ...", Toast.LENGTH_LONG ).show();
                        finish();return;
                    }
                } );
            }
        } );
        buttonRetour.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( EditDeletePatients.this,ConsulterListPatients.class );
                startActivity(intent);

            }
        } );
    }



}

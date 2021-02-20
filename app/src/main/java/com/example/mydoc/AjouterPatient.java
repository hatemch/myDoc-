package com.example.mydoc;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AjouterPatient extends AppCompatActivity {

    FirebaseDatabase database ;
    DatabaseReference databaseReference ;

    private Patient patient ;
    public static String patientid;

    EditText editTextNom ;
    EditText editTextPrenom;
    EditText editTextCin;
    EditText editTextEmail ;
    EditText editTextAge ;
    EditText editTextAdresse ;
    EditText editTextPhone ;

    Button buttonRetour ;
    Button buttonAdd ;
    RecyclerView recyclerViewPatients ;
    private ArrayList<Patient> arrayAdapter = new ArrayList<>(  );
    private ArrayAdapter<Patient> adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.fragment_ajouter_patient );

        editTextNom = (EditText) findViewById( R.id.editTextNom );
        editTextPrenom = (EditText) findViewById( R.id.editTextPrenom );
        editTextCin = (EditText) findViewById( R.id.editTextCin );
        editTextEmail = (EditText) findViewById( R.id.editTextEmail );
        editTextAge = (EditText) findViewById( R.id.editTextAge );
        editTextAdresse = (EditText) findViewById( R.id.editTextAdresse );
        editTextPhone = (EditText) findViewById( R.id.editTextPhone );
        buttonAdd = (Button) findViewById( R.id.buttonAjouter );
        buttonRetour = (Button) findViewById( R.id.buttonRetour );

        recyclerViewPatients = (RecyclerView) findViewById( R.id.recyclerViewPatients );

        adapter = new ArrayAdapter<Patient>(this, android.R.layout.simple_list_item_1, arrayAdapter  );

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference( "Patient");

        patient = new Patient( );



        buttonRetour.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( AjouterPatient.this,EspaceDocteur.class );
                startActivity(intent);
            }
        } );

        buttonAdd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getValues();

                if (TextUtils.isEmpty( patientid )) {

                    String id = databaseReference.push().getKey();

                    Patient patient = new Patient( id,  editTextNom.getText().toString(),  editTextPrenom.getText().toString(),  editTextAdresse.getText().toString(),  editTextPhone.getText().toString(),  editTextEmail.getText().toString(),  editTextAge.getText().toString(),  editTextCin.getText().toString()  );

                    databaseReference.child( id ).setValue( patient );




                   /* databaseReference.push().setValue( editTextNom.getText().toString() );
                    databaseReference.push().setValue( editTextPrenom.getText().toString() );
                    databaseReference.push().setValue( editTextEmail.getText().toString() );
                    databaseReference.push().setValue( editTextCin.getText().toString() );
                    databaseReference.push().setValue( editTextAdresse.getText().toString() );
                    databaseReference.push().setValue( editTextPhone.getText().toString() );
                    databaseReference.push().setValue( editTextAge.getText().toString() );*/

                    Toast.makeText( AjouterPatient.this, "Data inserted ...", Toast.LENGTH_LONG ).show();
                }
                editTextNom.setText( "" );
                editTextPrenom.setText( "" );
                editTextAdresse.setText( "" );
                editTextCin.setText( "" );
                editTextAge.setText( "" );
                editTextPhone.setText( "" );
                editTextEmail.setText( "" );


              /*  Intent intent1 = new Intent( AjouterPatient.this,EspaceDocteur.class );
                startActivity(intent1);*/
            }
        } );


    }

    private void getValues()
    {

        patient.setNom(editTextNom.getText().toString());
        patient.setPrenom(editTextPrenom.getText().toString());
        patient.setAdresse(editTextAdresse.getText().toString());
        patient.setCin(editTextCin.getText().toString());
        patient.setAge(editTextAge.getText().toString());
        patient.setTel(editTextPhone.getText().toString());
        patient.setEmail(editTextEmail.getText().toString());
    }
}

package com.example.mydoc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AjouterRDV extends AppCompatActivity {

    FirebaseDatabase database ;
    DatabaseReference databaseReferenceRDV ;

    private RDV appointment ;
    public static String appointmentId;

    EditText editTextNom ;
    EditText editTextPrenom;
    EditText editTextDate;
    EditText editTextHeur ;
    EditText editTextPhone ;
    EditText editTextEmail ;

    Button buttonRetour ;
    Button buttonAdd ;
    RecyclerView recyclerViewRDV ;
    private ArrayList<RDV> arrayAdapterRDV = new ArrayList<>(  );
    private ArrayAdapter<RDV> rdvAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.fragment_ajouter_rendez_vous );

        editTextNom = (EditText) findViewById( R.id.editTextNom );
        editTextPrenom = (EditText) findViewById( R.id.editTextPrenom );
        editTextDate = (EditText) findViewById( R.id.editTextDate );
        editTextHeur = (EditText) findViewById( R.id.editTextHeur );
        editTextPhone = (EditText) findViewById( R.id.editTextPhone );
        buttonAdd = (Button) findViewById( R.id.buttonAjouter );
        editTextEmail = (EditText) findViewById( R.id.editTextEmail );
        buttonRetour = (Button) findViewById( R.id.buttonRetour );

        recyclerViewRDV = (RecyclerView) findViewById( R.id.recyclerViewRDV );

        rdvAdapter = new ArrayAdapter<RDV>(this, android.R.layout.simple_list_item_1, arrayAdapterRDV  );

        database = FirebaseDatabase.getInstance();
        databaseReferenceRDV = database.getReference( "RendezVous");

        appointment = new RDV( );



        buttonRetour.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( AjouterRDV.this,EspaceDocteur.class );
                startActivity(intent);
            }
        } );

        buttonAdd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getValuesRDV();

                if (TextUtils.isEmpty( appointmentId )) {

                    String id = databaseReferenceRDV.push().getKey();

                    RDV appointment = new RDV( id,  editTextNom.getText().toString(),
                            editTextPrenom.getText().toString(), editTextDate.getText().toString(),
                            editTextHeur.getText().toString(), editTextEmail.getText().toString(), editTextPhone.getText().toString()  );

                    databaseReferenceRDV.child( id ).setValue( appointment );


                    Toast.makeText( AjouterRDV.this, "Data inserted ...", Toast.LENGTH_LONG ).show();
                }

                editTextNom.setText( "" );
                editTextPrenom.setText( "" );
                editTextDate.setText( "" );
                editTextHeur.setText( "" );
                editTextPhone.setText( "" );
                editTextEmail.setText( "" );

               /* Intent intent1 = new Intent( AjouterRDV.this,EspaceDocteur.class );
                startActivity(intent1);*/
            }
        } );


    }

    private void getValuesRDV()
    {

        appointment.setNom(editTextNom.getText().toString());
        appointment.setPrenom(editTextPrenom.getText().toString());
        appointment.setDateRDV(editTextDate.getText().toString());
        appointment.setHeurRDV(editTextHeur.getText().toString());
        appointment.setTel(editTextPhone.getText().toString());
        appointment.setEmail( editTextEmail.getText().toString() );
    }
}

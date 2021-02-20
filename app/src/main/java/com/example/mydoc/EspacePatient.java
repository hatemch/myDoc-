package com.example.mydoc;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Calendar;

public class EspacePatient extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    private static final boolean TODO = true;
    FirebaseAuth auth ;
    Button ajoutCordonnees, buttonConsulterListRDV  ;

    FirebaseDatabase database ;
    DatabaseReference ref ;
    Patient patient ;



    public static String patientid;
    EditText nom ;
    EditText prenom ;
    EditText cin ;
    EditText adress ;
    EditText tel ;
    EditText email;
    EditText age ;
    Button prendreRDV ;

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_espace_patient );

        auth = FirebaseAuth.getInstance();
        //user = auth.getCurrentUser();
        //UsersRef = FirebaseDatabase.getInstance().getReference().child("Users");

        ajoutCordonnees = (Button)findViewById( R.id.btnAjoutCordonnee );
        ajoutCordonnees.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( EspacePatient.this,AjouterPatient.class );
                startActivity(intent);
            }
        } );

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        TextView textViewDate = findViewById(R.id.text_view_date);
        textViewDate.setText(currentDate);

        /*


        //storageReference = FirebaseStorage.getInstance().getReference().child("images");

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View navView = navigationView.inflateHeaderView(R.layout.header);

        //ProfileImage = (ImageView) navView.findViewById(R.id.nav_profile_image);
        ProfileNom = (TextView) navView.findViewById(R.id.name);

        UsersRef.child(currentUserID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    String nom = dataSnapshot.child("name").getValue().toString();
                   // String image = dataSnapshot.child("profileImage").getValue().toString();
                    ProfileNom.setText(nom);
                   // Picasso.get().load(image).placeholder(R.drawable.userphoto).into(ProfileImage);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        */

       /* ajoutCordonnees.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(EspacePatient.this);
                View mView = getLayoutInflater().inflate(R.layout.formulaire_ajout_cordonnees,null);

                nom = (EditText) mView.findViewById(R.id.edtNom);
                prenom = (EditText) mView.findViewById(R.id.edtPrenom);
                cin = (EditText) mView.findViewById(R.id.cin);
                adress = (EditText) mView.findViewById(R.id.edtAdresse);
                tel = (EditText) mView.findViewById(R.id.edtTel);
                email = (EditText) mView.findViewById(R.id.edtemail);
                age = (EditText) mView.findViewById(R.id.edtAge);
                Button bajout = (Button) mView.findViewById(R.id.btnAdd);
                database = FirebaseDatabase.getInstance();
                ref = database.getReference( "Patient");
                patient = new Patient();

                bajout.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (TextUtils.isEmpty( patientid ))
                        {

                           //Save

                            String id = ref.push().getKey();
                            Patient patient;
                            patient = new Patient( id, nom.getText().toString(),  prenom.getText().toString(),  adress.getText().toString(),  tel.getText().toString(),  email.getText().toString(),  age.getText().toString(),  cin.getText().toString() );

                            ref.child( id ).setValue( patient );

                            Toast.makeText( EspacePatient.this, "Data inserted ...",Toast.LENGTH_LONG ).show();

                        }



                    }



                } );



                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();

            }



        } );*/

        prendreRDV = (Button) findViewById( R.id.buttonPredreRendezVous );
        prendreRDV.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( EspacePatient.this,AjouterRDV.class );
                startActivity(intent);

            }
        } );

        buttonConsulterListRDV = (Button) findViewById( R.id.buttonConsulterListeRendezVous );
        buttonConsulterListRDV.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent( EspacePatient.this,ConsulterListRDV.class );
                startActivity(intent3);
            }
        } );

        Toolbar toolbar = findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        drawer = findViewById( R.id.draw_layout );

        NavigationView navigationView = findViewById( R.id.nav_view );
        navigationView.setNavigationItemSelectedListener( this );
        //View navView = navigationView.inflateHeaderView(R.layout.nav_header);

        //ProfileImage = (ImageView) navView.findViewById(R.id.nav_profile_image);
        /*final TextView profilNom = (TextView) navView.findViewById(R.id.textViewNom);
        UsersRef.child(user).addValueEventListener( new ValueEventListener() {
                                                        @Override
                                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                                            if(dataSnapshot.exists())
                                                            {
                                                                String nom = dataSnapshot.child("name").getValue().toString();
                                                                // String image = dataSnapshot.child("profileImage").getValue().toString();
                                                                profilNom.setText(nom);
                                                                // Picasso.get().load(image).placeholder(R.drawable.userphoto).into(ProfileImage);
                                                            }

                                                        }

                                                        @Override
                                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                                        }
                                                    });*/

                ActionBarDrawerToggle toggle = new ActionBarDrawerToggle( this, drawer, toolbar,
                        R.string.navigation_drawer_open, R.string.navigation_drawer_close );

        drawer.addDrawerListener( toggle );
        toggle.syncState();



        }

    public  void annuler(View v)
    {
        Intent i = new Intent( this,EspacePatient.class );
        startActivity(i);
    }

    public void signout(View v)
    {
        auth.signOut();
        finish();
        Intent i = new Intent( this,MainActivity.class );
        startActivity(i);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {

            case R.id.nav_message:
                getSupportFragmentManager().beginTransaction().replace( R.id.fragment_container,
                        new MessageFragment() ).commit();
                break;

            case R.id.nav_call:
                Uri uri = Uri.parse( "tel:20665478" );
                Intent intent = new Intent( Intent.ACTION_CALL, uri );
                if (ActivityCompat.checkSelfPermission( this, Manifest.permission.CALL_PHONE ) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return TODO;
                }
                startActivity( intent );
                break;

            case R.id.nav_localisation :

                getSupportFragmentManager().beginTransaction().replace( R.id.fragment_container,
                        new LocalisationFragment()).commit();
                break;

            case R.id.nav_info :
                Toast.makeText( this, "Bienvenu à notre site web", Toast.LENGTH_SHORT ).show();

                Uri u=Uri.parse("http://www.google.fr/");
                Intent i = new Intent (Intent.ACTION_VIEW, u);
                startActivity(i);
                break;

            case R.id.nav_contact :
                Toast.makeText( this, "Nos contact", Toast.LENGTH_SHORT ).show();
                //Intent intent1 = new Intent( this,MainActivity.class );
               // startActivity(intent1);
                getSupportFragmentManager().beginTransaction().replace( R.id.fragment_container,
                        new ContactFragment() ).commit();
                break;

        }

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen( GravityCompat.START )) {
            drawer.closeDrawer( GravityCompat.START );
        } else {
            super.onBackPressed();
        }
    }

}

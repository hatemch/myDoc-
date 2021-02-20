package com.example.mydoc;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ConsulterListPatients extends AppCompatActivity {


   private RecyclerView recyclerView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.fragment_consulter__liste__patient );

        recyclerView = (RecyclerView) findViewById( R.id.recyclerViewPatients );

        new FirebaseDatabaseHelper().readPatients( new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Patient> patients, List<String> keys) {

                new RecyclerView_Config().setConfig( recyclerView, ConsulterListPatients.this, patients, keys);

            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        } );


    }
}

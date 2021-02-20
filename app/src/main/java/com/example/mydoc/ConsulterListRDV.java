package com.example.mydoc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class ConsulterListRDV extends AppCompatActivity {


   private RecyclerView recyclerView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.fragment_consulter__liste__rendezvous );

        recyclerView = (RecyclerView) findViewById( R.id.recyclerViewRDV );

        new FirebaseDatabaseHelperRDV().readRDV( new FirebaseDatabaseHelperRDV.DataStatus() {
            @Override
            public void DataIsLoaded(List<RDV> appointments, List<String> keys) {

                new RecyclerView_ConfigRDV().setConfig( recyclerView, ConsulterListRDV.this, appointments, keys);
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
        });
    }
}

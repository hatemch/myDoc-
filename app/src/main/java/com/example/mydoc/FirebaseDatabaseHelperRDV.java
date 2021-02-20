package com.example.mydoc;

import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelperRDV {

    FirebaseAuth auth ;
    FirebaseUser user ;
    FirebaseDatabase database ;
    DatabaseReference databaseReferenceRDV ;

    private RDV appointment ;
    private ArrayList<RDV> appointments = new ArrayList<>(  );
    private ArrayAdapter<RDV> adapterRDV ;

    public interface DataStatus {
        void DataIsLoaded(List<RDV> appointments, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabaseHelperRDV() {
        database = FirebaseDatabase.getInstance();
        databaseReferenceRDV = database.getReference( "RendezVous");

    }

    public void readRDV( final DataStatus dataStatus){
        databaseReferenceRDV.addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                appointments.clear();
                List<String> keys = new ArrayList<>( );
                for (DataSnapshot keyNode : dataSnapshot.getChildren())
                {
                    keys.add(keyNode.getKey());
                    RDV appointment = keyNode.getValue(RDV.class);
                    appointments.add( appointment );
                }

                dataStatus.DataIsLoaded( appointments, keys );
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );
    }

    public void upDateRDV (String key, RDV appointment, final DataStatus dataStatus){

        databaseReferenceRDV.child( key ).setValue( appointment )
                .addOnSuccessListener( new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                        dataStatus.DataIsUpdated();

                    }
                } );
     }

     public void deleteRDV (String key, final DataStatus dataStatus)
     {
         databaseReferenceRDV.child( key ).setValue( null )
                 .addOnSuccessListener( new OnSuccessListener<Void>() {
                     @Override
                     public void onSuccess(Void aVoid) {

                         dataStatus.DataIsDeleted();
                     }
                 } );
     }

}

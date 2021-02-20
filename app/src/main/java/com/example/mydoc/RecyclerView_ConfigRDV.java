package com.example.mydoc;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerView_ConfigRDV {

    private Context mContext ;
    private RDVAdapter rdvAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<RDV> appoitments, List<String> keys)
    {
        mContext = context;
        rdvAdapter = new RDVAdapter( appoitments, keys );
        recyclerView.setLayoutManager( new LinearLayoutManager( context ) );
        recyclerView.setAdapter( rdvAdapter );

    }

    class RDVItemView extends RecyclerView.ViewHolder {

        private TextView textViewNom;
        private TextView textViewPrenom;
        private TextView textViewEmail;
        private TextView textViewPhone;
        private TextView textViewDate ;
        private TextView textViewHeur ;

        private String key;

        public RDVItemView(ViewGroup parent) {
            super( LayoutInflater.from( mContext ).
                    inflate( R.layout.rdv_list_item, parent, false ) );


            textViewNom = (TextView) itemView.findViewById( R.id.textViewNom );
            textViewPrenom = (TextView) itemView.findViewById( R.id.textViewPrenom );
            textViewEmail = (TextView) itemView.findViewById( R.id.textViewEmail );
            textViewPhone = (TextView) itemView.findViewById( R.id.textViewPhone );
            textViewDate = (TextView) itemView.findViewById( R.id.textViewDate );
            textViewHeur = (TextView) itemView.findViewById( R.id.textViewHeur );

            itemView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent( mContext, EditDeleteRDV.class );
                    intent.putExtra( "Key", key );
                    intent.putExtra( "Nom", textViewNom.getText().toString() );
                    intent.putExtra( "Prenom", textViewPrenom.getText().toString() );
                    intent.putExtra( "Email", textViewEmail.getText().toString() );
                    intent.putExtra( "Phone", textViewPhone.getText().toString() );
                    intent.putExtra( "Date", textViewDate.getText().toString() );
                    intent.putExtra( "Heur", textViewHeur.getText().toString() );

                    mContext.startActivity( intent );
                }
            } );

        }

        public void bind(RDV appoitment, String key) {

            textViewNom.setText( appoitment.getNom() );
            textViewPrenom.setText( appoitment.getPrenom() );
            textViewEmail.setText( appoitment.getEmail());
            textViewPhone.setText( appoitment.getTel() );
            textViewDate.setText( appoitment.getDateRDV() );
            textViewHeur.setText( appoitment.getHeurRDV() );
            this.key = key;

        }
    }

    class RDVAdapter extends RecyclerView.Adapter<RDVItemView>{

            private List<RDV> appoitmentList;
            private  List<String> keys;

            public RDVAdapter(List<RDV> appoitmentList, List<String> keys) {
                this.appoitmentList = appoitmentList;
                this.keys = keys;
            }


            @NonNull
            @Override
            public RDVItemView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                return new RDVItemView( viewGroup );
            }

            @Override
            public void onBindViewHolder(@NonNull RDVItemView rdvItemView, int i) {

                rdvItemView.bind( appoitmentList.get( i ), keys.get( i ) );
            }

            @Override
            public int getItemCount() {
                return appoitmentList.size();
            }
        }

}

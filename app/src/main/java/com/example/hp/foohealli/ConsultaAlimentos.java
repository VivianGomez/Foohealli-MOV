package com.example.hp.foohealli;

import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.hp.foohealli.objetos.Alimento;
import com.example.hp.foohealli.objetos.FirebaseReferences;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


public class ConsultaAlimentos extends AppCompatActivity {

    private ImageView imagenAlimento;
    private StorageReference mStorage;
    private DatabaseReference mDataBase;
    private TextInputEditText busqueda;
    private Button buscar;
    private Uri foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_alimentos);

        busqueda= (TextInputEditText)  findViewById(R.id.alimentoBusqueda);
        buscar= (Button) findViewById(R.id.butBusqueAli);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarEnLaBase();
            }
        });


        imagenAlimento= (ImageView) findViewById(R.id.fotoAlimento);
        mStorage= FirebaseStorage.getInstance().getReference();

        FirebaseDatabase dataBase= FirebaseDatabase.getInstance();
        mDataBase=dataBase.getReference(FirebaseReferences.ALIMENTO_REFERENCE);

        Uri link= Uri.parse("https://firebasestorage.googleapis.com/v0/b/prueba-c6bc7.appspot.com/o/Alimentos%2FArroz.jpg?alt=media&token=4f8bfa35-3f57-4577-a609-01868be66be3");
        Glide.with(ConsultaAlimentos.this)
        .load(link)
        .fitCenter()
        .centerCrop()
        .into(imagenAlimento);
    }

    private void buscarEnLaBase(){
        String consulta=busqueda.getText().toString().trim();
        if(!consulta.equals(null) ){
           mDataBase.child(consulta).addValueEventListener(new ValueEventListener() {
               @Override
               public void onDataChange(DataSnapshot dataSnapshot) {
                   Alimento alimento= dataSnapshot.getValue(Alimento.class);
                   foto=Uri.parse(alimento.getImagen());
                   Glide.with(ConsultaAlimentos.this)
                           .load(foto)
                           .fitCenter()
                           .centerCrop()
                           .into(imagenAlimento);
               }

               @Override
               public void onCancelled(DatabaseError databaseError) {

               }
           });
        }



    }


}

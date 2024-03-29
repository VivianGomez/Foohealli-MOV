package com.example.hp.foohealli;

import android.graphics.Typeface;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hp.foohealli.objetos.Alimento;
import com.example.hp.foohealli.objetos.FirebaseReferences;
import com.example.hp.foohealli.objetos.Receta;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class Almuerzo extends AppCompatActivity {

    private ImageView imagenReceta;
    private StorageReference mStorage;
    private DatabaseReference mDataBase;
    private TextView nombreReceta;
    private TextView preparacion;
    private TextView ingredientes;
    private TextView almuerzo;
    private Typeface ananda;
    private Uri foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_almuerzo);
        String fuente1= "fuentes/AnandaNegrilla.ttf";
        this.ananda=Typeface.createFromAsset(getAssets(),fuente1);

        almuerzo = (TextView) findViewById(R.id.Almuerzo);
        almuerzo.setTypeface(ananda);
        imagenReceta= (ImageView) findViewById(R.id.fotoReceta2);
        mStorage= FirebaseStorage.getInstance().getReference();
        preparacion = (TextView)  findViewById(R.id.preparacion2);
        ingredientes = (TextView) findViewById(R.id.ingredientes2);
        nombreReceta = (TextView) findViewById(R.id.nombreReceta2);

        FirebaseDatabase dataBase= FirebaseDatabase.getInstance();
        mDataBase=dataBase.getReference(FirebaseReferences.MENUS_REFERENCE);

        mostrarOpcion(2);

        Button opcion1 = (Button) findViewById(R.id.btnOpc12);
        opcion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarOpcion(2);
            }
        });

        Button opcion2 = (Button) findViewById(R.id.btnOpc22);
        opcion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarOpcion(3);
            }
        });


    }

    private void mostrarOpcion(int opcion){
        mDataBase.child("almuerzos").child(opcion+"").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Receta receta= dataSnapshot.getValue(Receta.class);
                Log.i("IMAGEN*************",receta.getImagen());
                foto=Uri.parse(receta.getImagen());
                Glide.with(Almuerzo.this)
                        .load(foto)
                        .fitCenter()
                        .centerCrop()
                        .into(imagenReceta);
                preparacion.setText(receta.getDescripcion());

                String bonito ="";
                String[] ingrts = receta.getIngredientes().split(",");
                for(int i=0; i<ingrts.length; i++)
                {
                    bonito+=ingrts[i]+"\n";
                }

                ingredientes.setText(bonito);
                nombreReceta.setText(receta.getNombre());
            }



            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}

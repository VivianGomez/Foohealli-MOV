package com.example.hp.foohealli;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


public class ConsultaAlimentos extends AppCompatActivity {

    private ImageView imagenAlimento;
    private StorageReference mStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_alimentos);
        imagenAlimento= (ImageView) findViewById(R.id.fotoAlimento);
        mStorage= FirebaseStorage.getInstance().getReference();
        Uri link= Uri.parse("https://firebasestorage.googleapis.com/v0/b/prueba-c6bc7.appspot.com/o/Aguacate.jpg?alt=media&token=9c2d2bdb-b8a2-402a-9712-8a645c9320c5");
        Glide.with(ConsultaAlimentos.this)
        .load(link)
        .fitCenter()
        .centerCrop()
        .into(imagenAlimento);
    }


}

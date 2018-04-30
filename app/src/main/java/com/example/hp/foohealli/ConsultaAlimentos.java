package com.example.hp.foohealli;

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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


public class ConsultaAlimentos extends AppCompatActivity {

    private ImageView imagenAlimento;
    private ImageView confirmacion;;
    private DatabaseReference mDataBase;
    private TextInputEditText busqueda;
    private Button buscar;
    private Uri foto;
    private TextView campo;
    private TextView valor;

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
        confirmacion= (ImageView) findViewById(R.id.confirm);

        FirebaseDatabase dataBase= FirebaseDatabase.getInstance();
        mDataBase=dataBase.getReference(FirebaseReferences.ALIMENTO_REFERENCE);

    }

    private void buscarEnLaBase(){
        String consulta=busqueda.getText().toString().trim();
        if(!consulta.equals(null) && !consulta.isEmpty() ){
           mDataBase.child(consulta).addValueEventListener(new ValueEventListener() {
               @Override
               public void onDataChange(DataSnapshot dataSnapshot) {
                   Alimento alimento= dataSnapshot.getValue(Alimento.class);
                   if(alimento!=null) {
                       if(alimento.getPotasio()<=250.0){
                           confirmacion.setImageResource(R.mipmap.aprobado);
                       }
                       else{
                           confirmacion.setImageResource(R.mipmap.rechazado);
                       }
                       foto = Uri.parse(alimento.getImagen());
                       Glide.with(ConsultaAlimentos.this)
                               .load(foto)
                               .fitCenter()
                               .centerCrop()
                               .into(imagenAlimento);
                       campo = (TextView) findViewById(R.id.CampoProteina);
                       campo.setText("  Proteina");
                       valor = (TextView) findViewById(R.id.ValorProteina);
                       valor.setText(alimento.getProteina() + "");


                       campo = (TextView) findViewById(R.id.CampoHidraCar);
                       campo.setText("  Hidratos de Carbono");
                       valor = (TextView) findViewById(R.id.ValorHidraCar);
                       valor.setText(alimento.getHidratosCarbono() + "");


                       campo = (TextView) findViewById(R.id.CampoFibra);
                       campo.setText("  Fibra");
                       valor = (TextView) findViewById(R.id.ValorFibra);
                       valor.setText(alimento.getFibra() + "");


                       campo = (TextView) findViewById(R.id.CampoGrasaT);
                       campo.setText("  Gasas Totales");
                       valor = (TextView) findViewById(R.id.ValorGrasaT);
                       valor.setText(alimento.getGrasaTotal() + "");


                       campo = (TextView) findViewById(R.id.CampoColesterol);
                       campo.setText("  Colesterol");
                       valor = (TextView) findViewById(R.id.ValorColesterol);
                       valor.setText(alimento.getColesterol() + "");


                       campo = (TextView) findViewById(R.id.CampoAlcohol);
                       campo.setText("  Alcohol");
                       valor = (TextView) findViewById(R.id.ValorAlcohol);
                       valor.setText(alimento.getAlcohol() + "");


                       campo = (TextView) findViewById(R.id.CampoAgua);
                       campo.setText("  Agua");
                       valor = (TextView) findViewById(R.id.ValorAgua);
                       valor.setText(alimento.getAgua() + "");


                       campo = (TextView) findViewById(R.id.CampoCalcio);
                       campo.setText("  Calcio");
                       valor = (TextView) findViewById(R.id.ValorCalcio);
                       valor.setText(alimento.getCalcio() + "");


                       campo = (TextView) findViewById(R.id.CampoHierro);
                       campo.setText("  Hierro");
                       valor = (TextView) findViewById(R.id.ValorHierro);
                       valor.setText(alimento.getHierro() + "");


                       campo = (TextView) findViewById(R.id.CampoSodio);
                       campo.setText("  Sodio");
                       valor = (TextView) findViewById(R.id.ValorSodio);
                       valor.setText(alimento.getSodio() + "");


                       campo = (TextView) findViewById(R.id.CampoPotasio);
                       campo.setText("  Potasio");
                       valor = (TextView) findViewById(R.id.ValorPotasio);
                       valor.setText(alimento.getPotasio() + "");


                       campo = (TextView) findViewById(R.id.CampoFosforo);
                       campo.setText("  Fosforo");
                       valor = (TextView) findViewById(R.id.ValorFosforo);
                       valor.setText(alimento.getFosforo() + "");


                       campo = (TextView) findViewById(R.id.CampoVitaminaD);
                       campo.setText("  VitaminaD");
                       valor = (TextView) findViewById(R.id.ValorVitaminaD);
                       valor.setText(alimento.getVitaminaD() + "");


                       campo = (TextView) findViewById(R.id.CampoVitaminaA);
                       campo.setText("  VitaminaA");
                       valor = (TextView) findViewById(R.id.ValorVitaminaA);
                       valor.setText(alimento.getVitaminaA() + "");


                       campo = (TextView) findViewById(R.id.CampoVitaminaC);
                       campo.setText("  VitaminaC");
                       valor = (TextView) findViewById(R.id.ValorVitaminaC);
                       valor.setText(alimento.getVitaminaC() + "");
                   }
               }

               @Override
               public void onCancelled(DatabaseError databaseError) {

               }
           });
        }



    }


}

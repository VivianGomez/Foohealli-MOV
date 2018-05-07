package com.example.hp.foohealli;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hp.foohealli.objetos.ExamenesMedicos;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ExamenesActualesActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    EditText albumina, tfg, sodio, potasio, acidoUrico, proteinasOrina, presionArterial, creatinina, glucosa, trigliceridos, nitrogenoUreico, fosforo, colesterolTotal, estadio;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examenes_actuales);

        Button botonCuerpo = (Button) findViewById(R.id.btn_enviar);
        botonCuerpo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresar();
            }
        });
        mAuth = FirebaseAuth.getInstance();

        albumina = (EditText)findViewById(R.id.txt_albumina);
        sodio = (EditText)findViewById(R.id.txt_sodio);
        tfg = (EditText)findViewById(R.id.txt_tfg);
        potasio = (EditText)findViewById(R.id.txt_potasio);
        acidoUrico = (EditText)findViewById(R.id.txt_acidoUrico);
        proteinasOrina = (EditText)findViewById(R.id.txt_proteinasOrina);
        presionArterial = (EditText)findViewById(R.id.txt_presionArterial);
        creatinina = (EditText)findViewById(R.id.txt_creatinina);
        glucosa = (EditText)findViewById(R.id.txt_glucosa);
        trigliceridos = (EditText)findViewById(R.id.txt_trigliceridos);
        nitrogenoUreico = (EditText)findViewById(R.id.txt_nitrogenoUreico);
        fosforo = (EditText)findViewById(R.id.txt_fosforo);
        colesterolTotal = (EditText)findViewById(R.id.txt_colesterolTotal);
        obtenerValores();
    }

    private void regresar(){
        Intent pantalla =new Intent(this,MenuActivity.class);
        startActivity(pantalla);
    }

    private void obtenerValores(){
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("usuarios");
        DatabaseReference currentUserDB = mDatabase.child(mAuth.getCurrentUser().getUid());

        currentUserDB.child("examenes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
            ExamenesMedicos examenes=dataSnapshot.getValue(ExamenesMedicos.class);
                if(examenes!=null) {
                    albumina.setText(examenes.getAlbumina()+" gr/dL");
                    sodio.setText(examenes.getSodio()+" ml/min");
                    tfg.setText(examenes.getTGF()+" gr");
                    potasio.setText(examenes.getPotasio()+" mEq/L");
                    acidoUrico.setText(examenes.getAcidoUrico()+" mg/dL");
                    proteinasOrina.setText(examenes.getProteinasOrina()+" mg/dL");
                    presionArterial.setText(examenes.getPresionArterial()+" mm Hg");
                    creatinina.setText(examenes.getCreatinina()+" ml/m");
                    glucosa.setText(examenes.getGlucosa()+" mg/dL");
                    trigliceridos.setText(examenes.getTrigliceridos()+" mg/dL");
                    nitrogenoUreico.setText(examenes.getNitrogenoUreico()+" mg/dL");
                    fosforo.setText(examenes.getFosforo()+" mg/dL");
                    colesterolTotal.setText(examenes.getColesterolTotal()+" mg/dL");
                    }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


}

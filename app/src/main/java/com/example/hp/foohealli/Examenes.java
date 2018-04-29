package com.example.hp.foohealli;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hp.foohealli.objetos.ExamenesMedicos;
import com.example.hp.foohealli.objetos.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Examenes extends AppCompatActivity {

    EditText albumina, tfg, sodio, potasio, acidoUrico, proteinasOrina, presionArterial, creatinina, glucosa, trigliceridos, nitrogenoUreico, fosforo, colesterolTotal, estadio;
    Button enviar;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examenes);

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
        estadio = (EditText)findViewById(R.id.txt_estadio);

        enviar = (Button)findViewById(R.id.btn_enviar);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subirExamenes();
                enviar();
            }
        });
    }

    private void enviar(){
        Intent pantallaMenu = new Intent(this,MenuActivity.class);
        startActivity(pantallaMenu);
    }

    private void subirExamenes(){
        final Double albumin = Double.parseDouble(albumina.getText().toString().trim());
        final Double sodi = Double.parseDouble(sodio.getText().toString().trim());
        final Double tf = Double.parseDouble(tfg.getText().toString().trim());
        final Double potasi = Double.parseDouble(potasio.getText().toString().trim());
        final Double acidoUric = Double.parseDouble(acidoUrico.getText().toString().trim());
        final Double proteinasOrin = Double.parseDouble(proteinasOrina.getText().toString().trim());
        final Double presionArteria = Double.parseDouble(presionArterial.getText().toString().trim());
        final Double creatinin = Double.parseDouble(creatinina.getText().toString().trim());
        final Double glucos = Double.parseDouble(glucosa.getText().toString().trim());
        final Double triglicerido = Double.parseDouble(trigliceridos.getText().toString().trim());
        final Double nitrogenoUreic = Double.parseDouble(nitrogenoUreico.getText().toString().trim());
        final Double fosfor = Double.parseDouble(fosforo.getText().toString().trim());
        final Double colesterolTota = Double.parseDouble(colesterolTotal.getText().toString().trim());
        final int temp;
        if(estadio.getText().toString().trim() != null){
            temp = Integer.parseInt(estadio.getText().toString().trim());
        }else{
            temp = 0;
        }

        ExamenesMedicos examenes = new ExamenesMedicos(tf,glucos,acidoUric,albumin,potasi,sodi,fosfor,proteinasOrin,colesterolTota,nitrogenoUreic,creatinin,presionArteria,triglicerido);

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("usuarios");
        DatabaseReference currentUserDB = mDatabase.child(mAuth.getCurrentUser().getUid());
        currentUserDB.child("examenes").setValue(examenes);
        currentUserDB.child("estadio").setValue(temp);
        }
}


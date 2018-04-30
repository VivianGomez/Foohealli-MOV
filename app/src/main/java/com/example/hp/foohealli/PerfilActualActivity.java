package com.example.hp.foohealli;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hp.foohealli.objetos.Usuario;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PerfilActualActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    EditText nombre, edad, peso, sexo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_actual);
        mAuth = FirebaseAuth.getInstance();

        nombre =(EditText)findViewById(R.id.valorNombre);

        edad =(EditText)findViewById(R.id.valorEdad);
        peso =(EditText)findViewById(R.id.valorPeso);
        sexo=(EditText)findViewById(R.id.valorSexo);


        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("usuarios");
        DatabaseReference currentUserDB = mDatabase.child(mAuth.getCurrentUser().getUid());
        currentUserDB.child("nombres").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String pNombre= dataSnapshot.getValue(String.class);
                if(pNombre!=null) {
                    nombre.setText(pNombre);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        currentUserDB.child("edad").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Object pEdad= dataSnapshot.getValue();

                    edad.setText(pEdad.toString());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        currentUserDB.child("peso").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Object pPeso= dataSnapshot.getValue();

                peso.setText(pPeso.toString());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        currentUserDB.child("sexo").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Object pSexo= dataSnapshot.getValue();

if(pSexo.toString().equals("1")){
    sexo.setText("Masculino");
}
else{
    sexo.setText("Femenino");
}


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





        Button botonCuerpo = (Button) findViewById(R.id.button);
        botonCuerpo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiar();
            }
        });
    }

    private void cambiar(){
        Intent pantalla =new Intent(this,ProfileActivity.class);
        startActivity(pantalla);
    }
}

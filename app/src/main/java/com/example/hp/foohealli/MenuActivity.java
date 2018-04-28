package com.example.hp.foohealli;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ImageButton botonPerfil = (ImageButton) findViewById(R.id.imageButton3);
        botonPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pedirPerfil();
            }
        });


        ImageButton botonMenus = (ImageButton) findViewById(R.id.imageButton);
        botonMenus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pedirMenus();
            }
        });

        ImageButton botonExamenes = (ImageButton) findViewById(R.id.imageButton4);
        botonExamenes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pedirExamenes();
            }
        });


        ImageButton botonMedicinas = (ImageButton) findViewById(R.id.imageButton2);
        botonMedicinas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pedirMedicinas();
            }
        });


        ImageButton botonConsulta = (ImageButton) findViewById(R.id.imageButton6);
        botonConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pedirConsultas();
            }
        });

        ImageButton botonProgreso = (ImageButton) findViewById(R.id.imageButton5);
        botonProgreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pedirProgreso();
            }
        });
    }

    private void pedirExamenes(){
        Intent pantallaExamenes =new Intent(this,Examenes.class);
        startActivity(pantallaExamenes);
    }

    private void pedirPerfil(){
        Intent pantallaPerfil =new Intent(this,ProfileActivity.class);
        startActivity(pantallaPerfil);
    }

    private void pedirMenus(){
        Intent pantallaPerfil =new Intent(this,ProfileActivity.class);
        startActivity(pantallaPerfil);
    }

    private void pedirMedicinas(){
        Intent pantallaPerfil =new Intent(this,ProfileActivity.class);
        startActivity(pantallaPerfil);
    }

    private void pedirConsultas(){
        Intent pantallaPerfil =new Intent(this,ProfileActivity.class);
        startActivity(pantallaPerfil);
    }

    private void pedirProgreso(){
        Intent pantallaPerfil =new Intent(this,ProfileActivity.class);
        startActivity(pantallaPerfil);
    }
}

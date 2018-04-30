package com.example.hp.foohealli;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button botonPerfil = (Button) findViewById(R.id.button2);
        botonPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pedirPerfil();
            }
        });


        Button botonMenus = (Button) findViewById(R.id.button3);
        botonMenus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pedirMenus();
            }
        });

        Button botonExamenes = (Button) findViewById(R.id.button4);
        botonExamenes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pedirExamenes();
            }
        });


        Button botonMedicinas = (Button) findViewById(R.id.button5);
        botonMedicinas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pedirCasa();
            }
        });


        Button botonConsulta = (Button) findViewById(R.id.button6);
        botonConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultar();
            }
        });

        Button botonProgreso = (Button) findViewById(R.id.button7);
        botonProgreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pedirProgreso();
            }
        });
    }

    private void pedirExamenes(){
        Intent pantallaExamenes =new Intent(this,ExamenesActualesActivity.class);
        startActivity(pantallaExamenes);
    }

    private void pedirPerfil(){
        Intent pantallaPerfil =new Intent(this,PerfilActualActivity.class);
        startActivity(pantallaPerfil);
    }

    private void pedirMenus(){
        Intent pantallaPerfil =new Intent(this,RecetasActivity.class);
        startActivity(pantallaPerfil);
    }

    private void pedirCasa(){
        Intent pantallaPerfil =new Intent(this,CasaActivity.class);
        startActivity(pantallaPerfil);
    }


    private void pedirProgreso(){
        Intent pantallaPerfil =new Intent(this,ProgresoActivity.class);
        startActivity(pantallaPerfil);
    }
    private void consultar(){
        Intent pantallaConsulta =new Intent(this,ConsultaAlimentos.class);
        startActivity(pantallaConsulta);
    }
}

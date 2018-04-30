package com.example.hp.foohealli;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProgresoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progreso);

        Button botonCuerpo = (Button) findViewById(R.id.button8);
        botonCuerpo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pedirMiCuerpo();
            }
        });
        Button botonHabitos = (Button) findViewById(R.id.buttonHabitos);
        botonHabitos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pantallaHabitos();
            }
        });
        Button botonMetas = (Button) findViewById(R.id.buttonMetas);
        botonMetas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pantallaMetas();
            }
        });


    }

    private void pedirMiCuerpo(){
        Intent pantalla =new Intent(this,MiCuerpoActivity.class);
        startActivity(pantalla);
    }
    private void pantallaHabitos(){
        Intent pantalla =new Intent(this,MejoresHabitosActivity.class);
        startActivity(pantalla);
    }
    private void pantallaMetas(){
        Intent pantalla =new Intent(this,MetasSemanalesActivity.class);
        startActivity(pantalla);
    }
}
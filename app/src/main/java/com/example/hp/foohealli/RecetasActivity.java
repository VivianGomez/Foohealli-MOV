package com.example.hp.foohealli;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecetasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetas);

        Button desayuno = (Button) findViewById(R.id.desayuno);
        desayuno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iraDesayuno();
            }
        });

        Button almuerzo = (Button) findViewById(R.id.irAalmuerzo);
        almuerzo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iraAlmuerzo();
            }
        });

        Button cena = (Button) findViewById(R.id.irAcena);
        cena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iraCena();
            }
        });
    }

    public void iraDesayuno()
    {
        Intent desayuno = new Intent(this,DesayunoActivity.class);
        startActivity(desayuno);
    }

    public void iraAlmuerzo()
    {
        Intent almuerzo = new Intent(this,Almuerzo.class);
        startActivity(almuerzo);
    }

    public void iraCena()
    {
        Intent cena = new Intent(this,Cena.class);
        startActivity(cena);
    }




}

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
    }

    private void pedirMiCuerpo(){
        Intent pantalla =new Intent(this,MiCuerpoActivity.class);
        startActivity(pantalla);
    }
}
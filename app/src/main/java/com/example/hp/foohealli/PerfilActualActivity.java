package com.example.hp.foohealli;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PerfilActualActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_actual);

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

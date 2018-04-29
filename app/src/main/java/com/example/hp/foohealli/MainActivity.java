package com.example.hp.foohealli;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.hp.foohealli.objetos.FirebaseReferences;
import com.example.hp.foohealli.objetos.Usuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //firebase utiliza archivos singleton por lo que siempre usa un archivo para todas las referencias
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        //referencia a los datos para poder accederlos
        DatabaseReference referenciaAlimento = database.getReference(FirebaseReferences.ALIMENTO_REFERENCE);

        DatabaseReference referenciaUsuarios = database.getReference(FirebaseReferences.USUARIOS_REFERENCE);

        /*
        el metodo addValueEventListener permite la actualización inmediata de los datos, en tiempo real,
        si queremos obtener solo una vez el valor usamos addListenerForSingleValueEvent, el cual no actualiza en tiempo real.
        referencia.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
        int valor = dataSnapshot.getValue(Integer.class);
        Log.i("DATOS", valor+"");
        }
        @Override
        public void onCancelled(DatabaseError databaseError) {
        Log.e("ERROR", databaseError.getMessage());
        }
        });
        Log.i("KEY",referencia.getKey());
        */




        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

}

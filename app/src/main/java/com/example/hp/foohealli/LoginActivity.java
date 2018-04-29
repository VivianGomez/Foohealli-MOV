package com.example.hp.foohealli;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hp.foohealli.objetos.FirebaseReferences;
import com.example.hp.foohealli.objetos.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {


    // UI references.
    Button ingresar, registrarse;
    EditText correo, password;

    FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ingresar = (Button)findViewById(R.id.btn_login);
        registrarse = (Button)findViewById(R.id.btn_registro);
        correo = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);

        ingresar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = correo.getText().toString();
                String clave = password.getText().toString();
                iniciarSesion(email, clave);
            }
        });
        registrarse.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarse();;
            }
        });

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser usuario = firebaseAuth.getCurrentUser();
                if(usuario != null){
                    Log.i("SESION", "sesion iniciada con email: " +usuario.getEmail());
                }else{
                    Log.i("SESION", "sesión cerrada");
                }
            }
        };

        //firebase utiliza archivos singleton por lo que siempre usa un archivo para todas las referencias
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference refUsuarios = database.getReference(FirebaseReferences.USUARIOS_REFERENCE);

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
    }

    private void registrarse(){
        Intent pantallaRegistro = new Intent(this,RegistroActivity.class);
        startActivity(pantallaRegistro);
    }

    private void iraMenu(){
        Intent pantallaMenu = new Intent(this,MenuActivity.class);
        startActivity(pantallaMenu);
    }

    private void iniciarSesion(String email, String clave){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, clave).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.i("SESION", "sesion iniciada");
                    iraMenu();
                } else {
                    Log.i("SESION", task.getException().getMessage() + "");
                }
            }
            ;
        });
    }

    protected void onStart(){
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(mAuthListener);
    }

    protected void onStop(){
        super.onStop();
        if(mAuthListener != null){
            FirebaseAuth.getInstance().removeAuthStateListener(mAuthListener);
        }
    }
}


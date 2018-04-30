package com.example.hp.foohealli;

import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Instrumentation;
import android.app.LoaderManager.LoaderCallbacks;
import android.app.ProgressDialog;
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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

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
import java.util.EmptyStackException;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

public class RegistroActivity extends AppCompatActivity{

    Button ingresar, registrarse;
    EditText nombres, apellidos, edad, peso,email, clave, estadio, sexo;

    ProgressDialog mProgress;

    FirebaseAuth mAuth;

    FirebaseAuth.AuthStateListener mAuthListener;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mAuth = FirebaseAuth.getInstance();

        ingresar = (Button)findViewById(R.id.btn_ingresar);
        registrarse = (Button)findViewById(R.id.btn_registrarse);
        nombres = (EditText)findViewById(R.id.txt_nombres);
        apellidos = (EditText)findViewById(R.id.txt_apellidos);
        edad = (EditText)findViewById(R.id.txt_edad);
        peso = (EditText)findViewById(R.id.txt_peso);
        clave = (EditText)findViewById(R.id.txt_clave);
        email = (EditText)findViewById(R.id.txt_email);
        estadio = (EditText)findViewById(R.id.txt_estadio);
        sexo = (EditText)findViewById(R.id.txt_sexo);

        mProgress = new ProgressDialog(this);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresar();
            }
        });
        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarse();
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
    }

    private void registrarse(){
        final String nombre;
        final String apellido;
        final int age;
        final int weight;
        final String correo;
        final String pass;
        String t1;
        String t2;
        int t3;
        int t4;
        String t5;
        String t6;
        if(nombres.getText().toString().trim() != null){
            t1 = nombres.getText().toString().trim();
        }
        else{
            t1 = "";
        }
        if(apellidos.getText().toString().trim() != null){
            t2 = apellidos.getText().toString().trim();
        }
        else{
            t2 = "";
        }
        if(edad.getText().toString().trim() != null){
            t3 = Integer.parseInt(edad.getText().toString().trim());
        }
        else{
            t3 = 0;
        }
        if(peso.getText().toString().trim() != null){
            t4 = Integer.parseInt(peso.getText().toString().trim());
        }
        else{
            t4 = 0;
        }
        if(email.getText().toString().trim() != null){
            t5 = email.getText().toString().trim();
        }
        else{
            t5 = "";
        }
        if(clave.getText().toString().trim() != null){
            t6 = clave.getText().toString().trim();
        }
        else{
            t6 = "";
        }
        int temp;
        if(sexo.getText().toString().trim() != null){
            if(sexo.getText().toString().equalsIgnoreCase("Masculino")){
                temp = 1;
            }else{
                temp = 2;
            }
        }
        else{
            temp = 1;
        }
        final int sex = temp;
        nombre = t1;
        apellido = t2;
        age = t3;
        weight = t4;
        correo = t5;
        pass = t6;
        Usuario user = new Usuario(correo,nombre,apellido,age,weight,sex);

        if(!TextUtils.isEmpty(nombre)&&!TextUtils.isEmpty(apellido)&&!TextUtils.isEmpty(correo)&&!TextUtils.isEmpty(pass)){
            mProgress.setMessage("Registrando, espera un momento");
            mProgress.show();
            mAuth.createUserWithEmailAndPassword(correo, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    mProgress.dismiss();
                    if (task.isSuccessful()){
                        mAuth.signInWithEmailAndPassword(correo, pass);
                        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("usuarios");
                        DatabaseReference currentUserDB = mDatabase.child(mAuth.getCurrentUser().getUid());
                        currentUserDB.child("nombres").setValue(nombre);
                        currentUserDB.child("apellidos").setValue(apellido);
                        currentUserDB.child("edad").setValue(age);
                        currentUserDB.child("peso").setValue(weight);
                        currentUserDB.child("correo").setValue(correo);
                        currentUserDB.child("examenes").setValue(null);
                        currentUserDB.child("estadio").setValue(0+"s");
                        currentUserDB.child("sexo").setValue(sex);
                        pedirExamenes();
                    }else{
                        Log.i("REGISTRO","No fué posible regstrar el usuario");
                    }
                }
            });
        }
    }

    private void ingresar(){
        Intent pantallaIngreso =new Intent(this,LoginActivity.class);
        startActivity(pantallaIngreso);
    }

    private void pedirExamenes(){
        Intent pantallaExamenes =new Intent(this,Examenes.class);
        startActivity(pantallaExamenes);
    }
}

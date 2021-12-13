package com.example.pideloapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText EdtUser;
    EditText EdtPassword;
    Button btnLogin, btnJoinIn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EdtUser = findViewById(R.id.edtUser);
        EdtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnJoinIn = findViewById(R.id.btnGoJoinIn);

        mAuth = FirebaseAuth.getInstance();


    }

    public void onLogin(View view) {

        String Password = EdtPassword.getText().toString();
        String Mail = EdtUser.getText().toString();

        if (TextUtils.isEmpty(Mail))
        {
            EdtUser.setError("Ingresa un correo");
            EdtUser.requestFocus();
        }
        else if (TextUtils.isEmpty(Password)){
            Toast.makeText(this,  "Ingresa una contraseña", Toast.LENGTH_SHORT).show();
            EdtPassword.requestFocus();
        }
        else{
            mAuth.signInWithEmailAndPassword(Mail, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(MainActivity.this, "Bienvenid@ a Pidelo", Toast.LENGTH_SHORT).show();
                        Intent ToWelcome = new Intent (view.getContext(),Welcome.class);
                        startActivity(ToWelcome);
                    }
                    else{
                        Log.w("TAG","Error",task.getException());
                    }
                }
            });
        }
    }

    public void onGoJoinIn(View view) {
        Intent ToJoinIn = new Intent (view.getContext(),JoinIn.class);
        startActivity(ToJoinIn);
    }
}
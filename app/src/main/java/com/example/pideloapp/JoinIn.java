package com.example.pideloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class JoinIn extends AppCompatActivity {

    private EditText EdtMail, EdtLastName, EdtName,EdtPassword, EdtConfirmPassword;
    private Button BtnJoinIn;
    private TextView TxtLogin;
    private String userId;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_in);

        EdtName = findViewById(R.id.edtName);
        EdtLastName = findViewById(R.id.edtLastName);
        EdtMail = findViewById(R.id.edtEmail);
        EdtPassword = findViewById(R.id.edtPassword);
        EdtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        BtnJoinIn = findViewById(R.id.btnJoinIn);
        TxtLogin = findViewById(R.id.txtvLogin);

    }

    public void onJoinIn(View view) {
    }

    public void onGoLogin(View view) {
        Intent ToLogin = new Intent (view.getContext(),MainActivity.class);
        startActivity(ToLogin);
    }
}
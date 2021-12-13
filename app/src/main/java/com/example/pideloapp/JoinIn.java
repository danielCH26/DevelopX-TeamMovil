package com.example.pideloapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class JoinIn extends AppCompatActivity {

    private EditText EdtMail, EdtLastName, EdtName,EdtPassword, EdtPhone;
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
        EdtPhone = findViewById(R.id.edtPhone);
        BtnJoinIn = findViewById(R.id.btnJoinIn);
        TxtLogin = findViewById(R.id.txtvLogin);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

    }

    public void onJoinIn(View view) {
        String Name = EdtName.getText().toString();
        String LastName = EdtLastName.getText().toString();
        String Mail = EdtMail.getText().toString();
        String Password = EdtPassword.getText().toString();
        String Phone = EdtPhone.getText().toString();

        if (TextUtils.isEmpty(Name)) {
            EdtName.setError("Enter your name");
            EdtName.requestFocus();
        }

        else if (TextUtils.isEmpty(LastName)) {

            EdtLastName.setError("Enter your last name");
            EdtLastName.requestFocus();
        }

        else if (TextUtils.isEmpty(Mail)){

            EdtMail.setError("Enter your email");
            EdtMail.requestFocus();
        }

        else if (TextUtils.isEmpty(Password)){
            EdtPassword.setError("Enter your password");
            EdtPassword.requestFocus();
        }

        else if (TextUtils.isEmpty(Phone)){

            EdtPhone.setError("Enter your phone number");
            EdtPhone.requestFocus();
        }

        /*else if (Password != ConfirmPassword){

            Toast.makeText(this,  "Passwords don't match", Toast.LENGTH_SHORT).show();
            EdtConfirmPassword.requestFocus();
            EdtPassword.requestFocus();
        }*/
        else
        {
            mAuth.createUserWithEmailAndPassword(Mail, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        userId = mAuth.getCurrentUser().getUid();
                        DocumentReference documentReference = db.collection("users").document(userId);
                        Map<String, Object> user = new HashMap<>();
                        user.put("Name", Name);
                        user.put("LastName", LastName);
                        user.put("Mail",Mail);
                        user.put("Password", Password);
                        user.put("Phone", Phone);

                        documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Log.d("TAG","onSuccess: Datos registrados" + userId);
                            }
                        });
                        Toast.makeText(JoinIn.this, "Usuario registrado", Toast.LENGTH_SHORT).show();
                        Intent ToWelcome = new Intent (view.getContext(),Welcome.class);
                        startActivity(ToWelcome);
                    }
                    else {
                        Toast.makeText(JoinIn.this,"Usuario no registrado" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


    }

    public void onGoLogin(View view) {
        Intent ToLogin = new Intent (view.getContext(),MainActivity.class);
        startActivity(ToLogin);
    }
}
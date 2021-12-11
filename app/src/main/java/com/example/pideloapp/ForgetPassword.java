package com.example.pideloapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends AppCompatActivity {

    private Button BtnSendMail;
    private EditText EdtMail;
    private FirebaseAuth mAuth;
    private String Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        mAuth = FirebaseAuth.getInstance();
        EdtMail = findViewById(R.id.edtMail);
        BtnSendMail = findViewById(R.id.btnSendMail);
    }

    public void sendMail(View view) {

        Email = EdtMail.getText().toString();
        if(Email.isEmpty()){
            EdtMail.setError("Required");
        }
        else{
            mAuth.sendPasswordResetEmail(Email)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(ForgetPassword.this, "Check your email.", Toast.LENGTH_SHORT).show();
                                Intent ToMain = new Intent (view.getContext(),MainActivity.class);
                                startActivity(ToMain);
                                finish();
                            }
                            else {
                                Toast.makeText(ForgetPassword.this, "Error : " + task.getException(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        }

    }
}
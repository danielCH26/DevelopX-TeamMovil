package com.example.pideloapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText EdtUser;
    EditText EdtPassword;
    Button btnLogin, btnJoinIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EdtUser = findViewById(R.id.edtUser);
        EdtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnJoinIn = findViewById(R.id.btnGoJoinIn);

    }

    public void onLogin(View view) {
        if (EdtUser.getText().toString().equals("daniel") && EdtPassword.getText().toString().equals("1234"))
        {
            Intent ToWelcome = new Intent (view.getContext(),Welcome.class);
            startActivityForResult(ToWelcome,0);
            Toast.makeText(getApplicationContext(), "@string/txtWelcome", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,  "@string/txtErrorLogin", Toast.LENGTH_SHORT).show();
        }
    }

    public void onGoJoinIn(View view) {
        Intent ToJoinIn = new Intent (view.getContext(),JoinIn.class);
        startActivityForResult(ToJoinIn,0);
    }
}
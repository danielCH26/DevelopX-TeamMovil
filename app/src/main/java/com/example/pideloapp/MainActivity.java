package com.example.pideloapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtEmail;
    EditText edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail = (EditText) findViewById(R.id.edtxEmail);
        edtPass = (EditText) findViewById(R.id.edtxPass);
        Button bntLogin = (Button) findViewById(R.id.btnLogin);

    }

    public void onLogin(View view) {
        if (edtEmail.getText().toString().equals("a@b.c") && edtPass.getText().toString().equals("1234"))
        {
            Intent ToWelcome = new Intent (view.getContext(),Welcome.class);
            startActivityForResult(ToWelcome,0);
            Toast.makeText(getApplicationContext(), "@string/welcome", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,  "@string/errorLogin", Toast.LENGTH_SHORT).show();
        }
    }
}
package com.example.pideloapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
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
        edtEmail = (EditText) findViewById(R.id.edtUser);
        edtPass = (EditText) findViewById(R.id.edtPassword);
        Button bntLogin = (Button) findViewById(R.id.btnLogin);

    }

    public void onLogin(View view) {
        Toast aviso = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG);
        if (edtEmail.getText().toString().equals("a@b.c") && edtPass.getText().toString().equals("1234"))
        {
            Intent ToWelcome = new Intent (view.getContext(),Welcome.class);
            startActivity(ToWelcome);
            aviso.setText(getString(R.string.txtWelcome));
            aviso.show();
        }
        else{
            aviso.setText(getString(R.string.txtErrorLogin));
            aviso.show();
        }
    }

    public void onGoJoinIn(View view) {
        //Intent ToJoinIn = new Intent (view.getContext(),JoinIn.class);
        //startActivity(ToJoinIn);
    }

}
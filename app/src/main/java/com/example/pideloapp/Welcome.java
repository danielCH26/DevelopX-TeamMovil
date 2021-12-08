package com.example.pideloapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Welcome extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        setSupportActionBar(findViewById(R.id.tlbWelcome));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_welcome_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionSearch:
                Toast.makeText(this, "Boton buscar funciona", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.actionSettings:
                Toast.makeText(this, "Boton configuraciones funciona", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.actionProfile:
                Toast.makeText(this, "Boton perfil funciona", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.actionLogout:

                mAuth.signOut();
                Toast.makeText(this, "Cerrando sesion", Toast.LENGTH_SHORT).show();
                Intent ToLogin = new Intent (this,MainActivity.class);
                startActivity(ToLogin);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }


}
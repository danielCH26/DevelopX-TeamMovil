package com.example.pideloapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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

            case R.id.actionCart:
                replaceFragment(new CartFragment());
                Toast.makeText(this, "Boton buscar funciona", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.actionHome:
                replaceFragment(new HomeFragment());
                Toast.makeText(this, "Boton buscar funciona", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.actionCategories:
                replaceFragment(new CategoriesFragment());
                Toast.makeText(this, "Boton configuraciones funciona", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.actionSettings:
                replaceFragment(new SettingsFragment());
                Toast.makeText(this, "Boton configuraciones funciona", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.actionProfile:
                replaceFragment(new ProfileFragment());
                Toast.makeText(this, "Boton perfil funciona", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.actionLogout:

                mAuth.signOut();
                Toast.makeText(this, "Cerrando sesion", Toast.LENGTH_SHORT).show();
                Intent ToLogin = new Intent (this,MainActivity.class);
                startActivity(ToLogin);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();

    }

}
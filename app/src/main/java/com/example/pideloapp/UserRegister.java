package com.example.pideloapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UserRegister extends AppCompatActivity {

    FragmentContainerView FragTPYC;
    Fragment FragView;
    TextView readTPYC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
        FragTPYC = (FragmentContainerView) findViewById(R.id.FragmentTPYC);
        //FragTPYC.setVisibility(View.INVISIBLE);
        TextView readTPYC = (TextView) findViewById(R.id.txvTPYC);

    }

    public void readTPYC(View view) {

        FragView = new TPYCFragment();
        cargarFragmento(FragView);

    }

    private void cargarFragmento(Fragment FragView) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.FragmentTPYC,FragView);
        transaction.commit();
    }


}
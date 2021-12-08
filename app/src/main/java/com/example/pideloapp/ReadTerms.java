package com.example.pideloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReadTerms extends AppCompatActivity {

    Button btnJoinIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_terms);
        btnJoinIn = findViewById(R.id.btnGoJoinIn);
    }

    public void onGoJoinIn(View view) {
        Intent ToJoinIn = new Intent (view.getContext(),JoinIn.class);
        startActivity(ToJoinIn);
    }

}
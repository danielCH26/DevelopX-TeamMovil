package com.example.pideloapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Welcome extends AppCompatActivity {
    RecyclerView CategoryList;
    List<Category> Category;
    Context Contexto;

    // gestorDB

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        CategoryList=(RecyclerView) findViewById(R.id.CategoryLine);
        CategoryList.setHasFixedSize(true);
        LinearLayoutManager layoutManager= new LinearLayoutManager(Contexto);
        CategoryList.setLayoutManager(layoutManager);
        CategoriesListAdapter adapter = new CategoriesListAdapter(Category);
        InicializarDatos();
        InicializarAdaptador();

        }

    private void InicializarDatos() {
        Category=new ArrayList<>();
        Category.add(new Category(Category "Platos Fuertes", Description "Las más finas carnes", R.drawable.logo ));
        Category.add(new Category(Category "Pescados", Description "Del mar a la mesa", R.drawable.logo ));
        Category.add(new Category(Category "Aves", Description "Aves criadas especialmente para ti", R.drawable.logo ));
        Category.add(new Category(Category "Bebidas", Description "Refrecate", R.drawable.logo ));
        Category.add(new Category(Category "Postres", Description "Para endulzar el día", R.drawable.logo ));
    }

    private void InicializarAdaptador() {
        CategoriesListAdapter Adapter = new CategoriesListAdapter(Category);
        CategoryList.setAdapter(Adapter);

    }

}
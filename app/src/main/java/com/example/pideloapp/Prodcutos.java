package com.example.pideloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class Prodcutos extends AppCompatActivity {

    String Product;
    String Description;
    String Price
    ImageView Image;

    public Prodcutos (String Product, String Description, String Price, ImageView Image) {
        this.Product=Product;
        this.Description=Description;
        this.Price=Price;
        this.Image=Image

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prodcutos);
    }
}






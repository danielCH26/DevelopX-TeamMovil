package com.example.pideloapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductsListAdapter extends RecyclerView.Adapter <ProductsListAdapter.ProductViewHolder> {
    List<Products> ProductsList;

    public ProductsListAdapter(List<Product> productsList) { ProductsList = productsList;}

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.products_list_items_design);
        ProductViewHolder PVH = new ProductViewHolder(view);
        return PVH;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productiewHolder, int i) {
        productiewHolder.ProdName.setText(ProductsList.get(i).Product);
        productiewHolder.ProdDescription.setText(ProductsList.get(i).Description);
        productiewHolder.ProdPrice.setText(ProductsList.get(i).Price);
        productiewHolder.ProdImage.setImageResource(ProductsList.get(i).Image);

    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return ProductsList.size();
    }

    public class ProductsViewHolder extends RecyclerView.ViewHolder {
        LinearLayoutCompat LinearLayout;
        TextView ProdName;
        TextView ProdDescription;
        TextView ProdPrice;
        ImageView ProdImage;

        public ProductsViewHolder(@NonNull View itemView) {
            super(itemView);
            LinearLayout = (LinearLayoutCompat) itemView.findViewById(R.id.CategoryLine);
            ProdName = (TextView) itemView.findViewById(R.id.CatName);
            ProdDescription = (TextView) itemView.findViewById(R.id.CatDescription);
            ProdPrice = (TextView) itemView.findViewById(R.id.ProdPrice);
            ProdImage = (ImageView) itemView.findViewById(R.id.CatImage);

        }
    }

}


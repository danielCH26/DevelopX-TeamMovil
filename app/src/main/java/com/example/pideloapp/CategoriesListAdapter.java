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

public class CategoriesListAdapter extends RecyclerView.Adapter <CategoriesListAdapter.CategoryViewHolder> {
   List <Categories> CategoriesList;

    public CategoriesListAdapter(List<Category> categoriesList) {
        CategoriesList = categoriesList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.categories_list_items_design);
        CategoryViewHolder CVH= new CategoryViewHolder(view);
        return CVH;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.CatName.setText(CategoriesList.get(i).Category);
        categoryViewHolder.CatDescription.setText(CategoriesList.get(i).Description);
        categoryViewHolder.CatImage.setImageResource(CategoriesList.get(i).Image);

    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return CategoriesList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        LinearLayoutCompat LinearLayout;
        TextView CatName;
        TextView CatDescription;
        ImageView CatImage;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            LinearLayout = (LinearLayoutCompat) itemView.findViewById(R.id.CategoryLine);
            CatName = (TextView) itemView.findViewById(R.id.CatName);
            CatDescription = (TextView) itemView.findViewById(R.id.CatDescription);
            CatImage = (ImageView) itemView.findViewById(R.id.CatImage);

        }
    }
}
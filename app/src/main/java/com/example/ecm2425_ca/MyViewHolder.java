package com.example.ecm2425_ca;


import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView recipeNameView;

    Button button;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.recipeImage);
        recipeNameView = itemView.findViewById(R.id.recipeTitle);
        button = itemView.findViewById(R.id.recipeButton);
    }


}
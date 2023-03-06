package com.example.ecm2425_ca;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecm2425_ca.Item;
import com.example.ecm2425_ca.MyViewHolder;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<Item> items;

    public MyAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {


        holder.recipeNameView.setText(items.get(position).getTitle());
        //holder.imageView.setImageResource(items.get(position).getImageURL());



        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());


        executor.execute(new Runnable() {
                             @Override
                             public void run() {
                                 handler.post(new Runnable() {
                                     @Override
                                     public void run() {
                                         Picasso.get().load(items.get(position).getImageURL()).into(holder.imageView);
                                     }
                                 });
                             }
                         }



        );


                holder.button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Context context = v.getContext();
                        Intent intent = new Intent(context, RecipePage.class);
                        Bundle extras = new Bundle();
                        extras.putString("id", items.get(position).getId());
                        extras.putString("Title", items.get(position).getTitle());
                        extras.putString("ImageURL", items.get(position).getImageURL());
                        extras.putString("RecipeURL", items.get(position).getRecipeURL());
                        extras.putString("description", items.get(position).getDescription());
                        intent.putExtras(extras);

                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                        context.startActivity(intent);
                    }
                });


            }

            @Override
            public int getItemCount() {
                return items.size();
            }

}

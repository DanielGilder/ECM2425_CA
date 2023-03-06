package com.example.ecm2425_ca;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SavedRecipes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_recipes);


        RecyclerView recyclerView = findViewById(R.id.savedRecycler);

        List<Item> items = getRecipes();
       // items.add(new Item("", "Best Food Sites", "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F44%2F2022%2F11%2F17%2Farticle_291139_the-top-10-healthiest-foods-for-kids_-02.jpg&q=60","https://www.chefspencil.com/the-best-20-cooking-websites/", ""));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter((getApplicationContext()),items));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.savedRecipes :
                return true;

            case R.id.newRecipes :

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            default:
                return super.onOptionsItemSelected(item);


        }
    }


    public List<Item> getRecipes(){


        List<Item> items = new ArrayList<Item>();
        items.add(new Item("", "Best Food Sites", "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F44%2F2022%2F11%2F17%2Farticle_291139_the-top-10-healthiest-foods-for-kids_-02.jpg&q=60","https://www.chefspencil.com/the-best-20-cooking-websites/", ""));
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());




        executor.execute(new Runnable() {
                             @Override
                             public void run() {
                                 handler.post(new Runnable() {
                                     @Override
                                     public void run() {
                                         FirebaseFirestore db = FirebaseFirestore.getInstance();
                                         db.collection("recipes")
                                                 .get()
                                                 .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                                     @Override
                                                     public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                                         if (task.isSuccessful()) {
                                                             for (QueryDocumentSnapshot document : task.getResult()) {
                                                                 if (document.getBoolean("saved")) {
                                                                     String id = document.getId();
                                                                     String title = document.getString("RecipeTitle");
                                                                     String imageURL = document.getString("imageURL");
                                                                     String recipeURL = document.getString("recipeURL");
                                                                     String description = document.getString("description");

                                                                     items.add(new Item(id, title, imageURL, recipeURL, description));
                                                                 }
                                                             }
                                                         } else {
                                                             Log.w(TAG, "Error getting documents.", task.getException());
                                                         }

                                                     } } );
                                     }
                                 });
                             }
                         }



        );

        return items;
    }
}
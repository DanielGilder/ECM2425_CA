package com.example.ecm2425_ca;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getApplicationContext().getSharedPreferences("SavedData", 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.putString("dsdvdz", "okok");
        editor.commit();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        List<Item> items = new ArrayList<Item>();
        items.add(new Item("MeatBalls", R.drawable.a));
        items.add(new Item("MeatBalls", R.drawable.a));
        items.add(new Item("MeatBalls", R.drawable.a));
        items.add(new Item("MeatBalls", R.drawable.a));
        items.add(new Item("MeatBalls", R.drawable.a));
        items.add(new Item("MeatBalls", R.drawable.a));
        items.add(new Item("MeatBalls", R.drawable.a));
        items.add(new Item("MeatBalls", R.drawable.a));
        items.add(new Item("MeatBalls", R.drawable.a));
        items.add(new Item("MeatBalls", R.drawable.a));        items.add(new Item("MeatBalls", R.drawable.a));
        items.add(new Item("MeatBalls", R.drawable.a));
        items.add(new Item("MeatBalls", R.drawable.a));
        items.add(new Item("MeatBalls", R.drawable.a));
        items.add(new Item("MeatBalls", R.drawable.a));






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
                Intent intent = new Intent(getApplicationContext(), SavedRecipes.class);
                startActivity(intent);
                return true;

            case R.id.newRecipes : return  true;

            default:
                return super.onOptionsItemSelected(item);


        }
    }
}
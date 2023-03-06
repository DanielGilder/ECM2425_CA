package com.example.ecm2425_ca;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;

import android.os.Bundle;


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

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

       List<Item> items = getRecipes();
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

    public List<Item> getRecipes(){



        List<Item> items = new ArrayList<Item>();
        items.add(new Item("","Best Food Sites", "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F44%2F2022%2F11%2F17%2Farticle_291139_the-top-10-healthiest-foods-for-kids_-02.jpg&q=60","https://www.chefspencil.com/the-best-20-cooking-websites/", ""));

        return items;
    }


}
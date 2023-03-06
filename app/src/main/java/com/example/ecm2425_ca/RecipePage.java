package com.example.ecm2425_ca;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

public class RecipePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_page);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String id = extras.getString("id");
        String recipeTitle = extras.getString("Title");
        String imageURL = extras.getString("ImageURL");
        String recipeURL = extras.getString("RecipeURL");
        String description = extras.getString("description");
        TextView title = findViewById(R.id.textView);
        ImageView imageView = findViewById(R.id.imageView);
        Button linkedButton = findViewById(R.id.buttonLink);
        TextView descView = findViewById(R.id.descriptionView);

        descView.setText(description);

        ToggleButton saveButton = findViewById(R.id.toggleButton);



        saveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                updateSavedFeild(id, saveButton);

            }
        });





       changeButtonState(id, saveButton);



        title.setText(recipeTitle);
        Picasso.get().load(imageURL).into(imageView);

        linkedButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        goLink(recipeURL);
                    }
                }
        );
    }

    public void goLink(String url){


        Handler handler = new Handler(Looper.getMainLooper());

        handler.post(new Runnable() {
            @Override
            public void run() {
                // Perform network operations here
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Uri uri = Uri.parse(url);
                        startActivity(new Intent(Intent.ACTION_VIEW, uri));
                    }
                });
            }
        });


    }

    public void updateSavedFeild(String id, ToggleButton button){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("recipes").document(id).update("saved", button.isChecked());
    }

    public boolean changeButtonState(String id, ToggleButton button){
        FirebaseFirestore db = FirebaseFirestore.getInstance();


        DocumentReference docRef = db.collection("recipes").document(id);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        boolean result = document.getBoolean("saved");
                        button.setChecked(result);

                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }

            }
        });


        return false;
    }


}
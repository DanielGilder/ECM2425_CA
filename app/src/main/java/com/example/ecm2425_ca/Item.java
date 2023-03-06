package com.example.ecm2425_ca;

public class Item {



    String id;
    String title;
    String imageURL;
    String recipeURL;

    String description;

    public Item(String id,String title, String imageURL, String recipeURL, String description) {

        this.id = id;
        this.title = title;
        this.imageURL = imageURL;
        this.recipeURL = recipeURL;
        this.description = description;


    }

    public String getImageURL() {
        return imageURL;
    }

    public String getTitle() {
        return title;
    }

    public String getRecipeURL() {
        return recipeURL;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}






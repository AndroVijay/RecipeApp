package com.example.vijay.recipeapp.vijay.Model;

import android.graphics.Bitmap;

/**
 * Created by vijay on 17-02-2018.
 */

public class Recipe {


    private int id;
    private String name;
    private String discription;
    private byte[] image;


    public Recipe(String name, String discription, byte[] image, int id) {

        this.id=id;
        this.name = name;
        this.discription = discription;
        this.image = image;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}

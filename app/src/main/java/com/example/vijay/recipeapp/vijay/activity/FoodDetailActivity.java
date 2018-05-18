package com.example.vijay.recipeapp.vijay.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vijay.recipeapp.R;

public class FoodDetailActivity extends AppCompatActivity {

    TextView n,d;
    ImageView im;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);






        im=findViewById(R.id.Image_food);
         n=findViewById(R.id.Name_food);
         d=findViewById(R.id.Discription_food);
        Intent intent=getIntent();
        String name=intent.getStringExtra("NAME");
        String disc=intent.getStringExtra("DISC");
        byte[] bytes=intent.getByteArrayExtra("IMAGE");
        n.setText(name);
        d.setText(disc);

        Bitmap bitmap= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
        im.setImageBitmap(bitmap);
        //getSupportActionBar().setTitle(name);
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       getSupportActionBar().setTitle(name);



    }
}



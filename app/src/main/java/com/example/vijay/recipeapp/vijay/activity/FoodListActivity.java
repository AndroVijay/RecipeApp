package com.example.vijay.recipeapp.vijay.activity;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.vijay.recipeapp.R;
import com.example.vijay.recipeapp.vijay.Adapters.CustomAdapter;
import com.example.vijay.recipeapp.vijay.Model.Recipe;
import com.example.vijay.recipeapp.vijay.database.DatabaseHelper;

import java.util.ArrayList;

public class FoodListActivity extends AppCompatActivity implements CustomAdapter.OnItemClickListener {

    RecyclerView recyclerView;
    ArrayList<Recipe> arrayList;
    CustomAdapter adapter=null;
    private Cursor cursor;
    private int id;
    private String name;
    private String disc;
    private byte[] image;
    public static DatabaseHelper helper;
    private DrawerLayout mDrawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        setNavigationDrawer();


        recyclerView=findViewById(R.id.recyclerview);
        helper=new DatabaseHelper(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList=new ArrayList<>();
        adapter=new CustomAdapter(arrayList,this);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(FoodListActivity.this);


        //get data from database
         cursor=helper.getData("SELECT * FROM recipe");
         arrayList.clear();
        while (cursor.moveToNext())
        {

            id = cursor.getInt(0);
            name = cursor.getString(1);
            disc = cursor.getString(2);
            image = cursor.getBlob(3);

            arrayList.add(new Recipe(name,disc,image,id));
        }
        adapter.notifyDataSetChanged();
    }

    private void setNavigationDrawer() {

         navigationView = findViewById(R.id.navigation);

        toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open,R.string.drawer_close);
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.nav_frag1:

                        Intent intent=new Intent(FoodListActivity.this,FoodListActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_frag2:

                        Toast.makeText(FoodListActivity.this, "Checken Racipe", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_frag3:

                        Toast.makeText(FoodListActivity.this, "Breakfast Racipe", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_frag4:

                        Toast.makeText(FoodListActivity.this, "Red Meat Racipe", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_frag5:

                        Toast.makeText(FoodListActivity.this, "Vegetable based Racipe", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_frag6:

                        Toast.makeText(FoodListActivity.this, "Pastas Racipe", Toast.LENGTH_SHORT).show();
                        break;


                }
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });

}

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onItemClick(int position) {

        Intent intent=new Intent(FoodListActivity.this, FoodDetailActivity.class);

        Recipe recipe=arrayList.get(position);
        intent.putExtra("ID",recipe.getId());
        intent.putExtra("NAME",recipe.getName());
        intent.putExtra("DISC", recipe.getDiscription());
        intent.putExtra("IMAGE",recipe.getImage());
        startActivity(intent);
       //Toast.makeText(this, "selected item is : " + position , Toast.LENGTH_SHORT).show();



    }
}

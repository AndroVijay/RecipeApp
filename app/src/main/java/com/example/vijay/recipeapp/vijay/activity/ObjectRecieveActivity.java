package com.example.vijay.recipeapp.vijay.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.vijay.recipeapp.R;
import com.example.vijay.recipeapp.vijay.Model.PaercelModel;

public class ObjectRecieveActivity extends AppCompatActivity {

    TextView textView1,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_recieve);
        textView1=findViewById(R.id.objeName);
        textView2=findViewById(R.id.objAddress);
        Intent i=getIntent();
        PaercelModel employee=i.getParcelableExtra("Employee");

        String name=employee.getName();
        String Address=employee.getAddress();

        textView1.setText(name);
        textView2.setText(Address);

    }
}

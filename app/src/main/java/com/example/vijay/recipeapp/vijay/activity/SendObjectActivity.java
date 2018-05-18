package com.example.vijay.recipeapp.vijay.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vijay.recipeapp.R;
import com.example.vijay.recipeapp.vijay.Model.PaercelModel;

public class SendObjectActivity extends AppCompatActivity {

    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_object);

        button=findViewById(R.id.send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                PaercelModel emp=new PaercelModel("vijay","kanpur");

                Intent  intent=new Intent(SendObjectActivity.this, ObjectRecieveActivity.class);
                intent.putExtra("Employee",emp);
                startActivity(intent);

            }
        });
    }
}

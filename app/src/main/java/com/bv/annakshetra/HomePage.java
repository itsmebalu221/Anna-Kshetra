package com.bv.annakshetra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {
    Button donate;
    Button getfood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        donate= (android.widget.Button) findViewById(R.id.donate);
        getfood= (android.widget.Button) findViewById(R.id.getfood);

        donate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(HomePage.this,Donate.class);
                startActivity(intent);
            }
        });


        getfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(HomePage.this,Getfood.class);
                startActivity(intent);
            }
        });




    }
}
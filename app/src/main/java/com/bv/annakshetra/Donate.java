package com.bv.annakshetra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Donate extends AppCompatActivity {

    EditText name;
    Button submit;
    DatabaseReference DonorDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        name = findViewById(R.id.name);
        submit = findViewById(R.id.submit);

        DonorDatabase = FirebaseDatabase.getInstance().getReference().child("Donations");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertDonorData();
            }
        });

        }
    private void insertDonorData(){
        String Name = name.getText().toString();

        DonorData donorData = new DonorData(Name);
        DonorDatabase.push().setValue(donorData);
        Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();




    }
}
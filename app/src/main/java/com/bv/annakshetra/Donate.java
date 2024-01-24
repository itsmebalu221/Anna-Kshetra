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

    EditText Hname;
    EditText Dname;
    EditText Dphone;
    EditText Fnum;
    EditText Haddress;
    EditText Hlink;
    EditText Ftime;

    Button submit;
    DatabaseReference DonorDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        Hname = findViewById(R.id.Hname);
        Dname = findViewById(R.id.Dname);
        Dphone = findViewById(R.id.Dphone);
        Fnum = findViewById(R.id.Fnum);
        Haddress = findViewById(R.id.Haddress);
        Hlink = findViewById(R.id.Hlink);
        Ftime = findViewById(R.id.Ftime);
        //button
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
        String NameOfHotel = Hname.getText().toString();
        String NameOfDonor = Dname.getText().toString();
        String Phonenum = Dphone.getText().toString();
        String HotelAddress = Haddress.getText().toString();
        String MapLink = Hlink.getText().toString();
        String FoodNum = Fnum.getText().toString();
        String FoodTime = Ftime.getText().toString();


        DonorData donorData = new DonorData(NameOfHotel,NameOfDonor,Phonenum,HotelAddress,MapLink,FoodNum,FoodTime);
        DonorDatabase.push().setValue(donorData);
        Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();




    }
}
package com.bv.annakshetra;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class Getfood extends AppCompatActivity {

    ListView listView;
    List<DonorData> DonorList;
    DatabaseReference DonorDataref;








    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getfood);

        listView = findViewById(R.id.ListView);
        DonorList = new ArrayList<>();

        DonorDataref= FirebaseDatabase.getInstance().getReference("Donations");

        DonorDataref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DonorList.clear();

                for(DataSnapshot DonorDataSnap : snapshot.getChildren()){
                    DonorData DonorData = DonorDataSnap.getValue(DonorData.class);

                    DonorList.add(DonorData);
                }


                Adapter adapter = new Adapter(Getfood.this,DonorList);
                listView.setAdapter(adapter);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(Getfood.this, "Database Error", Toast.LENGTH_SHORT).show();

            }
        });







    }
}


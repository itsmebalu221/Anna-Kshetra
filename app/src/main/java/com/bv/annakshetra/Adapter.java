package com.bv.annakshetra;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class Adapter extends ArrayAdapter {
    private Activity mContext;
    List<DonorData> DonorList;


    public  Adapter(Activity mContext, List<DonorData> DonorList){
        super(mContext,R.layout.don,DonorList);
        this.mContext= mContext;
        this.DonorList = DonorList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();
        View listitem = inflater.inflate(R.layout.don,null,true);
        TextView name = listitem.findViewById(R.id.rname);

        DonorData donorData = DonorList.get(position);
        name.setText(donorData.getName());

        return listitem;
    }
}

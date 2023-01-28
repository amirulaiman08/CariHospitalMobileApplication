package com.example.groupproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
public class PersonAdapter extends ArrayAdapter <Person>{
    private Context mContext;
    private int mResource;
    public PersonAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Person> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView=layoutInflater.inflate(mResource,parent,false);

        ImageView imageView =convertView.findViewById(R.id.image);
        TextView txtName =convertView.findViewById(R.id.txtName);
        TextView txtNo =convertView.findViewById(R.id.txtNo);
        TextView txtClass =convertView.findViewById(R.id.txtClass);

        imageView.setImageResource(getItem(position).getImage());
        txtName.setText(getItem(position).getName());
        txtNo.setText(getItem(position).getStNo());
        txtClass.setText(getItem(position).getMyClass());




        return convertView;
    }
}

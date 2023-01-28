package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class aboutUs extends AppCompatActivity {
    ListView listView;
    TextView linkTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);


        listView = findViewById(R.id.listView);

        ArrayList<Person> arrayList = new ArrayList<>();

        arrayList.add(new Person(R.drawable.amirul, "Muhammad Amirul Aiman", "2020627888", "CS2405A"));
        arrayList.add(new Person(R.drawable.humaira, "Nur Humairah Hanisah", "2020827904", "CS2405A"));
        arrayList.add(new Person(R.drawable.farah, "Farah Syafiqa", "2020495322", "CS2405A"));
        arrayList.add(new Person(R.drawable.auni, "Siti Auniwaznah", "2020837642", "CS2405A"));
        linkTextView = findViewById(R.id.activity_main_link);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());

        PersonAdapter personAdapter = new PersonAdapter(this, R.layout.list_row, arrayList);
        listView.setAdapter(personAdapter);


    }



    }

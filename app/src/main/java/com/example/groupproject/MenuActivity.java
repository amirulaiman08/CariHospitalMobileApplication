package com.example.groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    CardView userProfile, myLocation, nearby, aboutUs;
    TextView greet;
    FirebaseDatabase firebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        greet=findViewById(R.id.greet);
        userProfile = findViewById(R.id.userProfile);
        myLocation = findViewById(R.id.myLocation);
        nearby = findViewById(R.id.nearby);
        aboutUs = findViewById(R.id.aboutUs);
        userProfile.setOnClickListener(this);
        myLocation.setOnClickListener(this);
        nearby.setOnClickListener(this);
        aboutUs.setOnClickListener(this);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("users").child("aiman");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String usernameFromDB = snapshot.child("username").getValue(String.class);
                greet.setText("Hello " +usernameFromDB +"!!");
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @Override
    public void onClick(View view) {
        Intent intent;

        switch(view.getId()){
            case R.id.userProfile:intent=new Intent(this, ProfileActivity.class);
            startActivity(intent);
            break;
            case R.id.myLocation:intent=new Intent(this, MapsActivity.class);
            startActivity(intent);
            break;
            case R.id.nearby:intent=new Intent(this, NearbyHospital.class);
                startActivity(intent);
                break;
            case R.id.aboutUs:intent=new Intent(this, aboutUs.class);
                startActivity(intent);
                break;
            default:break;
        }

    }
}
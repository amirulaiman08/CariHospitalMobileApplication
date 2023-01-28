package com.example.groupproject;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
public class ProfileActivity extends AppCompatActivity {
    TextView profileName, profileEmail, profileUsername, profilePassword, loginUsername;
    TextView titleName, titleUsername;
    FirebaseDatabase firebaseDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseDatabase = FirebaseDatabase.getInstance();
        profileName = findViewById(R.id.profileName);
        profileEmail = findViewById(R.id.profileEmail);
        profileUsername = findViewById(R.id.profileUsername);
        profilePassword = findViewById(R.id.profilePassword);
        titleName = findViewById(R.id.titleName);
        titleUsername = findViewById(R.id.titleUsername);

        showAllUserData();



    }
    public void showAllUserData(){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("users").child("aiman");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String nameFromDB = snapshot.child("name").getValue(String.class);
                String emailFromDB = snapshot.child("email").getValue(String.class);
                String usernameFromDB = snapshot.child("username").getValue(String.class);
                String passwordFromDB = snapshot.child("password").getValue(String.class);

                titleName.setText(nameFromDB);
                titleUsername.setText(usernameFromDB);
                profileName.setText(nameFromDB);
                profileEmail.setText(emailFromDB);
                profileUsername.setText(usernameFromDB);
                profilePassword.setText(passwordFromDB);


            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }


}





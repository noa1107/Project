package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String uName = getIntent().getStringExtra("userName");
/*
        FirebaseFirestore db= FirebaseFirestore.getInstance();
        post p=new post();
        p.setConect("fds");
        p.setSubject("fsd");
        p.setUserName("fsdf");
        db.collection("users").add(p);

 */
    }

}

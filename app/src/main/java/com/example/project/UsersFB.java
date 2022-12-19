package com.example.project;

import com.google.firebase.firestore.FirebaseFirestore;

public class UsersFB
{
    private FirebaseFirestore db= FirebaseFirestore.getInstance();


    public void addUser(User u )
    {
        db.collection("users").add(u);
    }

}

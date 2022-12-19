package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Profile extends AppCompatActivity
{
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
    public void setUserProfile(String mail,String password)
    {
        this.user=new User(mail,password);
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = new User(user);
    }


    private void setSpinner()
    {
        Spinner spinnerCountry=findViewById(R.id.spinnerCountry);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.city, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
    }

    public void updateProfile()
    {
        Intent i=getIntent();
        this.user.setEmail(i.getStringExtra("mail"));
        this.user.setPassword(i.getStringExtra("password"));
        EditText editTextPhone=findViewById(R.id.editTextPhone);
        String etPhone=editTextPhone.getText().toString();
        user.setPhoneNumber(etPhone);

        // save to firebase
        UsersFB uFB = new UsersFB();
        uFB.addUser(user);
    }


}
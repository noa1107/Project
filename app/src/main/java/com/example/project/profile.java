package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class profile extends AppCompatActivity
{
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
    private void setSpinner()
    {
        Spinner spinnerCity=findViewById(R.id.spinnerCountry);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.city, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
    }

    public void updateProfile()
    {
         user = new User();
        EditText editTextPhone=findViewById(R.id.editTextPhone);
        String etPhone=editTextPhone.getText().toString();
        user.setPhoneNumber(etPhone);

        // save to firebase
        UsersFB uFB = new UsersFB();
        uFB.addUser(user);
    }


}
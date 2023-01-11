package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Profile extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private User user;
    private Spinner spC;
    private  String cCountry;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        this.user=new User();
        spC=findViewById(R.id.spinnerCountry);
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this,R.array.countries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spC.setAdapter(adapter);
        spC.setOnItemSelectedListener(this);
    }

    public void updateProfile(View view)
    {
        Intent i=getIntent();
        this.user.setEmail(i.getStringExtra("mail"));
        EditText editTextPhone=findViewById(R.id.editTextPhone);
        String etPhone=editTextPhone.getText().toString();
        user.setPhoneNumber(etPhone);
        EditText editTextUname=findViewById(R.id.editTextTextPersonName);
        String Uname=editTextUname.getText().toString();
        user.setuName(Uname);
        user.setbCountry(cCountry);
        FirebaseFirestore db=FirebaseFirestore.getInstance();
        db.collection("users").add(user).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if(task.isSuccessful())
                    Toast.makeText(Profile.this, "success", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Profile.this, "fail", Toast.LENGTH_SHORT).show();


            }
        });

        // save to firebase
      //  UsersFB uFB = new UsersFB();
        //uFB.addUser(user);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
    {
        cCountry= adapterView.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {
        Toast.makeText(this, "Choose a country", Toast.LENGTH_SHORT).show();
    }
}
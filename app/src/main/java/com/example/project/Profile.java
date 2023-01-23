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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class Profile extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private User user;
    private Spinner spC;
    private  String cCountry;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        db = FirebaseFirestore.getInstance();

        checkIfProfileSet();
        if(db.collection("users")!=null)
            gotoHomeActivity();
        this.user=new User();
        spC=findViewById(R.id.spinnerCountry);
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this,R.array.countries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spC.setAdapter(adapter);
        spC.setOnItemSelectedListener(this);
    }

    private void checkIfProfileSet() {
        String mail = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        db.collection("users").whereEqualTo("email",mail).limit(1).get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        // indicator for success
                        if(task.isSuccessful())
                        {
                            // get result -> array of results
                            // size can be 0 - no profile updated
                            // stay here
                            // size can be 1 -> read user data continue
                            if( task.getResult().size() == 1)
                            {
                                Intent i = new Intent(Profile.this,HomeActivity.class);
                                startActivity(i);
                            }
                        }
                    }
                });


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
        db.collection("users").add(user).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(Profile.this, "success", Toast.LENGTH_SHORT).show();
                    gotoHomeActivity();
                }
                else
                    Toast.makeText(Profile.this, "fail", Toast.LENGTH_SHORT).show();
            }
        });
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
    private void gotoHomeActivity()
    {
        Intent intent= new Intent(this,HomeActivity.class);
        startActivity(intent);
    }


}
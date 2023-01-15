package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.checkerframework.common.returnsreceiver.qual.This;

public class LogIn extends AppCompatActivity
{
    private FirebaseAuth mAuth= FirebaseAuth.getInstance();
    User user=new User();
    String mail="";
    String password="";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        if(mAuth.getCurrentUser()!=null)
        {
            mail = mAuth.getCurrentUser().getEmail();
            gotoProfileActivity();
        }
    }
    public void signIn(View view)
    {
        EditText etEmail = findViewById(R.id.editTextTextEmailAddress);
        mail = etEmail.getText().toString();
        EditText etPassword = findViewById(R.id.editTextTextPassword);
        password = etPassword.getText().toString();
        if(TextUtils.isEmpty(etEmail.getText()) || TextUtils.isEmpty(etPassword.getText().toString()))
        {
            return;
        }
        mAuth.createUserWithEmailAndPassword(mail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                // check if success or fail
                if(task.isSuccessful())
                {

                   gotoProfileActivity();

                }
                else
                {
                    Toast.makeText(LogIn.this,"failed, " + task.getException(),Toast.LENGTH_LONG).show();
                }

            }
        });

    }


    private void gotoProfileActivity()
    {
        Intent intent= new Intent(this,Profile.class);
        intent.putExtra("mail",mail);
        startActivity(intent);

    }
}
package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.project.databinding.ActivityHomeBinding;
import com.google.android.gms.location.FusedLocationProviderClient;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding binding;

    private FusedLocationProviderClient fusedLocationProviderClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.person:
                    replaceFragment(new PersonFragment());
                    break;
                case R.id.settings:
                    replaceFragment(new SettingsFragment());
                    break;
            }
            return true;
        });

    }
    private void replaceFragment(Fragment fragment)
    {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.bottomNavigationView,fragment);
        fragmentTransaction.commit();
    }
    public void gotoCreateTrackActivity(View view)
    {
        Intent intent= new Intent(this,CreateTrack.class);
        startActivity(intent);
    }

}
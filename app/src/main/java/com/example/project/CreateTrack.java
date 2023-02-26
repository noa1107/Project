package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class CreateTrack extends AppCompatActivity {

    SearchView searchView;
    ListView listView;
    ArrayList arrayList;
    ArrayAdapter arrayAdapter;
    ArrayAdapter places;
    private Track track;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_track);
        track=new Track();
        searchView=findViewById(R.id.searchView);
        listView=findViewById(R.id.listView);

        arrayList=new ArrayList<>();
        arrayList.add("Israel");
        arrayList.add("US");
        arrayList.add("Italy");
        arrayList.add("Spain");
        arrayList.add("England");
        arrayAdapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                arrayAdapter.getFilter().filter(query);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String text)
            {
                arrayAdapter.getFilter().filter(text);
                return false;
            }
        });
    }
}
package com.example.countryapprecyclerview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView countryRecyclerView;
    CountryAdapter adapter;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener((view)->{
            Intent intent = new Intent(this, AddCountryActivity.class);
            startActivityForResult(intent, 101);
        });

        countryRecyclerView = findViewById(R.id.countryRecyclerView);
        adapter = new CountryAdapter(this);
        countryRecyclerView.setAdapter(adapter);


        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        countryRecyclerView.setLayoutManager(manager);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 101 && resultCode == RESULT_OK && data != null) {
            String countryName = data.getStringExtra("NAME");
            adapter.addCountryName(countryName);
        }
    }
}
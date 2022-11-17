package com.example.fragmentessentials;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFirstFragment();
    }

    void addFirstFragment() {
        FirstFragment ff = new FirstFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.mainLayout, ff, "FF").commit();


    }
}
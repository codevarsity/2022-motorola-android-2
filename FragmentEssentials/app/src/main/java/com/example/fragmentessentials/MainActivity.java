package com.example.fragmentessentials;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFirstFragment();
    }

    void addFirstFragment() {
        //create the fragment object
        FirstFragment ff = new FirstFragment();

        //get access to the fragment manager
        FragmentManager manager = getSupportFragmentManager();

        /*add a fragment to the activity */
        //create a fragment transaction
        manager.beginTransaction().add(R.id.mainLayout, ff, "FF").commit();
    }
}
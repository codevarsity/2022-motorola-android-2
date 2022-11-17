package com.example.activityessentials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView userTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        userTextView = findViewById(R.id.userTextViewSecondActiity);

        //get access to the launching intent
        Intent launchingIntent = getIntent();
        String message = launchingIntent.getStringExtra("MESSAGE");
        if (message != null) {
            userTextView.setText(message);
        }
    }
}
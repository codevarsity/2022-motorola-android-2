package com.example.countryapprecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddCountryActivity extends AppCompatActivity {

    Button doneButton;
    Button cancelButton;
    EditText countryNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_country);

        countryNameEditText = findViewById(R.id.countryNameEditText);
        doneButton = findViewById(R.id.doneButton);
        doneButton.setOnClickListener((view)->{
            Intent intent = new Intent();
            String countryName = countryNameEditText.getText().toString();
            intent.putExtra("NAME", countryName);
            setResult(RESULT_OK, intent);
            finish();
        });
        cancelButton = findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener((view)->{
            setResult(RESULT_CANCELED);;
            finish();
        });


    }
}
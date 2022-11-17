package com.example.activityessentials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;

class Book implements Serializable {
    String title;
    String author;
}


public class MainActivity extends AppCompatActivity {

    EditText userEditText;
    TextView userTextView;
    Button showButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userEditText = findViewById(R.id.userMessageEditText);
        userTextView = findViewById(R.id.textView);
        showButton = findViewById(R.id.showButton);

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("MainActivity", "Button Tapped");
                String userText = userEditText.getText().toString();
                //userTextView.setText(userText);


                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                Book book = new Book();
//                book.title = "Head First Android";
//                intent.putExtra("BOOK", book);

                intent.putExtra("MESSAGE", userText);
                startActivity(intent);
            }
        });

    }

    public void show(View view) {
        String userText = userEditText.getText().toString();
        userTextView.setText(userText);
    }
}
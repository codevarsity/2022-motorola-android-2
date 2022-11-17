package com.example.todomanager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> taskList = new ArrayList<>();
    TextView taskListTextView;
    Button addTaskButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //if portrait
        setContentView(R.layout.activity_main);



        Log.i("MainActivity", "onCreate");

 //       setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        taskListTextView = findViewById(R.id.taskListTextView);
        addTaskButton = findViewById(R.id.addTaskButton);
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddTask.class);
                startActivityForResult(intent, 101);
                //startActivity(intent);
            }
        });


        if(savedInstanceState != null) {
            taskList = savedInstanceState.getStringArrayList("TASK_LIST");
        } else {
            initializeSampleTasks();
        }

        updateUI();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("MainActivity", "onSaveInstanceState");
        outState.putStringArrayList("TASK_LIST", taskList);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity", "onResume");
        updateUI();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity", "onDestroy");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 101 && resultCode == RESULT_OK && data != null) {
            String title = data.getStringExtra("TITLE");
            taskList.add(title);

        }
    }

    void updateUI() {
        String text = convertArrayToString(taskList);
        taskListTextView.setText(text);
    }

    String convertArrayToString(ArrayList<String> items) {
        StringBuilder builder = new StringBuilder();
        for(String item : items ){
            builder.append(item);
            builder.append("\n");
        }
        return builder.toString();
    }

    void initializeSampleTasks() {
        taskList.add("Get Milk");
        taskList.add("Attend Android Training");
    }
}
package com.example.todomanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddTask extends AppCompatActivity {

    EditText taskTitleEditText;
    Button doneButton;
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        taskTitleEditText = findViewById(R.id.taskTitleEditText);
        doneButton = findViewById(R.id.doneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taskTitle = taskTitleEditText.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("TITLE", taskTitle);

                //send data back to parent
                setResult(RESULT_OK, intent);
                finish();

            }
        });
        cancelButton = findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

    }


}
package com.example.datapersistenceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);
    }

    public void writeToDB(View view) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", "Raj Singh");
        values.put("phone", "5555555555");
        long result  = database.insert("contact", null, values);
        Log.i("MainActivity", "Result = " + result);
    }

    public void readFromDB(View view) {
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Cursor cursor = database.query("contact", null, null, null, null, null, null);
        cursor.moveToFirst();
        String name = cursor.getString(1);
        Log.i("MainActivity", "Name = " + name);

    }

    public void writeSharedPref(View view) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        prefs.edit().putBoolean("ENABLE_SOMETHING", true).commit();

    }

    public void readSharedPref(View view) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean value = prefs.getBoolean("ENABLE_SOMETHING", false);
        Log.i("MainActivity", "Value = " + value);
    }

    public void writeToFile(View view) {
        //file output stream
        try {
            FileOutputStream outStream = openFileOutput("test.txt", MODE_PRIVATE);
            OutputStreamWriter writer = new OutputStreamWriter(outStream);
            BufferedWriter bufWriter = new BufferedWriter(writer);
            bufWriter.write("Hello WOrld!!!!!");
            bufWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
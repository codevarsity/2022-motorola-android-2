package com.example.boundserviceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    IStringConcat serviceInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void initialize(View view) {
        Intent intent = new Intent(this, StringConcatService.class);

        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                serviceInterface = IStringConcat.Stub.asInterface(iBinder);
                if(serviceInterface != null) {
                    Log.i("MainActivity", "Connected");
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        }, Service.BIND_AUTO_CREATE);
    }

    public void concatenate(View view) {
        ArrayList<String> items = new ArrayList<>();
        items.add("Hello");
        items.add("World");
        try {
            String result = serviceInterface.concat(items);
            Log.i("MainActivity", result);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
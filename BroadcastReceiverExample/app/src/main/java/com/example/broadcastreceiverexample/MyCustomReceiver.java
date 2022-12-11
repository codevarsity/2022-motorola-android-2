package com.example.broadcastreceiverexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyCustomReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //This method will be called on the main thread of the application
        //we must return as promptly as we can, and not make any blocking calls
        //Can't do any network IO

        Log.i("MyCustomReceiver", "Intent = " + intent.toString());
        Log.i("MyCustomReceiver", "MyCustomReceiverLaunched");
    }
}
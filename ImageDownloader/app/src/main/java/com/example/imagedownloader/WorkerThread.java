package com.example.imagedownloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WorkerThread extends Thread{
    Handler uiHandler;
    private Handler handler;

    public WorkerThread(Handler uiHandler) {
        this.uiHandler = uiHandler;
    }

    public synchronized void stopWorkerThread() {
        Looper.myLooper().quitSafely();
    }


    public synchronized void downloadImage(String link) {
        Message msg = handler.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putString("LINK", link);
        msg.setData(bundle);
        handler.sendMessage(msg);
    }

    @Override
    public void run() {
        Looper.prepare();
        handler = new Handler(Looper.myLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);

                Bundle data = msg.getData();
                String link = data.getString("LINK");
                Bitmap image = ImageUtilities.getImage(link);
                if(image != null) {
                    Log.i("MainActivity", "Image downloaded successfully");
                    //update the UI
                    Message uiMessage = uiHandler.obtainMessage();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("IMAGE", image);
                    uiMessage.setData(bundle);
                    uiHandler.sendMessage(uiMessage);
                }

            }
        };
        Looper.loop();
    }

}

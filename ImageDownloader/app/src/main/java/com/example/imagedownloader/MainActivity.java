package com.example.imagedownloader;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import kotlin.random.URandomKt;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    WorkerThread workerThread;

    //Data Message Handling
//    Handler handler = new Handler(Looper.getMainLooper()) {
//        @Override
//        public void handleMessage(@NonNull Message msg) {
//            super.handleMessage(msg);
//
//            Log.i("MainActivity", "Handler Received teh message");
//
//            Bitmap image = msg.getData().getParcelable("IMAGE");
//            imageView.setImageBitmap(image);
//        }
//    };

    Handler taskMessageHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Bundle bundle = msg.getData();
            Bitmap image = bundle.getParcelable("IMAGE");
            imageView.setImageBitmap(image);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        workerThread = new WorkerThread(taskMessageHandler);
        workerThread.start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        workerThread.stopWorkerThread();
    }

    public void download(View view) {
        workerThread.downloadImage("https://www.freepnglogos.com/uploads/android-logo-png/android-logo-symbol-free-download-icon-26.png");


    }


}
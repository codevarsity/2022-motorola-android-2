package com.example.imagedownloader;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivityAsyncTask extends AppCompatActivity {

    ImageView imageView;
    ImageDownloaderTask downloaderTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
    }



    public void download(View view) {

        Log.i("MainActivity", "download method");
        downloaderTask = new ImageDownloaderTask(imageView);
        ExecutorService service = Executors.newFixedThreadPool(2);
        downloaderTask.executeOnExecutor(service, "https://www.freepnglogos.com/uploads/android-logo-png/android-logo-symbol-free-download-icon-26.png");


    }


}
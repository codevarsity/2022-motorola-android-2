package com.example.imagedownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityService extends AppCompatActivity {

    ImageView imageView;
    ImageBroadcastReceiver receiver = new ImageBroadcastReceiver();
    class ImageBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bitmap image = intent.getParcelableExtra("IMAGE");
            imageView.setImageBitmap(image);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.example.imagedownloader.IMAGE");
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

    }

    public void download(View view) {
        Intent intent = new Intent(this, ImageDownloaderService.class);
        intent.putExtra("LINK", "https://www.freepnglogos.com/uploads/android-logo-png/android-logo-symbol-free-download-icon-26.png");
        startService(intent);

    }


}
package com.example.imagedownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityServiceResultReceiver extends AppCompatActivity {

    ImageView imageView;
    Handler uiHandler = new Handler();
    ResultReceiver resultReceiver = new ResultReceiver(uiHandler) {
        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            super.onReceiveResult(resultCode, resultData);
            if (resultCode == 101) {
                Bitmap image = resultData.getParcelable("IMAGE");
                imageView.setImageBitmap(image);
            }
        }
    };


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

    }

    public void download(View view) {
        Intent intent = new Intent(this, ImageDownloaderService.class);
        intent.putExtra("RESULT", resultReceiver);
        intent.putExtra("LINK", "https://www.freepnglogos.com/uploads/android-logo-png/android-logo-symbol-free-download-icon-26.png");
        startService(intent);

    }


}
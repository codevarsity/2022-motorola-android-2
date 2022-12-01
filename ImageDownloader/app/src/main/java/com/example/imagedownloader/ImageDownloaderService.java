package com.example.imagedownloader;

import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ResultReceiver;

public class ImageDownloaderService extends Service {
    public ImageDownloaderService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String link = intent.getStringExtra("LINK");
        Thread thread = new Thread(()->{
            Bitmap image = ImageUtilities.getImage(link);
            if(image != null) {
                ResultReceiver receiver = intent.getParcelableExtra("RESULT");
                Bundle bundle = new Bundle();
                bundle.putParcelable("IMAGE", image);
                receiver.send(101, bundle);

//                Intent broadcastIntent = new Intent("com.example.imagedownloader.IMAGE");
//                broadcastIntent.putExtra("IMAGE", image);
//                sendBroadcast(broadcastIntent);
//                stopSelf();
            }
        });
        thread.start();

        return START_NOT_STICKY;
    }
}
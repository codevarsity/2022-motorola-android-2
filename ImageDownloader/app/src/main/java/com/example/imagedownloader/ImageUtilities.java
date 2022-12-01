package com.example.imagedownloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ImageUtilities {
    static Bitmap getImage(String link) {
        try {
            URL url = new URL(link);
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            Bitmap imageBitmap = BitmapFactory.decodeStream(inputStream);
            if(imageBitmap != null) {
                Log.i("MainActivity", "Image Downloaded SUccessfully");
                return imageBitmap;
            } else {
                Log.i("MainActivity", "Unable to download Image");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

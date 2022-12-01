package com.example.imagedownloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ImageDownloaderTask extends AsyncTask<String, Integer, Bitmap> {

    ImageView imageView;

    public ImageDownloaderTask(ImageView imageView) {
        this.imageView = imageView;
    }


    @Override
    protected Bitmap doInBackground(String... strings) {
        String link = strings[0];
        Bitmap image = ImageUtilities.getImage(link);
        publishProgress(10);
        return image;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        //update the progress bar
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        imageView.setImageBitmap(bitmap);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }
}

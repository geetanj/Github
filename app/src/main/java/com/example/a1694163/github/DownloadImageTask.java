package com.example.a1694163.github;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;

/**
 * Created by 1694163 on 9/9/2017.
 */

public class DownloadImageTask extends AsyncTask<String,Void,Bitmap>{

    ImageView avatar;

    public DownloadImageTask(ImageView avatar) { this.avatar=avatar;
    }


    @Override
    protected Bitmap doInBackground(String... urls) {

        String urlimage=urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urlimage).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }
    protected void onPostExecute(Bitmap result) {
        avatar.setImageBitmap(result);
    }
}

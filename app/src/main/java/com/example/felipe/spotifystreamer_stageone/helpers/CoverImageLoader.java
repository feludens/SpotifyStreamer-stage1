package com.example.felipe.spotifystreamer_stageone.helpers;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.felipe.spotifystreamer_stageone.R;
import com.example.felipe.spotifystreamer_stageone.activities.MainActivity;

import java.io.InputStream;
import java.net.URL;

public class CoverImageLoader extends AsyncTask<String, String, Bitmap> {
    ProgressDialog pDialog;
    Bitmap coverImage;
    MainActivity mainActivity;

    public void setMainActivity(MainActivity activity){
        this.mainActivity = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(mainActivity);
        pDialog.setMessage("Loading Image ....");
        pDialog.show();

    }
    protected Bitmap doInBackground(String... args) {
        try {
            coverImage = BitmapFactory.decodeStream((InputStream) new URL(args[0]).getContent());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return coverImage;
    }

    protected void onPostExecute(Bitmap image) {
        if(image != null){
            pDialog.dismiss();
            //mainActivity.tempCoverImage = coverImage;
        }else{
            pDialog.dismiss();
        }
    }
}
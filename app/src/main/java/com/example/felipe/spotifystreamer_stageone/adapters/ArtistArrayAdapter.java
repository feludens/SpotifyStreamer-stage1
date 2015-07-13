package com.example.felipe.spotifystreamer_stageone.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.felipe.spotifystreamer_stageone.R;
import com.example.felipe.spotifystreamer_stageone.activities.MainActivity;
import com.example.felipe.spotifystreamer_stageone.models.ArtistResults;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class ArtistArrayAdapter extends ArrayAdapter<ArtistResults> {

    public Context context;

    public ArtistArrayAdapter(Context context, ArrayList<ArtistResults> albums) {
        super(context, 0, albums);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ArtistResults album = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_artist_search, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.artistName);
        ImageView imCover = (ImageView) convertView.findViewById(R.id.coverPicture);
        // Populate the data into the template view using the data object
        tvName.setText(album.getName());
        imCover.setImageBitmap(album.getAlbumCover());
        // Return the completed view to render on screen
        return convertView;
    }

}
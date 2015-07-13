package com.example.felipe.spotifystreamer_stageone.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.felipe.spotifystreamer_stageone.R;
import com.example.felipe.spotifystreamer_stageone.models.MyTracks;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import kaaes.spotify.webapi.android.models.Track;

public class TracksArrayAdapter extends ArrayAdapter<MyTracks> {

    public Context context;
    public Bitmap bitmap;
    ArrayList<MyTracks> myTracks;

    public TracksArrayAdapter(Context context, ArrayList<MyTracks> myTracks) {
        super(context, 0, myTracks);
        this.context = context;
        this.myTracks = myTracks;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        MyTracks track = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_top_tracks, parent, false);
        }
        // Lookup view for data population
        TextView tvTrackName = (TextView) convertView.findViewById(R.id.trackName);
        TextView tvAlbumName = (TextView) convertView.findViewById(R.id.albumName);
        ImageView imCover = (ImageView) convertView.findViewById(R.id.trackPicture);

        // Populate the data into the template view using the data object
        tvTrackName.setText(track.getName());
        tvAlbumName.setText(track.getAlbum());
        imCover.setImageBitmap(track.getCoverImage());

        // Return the completed view to render on screen
        return convertView;
    }
}
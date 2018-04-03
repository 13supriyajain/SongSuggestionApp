package com.supjain.songsuggestionapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * This is a custom ArrayAdapter class to iterate over SongDetails object Arraylist and inflate
 * songs.xml layout for each list view item representing a song
 */
public class SongListAdapter extends ArrayAdapter<SongDetails> {

    /**
     * This is SongListAdapter class's constructor, calling its super ArrayAdapter constructor with
     * activity context and ArrayList of SongDetails object.
     */
    public SongListAdapter(Activity context, ArrayList<SongDetails> songDetails) {
        super(context, 0, songDetails);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.songs, parent, false);
        }

        // Get the {@link SongDetails} object located at this position in the list
        final SongDetails currentSong = getItem(position);

        // Find the ImageView in the songs.xml layout with the ID songImg
        ImageView songImage = (ImageView) listItemView.findViewById(R.id.songImg);
        // Get the Image Resource Id for current SongDetails object and set it for this ImageView
        songImage.setImageResource(currentSong.getSongImageResourceId());

        // Find the TextView in the songs.xml layout with the ID songName
        TextView songName = (TextView) listItemView.findViewById(R.id.songName);
        // Get the name of the song for current SongDetails object and set it in the text view
        songName.setText(currentSong.getSongName());

        // Find the TextView in the songs.xml layout with the ID songAlbum
        TextView songAlbum = (TextView) listItemView.findViewById(R.id.songAlbum);
        // Get the Album name of the song for current SongDetails object and set it in the text view
        songAlbum.setText("Album: " + currentSong.getSongAlbum());

        // Find the TextView in the songs.xml layout with the ID songArtist
        TextView songArtist = (TextView) listItemView.findViewById(R.id.songArtist);
        // Get the Artist name of the song for current SongDetails object and set it in the text view
        songArtist.setText("Artist: " + currentSong.getSongArtist());

        return listItemView;
    }
}

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
 * This is a custom ArrayAdapter class to iterate over SongCategory object Arraylist and inflate
 * a song_category layout for each grid view item representing a song category
 */
public class CategoryAdapter extends ArrayAdapter<SongCategory> {

    /**
     * This is CategoryAdapter class's constructor, calling its super ArrayAdapter constructor with
     * activity context and ArrayList of SongCategory object.
     */
    public CategoryAdapter(Activity context, ArrayList<SongCategory> categories) {
        super(context, 0, categories);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    grid view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View gridItemView = convertView;
        if (gridItemView == null) {
            gridItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_category, parent, false);
        }

        // Get the {@link SongCategory} object located at this position in the grid
        final SongCategory currentCategory = getItem(position);

        // Find the TextView in the song_category.xml layout with the ID categoryText
        TextView categoryName = (TextView) gridItemView.findViewById(R.id.categoryText);
        // Get the name of the category for current SongCategory object and set it in the text view
        categoryName.setText(currentCategory.getCategoryName());

        // Find the ImageView in the song_category.xml layout with the ID categoryImg
        ImageView categoryImage = (ImageView) gridItemView.findViewById(R.id.categoryImg);
        // Get the Image Resource Id for current SongCategory object and set it for this ImageView
        categoryImage.setImageResource(currentCategory.getImageResourceId());

        return gridItemView;
    }
}

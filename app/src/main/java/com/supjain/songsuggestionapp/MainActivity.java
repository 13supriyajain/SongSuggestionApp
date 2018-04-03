package com.supjain.songsuggestionapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ArrayList of SongCategory class objects
        final ArrayList<SongCategory> categories = new ArrayList<>();
        categories.add(new SongCategory("Romantic", R.drawable.romance));
        categories.add(new SongCategory("Friendship", R.drawable.friendship));
        categories.add(new SongCategory("Birthday Party", R.drawable.birthday));
        categories.add(new SongCategory("House Party", R.drawable.party));
        categories.add(new SongCategory("Road Trip", R.drawable.road_trip));
        categories.add(new SongCategory("Workout", R.drawable.workout));

        //Create an object of custom ArrayAdapter class (CategoryAdapter) and attach it to 'songCategoryView' GridView
        CategoryAdapter categoryAdapter = new CategoryAdapter(this, categories);
        GridView gridView = findViewById(R.id.songCategoryView);
        gridView.setAdapter(categoryAdapter);

        /* Set onItemClickListener for GridView items. When user clicks on a particular song category,
        * display a toast message for the category clicked, load respective Activity class
        * and display list of songs from that category.*/
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String categoryPicked = categories.get(position).getCategoryName();
                switch (categoryPicked) {
                    case "Romantic":
                        Toast.makeText(MainActivity.this, "Romantic Category Picked", Toast.LENGTH_SHORT).show();
                        // Create a new intent to open the {@link RomanticCategoryActivity}
                        Intent romanticCatIntent = new Intent(MainActivity.this, RomanticCategoryActivity.class);
                        // Start the new activity
                        startActivity(romanticCatIntent);
                        break;
                    case "Friendship":
                        Toast.makeText(MainActivity.this, "Friendship Category Picked", Toast.LENGTH_SHORT).show();
                        // Create a new intent to open the {@link FriendshipCategoryActivity}
                        Intent friendshipCatIntent = new Intent(MainActivity.this, FriendshipCategoryActivity.class);
                        // Start the new activity
                        startActivity(friendshipCatIntent);
                        break;
                    case "Birthday Party":
                        Toast.makeText(MainActivity.this, "Birthday Category Picked", Toast.LENGTH_SHORT).show();
                        // Create a new intent to open the {@link BirthdayPartyCategoryActivity}
                        Intent birthdayPartyCatIntent = new Intent(MainActivity.this, BirthdayPartyCategoryActivity.class);
                        // Start the new activity
                        startActivity(birthdayPartyCatIntent);
                        break;
                    case "House Party":
                        Toast.makeText(MainActivity.this, "Party Category Picked", Toast.LENGTH_SHORT).show();
                        // Create a new intent to open the {@link HousePartyCategoryActivity}
                        Intent housePartyCatIntent = new Intent(MainActivity.this, HousePartyCategoryActivity.class);
                        // Start the new activity
                        startActivity(housePartyCatIntent);
                        break;
                    case "Road Trip":
                        Toast.makeText(MainActivity.this, "Road Trip Category Picked", Toast.LENGTH_SHORT).show();
                        // Create a new intent to open the {@link RoadTripCategoryActivity}
                        Intent roadTripCatIntent = new Intent(MainActivity.this, RoadTripCategoryActivity.class);
                        // Start the new activity
                        startActivity(roadTripCatIntent);
                        break;
                    case "Workout":
                        Toast.makeText(MainActivity.this, "Workout Category Picked", Toast.LENGTH_SHORT).show();
                        // Create a new intent to open the {@link WorkoutCategoryActivity}
                        Intent workoutCatIntent = new Intent(MainActivity.this, WorkoutCategoryActivity.class);
                        // Start the new activity
                        startActivity(workoutCatIntent);
                        break;
                }
            }
        });
    }
}

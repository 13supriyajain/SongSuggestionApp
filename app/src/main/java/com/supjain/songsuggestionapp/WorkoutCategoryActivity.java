package com.supjain.songsuggestionapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * This Activity class is for rendering a list of songs from 'Workout' song category.
 */
public class WorkoutCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        //ArrayList of SongDetails class objects
        final ArrayList<SongDetails> songDetails = new ArrayList<>();
        songDetails.add(new SongDetails(R.drawable.kamli, "Kamli",
                "Dhoom 3", "Sunidhi Chauhan", 2013, "3:59",
                "https://gaana.com/song/kamli-3",
                "https://www.youtube.com/watch?v=C8kSrkz8Hz8",
                "http://www.lyricsmint.com/2013/12/kamli-dhoom-3.html"));
        songDetails.add(new SongDetails(R.drawable.maujahimauja, "Mauja Hi Mauja",
                "Jab We Met", "Mika Singh", 2007, "3:47",
                "https://gaana.com/song/mauja-hi-mauja",
                "https://www.youtube.com/watch?v=PaDaoNnOQaM",
                "http://www.glamsham.com/music/lyrics/jab-we-met/mauja-hi-mauja/681/4943.htm"));
        songDetails.add(new SongDetails(R.drawable.jeekarda, "Jee Karda",
                "Badlapur", "Divya Kumar", 2015, "3:59",
                "https://gaana.com/song/jee-karda-6",
                "https://www.youtube.com/watch?v=VAJK04HOLd0",
                "http://www.lyricsmint.com/2014/12/jee-karda-badlapur.html"));
        songDetails.add(new SongDetails(R.drawable.zinda, "Zinda",
                "Bhaag Milkha Bhaag", "Siddharth Mahadevan", 2013, "2:42",
                "https://gaana.com/song/zinda",
                "https://www.youtube.com/watch?v=fP6MNznzVcQ",
                "http://www.lyricsmint.com/2013/05/zinda-bhaag-milkha-bhaag.html"));
        songDetails.add(new SongDetails(R.drawable.suitsuit, "Suit Suit",
                "Hindi Medium", "Guru Randhawa", 2017, "2:12",
                "https://gaana.com/song/suit-suit",
                "https://www.youtube.com/watch?v=88LgZ-cf_P4",
                "http://www.lyricsted.com/suit-guru-randhawa-arjun/"));
        songDetails.add(new SongDetails(R.drawable.crazykiyare, "Crazy Kiya Re",
                "Dhoom 2", "Sunidhi Chauhan", 2006, "5:04",
                "https://gaana.com/song/crazy-kiya-re",
                "https://www.youtube.com/watch?v=J2Bh68GTUOU",
                "https://www.lyricsmasti.com/song/1373/lyrics-of-Crazy-Kiya-Re.html"));
        songDetails.add(new SongDetails(R.drawable.malhari, "Malhari",
                "Bajirao Mastani", "Vishal Dadlani", 2015, "3:22",
                "https://gaana.com/song/malhari",
                "https://www.youtube.com/watch?v=YUH9jD__qHY",
                "http://www.lyricsmint.com/2015/11/malhari-bajirao-mastani.html"));
        songDetails.add(new SongDetails(R.drawable.ziddidil, "Ziddi Dil",
                "Mary Kom", "Vishal Dadlani", 2014, "2:25",
                "http://www.hungama.com/song/ziddi-dil/2592177/",
                "https://www.youtube.com/watch?v=hu9Ac_HPC7s",
                "http://www.lyricsmint.com/2014/07/ziddi-dil-mary-kom.html"));
        songDetails.add(new SongDetails(R.drawable.manalitrance, "Manali Trance",
                "The Shaukeens", "Neha Kakkar", 2014, "3:39",
                "https://gaana.com/playlist/kumarbhatia1-manalitrance",
                "https://www.youtube.com/watch?v=vZ_NpLWuL00",
                "http://www.lyricsmint.com/2014/10/manali-trance-shaukeens-honey-singh.html"));
        songDetails.add(new SongDetails(R.drawable.jikarda, "Jee Karda",
                "Singh Is Kinng", "Labh Janjua", 2008, "3:41",
                "https://gaana.com/song/jee-karda-5",
                "https://www.youtube.com/watch?v=40IlftR0R_U",
                "lhttps://www.lyricsmasti.com/song/6299/lyrics-of-Jee-Karda.html"));

        //Create an object of custom ArrayAdapter class (SongListAdapter) and attach it to 'song_list' ListView
        SongListAdapter songListAdapter = new SongListAdapter(this, songDetails);
        ListView listView = findViewById(R.id.song_list);
        listView.setAdapter(songListAdapter);

        /* Set onItemClickListener for list items. When user clicks on a song from the list of songs
         * display a new screen with song details, based on the song clicked (position in the ListView).*/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SongDetails songPicked = songDetails.get(position);
                Intent intent = new Intent(WorkoutCategoryActivity.this, SongDetailsDisplayActivity.class);
                intent.putExtra("songDetails", songPicked);
                intent.putExtra("parentActivity", "com.supjain.songsuggestionapp.WorkoutCategoryActivity");
                startActivity(intent);
            }
        });
    }
}

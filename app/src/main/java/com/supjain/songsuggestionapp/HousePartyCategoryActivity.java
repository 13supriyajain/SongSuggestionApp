package com.supjain.songsuggestionapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * This Activity class is for rendering a list of songs from 'House Party' song category.
 */
public class HousePartyCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        //ArrayList of SongDetails class objects
        final ArrayList<SongDetails> songDetails = new ArrayList<>();
        songDetails.add(new SongDetails(R.drawable.kalachashma, "Kala Chashma",
                "Baar Baar Dekho", "Neha Kakkar", 2016, "2:53",
                "https://gaana.com/song/kala-chashma",
                "https://www.youtube.com/watch?v=k4yXQkG2s1E",
                "http://www.lyricsmint.com/2016/07/baar-baar-dekho-kala-chashma.html"));
        songDetails.add(new SongDetails(R.drawable.kargaichull, "Kar Gai Chull",
                "Kapoor And Sons", "Badshah", 2014, "2:22",
                "https://gaana.com/song/kar-gayi-chull",
                "https://www.youtube.com/watch?v=NTHz9ephYTw",
                "http://www.lyricsmint.com/2016/02/kar-gayi-chull-kapoor-and-sons.html"));
        songDetails.add(new SongDetails(R.drawable.nashesichadhgai, "Nashe Si Chadh Gai",
                "Befikre", "Arijit Singh", 2016, "2:34",
                "https://gaana.com/song/nashe-si-chadh-gayi",
                "https://www.youtube.com/watch?v=Wd2B8OAotU8",
                "http://www.lyricsmint.com/2016/10/nashe-si-chadh-gayi-befikre.html"));
        songDetails.add(new SongDetails(R.drawable.tammatamma, "Tamma Tamma",
                "Badrinath Ki Dulhania", "Badshah", 2017, "2:56",
                "https://gaana.com/song/tamma-tamma-again",
                "https://www.youtube.com/watch?v=EEX_XM6SxmY",
                "http://www.lyricsmint.com/2017/02/tamma-tamma-again-badrinath-ki-dulhania.html"));
        songDetails.add(new SongDetails(R.drawable.babydoll, "Baby Doll",
                "Ragini MMS 2", "Meet Bros", 2014, "2:24",
                "https://gaana.com/song/baby-doll-21",
                "https://www.youtube.com/watch?v=kShTN0Jz6Jg",
                "http://www.lyricsmint.com/2014/02/baby-doll-ragini-mms-2-sunny-leone.html"));
        songDetails.add(new SongDetails(R.drawable.badtameezdil, "Badtameez Dil",
                "Yeh Jawaani Hai Deewani", "Benny Dayal", 2013, "4:30",
                "https://gaana.com/song/badtameez-dil",
                "https://www.youtube.com/watch?v=II2EO3Nw4m0",
                "http://www.lyricsmint.com/2013/04/badtameez-dil-yjhd.html"));
        songDetails.add(new SongDetails(R.drawable.dhoomagain, "Dhoom Again",
                "Dhoom 2", "Vishal Dadlani", 2006, "5:38",
                "https://gaana.com/song/dhoom-again",
                "https://www.youtube.com/watch?v=WGXmDsOwW4k",
                "http://www.lyricsoff.com/songs/dhoom-again.html"));
        songDetails.add(new SongDetails(R.drawable.abhitohparty, "Abhi To Party Shuru Hui Hai",
                "Khoobsurat", "Badshah", 2014, "3:09",
                "https://gaana.com/song/abhi-toh-party-shuru-hui-hai",
                "https://www.youtube.com/watch?v=8LZgzAZ2lpQ",
                "http://www.lyricsmint.com/2014/08/abhi-toh-party-badshah-khoobsurat.html"));
        songDetails.add(new SongDetails(R.drawable.jummekiraat, "Jumme Ki Raat",
                "Kick", "Salman Khan", 2014, "5:11",
                "https://gaana.com/song/jumme-ki-raat",
                "https://www.youtube.com/watch?v=dv_Qjzca56k",
                "http://www.lyricsmint.com/2014/06/jumme-ki-raat-kick.html"));
        songDetails.add(new SongDetails(R.drawable.thediscosong, "The Disco Song",
                "Student Of The Year", "Sunidhi Chauhan", 2012, "5:56",
                "https://gaana.com/song/the-disco-song-3",
                "https://www.youtube.com/watch?v=mcL6ZErM49Q",
                "http://www.lyricsmint.com/2012/08/the-disco-song-student-of-the-year.html"));

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
                Intent intent = new Intent(HousePartyCategoryActivity.this, SongDetailsDisplayActivity.class);
                intent.putExtra("songDetails", songPicked);
                intent.putExtra("parentActivity", "com.supjain.songsuggestionapp.HousePartyCategoryActivity");
                startActivity(intent);
            }
        });
    }
}

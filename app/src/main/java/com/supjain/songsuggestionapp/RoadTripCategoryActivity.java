package com.supjain.songsuggestionapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * This Activity class is for rendering a list of songs from 'Road Trip' song category.
 */
public class RoadTripCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        //ArrayList of SongDetails class objects
        final ArrayList<SongDetails> songDetails = new ArrayList<>();
        songDetails.add(new SongDetails(R.drawable.yuhichalachal, "Yunhi Chala Chal Rahi",
                "Swades", "Udit Narayan", 2004, "7:24",
                "https://gaana.com/song/yun-hi-chala-chal",
                "https://www.youtube.com/watch?v=-VB2dHVNyds",
                "http://www.glamsham.com/music/lyrics/swades/yun-hi-chala-chal/284/894.htm"));
        songDetails.add(new SongDetails(R.drawable.dilchahtahai, "Dil Chahta Hai",
                "Dil Chahta Hai", "Shankar Mahadevan", 2001, "2:30",
                "https://gaana.com/album/dil-chahta-hai",
                "https://www.youtube.com/watch?v=9coA7bcpJII",
                "http://www.glamsham.com/music/lyrics/dil-chahta-hai/dil-chahta-hai/59/236.htm"));
        songDetails.add(new SongDetails(R.drawable.khwabonkeparindey, "Khwabon Ke Parindey",
                "Zindagi Na Milegi Dobara", "Mohit Chauhan", 2011, "2:04",
                "https://gaana.com/song/khaabon-ke-parinday-1",
                "https://www.youtube.com/watch?v=cscdqZUdgCk",
                "http://www.lyricsmint.com/2011/06/khwabon-ke-parindey-znmd-songs-lyrics.html"));
        songDetails.add(new SongDetails(R.drawable.humjochalnelage, "Hum Jo Chalne Lage",
                "Jab We Met", "Shaan", 2007, "3:29",
                "https://gaana.com/playlist/shreya-sudip-mayekar-hum-jo-chalne-lage",
                "https://www.youtube.com/watch?v=9N7XfmueEOA",
                "http://www.glamsham.com/music/lyrics/jab-we-met/aao-milo-chalo/681/1278.htm"));
        songDetails.add(new SongDetails(R.drawable.zindagieksafar, "Zindagi Ek Safar",
                "Andaz", "Kishore Kumar", 1971, "4:13",
                "https://gaana.com/song/zindagi-ek-safar-hai-suhana-kishore-kumar",
                "https://www.youtube.com/watch?v=8wZDU-DDTOU",
                "http://lyrics.wikia.com/wiki/Kishore_Kumar:Zindagi_Ek_Safar_Hai_Suhana"));
        songDetails.add(new SongDetails(R.drawable.hairat, "Hairat",
                "Anjana Anjani", "Lucky Ali", 2010, "4:05",
                "https://gaana.com/song/hairat",
                "https://www.youtube.com/watch?v=YP08Ehw_bTI",
                "http://www.glamsham.com/music/lyrics/anjaana-anjaani/hairat/1368/3092.htm"));
        songDetails.add(new SongDetails(R.drawable.ilahi, "Ilahi",
                "Yeh Jawaani Hai Deewani", "Arijit Singh", 2013, "3:23",
                "https://gaana.com/song/ilahi-9",
                "https://www.youtube.com/watch?v=fdubeMFwuGs",
                "http://www.lyricsmint.com/2013/04/ilahi-yjhd.html"));
        songDetails.add(new SongDetails(R.drawable.aajkalzindagi, "Aaj Kal Zindagi",
                "Wake Up Sid", "Shankar Mahadevan", 2009, "3:54",
                "https://gaana.com/song/aaj-kal-zindagi-from-wake-up-sid-1",
                "https://www.youtube.com/watch?v=KWA0_kI5PKk",
                "http://www.glamsham.com/music/lyrics/wake-up-sid/aaj-kal-jindagi-mujhase-hai-keh-rahi/1161/2513.htm"));
        songDetails.add(new SongDetails(R.drawable.mastikipaathshala, "Masti Ki Paathshala",
                "Rang De Basanti", "A. R. Rahman", 2005, "2:23",
                "https://gaana.com/album/rang-de-basanti-hindi",
                "https://www.youtube.com/watch?v=FC6BBII9Qs8",
                "http://www.glamsham.com/music/lyrics/rang-de-basanti/apni-toh-paathshala/485/843.htm"));
        songDetails.add(new SongDetails(R.drawable.kabira, "Kabira",
                "Yeh Jawaani Hai Deewani", "Arijit Singh", 2013, "4:11",
                "https://gaana.com/song/kabira-1",
                "https://www.youtube.com/watch?v=jHNNMj5bNQw",
                "http://www.lyricsmint.com/2013/04/kabira-yjhd.html"));

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
                Intent intent = new Intent(RoadTripCategoryActivity.this, SongDetailsDisplayActivity.class);
                intent.putExtra("songDetails", songPicked);
                intent.putExtra("parentActivity", "com.supjain.songsuggestionapp.RoadTripCategoryActivity");
                startActivity(intent);
            }
        });
    }
}

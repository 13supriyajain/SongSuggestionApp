package com.supjain.songsuggestionapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * This Activity class is for rendering a list of songs from 'Friendship' song category.
 */
public class FriendshipCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        //ArrayList of SongDetails class objects
        final ArrayList<SongDetails> songDetails = new ArrayList<>();
        songDetails.add(new SongDetails(R.drawable.yaarondosti, "Yaaron Dosti",
                "Rockford", "KK", 1999, "4:17",
                "https://www.emp3e.co/mp3/yaron-dosti-badi-hi-haseen-hai.html",
                "https://www.youtube.com/watch?v=LCfvYo3ILG0",
                "https://www.lyricsmasti.com/song/4847/lyrics-of-Yaaron-Dosti-Badi-Hi.html"));
        songDetails.add(new SongDetails(R.drawable.tuhitomeradost, "Tu Hi To Mera Dost",
                "Yuvvraaj", "Shreya Ghoshal", 2008, "5:20",
                "https://gaana.com/song/tu-meri-dost-hain",
                "https://www.youtube.com/watch?v=WlNBpjhQCTg",
                "https://www.lyricsmasti.com/song/6479/lyrics-of-Tu-Hi-Toh-Meri-Dost-Hain.html"));
        songDetails.add(new SongDetails(R.drawable.terimeridostika, "Teri Meri Dosti",
                "Radio", "Himesh Reshammiya", 2009, "3:16",
                "https://gaana.com/song/teri-meri-dosti-ka-aasman",
                "https://www.youtube.com/watch?v=u-vMLqkd8ZQ",
                "http://www.hindilyrics.net/lyrics/of-Teri%20Meri%20Dosti%20Ka%20Aasmaan.html"));
        songDetails.add(new SongDetails(R.drawable.dostdostnaraha, "Dost Dost Na Raha",
                "Sangam", "Mukesh", 1964, "4:11",
                "https://gaana.com/song/dost-dost-na-raha-pyar-pyar-na-raha-2",
                "https://www.youtube.com/watch?v=OLnSZSSJp5M",
                "https://www.lyricsmasti.com/song/2026/lyrics-of-Dost-Dost-Na-Raha.html"));
        songDetails.add(new SongDetails(R.drawable.musumusu, "Musu Musu Hasi",
                "Pyaar Mein Kabhi Kabhi", "Shaan", 1999, "3:26",
                "https://gaana.com/song/musu-musu-hasi",
                "https://www.youtube.com/watch?v=5ahWUJsgqGg",
                "https://www.lyricsmasti.com/song/4508/lyrics-of-Musu-Musu-Hasi.html"));
        songDetails.add(new SongDetails(R.drawable.yedosti, "Yeh Dosti",
                "Sholey", "Kishore Kumar", 1975, "6:24",
                "https://gaana.com/song/yeh-dosti-hum-nahin-happy",
                "https://www.youtube.com/watch?v=91z_Q39uu1Q",
                "http://www.lyricsoff.com/songs/ye-dosti-hum-nahin-todenge.html"));
        songDetails.add(new SongDetails(R.drawable.jaanekyun, "Jaane Kyun",
                "Dostana", "Vishal Dadlani", 2008, "4:00",
                "https://gaana.com/song/jaane-kyun",
                "https://www.youtube.com/watch?v=n0PoVxBMUyE",
                "https://www.lyricsmasti.com/song/6470/lyrics-of-Jaane-Kyun-Dil-Jaanta-Hai.html"));
        songDetails.add(new SongDetails(R.drawable.jaanenahidenge, "Jaane Nahi Denge Tujhe",
                "3 Idiots", "Sonu Nigam", 2009, "3:12",
                "https://gaana.com/song/jaane-nahin-denge-tujhe",
                "https://www.youtube.com/watch?v=_svykdZMvJA",
                "http://www.glamsham.com/music/lyrics/3-idiots/jaane-nahin-denge-tujhe/1021/2652.htm"));
        songDetails.add(new SongDetails(R.drawable.terejaisayaar, "Tere Jaisa Yaar Kaha",
                "Yaarana", "Kishore Kumar", 1981, " 3:34",
                "https://gaana.com/song/tere-jaisa-yaar-kahan",
                "https://www.youtube.com/watch?v=9dcBy2uXL7E",
                "http://www.glamsham.com/music/lyrics/yaarana-(1981)/tere-jaisa-yaar-kahan/1694/3346.htm"));
        songDetails.add(new SongDetails(R.drawable.yaarihaiimaan, "Yaari Hai Imaan Mera",
                "Zanjeer", "Manna Dey", 1975, "6:36",
                "https://gaana.com/song/yari-hai-imaan-mera",
                "https://www.youtube.com/watch?v=T_WH2qBkf1Q",
                "http://www.lyricsoff.com/songs/gar-khuda-mujhse-kahe-yaari-hai-imaan-mera.html"));

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
                Intent intent = new Intent(FriendshipCategoryActivity.this, SongDetailsDisplayActivity.class);
                intent.putExtra("songDetails", songPicked);
                intent.putExtra("parentActivity", "com.supjain.songsuggestionapp.FriendshipCategoryActivity");
                startActivity(intent);
            }
        });
    }
}

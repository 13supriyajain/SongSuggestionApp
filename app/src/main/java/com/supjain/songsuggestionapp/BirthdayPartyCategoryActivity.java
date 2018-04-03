package com.supjain.songsuggestionapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * This Activity class is for rendering a list of songs from 'Birthday Party' song category.
 */
public class BirthdayPartyCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        //ArrayList of SongDetails class objects
        final ArrayList<SongDetails> songDetails = new ArrayList<>();
        songDetails.add(new SongDetails(R.drawable.happybudday, "Happy Budday",
                "Kill Dill", "Sukhwinder Singh", 2014, "4:18",
                "https://gaana.com/song/happy-budday",
                "https://www.youtube.com/watch?v=t9QjNLpBj5A",
                "http://www.lyricsoff.com/songs/happy-budday.html"));
        songDetails.add(new SongDetails(R.drawable.loveyouzindagi, "Love You Zindagi",
                "Dear Zindagi", "Amit Trivedi", 2016, "2:43",
                "https://gaana.com/song/love-you-zindagi-from-dear-zindagi",
                "https://www.youtube.com/watch?v=2ZBPjt9NQtk",
                "http://www.lyricsmint.com/2016/10/love-you-zindagi-dear-zindagi.html"));
        songDetails.add(new SongDetails(R.drawable.choteterabirthday, "Chote Tera Birthday Aaya",
                "Krantiveer The Revolution", "Mika Singh", 2010, "3:47",
                "https://gaana.com/song/chhote-tera-birthday-aaya",
                "http://www.dailymotion.com/video/x14xf7i",
                "http://www.glamsham.com/music/lyrics/krantiveer-the-revolution/chhote-tera-birthday-aaya/1328/2940.htm"));
        songDetails.add(new SongDetails(R.drawable.baarbaardin, "Baar Baar Din Ye Aaye",
                "Farz", "Mohammed Rafi", 1967, "6:20",
                "https://gaana.com/song/baar-baar-din-ye-aaye-happy-birthday-to-you",
                "https://www.youtube.com/watch?v=Jn9_6yINCy4",
                "https://www.lyricsmasti.com/song/2406/lyrics-of-Baar-Baar-Din-Yeh-Aaye.html"));
        songDetails.add(new SongDetails(R.drawable.humbhiagarbachhe, "Hum Bhi Agar Bachhe Hote",
                "Door Ki Awaaz", "Mohammed Rafi", 1964, "5:20",
                "https://mp3mad.site/download-185011/Hum-Bhi-Agar-Bachche-Hote-Various-new.html",
                "https://www.youtube.com/watch?v=EM9pkTUQgvk",
                "http://www.lyricsoff.com/songs/hum-bhi-agar-bachche-hote.html"));
        songDetails.add(new SongDetails(R.drawable.tukurtukur, "Tukur Tukur",
                "Dilwale", "Arijit Singh", 2015, "2:22",
                "https://gaana.com/song/tukur-tukur-2",
                "https://www.youtube.com/watch?v=0-ggsgFh5TI",
                "http://www.lyricsmint.com/2015/12/tukur-tukur-dilwale.html"));
        songDetails.add(new SongDetails(R.drawable.aajkiparty, "Aaj ki Party",
                "Bajrangi Bhaijaan", "Mika Singh", 2015, "2:53",
                "https://gaana.com/song/aaj-ki-party",
                "https://www.youtube.com/watch?v=vlS7oilbya0",
                "lhttp://www.lyricsmint.com/2015/07/aaj-ki-party-bajrangi-bhaijaan.html"));
        songDetails.add(new SongDetails(R.drawable.partyallnight, "Party All Night",
                "Boss", " Yo Yo Honey Singh", 2013, "2:54",
                "https://gaana.com/song/04-party-all-nightmp3",
                "https://www.youtube.com/watch?v=NO2R_vOPrYo",
                "http://www.lyricsmint.com/2013/09/party-all-night-boss-honey-singh.html"));
        songDetails.add(new SongDetails(R.drawable.letsnacho, "Lets Nacho",
                "Kapoor And Sons", "Badshah", 2016, "2:43",
                "https://gaana.com/song/lets-nacho",
                "https://www.youtube.com/watch?v=TLnwqAarPkM",
                "http://www.lyricsmint.com/2016/03/lets-nacho-kapoor-and-sons-badshah.html"));
        songDetails.add(new SongDetails(R.drawable.gulaabo, "Gulaabo",
                "Shaandaar", "Vishal Dadlani", 2015, "2:54",
                "http://www.hungama.com/song/gulaabo/16345329/",
                "https://www.youtube.com/watch?v=lYNNgGBVtTo",
                "http://www.lyricsmint.com/2015/09/gulaabo-shaandaar.html"));

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
                Intent intent = new Intent(BirthdayPartyCategoryActivity.this, SongDetailsDisplayActivity.class);
                intent.putExtra("songDetails", songPicked);
                intent.putExtra("parentActivity", "com.supjain.songsuggestionapp.BirthdayPartyCategoryActivity");
                startActivity(intent);
            }
        });
    }
}

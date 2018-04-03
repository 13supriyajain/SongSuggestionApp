package com.supjain.songsuggestionapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * This Activity class is for rendering a list of songs from 'Romantic' song category.
 */
public class RomanticCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        //ArrayList of SongDetails class objects
        final ArrayList<SongDetails> songDetails = new ArrayList<>();
        songDetails.add(new SongDetails(R.drawable.aankhonki, "Aankhon Ki",
                "Hum Dil De Chuke Sanam", "Kumar Sanu", 1999, "4:53",
                "https://gaana.com/song/chand-chhupa-badal-mein-1",
                "https://www.youtube.com/watch?v=3Y1kouWRi1s",
                "http://www.glamsham.com/music/lyrics/hum-dil-de-chuke-sanam/aankhon-ki/73/406.htm"));
        songDetails.add(new SongDetails(R.drawable.agartumsathho, "Agar Tum Sath Ho",
                "Tamasha", "Alka Yagnik", 2015, "2:11",
                "https://gaana.com/song/agar-tum-saath-ho",
                "https://www.youtube.com/watch?v=6SGRn9OHtFY",
                "http://www.lyricsmint.com/2015/09/tum-saath-ho-tamasha.html"));
        songDetails.add(new SongDetails(R.drawable.bolna, "Bolna",
                "Kapoor And Sons", "Arijit Singh", 2016, "2:06",
                "https://gaana.com/song/bolna-1",
                "https://www.youtube.com/watch?v=AJ-7X6cvOhY",
                "http://www.lyricsmint.com/2016/02/bolna-lyrics-kapoor-and-sons.html"));
        songDetails.add(new SongDetails(R.drawable.chahunmainyanaa, "Chahun Main Ya Naa",
                "Aashiqui 2", "Palak Muchhal", 2013, "4:00",
                "https://gaana.com/song/chauhunmainyanaa",
                "https://www.youtube.com/watch?v=VdyBtGaspss",
                "http://www.lyricsmint.com/2013/04/chahun-main-ya-na.html"));
        songDetails.add(new SongDetails(R.drawable.gerua, "Gerua",
                "Dilwale", "Arijit Singh", 2015, "4:47",
                "http://www.hungama.com/song/gerua/16786566/",
                "https://www.youtube.com/watch?v=AEIVhBS6baE",
                "http://www.lyricsmint.com/2015/11/gerua-dilwale.html"));
        songDetails.add(new SongDetails(R.drawable.janamjanam, "Janam Janam",
                "Dilwale", "Arijit Singh", 2015, "2:13",
                "https://gaana.com/song/janam-janam-4",
                "https://www.youtube.com/watch?v=Z9S72lKj_Bw",
                "http://www.lyricsmint.com/2015/12/janam-janam-dilwale.html"));
        songDetails.add(new SongDetails(R.drawable.nahinsamne, "Nahin Samne",
                "Taal", " Hariharan", 1999, "5:59",
                "https://songspk.name/nahin-samne-taal-mp3-song-of-day-app2yx-app21.html",
                "https://www.youtube.com/watch?v=LgIxwwIWroE",
                "http://www.glamsham.com/music/lyrics/taal/nahi-samne/92/973.htm"));
        songDetails.add(new SongDetails(R.drawable.raabta, "Raabta",
                "Agent Vinod", "Hamsika", 2012, "3:13",
                "https://gaana.com/song/raabta-kehte-hain-khuda-ne",
                "https://www.youtube.com/watch?v=-d9nvq3402M",
                "http://www.lyricsmint.com/2012/02/raabta-lyrics-agent-vinod.html"));
        songDetails.add(new SongDetails(R.drawable.sabtera, "Sab Tera",
                "Baaghi", "Shraddha Kapoor", 2016, "2:25",
                "https://gaana.com/song/sab-tera",
                "https://www.youtube.com/watch?v=WRQHV3kDcyo",
                "http://www.lyricsmint.com/2016/03/sab-tera-lyrics-baaghi.html"));
        songDetails.add(new SongDetails(R.drawable.tumhiho, "Tum Hi Ho",
                "Aashiqui 2", "Arijit Singh", 2013, "5:09",
                "https://gaana.com/song/tumhiho",
                "https://www.youtube.com/watch?v=IJq0yyWug1k",
                "http://www.lyricsmint.com/2013/03/tum-hi-ho-aashiqui-2.html"));

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
                Intent intent = new Intent(RomanticCategoryActivity.this, SongDetailsDisplayActivity.class);
                intent.putExtra("songDetails", songPicked);
                intent.putExtra("parentActivity", "com.supjain.songsuggestionapp.RomanticCategoryActivity");
                startActivity(intent);
            }
        });
    }
}

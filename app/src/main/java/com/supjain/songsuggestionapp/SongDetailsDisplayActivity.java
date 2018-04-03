package com.supjain.songsuggestionapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * This Activity class displays details of the song selected by user from list of songs.
 */
public class SongDetailsDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_details);

        //Retrieve extras/data from Intent object to get SongDetails object and parent activity name
        final Bundle intentExtra = getIntent().getExtras();
        if (intentExtra == null) {
            return;
        }
        SongDetails currentSongDetails = (SongDetails) intentExtra.getParcelable("songDetails");

        ImageView songImg = (ImageView) findViewById(R.id.detail_songImg);
        songImg.setImageResource(currentSongDetails.getSongImageResourceId());

        TextView songName = (TextView) findViewById(R.id.detail_songName);
        songName.setText(currentSongDetails.getSongName());

        TextView songAlbum = (TextView) findViewById(R.id.detail_songAlbum);
        songAlbum.setText(currentSongDetails.getSongAlbum());

        TextView songArtist = (TextView) findViewById(R.id.detail_songArtist);
        songArtist.setText(currentSongDetails.getSongArtist());

        TextView songAlbumYear = (TextView) findViewById(R.id.detail_songAlbumYear);
        songAlbumYear.setText(String.valueOf(currentSongDetails.getSongAlbumYear()));

        TextView songDuration = (TextView) findViewById(R.id.detail_songDuration);
        songDuration.setText(currentSongDetails.getSongDuration());

        TextView songAudioLink = (TextView) findViewById(R.id.detail_songAudioLink);
        String audioLink = "<a href=" + currentSongDetails.getSongAudioLink() + ">Audio Link</a>";
        songAudioLink.setMovementMethod(LinkMovementMethod.getInstance());
        songAudioLink.setText(Html.fromHtml(audioLink));

        TextView songVideoLink = (TextView) findViewById(R.id.detail_songVideoLink);
        String videoLink = "<a href=" + currentSongDetails.getSongVideoLink() + ">Video Link</a>";
        songVideoLink.setMovementMethod(LinkMovementMethod.getInstance());
        songVideoLink.setText(Html.fromHtml(videoLink));

        TextView songLyricsLink = (TextView) findViewById(R.id.detail_songLyricsLink);
        String lyricsLink = "<a href=" + currentSongDetails.getSongLyricsLink() + ">Lyrics Link</a>";
        songLyricsLink.setMovementMethod(LinkMovementMethod.getInstance());
        songLyricsLink.setText(Html.fromHtml(lyricsLink));

        /* When 'Back to Song List' button is clicked, take user back to parent song category activity
        * using explicit intent. To get the name of the parent activity use intentExtra data.
        * */
        Button backToSongListBtn = (Button) findViewById(R.id.btn_backToSongList);
        backToSongListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String parentActivityName = intentExtra.getString("parentActivity");
                Class parentActivity = MainActivity.class;
                try {
                    parentActivity = Class.forName(parentActivityName);
                } catch (ClassNotFoundException exception) {
                    exception.printStackTrace();
                }
                Intent intent = new Intent(SongDetailsDisplayActivity.this, parentActivity);
                startActivity(intent);
            }
        });

        /* When 'Back to Home Page' button is clicked, take user back to main activity
        * using explicit intent.
        * */
        Button backToCategoryListBtn = (Button) findViewById(R.id.btn_backToCategoryList);
        backToCategoryListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SongDetailsDisplayActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

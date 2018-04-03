package com.supjain.songsuggestionapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * This class stores all the information about a song like song name, art/image for that
 * song, album name etc.
 * This class implements Parcelable interface which helps in sending
 * this class's object from one Activity class to other as intentExtra.
 */
public class SongDetails implements Parcelable {

    public static final Parcelable.Creator<SongDetails> CREATOR
            = new Parcelable.Creator<SongDetails>() {
        public SongDetails createFromParcel(Parcel parcel) {
            return new SongDetails(parcel);
        }

        public SongDetails[] newArray(int size) {
            return new SongDetails[size];
        }
    };
    //Stores image/art for the song or album of the song
    private int mSongImageResourceId;
    //Stores song name
    private String mSongName;
    //Stores song album name
    private String mSongAlbum;
    //Stores song artist name
    private String mSongArtist;
    //Stores year of the album for the song
    private int mSongAlbumYear;
    //Stores video duration of the song
    private String mSongDuration;
    //Stores web link for audio of the song
    private String mSongAudioLink;
    //Stores web link for video of the song
    private String mSongVideoLink;
    //Stores web link for lyrics of the song
    private String mSongLyricsLink;

    /**
     * This is parametrized class constructor to create SongDetails class's object when inout data comes
     * inside a Parcel object.
     *
     * @param parcel - parcel object containing input data for SongDetails object
     **/
    private SongDetails(Parcel parcel) {
        mSongImageResourceId = parcel.readInt();
        mSongName = parcel.readString();
        mSongAlbum = parcel.readString();
        mSongArtist = parcel.readString();
        mSongAlbumYear = parcel.readInt();
        mSongDuration = parcel.readString();
        mSongAudioLink = parcel.readString();
        mSongVideoLink = parcel.readString();
        mSongLyricsLink = parcel.readString();
    }

    /**
     * This is parametrized class constructor to create SongDetails class's object
     *
     * @param imageResourceId - song image/art
     * @param songName        - name of the song
     * @param songAlbum       - name of the album of the song
     * @param songArtist      - name of the artist of the song
     * @param songAlbumYear   - year of album of the song
     * @param songDuration    - video duration of the song
     * @param songAudioLink   - weblink of audio of the song
     * @param songVideoLink   - weblink of video of the song
     * @param songLyricsLink  - weblink of lyrics of the song
     **/
    protected SongDetails(int imageResourceId, String songName, String songAlbum, String songArtist,
                          int songAlbumYear, String songDuration, String songAudioLink,
                          String songVideoLink, String songLyricsLink) {
        mSongImageResourceId = imageResourceId;
        mSongName = songName;
        mSongAlbum = songAlbum;
        mSongArtist = songArtist;
        mSongAlbumYear = songAlbumYear;
        mSongDuration = songDuration;
        mSongAudioLink = songAudioLink;
        mSongVideoLink = songVideoLink;
        mSongLyricsLink = songLyricsLink;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(mSongImageResourceId);
        parcel.writeString(mSongName);
        parcel.writeString(mSongAlbum);
        parcel.writeString(mSongArtist);
        parcel.writeInt(mSongAlbumYear);
        parcel.writeString(mSongDuration);
        parcel.writeString(mSongAudioLink);
        parcel.writeString(mSongVideoLink);
        parcel.writeString(mSongLyricsLink);
    }

    /**
     * This method returns image resource id for the SongDetails object
     */
    public int getSongImageResourceId() {
        return mSongImageResourceId;
    }

    /**
     * This method returns name of the song for the SongDetails object
     */
    public String getSongName() {
        return mSongName;
    }

    /**
     * This method returns album of the song for the SongDetails object
     */
    public String getSongAlbum() {
        return mSongAlbum;
    }

    /**
     * This method returns artist of the song for the SongDetails object
     */
    public String getSongArtist() {
        return mSongArtist;
    }

    /**
     * This method returns year of album of the song for the SongDetails object
     */
    public int getSongAlbumYear() {
        return mSongAlbumYear;
    }

    /**
     * This method returns video duration of the song for the SongDetails object
     */
    public String getSongDuration() {
        return mSongDuration;
    }

    /**
     * This method returns web link for the audio of the song for the SongDetails object
     */
    public String getSongAudioLink() {
        return mSongAudioLink;
    }

    /**
     * This method returns web link for the video of the song for the SongDetails object
     */
    public String getSongVideoLink() {
        return mSongVideoLink;
    }

    /**
     * This method returns web link for the lyrics of the song for the SongDetails object
     */
    public String getSongLyricsLink() {
        return mSongLyricsLink;
    }
}

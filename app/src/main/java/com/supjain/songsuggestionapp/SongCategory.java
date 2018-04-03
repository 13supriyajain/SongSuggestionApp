package com.supjain.songsuggestionapp;

/**
 * This class stores information about song category like Category name and relevant image for that
 * category.
 */
public class SongCategory {

    //For storing name of the category
    private String mCategoryName;
    //For storing image resource Id for the category
    private int mImageResourceId;

    /**
     * This is parametrized class constructor to create SongCategory class's object
     * @param categoryName  - name of the category
     * @param imageResourceId - image resource Id
     */
    public SongCategory(String categoryName, int imageResourceId){
        mCategoryName = categoryName;
        mImageResourceId = imageResourceId;
    }

    /**
    * This method returns category name for the SongCategory object
    */
    public String getCategoryName() {
        return mCategoryName;
    }

    /**
     * This method returns Image resource Id for the SongCategory object
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }
}

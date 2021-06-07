package com.example.myapp;

public class Word {
    private String mEnglish;
    private String mHindi;
    int mImage;

    public Word(String english,String hindi,int Image)
    {
        mEnglish=english;
        mHindi=hindi;
        mImage=Image;

    }
    public Word(String english,String hindi)
    {
        mEnglish=english;
        mHindi=hindi;


    }

    public String getEnglish() {
        return mEnglish;
    }

    public String getHindi() {
        return mHindi;
    }

    public int getImage() {
        return mImage;
    }
}

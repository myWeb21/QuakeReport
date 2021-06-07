package com.example.miwokapp2;

public class word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId=NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED=-1;
    private int mAudioResourceId;


    public word(String mD,String mM,int audioResource)
    {
        mDefaultTranslation=mD;
        mMiwokTranslation=mM;
        mAudioResourceId=audioResource;


    }
    public word(String mD,String mM,int mImageResourceId,int audioResource) {
        mDefaultTranslation = mD;
        mMiwokTranslation = mM;
        this.mImageResourceId=mImageResourceId;
        mAudioResourceId=audioResource;
    }


    public int getAudioResourceId() {
        return mAudioResourceId;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getResourceId(){return mImageResourceId;}

    public boolean hasImage()
    {
        return mImageResourceId!=NO_IMAGE_PROVIDED;
    }
}

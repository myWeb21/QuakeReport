package com.example.android.quakereport;

import java.util.Date;

public class Earthquake {
    private String mplace;
    private double mmag;
    private long mdate;
    private String murl;


    public Earthquake(String place,double mag,long d,String url)
    {
        mplace=place;
        mmag=mag;
        mdate=d;
        murl=url;

    }

    public long getd() {
        return mdate;
    }

    public double getmag() {
        return mmag;
    }

    public String getplace() {
        return mplace;
    }

    public String geturl() {
        return murl;
    }
}

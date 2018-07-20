package com.example.android.quakereport;

/**
 * Created by VICTOR on 7/19/2018.
 * An earthquake object contains information related to a single earthquake
 */

public class Earthquake {
    /*Magnitude of the earthquake*/
    private Double mMagnitude;

    /*Location of the earthquake*/
    private String mLocation;

    /*Date of the earthquake*/
    private long mTimeInMilliseconds;

    /*website link of the earthquake*/
    private String mUrl;

    public Earthquake(Double magnitude, String location, long timeInMilliseconds, String url){
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;
    }

    /*Since mMagnitude is private, This is a getter method that returns the magnitude of the earthquake*/
    public Double getMagnitude(){
        return mMagnitude;
    }

    /*Since mLocation is private, This is a getter method that returns the location of the earthquake*/
    public String getLocation(){
        return mLocation;
    }

    /*Since mDate is private, This is a getter method that returns the date of the earthquake*/
    public long getTimeInMilliseconds(){
        return mTimeInMilliseconds;
    }

    /*Since mWebsite is private, This is a getter method that returns the website of the earthquake*/
    public String getUrl(){
        return mUrl;
    }
}

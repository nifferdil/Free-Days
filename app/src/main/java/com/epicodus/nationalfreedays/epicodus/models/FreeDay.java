package com.epicodus.nationalfreedays.epicodus.models;

/**
 * Created by niffer on 10/23/15.
 */
public class FreeDay {
    private int Image;
    private String mTitle;
    private String mDate;
    private int mMonth;
    private int mDay;




    public void setDate(String date) {
        mDate = date;
    }

    public int getMonth() {
        return mMonth;
    }

    public void setMonth(int month) {
        mMonth = month;
    }

    public int getDay() {
        return mDay;
    }

    public void setDay(int day) {
        mDay = day;
    }

    private int mMonthDay;

    private int mDescription;
    private String mWebsite;

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public int getDescription() {
        return mDescription;
    }

    public void setDescription(int mDescription) {
        this.mDescription = mDescription;
    }


    public String getWebsite() {
        return mWebsite;
    }

    public void setWebsite(String mWebsite) {
        this.mWebsite = mWebsite;
    }

    public int getMonthDay() {
        return mMonthDay;
    }

    public void setMonthDay(int monthDay) {
        mMonthDay = monthDay;
    }

    public FreeDay(int image, String title, String date, int month, int day, int description, String website) {

        Image = image;
        mTitle = title;
        mDate = date;
        mMonth = month;
        mDay = day;
        mDescription = description;
        mWebsite = website;

    }
}
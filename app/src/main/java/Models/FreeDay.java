package models;

/**
 * Created by niffer on 10/23/15.
 */
public class FreeDay {
    private String mTitle;
    private String mDate;
    private String mDescription;
    private String mWebsite;

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

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }


    public String getWebsite() {
        return mWebsite;
    }

    public void setWebsite(String mWebsite) {
        this.mWebsite = mWebsite;
    }

    public FreeDay(String title, String date, String website, String description) {
        mTitle = title;
        mDate = date;
        mDescription = description;
        mWebsite = website;
    }
}
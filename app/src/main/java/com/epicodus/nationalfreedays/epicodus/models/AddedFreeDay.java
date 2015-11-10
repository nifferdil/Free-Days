package com.epicodus.nationalfreedays.epicodus.models;

import android.app.Activity;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niffer on 11/8/15.
 */
public class AddedFreeDay {

    ParseObject parseObject;
    String mNewFreeDayTitleText;
    String mNewFreeDayDate;
    String mNewFreeDayDescription;

    public AddedFreeDay(String newFreeDayTitleText, String newFreeDayDate, String newFreeDayDescription) {
        mNewFreeDayTitleText = newFreeDayTitleText;
        mNewFreeDayDate = newFreeDayDate;
        mNewFreeDayDescription = newFreeDayDescription;
        parseObject = new ParseObject("AddedFreeDay");
    }

    public String getNewFreeDayTitleText() {
        return mNewFreeDayTitleText;
    }

    public void setNewFreeDayTitleText(String newFreeDayTitleText) {
        mNewFreeDayTitleText = newFreeDayTitleText;
        parseObject.put("newFreeDayTitleText", newFreeDayTitleText);
    }

    public String getNewFreeDayDate() {
        return mNewFreeDayDate;
    }

    public void setNewFreeDayDate(String newFreeDayDate) {
        mNewFreeDayDate = newFreeDayDate;
        parseObject.put("newFreeDayDate", newFreeDayDate);
    }

    public String getNewFreeDayDescription() {
        return mNewFreeDayDescription;
    }

    public void setNewFreeDayDescription(String newFreeDayDescription) {
        mNewFreeDayDescription = newFreeDayDescription;
        parseObject.put("newFreeDayDescription", newFreeDayDescription);
    }

    public void save() {
        parseObject.saveInBackground();
    }

    public static ArrayList<AddedFreeDay> all(final Activity context, final Runnable runnable) {
        final ArrayList<AddedFreeDay> addedFreeDays = new ArrayList<>();


        ParseQuery<ParseObject> query = ParseQuery.getQuery("AddedFreeDay");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> objects, com.parse.ParseException e) {
                if (e == null) {
                    for (int i = 0; i < objects.size(); i++) {
                        ParseObject pAddedFreeDay = objects.get(i);

                        AddedFreeDay addedFreeDay = new AddedFreeDay(pAddedFreeDay.getString("newFreeDayTitleText"), pAddedFreeDay.getString("newFreeDayDate"), pAddedFreeDay.getString("newFreeDayDescription"));
                        addedFreeDays.add(addedFreeDay);

                        context.runOnUiThread(runnable);
                    }
                } else {
                    Log.d("parse", "failed request!" + e);

                }
            }
        });
        return addedFreeDays;
    }
}
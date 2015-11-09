package com.epicodus.nationalfreedays.epicodus.models;

import android.app.Activity;
import android.os.Message;
import android.util.Log;
import android.widget.EditText;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by niffer on 11/8/15.
 */
public class AddedFreeDay {

    String mNewFreeDayTitleText;
    String mNewFreeDayDate;
    String mNewFreeDayDescription;
    ParseObject parseObject;

    public void AddedFreeDay() {
        ParseObject parseObject = new ParseObject("AddedFreeDay");
    }

    public void AddedFreeDay(String newFreeDayTitleText, String newFreeDayDate, String newFreeDayDescription, String newFreeDayWebsite) {
        mNewFreeDayTitleText = newFreeDayTitleText;
        mNewFreeDayDate = newFreeDayDate;
        mNewFreeDayDescription = newFreeDayDescription;
    }

    public String getNewFreeDayTitleText() {
        return mNewFreeDayTitleText;
    }

    public void setNewFreeDayTitleText(String newFreeDayTitleText) {
        mNewFreeDayTitleText = newFreeDayTitleText;
    }

    public String getNewFreeDayDate() {
        return mNewFreeDayDate;
    }

    public void setNewFreeDayDate(String newFreeDayDate) {
        mNewFreeDayDate = newFreeDayDate;
    }

    public String getNewFreeDayDescription() {
        return mNewFreeDayDescription;
    }

    public void setmNewFreeDayDescription(String newFreeDayDescription) {
        mNewFreeDayDescription = newFreeDayDescription;
    }



    public static ArrayList<AddedFreeDay> all(final Activity context, final Runnable runnable) {
        final ArrayList<AddedFreeDay> addedFreeDays = new ArrayList<>();


        ParseQuery<ParseObject> query = ParseQuery.getQuery("MessagePost");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    for(int i = 0; i < objects.size(); i++){
                        ParseObject pMessage = objects.get(i);
                        ParseObject pUser = pMessage.getParseObject("userName");

                        AddedFreeDay addedFreeDay = new AddedFreeDay(pAddedFreeDay.getString("newF"),
                                pUser.getString("username"));
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

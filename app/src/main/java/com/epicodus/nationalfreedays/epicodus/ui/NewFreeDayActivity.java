package com.epicodus.nationalfreedays.epicodus.ui;

import android.app.ListActivity;
import android.os.Bundle;

import com.epicodus.nationalfreedays.R;

import java.util.ArrayList;

public class NewFreeDayActivity extends ListActivity {

    private ArrayList mNewFreeDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_free_day);
    }


}

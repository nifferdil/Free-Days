package com.epicodus.nationalfreedays.epicodus.ui;

import android.app.ListActivity;
import android.os.Bundle;

import com.epicodus.nationalfreedays.R;
import com.epicodus.nationalfreedays.epicodus.adapters.NewFreeDayAdapter;
import com.epicodus.nationalfreedays.epicodus.models.AddedFreeDay;

import java.util.ArrayList;

public class AddedFreeDayDisplayActivity extends ListActivity {

    private NewFreeDayAdapter mAdapter;
    private ArrayList<AddedFreeDay> mAddedFreeDays;
    private Runnable mUpdateFreeDaysRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_added_free_day_display);

        mUpdateFreeDaysRunnable = new Runnable() {
            @Override
            public void run() {
                mAdapter.notifyDataSetChanged();
            }
        };

        mAddedFreeDays = new ArrayList<AddedFreeDay>();
        mAddedFreeDays = AddedFreeDay.all(this, mUpdateFreeDaysRunnable);
        mAdapter = new NewFreeDayAdapter(this, mAddedFreeDays);
        setListAdapter(mAdapter);
    }

}

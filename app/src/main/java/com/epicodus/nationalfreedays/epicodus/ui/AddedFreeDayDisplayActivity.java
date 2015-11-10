package com.epicodus.nationalfreedays.epicodus.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.epicodus.nationalfreedays.R;
import com.epicodus.nationalfreedays.epicodus.adapters.NewFreeDayAdapter;
import com.epicodus.nationalfreedays.epicodus.models.AddedFreeDay;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddedFreeDayDisplayActivity extends ListActivity {

    private NewFreeDayAdapter mAdapter;
    private ArrayList<AddedFreeDay> mAddedFreeDays;
    private Runnable mUpdateFreeDaysRunnable;
    @Bind(R.id.daysButton)Button mDaysButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_added_free_day_display);
        ButterKnife.bind(this);

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

        mDaysButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddedFreeDayDisplayActivity.this, FreeDaysActivity.class);
                startActivity(intent);
            }
        });
    }
}

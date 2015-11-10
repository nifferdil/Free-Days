package com.epicodus.nationalfreedays.epicodus.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.nationalfreedays.R;
import com.epicodus.nationalfreedays.epicodus.models.AddedFreeDay;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewFreeDayActivity extends AppCompatActivity {

    @Bind(R.id.newFreeDayTitleText)EditText mNewFreeDayTitleText;
    @Bind(R.id.newFreeDayDate)EditText mNewFreeDayDate;
    @Bind(R.id.newFreeDayDescription)EditText mNewFreeDayDescription;
    @Bind(R.id.addedFreeDayButton)Button mAddedFreeDayButton;
    private ArrayList<AddedFreeDay> mAddedFreeDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_free_day);
        ButterKnife.bind(this);

        mAddedFreeDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFreeDay();

                Intent intent = new Intent(NewFreeDayActivity.this, AddedFreeDayDisplayActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addFreeDay() {
        String newFreeDayTitleText = mNewFreeDayTitleText.getText().toString();
        String newFreeDayDate = mNewFreeDayDate.getText().toString();
        String newFreeDayDescription = mNewFreeDayDescription.getText().toString();

        AddedFreeDay addedFreeDay = new AddedFreeDay(newFreeDayTitleText, newFreeDayDate, newFreeDayDescription);
        addedFreeDay.setNewFreeDayTitleText(newFreeDayTitleText);
        addedFreeDay.setNewFreeDayDate(newFreeDayDate);
        addedFreeDay.setNewFreeDayDescription(newFreeDayDescription);

        addedFreeDay.save();
        mAddedFreeDays = new ArrayList<AddedFreeDay>();
        mAddedFreeDays.add(addedFreeDay);
        mNewFreeDayTitleText.setText("");
        mNewFreeDayDate.setText("");
        mNewFreeDayDescription.setText("");
    }
}

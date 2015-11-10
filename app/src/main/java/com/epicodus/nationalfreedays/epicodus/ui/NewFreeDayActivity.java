package com.epicodus.nationalfreedays.epicodus.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.epicodus.nationalfreedays.R;
import com.epicodus.nationalfreedays.epicodus.models.AddedFreeDay;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewFreeDayActivity extends AppCompatActivity {

    @Bind(R.id.newFreeDayTitleText)TextView mNewFreeDayTitleText;
    @Bind(R.id.newFreeDayDate)TextView mNewFreeDayDate;
    @Bind(R.id.newFreeDayDescription)TextView mNewFreeDayDescription;
    @Bind(R.id.addedFreeDayButton)Button mAddedFreeDayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_free_day);
        ButterKnife.bind(this);

        mAddedFreeDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newFreeDayTitleText = mNewFreeDayTitleText.getText().toString();
                String newFreeDayDate = mNewFreeDayDate.getText().toString();
                String newFreeDayDescription = mNewFreeDayDescription.getText().toString();
                AddedFreeDay(newFreeDayTitleText, newFreeDayDate, newFreeDayDescription);
                Intent intent = new Intent(NewFreeDayActivity.this, AddedFreeDayDisplayActivity.class);
                startActivity(intent);
            }
        });
    }
}

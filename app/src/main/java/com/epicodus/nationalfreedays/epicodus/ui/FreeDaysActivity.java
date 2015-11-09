package com.epicodus.nationalfreedays.epicodus.ui;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.epicodus.nationalfreedays.R;
import com.epicodus.nationalfreedays.epicodus.models.FreeDay;
import com.epicodus.nationalfreedays.epicodus.models.FreeDayLib;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FreeDaysActivity extends AppCompatActivity {

    @Bind(R.id.nameLabel)TextView mNameLabel;
    @Bind(R.id.newFreeDayDateLabel)TextView mDateLabel;
    @Bind(R.id.descriptionLabel)TextView mDescriptionLabel;
    @Bind(R.id.websiteLabel)TextView mWebsiteLabel;
    @Bind(R.id.nextButton)Button mNextButton;
    @Bind(R.id.addNote)Button mAddNote;

    private FreeDayLib mFreeDayLib;
    private FreeDay mCurrentFreeDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_days);
        ButterKnife.bind(this);

        mFreeDayLib = new FreeDayLib();
        mCurrentFreeDay = mFreeDayLib.getFreeDays().get(0);

        setLayoutConTent();

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentFreeDay = mFreeDayLib.nextFreeDay(mCurrentFreeDay);
                setLayoutConTent();
            }
        });

        mAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FreeDaysActivity.this, NoteActivity.class);
                startActivity(intent);
            }
        });
        if (mCurrentFreeDay.getWebsite() != "") {
            mWebsiteLabel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mCurrentFreeDay.getWebsite()));
                    startActivity(intent);
                }
            });
            }
        }

    private void setLayoutConTent() {
        mNameLabel.setText(mCurrentFreeDay.getTitle());
        mDateLabel.setText(mCurrentFreeDay.getDate());
        if (mCurrentFreeDay.getWebsite() == "") {
            mWebsiteLabel.setText("Cool!");
            mWebsiteLabel.setTextColor(Color.parseColor("#404040"));
        } else {
            mWebsiteLabel.setText("Click here for more info");
            mWebsiteLabel.setTextColor(Color.BLUE);
        }
        mDescriptionLabel.setText(mCurrentFreeDay.getDescription());
    }
}
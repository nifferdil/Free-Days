package com.epicodus.nationalfreedays.epicodus.ui;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.nationalfreedays.R;
import com.epicodus.nationalfreedays.epicodus.models.FreeDay;
import com.epicodus.nationalfreedays.epicodus.models.FreeDayLib;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FreeDaysActivity extends AppCompatActivity {

    @Bind(R.id.imageLabel)
    ImageView imageLabel;
    @Bind(R.id.nameLabel)
    TextView mNameLabel;
    @Bind(R.id.newFreeDayDateLabel)
    TextView mDateLabel;
    @Bind(R.id.descriptionLabel)
    TextView mDescriptionLabel;
    @Bind(R.id.websiteLabel)
    TextView mWebsiteLabel;
    @Bind(R.id.nextButton)
    Button mNextButton;
    @Bind(R.id.addNote)
    Button mAddNote;
    @Bind(R.id.calendarButton)
    Button mCalendarButton;

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
//        if (mCurrentFreeDay.getWebsite() != "") {
//            mWebsiteLabel.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mCurrentFreeDay.getWebsite()));
//                    startActivity(intent);
//                }
//            });
//            }

        mCalendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar cal = new GregorianCalendar();

                //int year = cal.get(Calendar.YEAR);


                int year = cal.get(Calendar.YEAR) + 1;
                int month = mCurrentFreeDay.getMonth();
                int day = mCurrentFreeDay.getDay();
                cal.setTime(new Date());
                cal.set(year, month, day);

                Intent intent = new Intent(Intent.ACTION_EDIT);
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(
                        CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                        cal.getTime().getTime());
//                Calendar cal = Calendar.getInstance();
//                Intent intent = new Intent(Intent.ACTION_EDIT);
//                intent.setType("vnd.android.cursor.item/event");
//
//                Calendar tmpCal = new GregorianCalendar();
//                    tmpCal.set(Calendar.MONTH, 11);
//                    tmpCal.set(Calendar.DAY_OF_MONTH, 1);
//
//                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, tmpCal);
                intent.putExtra("allDay", true);
                intent.putExtra("rrule", "FREQ=YEARLY");
                intent.putExtra("endTime", cal.getTimeInMillis() + 60 * 60 * 1000);
                intent.putExtra("title", mCurrentFreeDay.getTitle());
                startActivity(intent);
            }
        });
    }

    private void setLayoutConTent() {
        imageLabel.setImageResource(mCurrentFreeDay.getImage());
        mNameLabel.setText(mCurrentFreeDay.getTitle());
        mDateLabel.setText(mCurrentFreeDay.getDate());

        mDescriptionLabel.setText(mCurrentFreeDay.getDescription());
        if (mCurrentFreeDay.getWebsite() == "") {
            mWebsiteLabel.setClickable(false);
            mWebsiteLabel.setText("Cool!");
            mWebsiteLabel.setTextColor(Color.parseColor("#404040"));
        } else {
            mWebsiteLabel.setText("Click here for more info");
            mWebsiteLabel.setTextColor(Color.BLUE);
            mWebsiteLabel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mCurrentFreeDay.getWebsite()));
                    startActivity(intent);
                }
            });
        }
    }
}


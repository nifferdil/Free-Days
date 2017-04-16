package com.epicodus.nationalfreedays.epicodus.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.epicodus.nationalfreedays.R;
import com.epicodus.nationalfreedays.epicodus.models.FreeDay;
import com.epicodus.nationalfreedays.epicodus.models.FreeDayLib;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

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
    RelativeLayout mNextButton;
    @Bind(R.id.button_previous)
    RelativeLayout mPreviousButton;
    //    @Bind(R.id.addNote)
//    Button mAddNote;
    @Bind(R.id.calendarButton)
    ImageView mCalendarButton;

    private FreeDayLib mFreeDayLib;
    private FreeDay mCurrentFreeDay;
    private FreeDay mFirstFreeDay;
    private AdView mAdView;

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity mActivity = this;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_days);
        ButterKnife.bind(this);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-9751202674393575~3609548047");

        Intent listSelection = getIntent();
        String indexTitle = listSelection.getStringExtra("titleFromList");
        int selectedFreeDay = listSelection.getIntExtra("freeDayChoice", 0);

        mFreeDayLib = new FreeDayLib();
        mCurrentFreeDay = mFreeDayLib.getFreeDays().get(selectedFreeDay);
        setLayoutConTent();

        //mCurrentFreeDay = mFreeDayLib.getFreeDays().get(0);

        //If user did not arrive from the list, call setFirstFreeDay();

//        if (selectedFreeDay = null) {
//            setFirstFreeDay();
//        }

        //int chosenMonth = freeDay.getMonth();
//        int index;
//        index = selectedFreeDay;
//        // If a Free Day title in the Lib has the same title as the one chosen in list, get it
//        mCurrentFreeDay = mFreeDayLib.getFreeDays().get(index);

//            for (FreeDay freeDay : mFreeDayLib.getFreeDays()) {
//                String title = freeDay.getTitle();
//
//                if (title.equalsIgnoreCase(indexTitle)) {
//                    int chosenMonth = freeDay.getMonth();
//                    int index;
//                    index = chosenMonth;
//                    // If a Free Day title in the Lib has the same title as the one chosen in list, get it
//                    mCurrentFreeDay = mFreeDayLib.getFreeDays().get(index);
//                } else {
//                    mCurrentFreeDay = mFreeDayLib.getFreeDays().get(0);
//                    setFirstFreeDay();
//                }
//            }


//        if (index != null) {
//            int indexPosition = Integer.parseInt(index);
//            if (currentDay > freeDayDay) {
//                index = mCurrentFreeDay.getTitle();
//            mCurrentFreeDay = mFreeDayLib.getFreeDays().get(index);
//        } else {
//            mCurrentFreeDay = mFreeDayLib.getFreeDays().get(0);
//        }

                    //setFirstFreeDay();

                    mAdView = (AdView) findViewById(R.id.adView);
                    AdRequest adRequest = new AdRequest.Builder()
                            .build();
                    mAdView.loadAd(adRequest);

                    setTitle(R.string.free_days);

                    mNextButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mCurrentFreeDay = mFreeDayLib.nextFreeDay(mCurrentFreeDay);
                            setLayoutConTent();
                            mWebView = (WebView) findViewById(R.id.webview);
                            mWebView.setVisibility(View.GONE);

//                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + mCurrentFreeDay.getLocation());
//                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
//                mapIntent.setPackage("com.google.android.apps.maps");
//                startActivity(mapIntent);
                        }
                    });

                    mPreviousButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mCurrentFreeDay = mFreeDayLib.previousFreeDay(mCurrentFreeDay);
                            setLayoutConTent();
                            mWebView = (WebView) findViewById(R.id.webview);
                            mWebView.setVisibility(View.GONE);
                        }
                    });

//        mAddNote.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(FreeDaysActivity.this, NoteActivity.class);
//                startActivity(intent);
//            }
//        });

//
//        {
//            public void onProgressChanged(WebView view, int progress)
//            {
//                //Make the bar disappear after URL is loaded, and changes string to Loading...
//                //mActivity .setTitle("Loading...");
//                mActivity .setProgress(progress * 100); //Make the bar disappear after URL is loaded
//
//                // Return the app name after finish loading
//                if(progress == 100)
//                {
//                }
//            }
//        });

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

                            int currentDayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
                            int currentMonth = cal.get(Calendar.MONTH);

                            int freeDayMonth = mCurrentFreeDay.getMonth();
                            int freeDayDay = mCurrentFreeDay.getDay();

                            int year;
                            if (currentMonth > freeDayMonth) {
                                year = cal.get(Calendar.YEAR) + 1;
                            } else year = cal.get(Calendar.YEAR);

                            if (currentMonth == freeDayMonth) {
                                if (currentDayOfMonth > freeDayDay) {
                                    year = cal.get(Calendar.YEAR) + 1;
                                } else year = cal.get(Calendar.YEAR);
                            }

                            cal.setTime(new Date());

                            cal.set(year, freeDayMonth, freeDayDay);

                            if (mCurrentFreeDay.getTitle().equalsIgnoreCase("Free Comic Day")) {
                                cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
                                cal.set(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
                            } else if (mCurrentFreeDay.getTitle().equalsIgnoreCase("National Donut Day")) {

                                cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                                cal.set(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
                            }

                            Intent intent = new Intent(Intent.ACTION_EDIT);
                            intent.setData(CalendarContract.Events.CONTENT_URI);
                            intent.putExtra(
                                    CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                                    cal.getTime().getTime());

                            intent.setType("vnd.android.cursor.item/event");
                            intent.putExtra("allDay", true);
                            intent.putExtra("rrule", "FREQ=YEARLY");
                            intent.putExtra("endTime", cal.getTimeInMillis() + 60 * 60 * 1000);
                            intent.putExtra("title", mCurrentFreeDay.getTitle());
                            startActivity(intent);
                        }
                    });

                }

                public void setFirstFreeDay() {
                    Calendar cal = new GregorianCalendar();
                    int currentMonth = cal.get(Calendar.MONTH);
                    int currentDay = cal.get(Calendar.DAY_OF_MONTH);
                    int freeDayMonth = mCurrentFreeDay.getMonth();
                    int freeDayDay = mCurrentFreeDay.getDay();

                    boolean isFreeDayMonth = currentMonth == freeDayMonth;

                    if (isFreeDayMonth) {
                        int index;
                        if (currentDay > freeDayDay) {
                            index = mCurrentFreeDay.getMonth();
                            mCurrentFreeDay = mFreeDayLib.getFreeDays().get(index + 1);
                            setLayoutConTent();
                        } else
                            setLayoutConTent();
                    } else {
                        //The Free Day displayed is the Free Day that has the same month as the current month, depending on day:
                        for (FreeDay freeDay : mFreeDayLib.mFreeDays) {
                            int index;
                            index = freeDay.getMonth();
                            if (index == currentMonth) {
                                if (currentDay > freeDayDay) {
                                    mCurrentFreeDay = mFreeDayLib.getFreeDays().get(index + 1);
                                    setLayoutConTent();
                                } else {
                                    mCurrentFreeDay = mFreeDayLib.getFreeDays().get(index);
                                    setLayoutConTent();
                                }

                            }
                        }
                    }
                }

                public void setLayoutConTent() {
                    imageLabel.setImageResource(mCurrentFreeDay.getImage());
                    mNameLabel.setText(mCurrentFreeDay.getTitle());
                    mDateLabel.setText(mCurrentFreeDay.getDate());
                    mDescriptionLabel.setText(mCurrentFreeDay.getDescription());


                    if (mCurrentFreeDay.getWebsite() == "") {
                        mWebsiteLabel.setClickable(false);
                        mWebsiteLabel.setText("");
                        mWebsiteLabel.setTextColor(Color.parseColor("#404040"));
                    } else {
                        mWebsiteLabel.setText("More info about " + mCurrentFreeDay.getTitle());
                        mWebsiteLabel.setTextColor(Color.BLUE);
                        mWebsiteLabel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                mWebView = (WebView) findViewById(R.id.webview);
                                mWebView.setVisibility(View.VISIBLE);

                                mWebView.setOnTouchListener(new View.OnTouchListener() {
                                    // Setting on Touch Listener for handling the touch inside ScrollView
                                    @Override
                                    public boolean onTouch(View v, MotionEvent event) {
                                        // Disallow the touch request for parent scroll on touch of child view
                                        v.getParent().requestDisallowInterceptTouchEvent(true);
                                        return false;
                                    }
                                });

                                mWebView.getSettings().setJavaScriptEnabled(true);
                                mWebView.setWebViewClient(new MyBrowser());
                                mWebView.loadUrl(mCurrentFreeDay.getWebsite());
                            }
                        });
                    }
                }

                private class MyBrowser extends WebViewClient {
                    @SuppressWarnings("deprecation")
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        view.loadUrl(url);
                        return true;
                    }
                }

                @Override
                public void onPause() {
                    if (mAdView != null) {
                        mAdView.pause();
                    }
                    super.onPause();
                }

                @Override
                public void onResume() {
                    super.onResume();
                    if (mAdView != null) {
                        mAdView.resume();
                    }
                }

                @Override
                public void onDestroy() {
                    if (mAdView != null) {
                        mAdView.destroy();
                    }
                    super.onDestroy();
                }
            }

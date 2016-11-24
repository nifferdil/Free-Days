package com.epicodus.nationalfreedays.epicodus.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.Button;

import com.epicodus.nationalfreedays.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;

    @Bind(R.id.daysButton)
    Button mDaysButton;
    //@Bind(R.id.addFreeDayButton)
    Button mAddFreeDayButton;
    private SharedPreferences mPreferences;
    //private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


//        Parse.enableLocalDatastore(this);
//
//        Parse.initialize(this, "hfzrL6VhxXbCPko1YAupdo6OdDticlonAIX7E0Zi", "7aMR1BJ5b946KhrjwGEvGTButJNQP6hLxLHaLblo");
//
//        mPreferences = getApplicationContext().getSharedPreferences("freedays", Context.MODE_PRIVATE);
//
//        if (!isRegistered()) {
//            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
//            startActivity(intent);
//        }

        mDaysButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FreeDaysActivity.class);
                startActivity(intent);
            }
        });

//        mAddFreeDayButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, NewFreeDayActivity.class);
//                startActivity(intent);
//            }
//        });


//    private boolean isRegistered() {
//        String username = mPreferences.getString("username", null);
//        if (username == null) {
//            return false;
//        } else {
//            setUser(username);
//            return true;
//        }
//    }
//
//    private void setUser(String username) {
//        User user = User.find(username);
//        if (user != null) {
//            mUser = user;
//        } else {
//            mUser = new User(username);
//            mUser.save();
//        }
//        Toast.makeText(this, "Welcome " + mUser.getName(), Toast.LENGTH_LONG).show();
//    }


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.action_settings, R.string.action_settings);
        drawer.addDrawerListener(drawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();
    }

    public void onDrawerClick(View view) {
        switch (view.getId()) {
            case R.id.drawer_item_about:

                final AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setTitle(R.string.about_free_days);
                builder.setMessage(Html.fromHtml("<p>Sample text, <a href=\"http://google.nl\">hyperlink</a>.</p>") + getString(R.string.app_description));

                builder.setNegativeButton(R.string.ok,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int item) {

                                    }
                                });

                Dialog dialog;
                dialog = builder.create();
                dialog.show();


                drawer.closeDrawer(GravityCompat.START);
                break;

        }
    }


}

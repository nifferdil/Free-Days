package com.epicodus.nationalfreedays.epicodus.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
                builder.setMessage(getString(R.string.app_description));

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
            case R.id.drawer_item_attribution:

                showDialog();
                break;
        }
    }

        public void showDialog() {
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Attribution");

            LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.credits, null);

            final TextView text = (TextView) layout.findViewById(R.id.text);
            text.setMovementMethod(LinkMovementMethod.getInstance());
            text.setLinkTextColor(Color.BLUE);
            builder.setMessage("Icons made by:");
            text.setText(Html.fromHtml("<a href=http://www.freepik.com> Freepik</a><br> <a href=http://www.flaticon.com/authors/madebyoliver>  Madebyoliver</a><br> <a href=http://www.flaticon.com> www.flaticon.com</a><br><a href=https://creativecommons.org/licenses/by/4.0/> Google Material Design Icons</a><br>"));
            builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int i) {

                }
            });
            AlertDialog dialog = builder.create();

            Button b = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
            if(b != null)
                b.setTextColor(Color.BLACK);

            dialog.setView(layout);
            dialog.show();
        }

//        public static Spanned fromHtml(String source) {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                return Html.fromHtml(source, Html.FROM);
//            } else {
//                return Html.fromHtml(source);
//            }
//        }

}

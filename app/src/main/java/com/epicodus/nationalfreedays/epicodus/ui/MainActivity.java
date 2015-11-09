package com.epicodus.nationalfreedays.epicodus.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.epicodus.nationalfreedays.R;
import com.epicodus.nationalfreedays.epicodus.models.User;
import com.parse.Parse;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.daysButton)Button mDaysButton;
    private SharedPreferences mPreferences;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "hfzrL6VhxXbCPko1YAupdo6OdDticlonAIX7E0Zi", "7aMR1BJ5b946KhrjwGEvGTButJNQP6hLxLHaLblo");

        mPreferences = getApplicationContext().getSharedPreferences("freedays", Context.MODE_PRIVATE);

        if (!isRegistered()) {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        }

        mDaysButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FreeDaysActivity.class);
                    startActivity(intent);
            }
        });
    }

    private boolean isRegistered() {
        String username = mPreferences.getString("username", null);
        if (username == null) {
            return false;
        } else {
            setUser(username);
            return true;
        }
    }

    private void setUser(String username) {
        User user = User.find(username);
        if (user != null) {
            mUser = user;
        } else {
            mUser = new User(username);
            mUser.save();
        }
        Toast.makeText(this, "Welcome " + mUser.getName(), Toast.LENGTH_LONG).show();
    }
}

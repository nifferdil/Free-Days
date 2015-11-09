package com.epicodus.nationalfreedays.epicodus;

/**
 * Created by niffer on 11/6/15.
 */
import android.app.Application;

import com.parse.Parse;


public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);
//
        Parse.initialize(this, "7EuPvWtQ5mrGUi0khIKtbNOaw3jQtvG77NAZi0tQ", "hMyRAjjH6sBGRoFMSSt39OulRMgXqmY5M4wNMK4s");
    }
}
package com.asa.billtracker;

import android.app.Application;

import com.asa.billtracker.ui.MainActivity;
import com.crashlytics.android.Crashlytics;
import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.PushService;

/**
 * Created by Aaron on 9/27/13.
 */
public class BillApplication extends Application {

    public static final boolean DEBUG = true;

    @Override
    public void onCreate() {
        super.onCreate();
        if (!DEBUG) {
            Crashlytics.start(this);
        }
        Parse.initialize(getApplicationContext(), AppData.PARSE_APP_ID, AppData.PARSE_CLIENT_ID);

        // Enabling Push Notifications
        // TODO - Change this to the launch activity
        PushService.setDefaultPushCallback(this, MainActivity.class);
        // TODO - Maybe don't use this
//        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}

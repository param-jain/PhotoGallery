package com.bignerdranch.android.photogallery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by param_jain on 14/01/18.
 */

public class StartupReceiver extends BroadcastReceiver {

    private static final String TAG = "Startup Receiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "Received Broadcast Intent: " + intent.getAction());

        boolean isOn = QueryPreferences.isAlarmOn(context);
        PollService.setServiceAlarm(context, isOn);
    }

}
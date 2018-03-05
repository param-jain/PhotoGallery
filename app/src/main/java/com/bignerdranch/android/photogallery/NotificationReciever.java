package com.bignerdranch.android.photogallery;

import android.app.Activity;
import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

/**
 * Created by param_jain on 14/01/18.
 */

public class NotificationReciever extends BroadcastReceiver {

    private static final String TAG = "NotificationReciever";

    @Override
    public void onReceive(Context c, Intent i) {
        Log.i(TAG, "Recieved Result: " + getResultCode());
        if(getResultCode() != Activity.RESULT_OK) {
            return;
        }

        int requestCode = i.getIntExtra(PollService.REQUEST_CODE, 0);
        Notification notification = (Notification)i.getParcelableExtra(PollService.NOTIFICATION);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(c);
        notificationManager.notify(requestCode, notification);
    }

}

package com.sterlingryan.dental_care;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Alarm received!", Toast.LENGTH_LONG).show();

        //Playing the default ringtone
        /*Uri ringtoneUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        Ringtone ringtoneSound = RingtoneManager.getRingtone(context, ringtoneUri);

        if (ringtoneSound != null) {
            ringtoneSound.play();
        }*/
    }
}

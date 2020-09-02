package com.example.broadcastreceiverusbconnect;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

public class detectarUsb extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        boolean b = intent.getBooleanExtra("connected",false);
        if(b){
            try {
                Intent i = new Intent();
                String number = "911";
                i.setAction(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:" + number));
                context.startActivity(i);
            }
            catch(ActivityNotFoundException e)
            {
                Log.e("call", "Call failed", e);
            }

        }
    }
}

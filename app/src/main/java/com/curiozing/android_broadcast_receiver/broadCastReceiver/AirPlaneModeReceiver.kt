package com.curiozing.android_broadcast_receiver.broadCastReceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.widget.Toast

class AirPlaneModeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.let {
            if(it.action == Intent.ACTION_AIRPLANE_MODE_CHANGED){
                when(Settings.Global.getInt(context?.contentResolver, Settings.Global.AIRPLANE_MODE_ON)){
                    0 -> {
                        context?.let { ctx ->
                            Toast.makeText(ctx, "Airplane Mode Turned Off", Toast.LENGTH_LONG).show()
                        }
                    }
                    1 ->{
                        context?.let { ctx ->
                            Toast.makeText(ctx, "Airplane Mode Turned ON", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        }
    }
}
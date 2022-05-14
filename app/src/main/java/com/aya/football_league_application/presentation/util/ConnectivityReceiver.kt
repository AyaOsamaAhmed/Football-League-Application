package com.aya.football_league_application.presentation.util

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager

class ConnectivityReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        connectivityReceiverListener?.onNetworkConnectionChanger(isConnectedOrConnecting(context!!))
    }

    private fun isConnectedOrConnecting(context: Context):Boolean{
        val connMgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connMgr.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    interface ConnectivityReceiverListener{
        fun onNetworkConnectionChanger(isConnected: Boolean)

    }

    companion object{
        var connectivityReceiverListener: ConnectivityReceiverListener? = null
    }
}
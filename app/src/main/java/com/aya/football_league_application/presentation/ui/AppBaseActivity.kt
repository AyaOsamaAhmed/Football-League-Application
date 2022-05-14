package com.aya.football_league_application.presentation.ui

import android.content.Context
import android.content.ContextWrapper
import android.content.IntentFilter
import android.content.res.Configuration
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aya.football_league_application.R
import com.aya.football_league_application.presentation.util.ConnectivityReceiver
import com.kaopiz.kprogresshud.KProgressHUD
import java.text.SimpleDateFormat
import java.util.*
import com.aya.football_league_application.presentation.util.*

open class AppBaseActivity : AppCompatActivity() ,  ConnectivityReceiver.ConnectivityReceiverListener {

    private var mMyApp: MultiDexApp? = null
    private var receiver : ConnectivityReceiver = ConnectivityReceiver()
    private  var dialogProgressBar : KProgressHUD? = null

    protected inline fun <reified T : ViewDataBinding> binding(@LayoutRes resId: Int): Lazy<T> =
        lazy {
            DataBindingUtil.setContentView<T>(this@AppBaseActivity, resId).apply {
                lifecycleOwner = this@AppBaseActivity
                executePendingBindings()
            }
        }

    protected inline fun <reified T : ViewModel> setViewModel(modelClass: Class<T>): Lazy<T> = lazy {
        ViewModelProvider(this).get(modelClass)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initApp()

        val data = SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy" , Locale.ENGLISH)
        val dt = data.parse("Wed May 26 13:24:52 GMT+02:00 2021")
        val sdf = SimpleDateFormat("hh:mm aa" , Locale.ENGLISH)
        val time1: String = sdf.format(dt!!)
        System.out.println("dsadasd-----dsadasd --data == "+time1);

    }

    private fun initApp() {
        // initialization mApp
        mMyApp = this.applicationContext as MultiDexApp
        val currActivity = mMyApp!!.getCurrentActivity()
        if (this == currActivity) mMyApp!!.setCurrentActivity(null)
        mMyApp!!.setCurrentActivity(this)
        // Save Language
        if (getAppLanguage() == "en"){
            getSharedPrefInstance().setValue(Constant.LANGUAGE, "en")
            val localeToSwitchTo = Locale("en")
            ContextUtils.updateLocale(this, localeToSwitchTo)
        }else{
            getSharedPrefInstance().setValue(Constant.LANGUAGE, "ar")
            val localeToSwitchTo = Locale("ar")
            ContextUtils.updateLocale(this, localeToSwitchTo)
        }
    }

    override fun attachBaseContext(newBase: Context) {
        val localeToSwitchTo = Locale(getAppLanguage())
        val localeUpdatedContext: ContextWrapper = ContextUtils.updateLocale(
            newBase,
            localeToSwitchTo
        )
        super.attachBaseContext(localeUpdatedContext)
    }

    override fun onResume() {
        super.onResume()
        // To Start BroadcastReceiver
        initApp()
        registerReceiver(receiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
        ConnectivityReceiver.connectivityReceiverListener = this
    }

    override fun onPause() {
        super.onPause()
        // To Stop BroadcastReceiver
        unregisterReceiver(receiver)
    }

    open fun clearReferences() {
        // To Clear References Activity
        val currActivity = mMyApp!!.getCurrentActivity()
        if (this == currActivity) mMyApp!!.setCurrentActivity(null)
    }

    override fun onNetworkConnectionChanger(isConnected: Boolean) {
        // Fire No Internet Connections Dialog
        return
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        // Save Language
        if (getAppLanguage() == "en"){
            getSharedPrefInstance().setValue(Constant.LANGUAGE, "en")
            val localeToSwitchTo = Locale("en")
            ContextUtils.updateLocale(this, localeToSwitchTo)
        }else{
            getSharedPrefInstance().setValue(Constant.LANGUAGE, "ar")
            val localeToSwitchTo = Locale("ar")
            ContextUtils.updateLocale(this, localeToSwitchTo)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }


    @Synchronized
    fun getProgressBarInstance(): KProgressHUD {
        if (dialogProgressBar == null) {
            dialogProgressBar = KProgressHUD.create(this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel(getString(R.string.dialog_please_waiting))
                .setCancellable(false)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f)
        }
        return dialogProgressBar!!
    }
}

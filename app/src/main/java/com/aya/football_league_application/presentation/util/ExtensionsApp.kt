package com.aya.football_league_application.presentation.util

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.aya.football_league_application.R
import com.aya.football_league_application.presentation.ui.MultiDexApp
import com.aya.football_league_application.presentation.util.Constant.LANGUAGE
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import java.util.*
import javax.sql.DataSource

fun getAppLanguage(): String = getSharedPrefInstance().getStringValue(LANGUAGE, defaultValue = Locale.getDefault().language)

fun getSharedPrefInstance(): SharedPrefsHelper {
    return if (MultiDexApp.sharedPrefsHelper == null) {
        MultiDexApp.sharedPrefsHelper = SharedPrefsHelper()
        MultiDexApp.sharedPrefsHelper!!
    } else {
        MultiDexApp.sharedPrefsHelper!!
    }
}


fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun ImageView.setGlideImageUrl(url: String, progressBar: ProgressBar?){
    Glide.with(this.context)
        .load(url)
        .listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: com.bumptech.glide.request.target.Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                progressBar?.visibility = View.GONE
                setImageResource(R.mipmap.ic_launcher)
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: com.bumptech.glide.request.target.Target<Drawable>?,
                dataSource: com.bumptech.glide.load.DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                progressBar?.visibility = View.GONE
                return false
            }

        })
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(this)
}













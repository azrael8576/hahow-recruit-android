package com.alex.hahow_recruit

import android.app.Application
import androidx.work.Configuration
import com.facebook.stetho.Stetho

class MainApplication : Application(), Configuration.Provider {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }

    override fun getWorkManagerConfiguration(): Configuration =
                Configuration.Builder()
                        .setMinimumLoggingLevel(if (BuildConfig.DEBUG) android.util.Log.DEBUG else android.util.Log.ERROR)
                        .build()
}

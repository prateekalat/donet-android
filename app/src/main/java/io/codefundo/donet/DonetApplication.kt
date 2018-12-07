package io.codefundo.donet

import android.app.Application
import io.codefundo.donet.dagger.AppComponent
import io.codefundo.donet.dagger.DaggerAppComponent
import io.codefundo.donet.dagger.RetrofitModule

class DonetApplication : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

        appComponent = DaggerAppComponent.builder()
                .retrofitModule(RetrofitModule())
                .build()
    }

    companion object {
        lateinit var INSTANCE : DonetApplication
            private set
    }
}
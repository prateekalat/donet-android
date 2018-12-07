package io.codefundo.donet.dagger

import io.codefundo.donet.DonetApplication

class AppComponentInjector {
    companion object {
        val instance: AppComponent
            get() = DonetApplication.INSTANCE.appComponent
    }
}
package io.codefundo.donet.core.dagger

import io.codefundo.donet.core.DonetApplication

class AppComponentInjector {
    companion object {
        val instance: AppComponent
            get() = DonetApplication.INSTANCE.appComponent
    }
}
package io.codefundo.donet.authentication.dagger

import io.codefundo.donet.core.dagger.AppComponentInjector

class AuthenticationComponentInjector {
    companion object {
        val instance: AuthenticationComponent by lazy {
            DaggerAuthenticationComponent
                    .builder()
                    .appComponent(AppComponentInjector.instance)
                    .build()
        }
    }
}
package io.codefundo.donet.authentication.dagger

import dagger.Component
import io.codefundo.donet.authentication.AuthenticationViewModel
import io.codefundo.donet.core.dagger.AppComponent

@AuthenticationScope
@Component(dependencies = [AppComponent::class], modules = [AuthenticationModule::class])
interface AuthenticationComponent {
    fun inject(authenticationViewModel: AuthenticationViewModel)
}
package io.codefundo.donet.authentication

import androidx.lifecycle.ViewModel
import io.codefundo.donet.authentication.dagger.AuthenticationComponentInjector
import io.codefundo.donet.authentication.domain.AuthenticationRepository
import javax.inject.Inject

class AuthenticationViewModel : ViewModel() {

    @Inject lateinit var authenticationRepository: AuthenticationRepository

    init {
        AuthenticationComponentInjector
                .instance
                .inject(this)
    }
}
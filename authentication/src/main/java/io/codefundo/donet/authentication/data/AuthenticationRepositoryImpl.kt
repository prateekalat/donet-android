package io.codefundo.donet.authentication.data

import io.codefundo.donet.authentication.dagger.AuthenticationScope
import io.codefundo.donet.authentication.domain.AuthenticationRepository
import javax.inject.Inject

@AuthenticationScope
class AuthenticationRepositoryImpl @Inject constructor(
        private val authenticationRetrofitService: AuthenticationRetrofitService
) : AuthenticationRepository {

    override fun login() = authenticationRetrofitService
            .login("anirudhkovuru@gmail.com", "SameForEveryone")
}
package io.codefundo.donet.authentication.domain

import androidx.lifecycle.LiveData
import io.codefundo.donet.authentication.dagger.AuthenticationScope
import io.codefundo.donet.authentication.data.AccessToken
import io.codefundo.donet.core.UseCase
import javax.inject.Inject

@AuthenticationScope
class GetAuthenticationTokenUseCase @Inject constructor(
        private val authenticationRepository: AuthenticationRepository
) : UseCase<Void, AccessToken> {
    override fun execute(vararg args: Void): LiveData<AccessToken> =
            authenticationRepository.getCachedAccessToken()
}
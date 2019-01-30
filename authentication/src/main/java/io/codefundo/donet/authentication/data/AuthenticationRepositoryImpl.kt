package io.codefundo.donet.authentication.data

import androidx.lifecycle.MutableLiveData
import io.codefundo.donet.authentication.dagger.AuthenticationScope
import io.codefundo.donet.authentication.domain.AuthenticationRepository
import io.reactivex.Single
import javax.inject.Inject

@AuthenticationScope
class AuthenticationRepositoryImpl @Inject constructor(
        private val authenticationRetrofitService: AuthenticationRetrofitService
) : AuthenticationRepository {

    private val tokenLiveData = MutableLiveData<String>()

    override fun login(): Single<String> = authenticationRetrofitService
            .login("anirudhkovuru@gmail.com", "SameForEveryone")
            .doAfterSuccess { tokenLiveData.value = it }

    override fun getToken() = tokenLiveData
}
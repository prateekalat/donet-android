package io.codefundo.donet.authentication.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.codefundo.donet.authentication.dagger.AuthenticationScope
import io.codefundo.donet.authentication.domain.AuthenticationRepository
import io.codefundo.donet.core.Resource
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

@AuthenticationScope
class AuthenticationRepositoryImpl @Inject constructor(
        private val authenticationRetrofitService: AuthenticationRetrofitService
) : AuthenticationRepository {

    private val accessToken = MutableLiveData<AccessToken>()
    private val user = MutableLiveData<User>()
    private val userLiveData = MutableLiveData<Resource>()

    override fun requestAccessTokenFromServer(
            url: String,
            idToken: Map<String, String>
    ): Single<AccessToken> = authenticationRetrofitService.getAccessToken(url, idToken)

    override fun getCachedAccessToken(): LiveData<AccessToken> = accessToken

    override fun setCachedAccessToken(accessToken: AccessToken) {
        this.accessToken.value = accessToken
    }

    override fun requestUserFromServer(): LiveData<Resource> {
        val token = accessToken.value
        if (token != null) {
            authenticationRetrofitService.getUser(token.toString())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeBy(
                            onSuccess = {
                                val user = it.user
                                userLiveData.value = Resource.Success(user)
                                this.user.value = user
                            },
                            onError = {
                                userLiveData.value = Resource.Failure(it)
                                Log.e("AuthRepository", it.message)
                            }
                    )
        }

        return userLiveData
    }

    override fun getCachedUser(): LiveData<User> = user
}
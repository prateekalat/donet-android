package io.codefundo.donet.authentication.domain

import androidx.lifecycle.LiveData
import io.codefundo.donet.authentication.data.AccessToken
import io.codefundo.donet.authentication.data.User
import io.codefundo.donet.core.Resource
import io.reactivex.Single

interface AuthenticationRepository {

    fun requestUserFromServer(): LiveData<Resource>
    fun getCachedUser(): LiveData<User>

    fun getCachedAccessToken(): LiveData<AccessToken>
    fun setCachedAccessToken(accessToken: AccessToken)

    fun requestAccessTokenFromServer(url: String, idToken: Map<String, String>): Single<AccessToken>
}
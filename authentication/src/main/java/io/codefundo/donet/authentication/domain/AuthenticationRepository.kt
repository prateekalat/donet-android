package io.codefundo.donet.authentication.domain

import androidx.lifecycle.LiveData
import io.reactivex.Single

interface AuthenticationRepository {

    fun login(): Single<String>

    fun getToken(): LiveData<String>
}
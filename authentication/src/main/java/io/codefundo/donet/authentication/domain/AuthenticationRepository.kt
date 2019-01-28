package io.codefundo.donet.authentication.domain

import io.reactivex.Single

interface AuthenticationRepository {

    fun login(): Single<String>
}
package io.codefundo.donet.authentication.data

import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthenticationRetrofitService {

    @FormUrlEncoded
    @POST("login")
    fun login(
            @Field("email_id") email: String,
            @Field("password") password: String
    ): Single<String>
}
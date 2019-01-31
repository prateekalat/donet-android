package io.codefundo.donet.authentication.data

import io.reactivex.Single
import retrofit2.http.*

interface AuthenticationRetrofitService {

    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST
    fun getAccessToken(
            @Url url: String,
            @FieldMap idToken: Map<String, String>
    ): Single<AccessToken>

    @GET
    fun getUser(
            @Url url: String,
            @Header("Authorization") token: String
    ): Single<UserWrapper>
}
package io.codefundo.donet.authentication.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AccessToken(
    @Json(name = "access_token") val accessToken: String,
    @Json(name = "token_type") val tokenType: String
) {
    override fun toString() = "$tokenType $accessToken"
}

package io.codefundo.donet.authentication.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
        @Json(name = "userID") val id: Int,
        @Json(name = "firstName") val firstName: String,
        @Json(name = "lastName") val lastName: String
)

@JsonClass(generateAdapter = true)
data class UserWrapper(
        @Json(name = "currentUser") val user: User
)
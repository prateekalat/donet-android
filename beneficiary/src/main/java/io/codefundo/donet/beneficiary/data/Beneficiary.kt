package io.codefundo.donet.beneficiary.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Beneficiary(
        @Json(name = "ID") val id: Int,
        @Json(name = "FirstName") val firstName: String,
        @Json(name = "LastName") val lastName: String
)

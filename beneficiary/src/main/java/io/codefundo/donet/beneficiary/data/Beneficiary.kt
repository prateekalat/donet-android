package io.codefundo.donet.beneficiary.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Beneficiary(
        @Json(name = "ref_id") val id: Int,
        @Json(name = "name") val name: String,
        @Json(name = "balance") val balance: Int
)

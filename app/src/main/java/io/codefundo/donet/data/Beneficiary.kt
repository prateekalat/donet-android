package io.codefundo.donet.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Beneficiary(
        val id: Int,
        val name: String,
        val balance: Int
)

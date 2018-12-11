package io.codefundo.donet.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FilterParameter(
        val id: Int,
        val value: String
)
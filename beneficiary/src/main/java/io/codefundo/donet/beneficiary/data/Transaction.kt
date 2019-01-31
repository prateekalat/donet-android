package io.codefundo.donet.beneficiary.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Transaction(
        val value: String,
        val name: String = "amountDonated",
        val workflowFunctionParameterId: Int = 14
)

@JsonClass(generateAdapter = true)
data class TransactionWrapper(
        val workflowActionParameters: List<Transaction>,
        val workflowFunctionID: Int = 14
)
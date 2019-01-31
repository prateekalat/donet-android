package io.codefundo.donet.beneficiary.data

import io.reactivex.Single
import retrofit2.http.*

interface BeneficiaryRetrofitService {

    @GET("beneficiaries")
    fun getCurrentBeneficiaries(
            @Header("Authorization") token: String,
            @Query("userId") userId: Int
    ): Single<List<Beneficiary>>

    @GET("refugee")
    fun searchForNewBeneficiaries(
            @Header("Authorization") token: String
    ): Single<List<Beneficiary>>

    @GET("transaction")
    fun getSmartContractId(
//            @Header("Authorization") token: String,
            @Query("userId") userId: Int
    ): Single<Int>

    @POST("beneficiaries/add")
    fun addNewBeneficiary(
            @Header("Authorization") token: String,
            @Field("beneficiary") beneficiary: Beneficiary
    ): Single<Any>

    @POST
    fun donate(
            @Url url: String,
            @Header("Authorization") token: String,
            @Body transactionWrapper: TransactionWrapper
    ): Single<Int>
}
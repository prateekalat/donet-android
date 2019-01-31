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

    @POST("beneficiaries/add")
    fun addNewBeneficiary(
            @Header("Authorization") token: String,
            @Field("beneficiary") beneficiary: Beneficiary
    ): Single<Any>
}
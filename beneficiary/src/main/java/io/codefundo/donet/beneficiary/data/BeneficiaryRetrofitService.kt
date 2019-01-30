package io.codefundo.donet.beneficiary.data

import io.reactivex.Single
import retrofit2.http.*

interface BeneficiaryRetrofitService {

    @GET("beneficiaries/{id}")
    fun getCurrentBeneficiaries(
            @Header("Authorization") token: String,
            @Path("id") userId: Int
    ): Single<List<Beneficiary>>

    @GET("refugee/{id}")
    fun searchForNewBeneficiaries(
            @Header("Authorization") token: String,
            @Path("id") userId: Int,
            @QueryMap parameters: Map<String, Int?>
    ): Single<List<Beneficiary>>

    @POST("beneficiaries/add")
    fun addNewBeneficiary(
            @Header("Authorization") token: String,
            @Field("beneficiary") beneficiary: Beneficiary
    ): Single<Any>
}
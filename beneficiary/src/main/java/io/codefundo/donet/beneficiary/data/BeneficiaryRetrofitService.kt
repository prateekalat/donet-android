package io.codefundo.donet.beneficiary.data

import io.reactivex.Single
import retrofit2.http.*

interface BeneficiaryRetrofitService {

    @GET("beneficiaries/{id}")
    fun getCurrentBeneficiaries(@Path("id") userId: Int): Single<List<Beneficiary>>

    @GET("refugee/{id}")
    fun searchForNewBeneficiaries(
            @Path("id") userId: Int,
            @QueryMap parameters: Map<String, Int?>
    ): Single<List<Beneficiary>>

    @POST("beneficiaries/add")
    fun addNewBeneficiary(@Field("beneficiary") beneficiary: Beneficiary): Single<Any>
}
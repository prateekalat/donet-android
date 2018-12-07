package io.codefundo.donet.data

import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface BeneficiaryRetrofitService {

    @GET("beneficiaries/{userId}")
    fun getCurrentBeneficiaries(@Path("userId") userId: Int): Single<List<Beneficiary>>

    @GET("beneficiaries/search/{parameters}")
    fun searchForNewBeneficiaries(@Path("parameters") parameters: List<String>): Single<List<Beneficiary>>

    @POST("beneficiaries/add")
    fun addNewBeneficiary(@Field("beneficiary") beneficiary: Beneficiary): Single<Any>
}
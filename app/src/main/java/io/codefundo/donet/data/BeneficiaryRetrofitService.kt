package io.codefundo.donet.data

import io.reactivex.Single
import retrofit2.http.*

interface BeneficiaryRetrofitService {

    @GET("beneficiaries")
    fun getCurrentBeneficiaries(): Single<List<Beneficiary>>

    @GET("beneficiaries/search")
    fun searchForNewBeneficiaries(@QueryMap parameters: Map<String, String>): Single<List<Beneficiary>>

    @POST("beneficiaries/add")
    fun addNewBeneficiary(@Field("beneficiary") beneficiary: Beneficiary): Single<Any>
}
package io.codefundo.donet.beneficiary.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.codefundo.donet.authentication.domain.GetAuthenticationTokenUseCase
import io.codefundo.donet.beneficiary.domain.BeneficiaryRepository
import io.codefundo.donet.core.Resource
import io.codefundo.donet.core.subscribeWithLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class BeneficiaryRepositoryImpl @Inject constructor(
        private val beneficiaryRetrofitService: BeneficiaryRetrofitService,
        getAuthenticationTokenUseCase: GetAuthenticationTokenUseCase
) : BeneficiaryRepository {

    private val searchForNewBeneficiariesResult = MutableLiveData<Resource>()
    private val getCurrentBeneficiariesResult = MutableLiveData<Resource>()

    private val tokenResult = getAuthenticationTokenUseCase.execute()

    override fun addNewBeneficiary(id: Int): LiveData<Resource> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchForNewBeneficiaries(parameters: Map<String, Int?>): LiveData<Resource> {

        val nonNullParameters = parameters.filter { it.value != null }
        val userId = nonNullParameters["don_id"]
        if (userId != null) {
            val token = tokenResult.value
            if (token != null) {
                beneficiaryRetrofitService
                        .searchForNewBeneficiaries(token, userId, nonNullParameters)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWithLiveData(searchForNewBeneficiariesResult)
            } else {
                searchForNewBeneficiariesResult.value = Resource.Failure(Throwable("Auth token is null"))
            }
        } else {
            searchForNewBeneficiariesResult.value = Resource.Failure(Throwable("User id is null"))
        }

        return searchForNewBeneficiariesResult
    }

    override fun getCurrentBeneficiaries(userId: Int): LiveData<Resource> {

        val token = tokenResult.value
        if (token != null) {
            beneficiaryRetrofitService
                    .getCurrentBeneficiaries(token, userId)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWithLiveData(getCurrentBeneficiariesResult)
        } else {
            getCurrentBeneficiariesResult.value = Resource.Failure(Throwable("Auth token is null"))
        }

        return getCurrentBeneficiariesResult
    }
}
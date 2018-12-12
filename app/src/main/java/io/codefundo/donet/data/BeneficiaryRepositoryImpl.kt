package io.codefundo.donet.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.codefundo.donet.domain.BeneficiaryRepository
import io.codefundo.donet.domain.Resource
import io.codefundo.donet.domain.subscribeWithLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class BeneficiaryRepositoryImpl @Inject constructor(
        private val beneficiaryRetrofitService: BeneficiaryRetrofitService
) : BeneficiaryRepository {

    private val searchForNewBeneficiariesResult = MutableLiveData<Resource>()
    private val getCurrentBeneficiariesResult = MutableLiveData<Resource>()

    override fun addNewBeneficiary(id: Int): LiveData<Resource> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchForNewBeneficiaries(parameters: Map<String, Int?>): LiveData<Resource> {

        val nonNullParameters = parameters.filter { it.value != null }
        val userId = nonNullParameters["don_id"]
        if (userId != null) {
            beneficiaryRetrofitService
                    .searchForNewBeneficiaries(userId, nonNullParameters)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWithLiveData(searchForNewBeneficiariesResult)
        } else {
            searchForNewBeneficiariesResult.value = Resource.Failure(Throwable("User id is null"))
        }

        return searchForNewBeneficiariesResult
    }

    override fun getCurrentBeneficiaries(userId: Int): LiveData<Resource> {

        beneficiaryRetrofitService
                .getCurrentBeneficiaries(userId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWithLiveData(getCurrentBeneficiariesResult)

        return getCurrentBeneficiariesResult
    }
}
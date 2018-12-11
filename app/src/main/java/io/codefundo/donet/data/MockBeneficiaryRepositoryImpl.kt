package io.codefundo.donet.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.codefundo.donet.domain.BeneficiaryRepository
import io.codefundo.donet.domain.Resource
import io.codefundo.donet.domain.subscribeWithLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class MockBeneficiaryRepositoryImpl @Inject constructor(
        private val beneficiaryRetrofitService: BeneficiaryRetrofitService) : BeneficiaryRepository {

    private val searchForNewBeneficiariesResult = MutableLiveData<Resource>()
    private val getCurrentBeneficiariesResult = MutableLiveData<Resource>()

    override fun addNewBeneficiary(id: Int): LiveData<Resource> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchForNewBeneficiaries(parameters: List<String>): LiveData<Resource> {

        val mapOfProperties = mutableMapOf<String, String>()
        val keys = arrayOf("age-group", "familial", "disability", "gender", "balance")
        parameters.forEachIndexed { index, s -> mapOfProperties[keys[index]] = s}

        beneficiaryRetrofitService
                .searchForNewBeneficiaries(mapOfProperties)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWithLiveData(searchForNewBeneficiariesResult)

        return searchForNewBeneficiariesResult
    }

    override fun getCurrentBeneficiaries(): LiveData<Resource> {

        beneficiaryRetrofitService
                .getCurrentBeneficiaries()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWithLiveData(getCurrentBeneficiariesResult)

        return getCurrentBeneficiariesResult
    }
}
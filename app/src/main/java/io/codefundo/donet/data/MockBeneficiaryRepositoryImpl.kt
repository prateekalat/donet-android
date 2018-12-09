package io.codefundo.donet.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.codefundo.donet.domain.BeneficiaryRepository
import io.codefundo.donet.domain.Parameter
import io.codefundo.donet.domain.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class MockBeneficiaryRepositoryImpl @Inject constructor(
        val beneficiaryRetrofitService: BeneficiaryRetrofitService) : BeneficiaryRepository {

    private val beneficiaries = MutableLiveData<Resource>()

    override fun addNewBeneficiary(id: Int): LiveData<Resource> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchForNewBeneficiaries(parameters: List<Parameter>): LiveData<Resource> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrentBeneficiaries(): LiveData<Resource> {
//        beneficiaries.value = Resource.Success(
//                listOf(
//                        Beneficiary(1, "John Smith", 100),
//                        Beneficiary(2, "Jane Does", 77),
//                        Beneficiary(3, "Bart Simpson", 200)
//                )
//        )

        beneficiaryRetrofitService.getCurrentBeneficiaries()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onError = {
                        beneficiaries.value = Resource.Failure(it)
                    },
                    onSuccess = {
                        beneficiaries.value = Resource.Success(it)
                    }
        )

        return beneficiaries
    }
}
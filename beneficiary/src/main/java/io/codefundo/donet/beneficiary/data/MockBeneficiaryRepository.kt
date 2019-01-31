package io.codefundo.donet.beneficiary.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.codefundo.donet.beneficiary.domain.BeneficiaryRepository
import io.codefundo.donet.core.Resource

class MockBeneficiaryRepository : BeneficiaryRepository {
    override fun getCachedCurrentBeneficiaries(): LiveData<Resource> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCachedSearchedBeneficiaries(): LiveData<Resource> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val searchForNewBeneficiariesResult = MutableLiveData<Resource>()
    private val getCurrentBeneficiariesResult = MutableLiveData<Resource>()

    override fun addNewBeneficiary(id: Int): LiveData<Resource> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchForNewBeneficiaries(parameters: Map<String, Int?>): LiveData<Resource> {
        searchForNewBeneficiariesResult.value = Resource.Success(listOf(
                Beneficiary(
                        1,
                        "John",
                        "Smith"
                )
        ))

        return searchForNewBeneficiariesResult
    }

    override fun getCurrentBeneficiaries(userId: Int): LiveData<Resource> {
        getCurrentBeneficiariesResult.value = Resource.Success(listOf(
                Beneficiary(
                        1,
                        "John",
                        "Smith"
                )
        ))

        return getCurrentBeneficiariesResult
    }
}
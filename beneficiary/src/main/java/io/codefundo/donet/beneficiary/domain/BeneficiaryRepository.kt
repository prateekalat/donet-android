package io.codefundo.donet.beneficiary.domain

import androidx.lifecycle.LiveData
import io.codefundo.donet.core.Resource

interface BeneficiaryRepository {

    fun addNewBeneficiary(id: Int): LiveData<Resource>

    fun searchForNewBeneficiaries(parameters: Map<String, Int?>): LiveData<Resource>

    fun getCachedSearchedBeneficiaries(): LiveData<Resource>
    fun getCachedCurrentBeneficiaries(): LiveData<Resource>

    fun getCurrentBeneficiaries(userId: Int): LiveData<Resource>
}
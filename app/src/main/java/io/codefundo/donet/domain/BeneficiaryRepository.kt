package io.codefundo.donet.domain

import androidx.lifecycle.LiveData

interface BeneficiaryRepository {

    fun addNewBeneficiary(id: Int): LiveData<Resource>

    fun searchForNewBeneficiaries(parameters: Map<String, Int?>): LiveData<Resource>

    fun getCurrentBeneficiaries(userId: Int): LiveData<Resource>
}
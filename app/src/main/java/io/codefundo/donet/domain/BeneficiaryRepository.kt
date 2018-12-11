package io.codefundo.donet.domain

import androidx.lifecycle.LiveData

interface BeneficiaryRepository {

    fun addNewBeneficiary(id: Int): LiveData<Resource>

    fun searchForNewBeneficiaries(parameters: List<String>): LiveData<Resource>

    fun getCurrentBeneficiaries(): LiveData<Resource>
}
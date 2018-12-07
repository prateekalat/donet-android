package io.codefundo.donet.domain

import io.codefundo.donet.data.User
import io.reactivex.Single

interface BeneficiaryService {

    fun addNewBeneficiary(id: Int): Single<ResponseObject>

    fun searchForNewBeneficiaries(parameters: List<Parameter>): Single<ResponseObject>

    fun getCurrentBeneficiaries(user: User): Single<ResponseObject>
}
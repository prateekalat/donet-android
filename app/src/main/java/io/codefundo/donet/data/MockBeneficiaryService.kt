package io.codefundo.donet.data

import io.codefundo.donet.domain.BeneficiaryService
import io.codefundo.donet.domain.Parameter
import io.codefundo.donet.domain.ResponseObject
import io.reactivex.Single

class MockBeneficiaryService : BeneficiaryService {
    override fun addNewBeneficiary(id: Int): Single<ResponseObject> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchForNewBeneficiaries(parameters: List<Parameter>): Single<ResponseObject> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrentBeneficiaries(user: User): Single<ResponseObject> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
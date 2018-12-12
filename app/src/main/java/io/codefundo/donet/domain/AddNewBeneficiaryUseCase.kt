package io.codefundo.donet.domain

import androidx.lifecycle.LiveData
import io.codefundo.donet.dagger.BeneficiaryScope
import io.codefundo.donet.data.Beneficiary
import javax.inject.Inject

@BeneficiaryScope
class AddNewBeneficiaryUseCase @Inject constructor(
        private val beneficiaryRepository: BeneficiaryRepository
): UseCase<Beneficiary, Resource> {

    override fun execute(vararg args: Beneficiary): LiveData<Resource> =
            beneficiaryRepository.addNewBeneficiary(args.first().id)
}
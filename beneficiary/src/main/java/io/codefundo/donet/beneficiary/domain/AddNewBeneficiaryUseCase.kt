package io.codefundo.donet.beneficiary.domain

import androidx.lifecycle.LiveData
import io.codefundo.donet.beneficiary.data.Beneficiary
import io.codefundo.donet.core.Resource
import io.codefundo.donet.core.UseCase
import io.codefundo.donet.beneficiary.dagger.BeneficiaryScope
import javax.inject.Inject

@BeneficiaryScope
class AddNewBeneficiaryUseCase @Inject constructor(
        private val beneficiaryRepository: BeneficiaryRepository
): UseCase<Beneficiary, Resource> {

    override fun execute(vararg args: Beneficiary): LiveData<Resource> =
            beneficiaryRepository.addNewBeneficiary(args.first().id)
}
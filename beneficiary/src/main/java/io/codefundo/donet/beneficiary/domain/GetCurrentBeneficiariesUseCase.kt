package io.codefundo.donet.beneficiary.domain

import androidx.lifecycle.LiveData
import io.codefundo.donet.core.Resource
import io.codefundo.donet.core.UseCase
import io.codefundo.donet.beneficiary.dagger.BeneficiaryScope
import io.codefundo.donet.beneficiary.data.User
import javax.inject.Inject

@BeneficiaryScope
class GetCurrentBeneficiariesUseCase @Inject constructor(
        private val beneficiaryRepository: BeneficiaryRepository
): UseCase<User, Resource> {

    override fun execute(vararg args: User): LiveData<Resource> =
            beneficiaryRepository.getCurrentBeneficiaries(args.first().id)
}
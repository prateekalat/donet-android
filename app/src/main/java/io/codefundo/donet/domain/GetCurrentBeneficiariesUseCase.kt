package io.codefundo.donet.domain

import androidx.lifecycle.LiveData
import io.codefundo.donet.dagger.BeneficiaryScope
import io.codefundo.donet.data.User
import javax.inject.Inject

@BeneficiaryScope
class GetCurrentBeneficiariesUseCase @Inject constructor(
        private val beneficiaryRepository: BeneficiaryRepository
): UseCase<User, Resource> {

    override fun execute(vararg args: User): LiveData<Resource> =
            beneficiaryRepository.getCurrentBeneficiaries(args.first().id)
}
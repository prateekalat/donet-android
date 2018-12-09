package io.codefundo.donet.domain

import androidx.lifecycle.LiveData
import io.codefundo.donet.dagger.BeneficiaryScope
import javax.inject.Inject

@BeneficiaryScope
class GetCurrentBeneficiariesUseCase @Inject constructor(
        private val beneficiaryRepository: BeneficiaryRepository): UseCase<Unit, Resource> {

    override fun execute(vararg args: Unit): LiveData<Resource> =
            beneficiaryRepository.getCurrentBeneficiaries()
}
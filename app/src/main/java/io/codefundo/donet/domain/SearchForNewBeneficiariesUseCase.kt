package io.codefundo.donet.domain

import androidx.lifecycle.LiveData
import io.codefundo.donet.dagger.BeneficiaryScope
import javax.inject.Inject

@BeneficiaryScope
class SearchForNewBeneficiariesUseCase @Inject constructor(
        private val beneficiaryRepository: BeneficiaryRepository): UseCase<Parameter, Resource> {

    override fun execute(vararg args: Parameter): LiveData<Resource> =
            beneficiaryRepository.searchForNewBeneficiaries(args.toList())
}
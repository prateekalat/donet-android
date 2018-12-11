package io.codefundo.donet.domain

import androidx.lifecycle.LiveData
import io.codefundo.donet.dagger.BeneficiaryScope
import javax.inject.Inject

@BeneficiaryScope
class SearchForNewBeneficiariesUseCase @Inject constructor(
        private val beneficiaryRepository: BeneficiaryRepository): UseCase<String, Resource> {

    override fun execute(vararg args: String): LiveData<Resource> =
            beneficiaryRepository.searchForNewBeneficiaries(args.toList())
}
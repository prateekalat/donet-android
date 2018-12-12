package io.codefundo.donet.domain

import androidx.lifecycle.LiveData
import io.codefundo.donet.dagger.BeneficiaryScope
import javax.inject.Inject

@BeneficiaryScope
class SearchForNewBeneficiariesUseCase @Inject constructor(
        private val beneficiaryRepository: BeneficiaryRepository
) : UseCase<Map<String, Int?>, Resource> {

    override fun execute(vararg args: Map<String, Int?>): LiveData<Resource> =
            beneficiaryRepository.searchForNewBeneficiaries(args.first())
}
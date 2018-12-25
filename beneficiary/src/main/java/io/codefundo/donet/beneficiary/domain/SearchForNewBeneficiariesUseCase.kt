package io.codefundo.donet.beneficiary.domain

import androidx.lifecycle.LiveData
import io.codefundo.donet.core.Resource
import io.codefundo.donet.core.UseCase
import io.codefundo.donet.beneficiary.dagger.BeneficiaryScope
import javax.inject.Inject

@BeneficiaryScope
class SearchForNewBeneficiariesUseCase @Inject constructor(
        private val beneficiaryRepository: BeneficiaryRepository
) : UseCase<Map<String, Int?>, Resource> {

    override fun execute(vararg args: Map<String, Int?>): LiveData<Resource> =
            beneficiaryRepository.searchForNewBeneficiaries(args.first())
}
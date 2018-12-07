package io.codefundo.donet.domain

import io.codefundo.donet.dagger.BeneficiaryScope
import javax.inject.Inject

@BeneficiaryScope
class SearchForNewBeneficiariesUseCase @Inject constructor(private val beneficiaryService: BeneficiaryService) {

    fun searchForNewBeneficiaries(parameters: List<Parameter>) = beneficiaryService.searchForNewBeneficiaries(parameters)
}
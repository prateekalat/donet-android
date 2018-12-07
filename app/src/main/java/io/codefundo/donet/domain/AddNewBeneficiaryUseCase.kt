package io.codefundo.donet.domain

import io.codefundo.donet.dagger.BeneficiaryScope
import javax.inject.Inject

@BeneficiaryScope
class AddNewBeneficiaryUseCase @Inject constructor(private val beneficiaryService: BeneficiaryService) {

    fun addNewBeneficiary(id: Int) = beneficiaryService.addNewBeneficiary(id)
}
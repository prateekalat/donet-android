package io.codefundo.donet.domain

import io.codefundo.donet.dagger.BeneficiaryScope
import io.codefundo.donet.data.User
import javax.inject.Inject

@BeneficiaryScope
class GetCurrentBeneficiariesUseCase @Inject constructor(private val beneficiaryService: BeneficiaryService) {

    fun getCurrentBeneficiaries(user: User) = beneficiaryService.getCurrentBeneficiaries(user)
}
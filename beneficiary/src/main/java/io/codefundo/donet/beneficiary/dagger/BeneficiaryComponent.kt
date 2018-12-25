package io.codefundo.donet.beneficiary.dagger

import dagger.Component
import io.codefundo.donet.beneficiary.BeneficiaryViewModel
import io.codefundo.donet.core.dagger.AppComponent

@BeneficiaryScope
@Component(dependencies = [AppComponent::class], modules = [BeneficiaryModule::class])
interface BeneficiaryComponent {
    fun inject(beneficiaryViewModel: BeneficiaryViewModel)
}
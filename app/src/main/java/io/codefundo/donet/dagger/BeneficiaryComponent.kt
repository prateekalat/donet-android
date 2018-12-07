package io.codefundo.donet.dagger

import dagger.Component
import io.codefundo.donet.BeneficiaryViewModel

@BeneficiaryScope
@Component(dependencies = [AppComponent::class], modules = [BeneficiaryModule::class])
interface BeneficiaryComponent {
    fun inject(beneficiaryViewModel: BeneficiaryViewModel)
}
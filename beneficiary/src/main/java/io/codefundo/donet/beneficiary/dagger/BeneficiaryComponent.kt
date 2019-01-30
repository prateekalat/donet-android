package io.codefundo.donet.beneficiary.dagger

import dagger.Component
import io.codefundo.donet.authentication.dagger.AuthenticationComponent
import io.codefundo.donet.beneficiary.BeneficiaryViewModel

@BeneficiaryScope
@Component(
        dependencies = [AuthenticationComponent::class],
        modules = [BeneficiaryModule::class]
)
interface BeneficiaryComponent {
    fun inject(beneficiaryViewModel: BeneficiaryViewModel)
}
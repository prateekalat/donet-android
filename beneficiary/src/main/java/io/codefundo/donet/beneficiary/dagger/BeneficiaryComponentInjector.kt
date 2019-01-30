package io.codefundo.donet.beneficiary.dagger

import io.codefundo.donet.authentication.dagger.AuthenticationComponentInjector

class BeneficiaryComponentInjector {
    companion object {
        val instance : BeneficiaryComponent by lazy {
            DaggerBeneficiaryComponent
                    .builder()
                    .authenticationComponent(AuthenticationComponentInjector.instance)
                    .build()
        }
    }
}
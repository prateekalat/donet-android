package io.codefundo.donet.beneficiary.dagger

import io.codefundo.donet.core.dagger.AppComponentInjector

class BeneficiaryComponentInjector {
    companion object {
        val instance : BeneficiaryComponent by lazy {
            DaggerBeneficiaryComponent
                    .builder()
                    .appComponent(AppComponentInjector.instance)
                    .build()
        }
    }
}
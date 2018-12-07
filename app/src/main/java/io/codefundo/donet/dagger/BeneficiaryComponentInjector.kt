package io.codefundo.donet.dagger

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
package io.codefundo.donet.dagger

import dagger.Module
import dagger.Provides
import io.codefundo.donet.data.MockBeneficiaryService
import io.codefundo.donet.domain.BeneficiaryService

@Module
class BeneficiaryModule {

    @Provides
    @BeneficiaryScope
    fun provideBeneficiaryService(): BeneficiaryService = MockBeneficiaryService()
}
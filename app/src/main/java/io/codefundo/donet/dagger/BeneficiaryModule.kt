package io.codefundo.donet.dagger

import dagger.Module
import dagger.Provides
import io.codefundo.donet.data.BeneficiaryRetrofitService
import io.codefundo.donet.data.MockBeneficiaryRepositoryImpl
import io.codefundo.donet.domain.BeneficiaryRepository
import retrofit2.Retrofit

@Module
class BeneficiaryModule {

    @Provides
    @BeneficiaryScope
    fun provideBeneficiaryRetrofitService(retrofit: Retrofit): BeneficiaryRetrofitService
        = retrofit.create(BeneficiaryRetrofitService::class.java)

    @Provides
    @BeneficiaryScope
    fun provideBeneficiaryRepository(beneficiaryRetrofitService: BeneficiaryRetrofitService): BeneficiaryRepository
            = MockBeneficiaryRepositoryImpl(beneficiaryRetrofitService)
}
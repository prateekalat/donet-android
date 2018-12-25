package io.codefundo.donet.beneficiary.dagger

import dagger.Module
import dagger.Provides
import io.codefundo.donet.beneficiary.data.BeneficiaryRepositoryImpl
import io.codefundo.donet.beneficiary.data.BeneficiaryRetrofitService
import io.codefundo.donet.beneficiary.domain.BeneficiaryRepository
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
            = BeneficiaryRepositoryImpl(beneficiaryRetrofitService)
}
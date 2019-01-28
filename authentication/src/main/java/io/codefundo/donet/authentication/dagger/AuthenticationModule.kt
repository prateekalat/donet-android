package io.codefundo.donet.authentication.dagger

import dagger.Module
import dagger.Provides
import io.codefundo.donet.authentication.data.AuthenticationRepositoryImpl
import io.codefundo.donet.authentication.data.AuthenticationRetrofitService
import io.codefundo.donet.authentication.domain.AuthenticationRepository
import retrofit2.Retrofit

@Module
class AuthenticationModule {

    @Provides
    @AuthenticationScope
    fun provideAuthenticationRetrofitService(retrofit: Retrofit): AuthenticationRetrofitService =
            retrofit.create(AuthenticationRetrofitService::class.java)

    @Provides
    @AuthenticationScope
    fun provideAuthenticationRepository(
            authenticationRetrofitService: AuthenticationRetrofitService
    ): AuthenticationRepository = AuthenticationRepositoryImpl(authenticationRetrofitService)
}
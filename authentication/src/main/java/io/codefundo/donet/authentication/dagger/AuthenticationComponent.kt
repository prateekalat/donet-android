package io.codefundo.donet.authentication.dagger

import dagger.Component
import io.codefundo.donet.authentication.AuthenticationViewModel
import io.codefundo.donet.authentication.domain.AuthenticationRepository
import io.codefundo.donet.authentication.domain.GetAuthenticationTokenUseCase
import io.codefundo.donet.core.dagger.AppComponent
import retrofit2.Retrofit

@AuthenticationScope
@Component(dependencies = [AppComponent::class], modules = [AuthenticationModule::class])
interface AuthenticationComponent {
    fun inject(authenticationViewModel: AuthenticationViewModel)

    fun provideRetrofit(): Retrofit
    fun provideGetAuthenticationTokenUseCase(): GetAuthenticationTokenUseCase
    fun provideAuthenticationRepository(): AuthenticationRepository
}
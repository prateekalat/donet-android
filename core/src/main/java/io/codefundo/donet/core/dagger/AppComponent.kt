package io.codefundo.donet.core.dagger

import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class])
interface AppComponent {

    // Provide dependencies to children
    fun retrofit(): Retrofit
}
package io.codefundo.donet.dagger

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    @Named("baseUrl")
    fun provideBaseUrl(): String = "https://11a3fdc5.ngrok.io/api/v1.0/"

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient()

    @Provides
    @Singleton
    fun provideRetrofit(httpClient: OkHttpClient, @Named("baseUrl") url: String): Retrofit =
            Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(MoshiConverterFactory.create())
                .client(httpClient)
                .build()
}
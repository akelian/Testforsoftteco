package by.softteco.nmisko.data.remote.retrofit

import by.softteco.nmisko.data.AppContracts
import by.softteco.nmisko.data.remote.CurlLoggingInterceptor
import by.softteco.nmisko.data.remote.api.RemoteApi

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Named

import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideOkHTTPClient(@Named("interceptor") interceptor: CurlLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Provides
    @Singleton
    @Named("interceptor")
    fun provideLoggingInterceptor(): CurlLoggingInterceptor {
        return CurlLoggingInterceptor()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): RemoteApi {
        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(AppContracts.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
        return retrofit.create(RemoteApi::class.java)
    }
}
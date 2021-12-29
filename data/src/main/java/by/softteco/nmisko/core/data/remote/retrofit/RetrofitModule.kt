package by.softteco.nmisko.core.data.remote.retrofit

import by.softteco.nmisko.core.data.AppContracts
import by.softteco.nmisko.core.data.remote.api.RemoteApi
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Named
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideOkHTTPClient(/*@Named("interceptor") interceptor: HttpLoggingInterceptor*/): OkHttpClient {
        return OkHttpClient.Builder()/*.addInterceptor(interceptor)*/.build()
    }

//    @Provides
//    @Singleton
//    @Named("interceptor")
//    fun provideLoggingInterceptor(): CurlLoggingInterceptor {
//        val loggingInterceptor = HttpLoggingInterceptor()
//        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//        return loggingInterceptor
//    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): RemoteApi {
        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(AppContracts.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
        return retrofit.create()
    }
}
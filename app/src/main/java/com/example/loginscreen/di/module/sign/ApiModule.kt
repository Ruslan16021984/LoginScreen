package com.example.loginscreen.di.module.sign

import com.example.loginscreen.BuildConfig
import com.example.loginscreen.di.scope.SignScope
import com.example.loginscreen.repository.AppRepository
import com.example.loginscreen.repository.api.ApiService
import com.example.loginscreen.repository.api.ServerCommunicator
import com.example.loginscreen.repository.database.AppDatabase
import dagger.Module
import dagger.Provides
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class ApiModule {
    companion object{
        private const val API_URL = "https://tips-api-staging.crio-server.com/"
    }
    @SignScope
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create<ApiService>(ApiService::class.java)
    }
    @SignScope
    @Provides
    fun provideRetrofitBuilder(): Retrofit.Builder{
        val builder = OkHttpClient.Builder()
            .connectionPool(ConnectionPool(5, 30, TimeUnit.SECONDS))
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG){
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            builder.addInterceptor(httpLoggingInterceptor)
        }
        return Retrofit.Builder().client(builder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    }
    @SignScope
    @Provides
    internal fun providesRepository(communicator: ServerCommunicator, database: AppDatabase): AppRepository {
        return AppRepository(communicator, database)
    }
    @SignScope
    @Provides
    fun provideRetrofit( builder: Retrofit.Builder): Retrofit {
        return builder.baseUrl(API_URL).build()
    }

    @SignScope
    @Provides
    fun provideCommunicator(apiService: ApiService): ServerCommunicator {
        return ServerCommunicator(apiService)
    }
}
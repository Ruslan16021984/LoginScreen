package com.example.loginscreen.di.module

import com.example.loginscreen.di.scope.ApiScope
import com.example.loginscreen.repository.api.ApiService
import com.example.loginscreen.repository.api.ServerCommunicator
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Named

@Module(includes = [RetrofitModule::class])
class ApiModule {
    companion object{
        private val API_URL = "https://tips-api-staging.crio-server.com/"
    }

    @Provides
    @ApiScope
    fun provideRetrofit( builder: Retrofit.Builder): Retrofit {
        return builder.baseUrl(API_URL).build()
    }

    @Provides
    @ApiScope
    @Inject
    fun provideApiService(retrofit: Retrofit): ApiService{
        return retrofit.create<ApiService>(ApiService::class.java!!)
    }
    @Provides
    @ApiScope
    fun provideCommunicator(apiService: ApiService): ServerCommunicator {
        return ServerCommunicator(apiService)
    }
}
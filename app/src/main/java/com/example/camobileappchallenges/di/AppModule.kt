package com.example.camobileappchallenges.di

import com.example.camobileappchallenges.common.Constants
import com.example.camobileappchallenges.data.remote.GetListAccountsApi
import com.example.camobileappchallenges.data.repository.AccountRepositoryImp
import com.example.camobileappchallenges.domain.repository.AccountsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/*
   this is the dependency injection
   Api and Repository
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun  provideAccountsApi(): GetListAccountsApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GetListAccountsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAccountsRepository(api: GetListAccountsApi): AccountsRepository{
        return AccountRepositoryImp(api)
    }
}
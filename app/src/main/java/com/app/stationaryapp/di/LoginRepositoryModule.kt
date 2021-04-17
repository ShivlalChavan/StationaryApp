package com.app.stationaryapp.di

import com.app.stationaryapp.model.UserLoginRequest
import com.app.stationaryapp.repository.LoginRepository
import com.app.stationaryapp.retrofit.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object LoginRepositoryModule {
    @Singleton
    @Provides
    fun provideLoginRepositoy(
        apiService: ApiService
    ):LoginRepository {
        return LoginRepository(apiService)
    }
}
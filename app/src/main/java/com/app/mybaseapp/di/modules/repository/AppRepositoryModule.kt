package com.app.mybaseapp.di.modules.repository

import com.app.mybaseapp.repository.app_repository.AppRepository
import com.app.mybaseapp.repository.app_repository.AppRepositoryImplementation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AppRepositoryModule {

    @Binds
    @Singleton
    fun bindMyRepository(impl: AppRepositoryImplementation): AppRepository

}
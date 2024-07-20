package com.android.data.di

import com.android.data.repository.MovieRepository
import com.android.data.repository.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {

    @Binds
    fun bindsMainRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository
}
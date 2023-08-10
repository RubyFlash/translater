package com.example.translator.di

import android.content.Context
import com.example.translator.data.repository.DataStoreRepositoryImpl
import com.example.translator.domain.repository.DataStoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreRepository(@ApplicationContext context: Context) : DataStoreRepository {
        return DataStoreRepositoryImpl(context = context)
    }

}
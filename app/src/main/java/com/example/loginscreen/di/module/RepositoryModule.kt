package com.example.loginscreen.di.module

import com.example.loginscreen.di.scope.RepositoryScope
import com.example.loginscreen.repository.AppRepository
import com.example.loginscreen.repository.api.ServerCommunicator
import com.example.loginscreen.repository.database.AppDatabase
import dagger.Module
import dagger.Provides
@Module
class RepositoryModule {
    @RepositoryScope
    @Provides
    internal fun providesRepository(communicator: ServerCommunicator, database: AppDatabase): AppRepository{
        return AppRepository(communicator, database)
    }
}
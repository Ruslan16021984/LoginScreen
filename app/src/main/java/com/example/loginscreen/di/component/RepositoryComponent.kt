package com.example.loginscreen.di.component

import com.example.loginscreen.di.module.RepositoryModule
import com.example.loginscreen.di.scope.RepositoryScope
import com.example.loginscreen.repository.AppRepository
import dagger.Component

@RepositoryScope
@Component(modules = [RepositoryModule::class], dependencies = [ApiComponent::class, DatabaseComponent::class])
interface RepositoryComponent {
    val repository: AppRepository
}
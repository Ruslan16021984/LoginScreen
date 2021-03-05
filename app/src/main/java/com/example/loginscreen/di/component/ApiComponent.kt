package com.example.loginscreen.di.component

import com.example.loginscreen.di.module.ApiModule
import com.example.loginscreen.di.scope.ApiScope
import com.example.loginscreen.repository.api.ServerCommunicator
import dagger.Component
@ApiScope
@Component(modules = [ApiModule::class])
interface ApiComponent {
    val serverCommunicator: ServerCommunicator
}
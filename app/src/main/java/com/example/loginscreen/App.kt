package com.example.loginscreen

import android.app.Application
import androidx.room.Room
import com.example.loginscreen.di.component.*
import com.example.loginscreen.di.module.ApiModule
import com.example.loginscreen.di.module.DataBaseModule
import com.example.loginscreen.di.module.RepositoryModule
import com.example.loginscreen.di.module.ViewModuleModule
import com.example.loginscreen.repository.database.AppDatabase

class App: Application() {
    private var viewModelComponent: ViewModelComponent? = null
    private var database: AppDatabase?= null
    override fun onCreate() {
        super.onCreate()
        initRoom()
        initDagger()
    }
    private fun initRoom(){
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .allowMainThreadQueries()
            .build()
    }
    private fun initDagger() {
        val apiComponent = DaggerApiComponent.builder()
            .apiModule(ApiModule())
            .build()

        val databaseComponent = DaggerDatabaseComponent.builder()
            .dataBaseModule(DataBaseModule(this!!.database!!))
            .build()

        val repositoryComponent = DaggerRepositoryComponent.builder()
            .apiComponent(apiComponent)
            .databaseComponent(databaseComponent)
            .repositoryModule(RepositoryModule())
            .build()

        viewModelComponent = DaggerViewModelComponent.builder()
            .repositoryComponent(repositoryComponent)
            .viewModuleModule(ViewModuleModule(this))
            .build()
    }
    fun getViewModelComponent(): ViewModelComponent {
        return this.viewModelComponent!!
    }
}
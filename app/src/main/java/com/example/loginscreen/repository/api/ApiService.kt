package com.example.loginscreen.repository.api

import com.example.loginscreen.repository.database.entity.Status
import com.example.loginscreen.repository.database.entity.User
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("login")
    fun postUser(@Query("phone_code") phone_code: String,
    @Query("phone_number")  phone_number: String,
    @Query("password") password: String): Single<Status>
}
package com.example.loginscreen.repository.api

import com.example.loginscreen.repository.database.entity.Status
import io.reactivex.Single
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("login")
    fun postUser(@Query("phone_code") phone_code: String,
    @Query("phone_number")  phone_number: String,
    @Query("password") password: String): Single<Status>
}
package com.example.loginscreen.repository.database.entity

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class Status (
    @SerializedName("status")
    @Expose
    var status: String? = null,

    @SerializedName("user")
    @Expose
    var user: User? = null

)
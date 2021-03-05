package com.example.loginscreen.repository.database.entity

import androidx.annotation.NonNull
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User (
    @Expose
    @SerializedName("name")
    var name: String
)
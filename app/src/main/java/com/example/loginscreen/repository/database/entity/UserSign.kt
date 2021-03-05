package com.example.loginscreen.repository.database.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user")
data class UserSign(
    @PrimaryKey
    @NonNull
    @SerializedName("userId")
    @Expose
    val userId: String,
    @Expose
    @SerializedName("name")
    val name: String?,
    @Expose
    @SerializedName("surname")
    val surname: String?,
    @Expose
    @SerializedName("phone")
    val phone: String?,
    @Expose
    @SerializedName("password")
    val password: String?
)
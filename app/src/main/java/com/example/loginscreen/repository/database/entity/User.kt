package com.example.loginscreen.repository.database.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
@Entity(tableName = "user")
data class User (
    @PrimaryKey
    @NonNull
    @SerializedName("user_id")
    @Expose
    var userId: String,
    @SerializedName("name")
    @Expose
    var name: String? = null,
    @SerializedName("second_name")
    @Expose
    var secondName: String? = null,
    @SerializedName("phone_number")
    @Expose
    var phoneNumber: String? = null,
    @SerializedName("phone_code")
    @Expose
    var phoneCode: String? = null







)
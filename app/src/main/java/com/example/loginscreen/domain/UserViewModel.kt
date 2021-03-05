package com.example.loginscreen.domain

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.loginscreen.repository.AppRepository
import com.example.loginscreen.repository.database.entity.UserSign
import com.kalashnyk.denys.kotlinsample.presentation.widget.SingleLiveEvent

class UserViewModel(application: Application, private val mRepository: AppRepository) :
    BaseViewModel(application) {
    var status: Boolean = true
    private val liveDataItem = SingleLiveEvent<UserSign>()
    fun getLiveDataItem(): LiveData<UserSign> {
        return liveDataItem
    }


    fun postUser(
        code: String,
        number: String,
        password: String
    ) {
        mRepository.postUserToServer(code, number, password).subscribe({
            Log.e("postUserToServer", " --------${it.isSuccessful}")
            it.body()?.userId?.let { it1 ->
                UserSign(
                    it1,
                    it.body()?.name,
                    it.body()?.surname,
                    it.body()?.phone,
                    it.body()?.password
                )
                Log.e("post", " --------${it.body().toString()}")
            }


        }, {
                 Log.e("-----Error", "-----------")
        })

    }

    fun getUser(): LiveData<UserSign> {
        val user = mRepository.getUserFromDb()
        liveDataItem.value = user.value
        return user
    }
}
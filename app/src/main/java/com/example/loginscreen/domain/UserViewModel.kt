package com.example.loginscreen.domain

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.loginscreen.repository.AppRepository
import com.example.loginscreen.repository.database.entity.User
import com.example.loginscreen.widget.SingleLiveEvent
import io.reactivex.Single
import javax.inject.Inject

class UserViewModel
    @Inject
        constructor(private val mRepository: AppRepository) :
    ViewModel() {
    private val liveDataItem = SingleLiveEvent<User>()
    fun getLiveDataItem(): LiveData<User> {
        return liveDataItem
    }

    @SuppressLint("CheckResult")
    fun postUser(code: String,
                 number: String,
                 password: String){
        mRepository.postUserToServer(code, number, password)?.subscribe ({
            liveDataItem.value = it
        },{
            Log.e("TAG", "postUser -> Throwable")
        })
    }
    fun getUse(): Single<User> {
        return mRepository.getUserFromDb()
    }
}
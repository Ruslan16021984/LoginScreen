package com.example.loginscreen.domain

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.loginscreen.repository.AppRepository
import com.example.loginscreen.repository.database.entity.User
import com.example.loginscreen.widget.SingleLiveEvent
import io.reactivex.rxjava3.core.Single

class UserViewModel(application: Application, private val mRepository: AppRepository) :
    BaseViewModel(application) {
    private val liveDataItem = SingleLiveEvent<User>()
    fun getLiveDataItem(): LiveData<User> {
        return liveDataItem
    }

    fun postUser(code: String,
                 number: String,
                 password: String){
        mRepository.postUserToServer(code, number, password)?.subscribe ({
            liveDataItem.value = it
        },{
            Log.e("-----Error", "-----------")
        })
    }
    fun getUse(): Single<User> {
        return mRepository.getUserFromDb()
    }
}
package com.example.loginscreen.domain

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.loginscreen.repository.AppRepository
import com.example.loginscreen.repository.database.entity.User
import com.example.loginscreen.widget.SingleLiveEvent

class UserViewModel(application: Application, private val mRepository: AppRepository) :
    BaseViewModel(application) {
    private val liveDataItem = SingleLiveEvent<User>()
    fun getLiveDataItem(): LiveData<User> {
        return liveDataItem
    }


//    fun postUser(
//        code: String,
//        number: String,
//        password: String
//    ) {
//        mRepository.postUserToServer(code, number, password).subscribe({
//val fullNumber = " $code${ it.user?.phoneNumber }"
//                val user = it.user?.let { it1 -> User(it1.userId, it.user?.secondName, it.user?.name, fullNumber) }
//            if (user != null) {
//               mRepository.addUser(user)
//              liveDataItem.value =  mRepository.getUserFromDb()
//            }
//
//
//        }, {
//            Log.e("-----Error", "-----------")
//        })
//
//    }
    fun postUser2(code: String,
                 number: String,
                 password: String){
        mRepository.postUserToServer2(code, number, password)?.subscribe ({
            liveDataItem.value = it
        },{
            Log.e("-----Error", "-----------")
        })
    }
    fun getUse(): User{
        return mRepository.getUserFromDb()
    }
}
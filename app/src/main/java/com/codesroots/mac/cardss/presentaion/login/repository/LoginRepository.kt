package com.codesroots.hossam.mandoobapp.presentation.login.repository


import androidx.lifecycle.MutableLiveData
import com.codesroots.mac.cardss.models.LogData
import com.codesroots.mac.firstkotlon.DataLayer.ApiService.APIServices
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginRepository {





    fun Login(username:String,password:String,livedata: MutableLiveData<LogData>?) {

        APIServices.create().Login(username,password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { data -> data }
            .subscribe(
                { books ->
                    livedata?.postValue(books)
                },
                { error ->

                }
            )
    }



}

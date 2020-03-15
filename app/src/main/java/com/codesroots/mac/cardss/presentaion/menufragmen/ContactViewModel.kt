package com.codesroots.mac.cardss.presentaion.menufragmen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codesroots.mac.cardss.models.PartnersModel
import com.codesroots.mac.cardss.models.Terms
import com.codesroots.mac.firstkotlon.DataLayer.Repo.DataRepo


import io.reactivex.disposables.CompositeDisposable

class ContactViewModel() : ViewModel() {

    var contactMutableLiveData = MutableLiveData<Terms>()
    var PartnersMutableLiveData = MutableLiveData<List<PartnersModel>>()

    var error = MutableLiveData<Throwable>()
    var DateRepoCompnay: DataRepo = DataRepo()

    private val mCompositeDisposable = CompositeDisposable()
//
    init {
    contactMutableLiveData = MutableLiveData()
    PartnersMutableLiveData = MutableLiveData()

}


     fun getTermsData() {
        DateRepoCompnay.GetTermsData(contactMutableLiveData)
    }

    fun getContactData() {
        DateRepoCompnay.GetContactData(contactMutableLiveData)
    }
    fun getPartnersData() {
        DateRepoCompnay.GetPartnersData(PartnersMutableLiveData)
    }
    override fun onCleared() {
        super.onCleared()
        mCompositeDisposable.clear()
    }
}

package com.codesroots.mac.cardss.presentaion.mainfragment.viewmodel

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.codesroots.mac.cardss.models.*
import com.codesroots.mac.firstkotlon.DataLayer.Repo.DataRepo

import io.reactivex.disposables.CompositeDisposable

@BindingAdapter("app:imageResource")
fun setImageResource(imageView: AppCompatImageView, resource: String?) {
    Glide.with(imageView.context).load("https://device-smart-iq.com/"+resource).into(imageView)
}
@BindingAdapter("app:imageResourcee")
fun setImageResourcee(imageView: AppCompatImageView, resource: String?) {
    Glide.with(imageView.context).load(resource).into(imageView)
}
class MainViewModel : ViewModel() {

    var DateRepoCompnay: DataRepo = DataRepo()
     var mCompositeDisposable = CompositeDisposable()

    var CompanyResponseLD : MutableLiveData<List<CompanyDatum>>? = null
    var MyBalanceResponseLD : MutableLiveData<MyBalance>? = null
    var SliderDataResponseLD : MutableLiveData<List<SliderElement>>? = null

    var BuyPackageResponseLD : MutableLiveData<Buypackge>? = null
    var ReportDailyResponseLD : MutableLiveData<List<ReportDaily>>? = null
    var ReportHistroyResponseLD : MutableLiveData<List<ReportDaily>>? = null

    init {
        CompanyResponseLD = MutableLiveData()
        BuyPackageResponseLD = MutableLiveData()
        MyBalanceResponseLD = MutableLiveData()
        SliderDataResponseLD = MutableLiveData()
        ReportDailyResponseLD = MutableLiveData()
        ReportHistroyResponseLD = MutableLiveData()
        mCompositeDisposable  = CompositeDisposable()
    }


    fun getMyBalance(){
        DateRepoCompnay.GetMyBalance(MyBalanceResponseLD)
    }

    fun getcompanyData(){
        DateRepoCompnay.GetData(CompanyResponseLD)
                    }

    fun getPackageDetails(id:String){
        DateRepoCompnay.GetPackageDetails(id,CompanyResponseLD)
    }


    fun BuyPackage(id:String,auth:String,amount:String){

        DateRepoCompnay.BuyPackage(id,auth,amount,BuyPackageResponseLD,mCompositeDisposable)

    }
    fun PrintReport(oopo:String,auth:String){
        DateRepoCompnay.PrintReport(oopo,auth,BuyPackageResponseLD)
    }
    fun GetMyDeialyReport(auth:String){
        DateRepoCompnay.GetMyDeialyReport(auth,ReportDailyResponseLD)
    }
    fun GetMyDatesReport(auth:String,from:String,to:String){
        DateRepoCompnay.GetMyMonthReport(auth,from,to,ReportDailyResponseLD)
    }
    fun GetMyImages(auth:String){
        DateRepoCompnay.GetMyImages(auth,SliderDataResponseLD)
    }

    override fun onCleared() {
        super.onCleared()
        mCompositeDisposable.dispose()
        mCompositeDisposable.clear()

    }
}
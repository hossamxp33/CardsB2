package com.codesroots.mac.cards.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue


@Parcelize
data class Buypackge (
    val opno: String? = null,
    val salor: String? = null,
    val time: String? = null,
    val device: String? = null,
    val name: String? = null,
    val src: String? = null,
    val price: String? = null,
    val notes: String? = null,
    val count: String? = null,
    val err: String? = null,
val notesimg :String? = null,
    val pencode:List<Pencode>? = null
):Parcelable {

}

data class LogData(
    val auth: String,
    val err: Int

)
data class MyBalance (
    val account: String? = null,
    val commession: String? = null
)
data class ReportDaily (
    val opid: Long,
    val opno: String,
    val opdate: String,
    val strcase: String,
    val amount: String,
    val err: String? = null

    )
@Parcelize

data class Pencode (
    val pencode: String? = null,
    val expdate: String? = null,
    var serial:String? = null

    ):Parcelable {

}

data class Terms (
    val headline: String,
    val details: String,
    val mobile: String,
    val email: String,
    val fb: String
)
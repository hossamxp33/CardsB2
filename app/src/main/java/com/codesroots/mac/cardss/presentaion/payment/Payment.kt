package com.codesroots.mac.cardss.presentaion.payment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.codesroots.mac.cardss.R
import com.codesroots.mac.cardss.databinding.ActivityPaymentBinding
import com.codesroots.mac.cardss.models.Buypackge

import kotlinx.android.synthetic.main.activity_payment.*


class Payment : AppCompatActivity() {


    var dataa: Buypackge? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        val binding = DataBindingUtil.setContentView<ActivityPaymentBinding>(this, R.layout.activity_payment)

        var extras = intent.extras
        val value = extras!!.getParcelable<Buypackge>("myobj")



        if (!value!!.pencode.isNullOrEmpty()) {

            value!!.pencode!!.forEach {

                secret.append(it.pencode)
                secret.append("\n")
                secret.text.toString()


                fatoravalue.append(it.serial)
                fatoravalue.append("\n")
                fatoravalue.text.toString()

            }

        }



        binding.buy = value
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
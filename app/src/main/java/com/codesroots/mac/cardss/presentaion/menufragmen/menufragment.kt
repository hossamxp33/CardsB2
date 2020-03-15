package com.codesroots.mac.cardss.presentaion.menufragmen

import android.content.Intent
import com.codesroots.mac.cardss.R
import com.codesroots.mac.cardss.presentaion.MainActivity
import com.codesroots.mac.cardss.presentaion.login.LoginActivity
import kotlinx.android.synthetic.main.menu_fragment.view.*


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.codesroots.mac.cardss.DataLayer.helper.PreferenceHelper
import com.codesroots.mac.cardss.DataLayer.usecases.checkUserLogin


class MenuFragment : Fragment() {

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,  savedInstanceState: Bundle? ): View? {

        val view= inflater.inflate(R.layout.menu_fragment, container, false)

//        view.login.setOnClickListener {
//            val homeIntent = Intent(context, LoginActivity::class.java)
//            ( context as MainActivity).startActivity(homeIntent)
//        }
        view.partners.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_frame,Partners())?.addToBackStack("login")?.commit()
        }
//
        view.profile.setOnClickListener {
            if (checkUserLogin(context!!))
                activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_frame,ContactFragment())?.addToBackStack("login")?.commit()
        }
//
        view.favoffers.setOnClickListener {
            if (checkUserLogin(context!!))
                activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_frame,TermsFragment())?.addToBackStack(null)?.commit()
        }

        view.logout.setOnClickListener {
            if (checkUserLogin(context!!)) {
                PreferenceHelper.setToken("",context)
                Toast.makeText(context, "تم تسجيل خروجك", Toast.LENGTH_SHORT).show()

                val homeIntent = Intent(context, LoginActivity::class.java)
                ( context as MainActivity).startActivity(homeIntent)
            }
        }

        return view
    }

}

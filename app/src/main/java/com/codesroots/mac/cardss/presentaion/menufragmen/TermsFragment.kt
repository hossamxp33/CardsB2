package com.codesroots.mac.cardss.presentaion.menufragmen

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.codesroots.mac.cardss.R
import kotlinx.android.synthetic.main.contact_fragment.*

class TermsFragment : Fragment() {


    lateinit var contactViewModel: ContactViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.terms_layout, container, false)


        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contactViewModel =
            ViewModelProviders.of(this).get(ContactViewModel::class.java)
//
        contactViewModel.getTermsData()
        contactViewModel.contactMutableLiveData?.observe(this , Observer {
            phone2.text = it.details
            phone2.setMovementMethod(ScrollingMovementMethod());
        })
//
//        contactViewModel.error.observe(
//            this,
//            { throwable ->
//                Toast.makeText(
//                    activity,
//                    getText(R.string.erroroccure),
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//        )
    }


}
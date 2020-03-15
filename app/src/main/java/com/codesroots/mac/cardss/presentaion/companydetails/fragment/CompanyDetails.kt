package com.codesroots.mac.cardss.presentaion.companydetails.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.codesroots.mac.cardss.R
import com.codesroots.mac.cardss.presentaion.IPosPrinterTestDemo

import com.codesroots.mac.cardss.presentaion.mainfragment.viewmodel.MainViewModel
import com.codesroots.mac.cardss.presentaion.reportsFragment.adapters.CompanyDetailsAdapter
import kotlinx.android.synthetic.main.company_details.view.*


class CompanyDetails  : Fragment() {

    lateinit var MainAdapter: CompanyDetailsAdapter
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.company_details, container, false)
        viewModel = ViewModelProviders.of(this).get(
            MainViewModel::
            class.java
        )
        if (arguments != null) {
            IPosPrinterTestDemo.getInstance().connectPrinterService(context)
            val packageId = arguments?.getString("packageId")
            viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
            viewModel.getPackageDetails(packageId!!)
            viewModel.CompanyResponseLD?.observe(this, Observer {


                MainAdapter = CompanyDetailsAdapter(viewModel, context, it)
                view.recyler.layoutManager = LinearLayoutManager(context)
                view.recyler.adapter = MainAdapter;

            })

        }
        return  view
    }

}
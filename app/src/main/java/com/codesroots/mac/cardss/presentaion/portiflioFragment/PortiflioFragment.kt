package com.codesroots.mac.cardss.presentaion.portiflioFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.codesroots.mac.cardss.R
import com.codesroots.mac.cardss.db.CardDatabase
import com.codesroots.mac.cardss.models.Buypackge
import com.codesroots.mac.cardss.presentaion.mainfragment.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.portiflio_fragment.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PortiflioFragment : Fragment() {
    lateinit var Adapterr : portifolioAdapter
    lateinit var viewModel: MainViewModel
    val card: Buypackge? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {

        val view= inflater.inflate(R.layout.portiflio_fragment, container, false)

        view.recycle_portiflio.layoutManager = LinearLayoutManager(activity!!.applicationContext);
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        fetchdata(view)

        return view

    }


    private   fun fetchdata(view: View) {
        GlobalScope.launch {
            activity!!.applicationContext.let {

                val db = Room.databaseBuilder(
                    activity!!.applicationContext,
                    CardDatabase::class.java, "card-database"
                ).build()
                var data =   db.getCardDao().GetAllData()
                println(data)
                Thread {
                    activity!!.runOnUiThread {
                        view.recycle_portiflio.adapter = portifolioAdapter(viewModel,context,data)
                    }
                }.start()
            }

        }
    }



}

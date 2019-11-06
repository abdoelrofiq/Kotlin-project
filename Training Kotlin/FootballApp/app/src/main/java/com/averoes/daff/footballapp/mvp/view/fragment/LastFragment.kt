package com.averoes.daff.footballapp.mvp.view.fragment


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.averoes.daff.footballapp.R
import com.averoes.daff.footballapp.adapter.MyAdapter
import com.averoes.daff.footballapp.mvp.model.EventsItem
import com.averoes.daff.footballapp.mvp.presenter.MainPresenter
import com.averoes.daff.footballapp.mvp.view.MainView
import com.averoes.daff.footballapp.mvp.view.activity.DetailActivity
import kotlinx.android.synthetic.main.fragment_match.*
import kotlinx.android.synthetic.main.fragment_match.view.*
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class LastFragment : Fragment(), MainView {


    var mainpresenter: MainPresenter? = null

    val liga: MutableList<EventsItem> = mutableListOf()
    var IdLiga: Int = 4335
    var listLigaAdapter: MyAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_match, container, false)
        v.listfootball.layoutManager = LinearLayoutManager(activity)
        return v

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainpresenter = MainPresenter(this)
        mainpresenter!!.getLastMatch(IdLiga)
        listLigaAdapter = MyAdapter(liga) {

            startActivity(Intent(context, DetailActivity::class.java))
        }

        listfootball.adapter = listLigaAdapter


    }

    override fun showLoading() {

        progress.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress.visibility = View.GONE

    }

    override fun showMessage(isiPesan: String) {
        toast(isiPesan)
    }

    override fun showListItem(listItem: List<EventsItem>?) {

        liga.clear()
        if (listItem!= null){
            liga.addAll(listItem)
        }else{
            toast("Nothing Data")
        }
        listLigaAdapter?.notifyDataSetChanged()
    }

    override fun errorMessage(pesanError: String) {

        toast(pesanError)
    }


}

package com.averoes.daff.footballapp.mvp.view

import com.averoes.daff.footballapp.mvp.model.EventsItem

/**
 * Created by daff on 19/03/19 at 11:13.
 */
interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showMessage(isiPesan: String)
    fun showListItem(listItem: List<EventsItem>?)
    fun errorMessage(pesanError : String)
}
package com.averoes.daff.prayertime.view

import com.averoes.daff.prayertime.model.Data

/**
 * Created by daff on 20/03/19 at 6:51.
 */
interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showMessage(isiPesan: String)
    fun showListItem(listItem: Data?)
    fun errorMessage(pesanError : String)
}
package com.averoes.daff.notedailyapp

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.averoes.daff.notedailyapp.model.ResponseInsert
import com.averoes.daff.notedailyapp.model.ResultItem
import com.averoes.daff.notedailyapp.network.RetrofigConfig
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progress = ProgressDialog(this)
        progress.setMessage("Loading..")
        progress.show()

        val request = RetrofigConfig().getInstance()

        request.getNote().enqueue(object : Callback<ResponseInsert> {
            override fun onFailure(call: Call<ResponseInsert>, t: Throwable) {
                Log.e("Response", "Failure")
                Toast.makeText(this@MainActivity, "Response Failed", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<ResponseInsert>, response: Response<ResponseInsert>) {

                progress.dismiss()

                Log.d("Response", "Succes")

                showData(response.body()!!.result)
            }
        })
    }

    fun showData(data : List<ResultItem?>?){
        recycler.adapter = MyAdapter(this, data)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.setHasFixedSize(true)
    }
}

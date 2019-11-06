package com.averoes.daff.notedailyapp

import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.averoes.daff.notedailyapp.model.ResponseInsert
import com.averoes.daff.notedailyapp.network.ApiService
import com.averoes.daff.notedailyapp.network.RetrofigConfig
import kotlinx.android.synthetic.main.activity_add_note.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class AddNote : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        val date = Calendar.getInstance()
        val year = date.get(Calendar.YEAR)
        val month = date.get(Calendar.MONTH)
        val day = date.get(Calendar.DAY_OF_WEEK)


        img_date.setOnClickListener {
            val datePicker =
                DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                    input_date.setText("" + dayOfMonth + "-" + (monthOfYear + 1) + "-" + year).toString()

                }, year, month, day)

            datePicker.show()
        }

        btn_add.setOnClickListener {
            addNote(input_date = input_date, input_title = input_title, input_note = input_note)
        }
    }



    private fun addNote(input_date: EditText, input_title : EditText, input_note : EditText){

        val progres = ProgressDialog(this@AddNote)
        progres.show()

        val request: ApiService = RetrofigConfig().getInstance()

        val response : Call<ResponseInsert> = request.tambahNote(date = input_date.text.toString(),
                                                                title = input_title.text.toString(),
                                                                note = input_note.text.toString())

        response.enqueue(object : Callback<ResponseInsert>{
            override fun onFailure(call: Call<ResponseInsert>, t: Throwable) {
                Log.e("Response", "Failure")
                Toast.makeText(this@AddNote, "Response Failed",Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<ResponseInsert>, response: Response<ResponseInsert>) {
               // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

                Log.d("response",response.message())
                Toast.makeText(this@AddNote, "Response Succes", Toast.LENGTH_SHORT).show()

                var result = response.body()?.result
                if (result!!.equals("true")){
                    startActivity(Intent(this@AddNote, MainActivity::class.java))

                 //   Toast.makeText(this@AddNote, result, Toast.LENGTH_SHORT).show()
                }else{
                  //  Toast.makeText(this@AddNote, result, Toast.LENGTH_SHORT).show()

                }
            }

        })

    }
}

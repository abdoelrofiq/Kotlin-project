package com.averoes.daff.dailynote

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.averoes.daff.dailynote.model.Daily
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_daily.*
import java.text.SimpleDateFormat
import java.util.*

class DailyActivity : AppCompatActivity() {

    val saveData = FirebaseDatabase.getInstance().getReference("daily")

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily)


        dataNote()

        val date = Calendar.getInstance()
        val year = date.get(Calendar.YEAR)
        val month = date.get(Calendar.MONTH)
        val day = date.get(Calendar.DAY_OF_WEEK)


        img_date.setOnClickListener {
            val datePicker =
                DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                    date_picker.setText("$dayOfMonth-${monthOfYear+1}-$year").toString()

                }, year, month, day)

            datePicker.show()
        }

        btn_save.setOnClickListener {

            val myDailyNote = Daily(title = title_daily.text.toString(),
                                    note = note_daily.text.toString(),
                                    date = date_picker.text.toString(), firebaseKey = date_picker.text.toString())
            saveData.push().setValue(myDailyNote.myNote)

            Toast.makeText(this, "Data has been Saved", Toast.LENGTH_LONG).show()
            title_daily.setText("")
            note_daily.setText("")
            date_picker.setText("")

            startActivity(Intent(this, MainActivity::class.java))
        }

        btn_showList.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }


    }

    fun dataNote(){

        val intent = intent
        intent.getStringExtra(DATE)
        intent.getStringExtra(TITLE)
        intent.getStringExtra(NOTE)
    }

    companion object {
        val DATE = "date"
        val TITLE = "title"
        val NOTE = "note"
    }

}


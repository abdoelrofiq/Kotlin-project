package com.averoes.daff.firebaseapp.database

import android.app.DatePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.averoes.daff.firebaseapp.R
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_daily.*
import java.util.*

class DailyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily)

        val saveData = FirebaseDatabase.getInstance().getReference("daily")

        val date = Calendar.getInstance()
        val year = date.get(Calendar.YEAR)
        val month = date.get(Calendar.MONTH)
        val day = date.get(Calendar.DAY_OF_WEEK)

        img_date.setOnClickListener {
            val datePicker =
                DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                    date_picker.setText("" + dayOfMonth + "-" + monthOfYear + "-" + year)
                }, year, month, day)

            datePicker.show()
        }

        btn_save.setOnClickListener {
            val title = title_daily.text.toString().trim()
            val note = note_daily.text.toString()


            val key = saveData.push().key
            val d = Daily(date = date_picker.toString(), title = title, note = note)

            if (key != null) {
                saveData.child(key).setValue(d).addOnCompleteListener {

                    Toast.makeText(this, "Data has been Saved", Toast.LENGTH_LONG).show()
                    title_daily.setText("")
                    note_daily.setText("")

                }
            }
        }


    }
}


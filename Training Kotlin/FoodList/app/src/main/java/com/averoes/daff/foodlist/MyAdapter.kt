package com.averoes.daff.foodlist

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.list_item.view.*
import java.util.ArrayList

/**
 * Created by daff on 18/03/19 at 14:25.
 */
class MyAdapter(val context: Context, val foodList: ArrayList<FoodItem> = ArrayList()) : BaseAdapter() {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
       val food = foodList[position]
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.list_item, null )

        view.ivFoodImage.setImageResource(food.image)
        view.ivFoodImage.setOnClickListener {

            val intent = Intent(context, FoodDetail::class.java)
            intent.putExtra("name", food.name)
            intent.putExtra("desc", food.desx)
            intent.putExtra("image", food.image)
            context.startActivity(intent)
        }
        view.tvName.text = food.name
        return view

    }

    override fun getItem(position: Int): Any {

        return foodList[position]
    }

    override fun getItemId(position: Int): Long {

        return position.toLong()
    }

    override fun getCount(): Int {

        return foodList.size
    }
}
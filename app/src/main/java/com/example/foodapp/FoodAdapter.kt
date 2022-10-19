package com.example.foodapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(private val context: Context, private var list: List<Food>,
                  var onFoodClickListener: OnFoodClickListener):
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val itemView = LayoutInflater.from(context)
            .inflate(R.layout.food, parent, false)

        return FoodViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class FoodViewHolder: RecyclerView.ViewHolder, View.OnClickListener {

        constructor(itemView: View) : super(itemView) {
            itemView.setOnClickListener(this)
        }

        fun bind(food: Food) {
            (itemView.findViewById<ImageView>(R.id.ivPicture)).setImageResource(food.id)
            (itemView.findViewById<TextView>(R.id.tvName)).text = food.name
        }

        override fun onClick(view: View?) {
            onFoodClickListener.onFoodClicked(list[adapterPosition])
        }

    }

    interface OnFoodClickListener {
        fun onFoodClicked(food: Food)
    }

}
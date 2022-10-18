package com.example.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_FOOD = "extra_food"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val food = intent.getSerializableExtra(EXTRA_FOOD) as Food

        var iv = findViewById<ImageView>(R.id.ivPicture)
        iv.setImageResource(food.id)

        var tv1 = findViewById<TextView>(R.id.tvName)
        tv1.text = food.name

        var tv2 = findViewById<TextView>(R.id.tvRecipe)
        tv2.text = food.recipe
    }
}


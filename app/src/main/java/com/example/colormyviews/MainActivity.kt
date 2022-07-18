package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun makeColored(view: View) {
        val rnd = Random()
        val color = Color.argb(255,
            rnd.nextInt(256),
            rnd.nextInt(256),
            rnd.nextInt(256))

        when (view.id) {
            R.id.box_one_text -> view.setBackgroundColor(color)
            R.id.box_two_text -> view.setBackgroundColor(color)
            R.id.box_three_text -> view.setBackgroundColor(color)
            R.id.box_four_text -> view.setBackgroundColor(color)
            R.id.box_five_text -> view.setBackgroundColor(color)
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    private fun setListeners() {
        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)

        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)

        val redButton = findViewById<Button>(R.id.red_button)
        val greenButton = findViewById<Button>(R.id.green_button)
        val yellowButton = findViewById<Button>(R.id.yellow_button)

        val clickableViews = listOf<View>(
            boxOneText, boxTwoText, boxThreeText,
            boxFourText, boxFiveText, rootConstraintLayout
        )

        val buttons = listOf<Button>(redButton, greenButton, yellowButton)

        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }

        for (item in buttons) {
            item.setOnClickListener {
                when (it.id) {
                    R.id.red_button -> for (view in clickableViews - rootConstraintLayout) {
                        view.setBackgroundResource(R.color.my_red)
                    }
                    R.id.yellow_button -> for (view in clickableViews - rootConstraintLayout) {
                        view.setBackgroundResource(R.color.my_yellow)
                    }
                    else -> for (view in clickableViews - rootConstraintLayout) {
                        view.setBackgroundResource(R.color.my_green)
                    }
                }
            }
        }
    }
}
package com.konatsup.excountapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var keywords: List<String> = listOf("apple", "banana", "cat", "dog")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var number: Int = 0
        numberTextView.text = "0"
        keywordTextView.text = keywords[number]

        plusButton.setOnClickListener {
            number += 1
            updateText(number)
        }

        minusButton.setOnClickListener {
            number -= 1
            updateText(number)
        }

        clearButton.setOnClickListener {
            number = 0
            updateText(number)
        }
    }

    fun updateText(resultNumber: Int) {
        numberTextView.text = resultNumber.toString()

        if (resultNumber >= 0 && resultNumber < keywords.size) {
            keywordTextView.text = keywords[resultNumber]
        } else {
            keywordTextView.text = "その番号のキーワードは存在しません"
        }

        when {
            resultNumber % 15 == 0 -> numberTextView.setTextColor(Color.RED)
            resultNumber % 3 == 0 -> numberTextView.setTextColor(Color.GREEN)
            resultNumber % 5 == 0 -> numberTextView.setTextColor(Color.BLUE)
            else -> numberTextView.setTextColor(Color.BLACK)
        }
    }

}

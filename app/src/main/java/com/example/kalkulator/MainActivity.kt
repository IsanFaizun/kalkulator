package com.example.kalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var txt_first: TextView
    private lateinit var txt_second: TextView
    private lateinit var operator: TextView
    private lateinit var the_result: TextView

    private var firstNum = 0
    private var secondNum = 0
    private var operatorNow = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt_first = findViewById(R.id.txt_first)
        txt_second = findViewById(R.id.txt_second)
        operator = findViewById(R.id.operator)
        the_result = findViewById(R.id.res)
    }

    fun numClick(view: View) {
        val btn = view as Button
        val num = btn.text.toString()
        if (operatorNow.isEmpty()){
            firstNum = firstNum * 10 + num.toInt()
            txt_first.text = firstNum.toString()
        } else {
            secondNum = secondNum * 10 + num.toInt()
            txt_second.text = secondNum.toString()
        }
    }

    fun oprClick(view: View) {
        val btn = view as Button
        operatorNow = btn.text.toString()
        operator.text = operatorNow
    }

    fun equalClick(view: View) {
        var equal = 0.0
        var num1 = firstNum.toDouble()
        var num2 = secondNum.toDouble()
        when (operatorNow) {
            "+" -> equal = num1 + num2
            "-" -> equal = num1 - num2
            "×" -> equal = num1 * num2
            "÷" -> {
                if (num2 != 0.0) {
                    equal = num1 / num2
                }
            }
        }
        if (equal % 1 == 0.0) {
            val intResult = equal.toInt()
            the_result.text = intResult.toString()
        } else {
            val decimalFormat = DecimalFormat("#." + "#".repeat(100))
            the_result.text = decimalFormat.format(equal)
        }
    }

    fun clearNumber(view: View) {
        firstNum = 0
        secondNum = 0
        operatorNow = ""
        txt_first.text = ""
        txt_second.text = ""
        operator.text = ""
        the_result.text = ""
    }
}
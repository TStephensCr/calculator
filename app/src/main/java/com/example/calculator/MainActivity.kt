package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvInput: TextView
    private lateinit var btnOne: Button
    private lateinit var btnTwo: Button
    private lateinit var btnThree: Button
    private lateinit var btnFour: Button
    private lateinit var btnFive: Button
    private lateinit var btnSix: Button
    private lateinit var btnSeven: Button
    private lateinit var btnEight: Button
    private lateinit var btnNine: Button
    private lateinit var btnAC: Button
    private lateinit var btnC: Button
    private lateinit var btnBackspace: Button
    private lateinit var btnDivide: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnAdd: Button
    private lateinit var btnSubtract: Button
    private lateinit var btnDot: Button
    private lateinit var btnZero: Button
    private lateinit var btnEqual: Button

    private var currentInput = StringBuilder()
    private var currentOperator: String = ""
    private var firstNum: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //element variables
        val tvInput = findViewById<TextView>(R.id.tvInput)
        val btnOne = findViewById<Button>(R.id.btnOne)
        val btnTwo = findViewById<Button>(R.id.btnTwo)
        val btnThree = findViewById<Button>(R.id.btnThree)
        val btnFour = findViewById<Button>(R.id.btnFour)
        val btnFive = findViewById<Button>(R.id.btnFive)
        val btnSix = findViewById<Button>(R.id.btnSix)
        val btnSeven = findViewById<Button>(R.id.btnSeven)
        val btnEight = findViewById<Button>(R.id.btnEight)
        val btnNine = findViewById<Button>(R.id.btnNine)
        val btnAC = findViewById<Button>(R.id.allClear)
        val btnC = findViewById<Button>(R.id.clear)
        val btnBackspace = findViewById<ImageButton>(R.id.btnBackspace)
        val btnDivide = findViewById<Button>(R.id.btnDivide)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSubtract = findViewById<Button>(R.id.btnSubtract)
        val btnDot = findViewById<Button>(R.id.btnDot)
        val btnZero = findViewById<Button>(R.id.btnZero)
        val btnEqual = findViewById<Button>(R.id.btnEqual)

        currentInput = StringBuilder()
    }

    private fun appendNumber(number: String) {
        currentInput.append(number)
        updateDisplay()
    }

    // Function to set the current operator
    private fun setOperator(operator: String) {//save first variable, empty currentInput
        currentOperator = operator
        firstNum = currentInput.toString().toDouble()
        currentInput = StringBuilder()
        updateDisplay()
    }

    // Function to calculate results
    private fun calculateResult() {//save second variable
        val secondNum: Double = currentInput.toString().toDouble()
        val result: Double? = when(currentOperator){
            "+" -> firstNum + secondNum
            "-" -> firstNum - secondNum
            "×" -> firstNum * secondNum
            "÷" -> firstNum / secondNum
            else -> null
        }

        updateDisplay()
    }

    // Function to clear input
    private fun clearInput() {
        // Implement logic to clear the input and reset the display
    }

    // Function to clear input
    private fun allClearInput() {
        // Implement logic to clear the input and reset the display
    }

    // Function to update the display
    private fun updateDisplay() {
        tvInput.text = currentInput.toString()
    }
}


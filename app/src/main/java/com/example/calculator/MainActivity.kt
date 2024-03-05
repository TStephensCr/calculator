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
    private lateinit var btnBackspace: ImageButton
    private lateinit var btnDivide: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnAdd: Button
    private lateinit var btnSubtract: Button
    private lateinit var btnDot: Button
    private lateinit var btnZero: Button
    private lateinit var btnEqual: Button

    private var currentInput = StringBuilder()
    private var currentOperator: String = ""
    private var firstNum: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //element variables
        tvInput = findViewById<TextView>(R.id.tvInput)
        btnOne = findViewById<Button>(R.id.btnOne)
        btnTwo = findViewById<Button>(R.id.btnTwo)
        btnThree = findViewById<Button>(R.id.btnThree)
        btnFour = findViewById<Button>(R.id.btnFour)
        btnFive = findViewById<Button>(R.id.btnFive)
        btnSix = findViewById<Button>(R.id.btnSix)
        btnSeven = findViewById<Button>(R.id.btnSeven)
        btnEight = findViewById<Button>(R.id.btnEight)
        btnNine = findViewById<Button>(R.id.btnNine)
        btnAC = findViewById<Button>(R.id.allClear)
        btnC = findViewById<Button>(R.id.clear)
        btnBackspace = findViewById<ImageButton>(R.id.btnBackspace)
        btnDivide = findViewById<Button>(R.id.btnDivide)
        btnMultiply = findViewById<Button>(R.id.btnMultiply)
        btnAdd = findViewById<Button>(R.id.btnAdd)
        btnSubtract = findViewById<Button>(R.id.btnSubtract)
        btnDot = findViewById<Button>(R.id.btnDot)
        btnZero = findViewById<Button>(R.id.btnZero)
        btnEqual = findViewById<Button>(R.id.btnEqual)

        currentInput = StringBuilder()

        btnOne.setOnClickListener { appendNumber("1") }
        btnTwo.setOnClickListener { appendNumber("2") }
        btnThree.setOnClickListener { appendNumber("3") }
        btnFour.setOnClickListener { appendNumber("4") }
        btnFive.setOnClickListener { appendNumber("5") }
        btnSix.setOnClickListener { appendNumber("6") }
        btnSeven.setOnClickListener { appendNumber("7") }
        btnEight.setOnClickListener { appendNumber("8") }
        btnNine.setOnClickListener { appendNumber("9") }
        btnZero.setOnClickListener { appendNumber("0") }

        // Operator buttons
        btnAdd.setOnClickListener { setOperator("+") }
        btnSubtract.setOnClickListener { setOperator("-") }
        btnMultiply.setOnClickListener { setOperator("×") }
        btnDivide.setOnClickListener { setOperator("÷") }

        // Other buttons
        btnEqual.setOnClickListener { calculateResult() }
        btnC.setOnClickListener { clearInput() }
        btnAC.setOnClickListener { allClearInput() }
        btnBackspace.setOnClickListener { deleteCharacter() }
        btnDot.setOnClickListener { appendNumber(".") }
    }

    private fun appendNumber(number: String) {
        if(currentOperator == "" && currentInput.isEmpty())
            firstNum = null
        currentInput.append(number)
        updateDisplay()
    }

    // Function to set the current operator
    private fun setOperator(operator: String) {//problema quando fai num + num + num
        if(currentInput.isEmpty())
            if(operator == "-") {appendNumber("-"); return}
        if(firstNum == null){
            if(currentInput.isEmpty()) return
            firstNum = currentInput.toString().toDouble()
            currentInput.clear()
            currentOperator = operator
        }else{
            if(currentInput.isEmpty()) currentOperator = operator
            else {
                if(currentOperator == "")
                    currentOperator = operator
                calculateResult()
                currentOperator = operator
            }
        }
        updateDisplay()
    }

    // Function to calculate results
    private fun calculateResult() {//save second variable
        if(currentOperator == "") return
        val secondNum: Double = currentInput.toString().toDouble()
        val result: Double? = when(currentOperator){
            "+" -> firstNum?.plus(secondNum)
            "-" -> firstNum?.minus(secondNum)
            "×" -> firstNum?.times(secondNum)
            "÷" -> firstNum?.div(secondNum)
            else -> null
        }
        val formattedResult = String.format("%.12f", result).trimEnd('0').trimEnd('.')
        tvInput.text = formattedResult
        currentInput = StringBuilder(formattedResult)
        updateDisplay()
        firstNum = currentInput.toString().toDouble()
        currentInput.clear()
        currentOperator = ""
    }

    // Function to clear input
    private fun clearInput() {
        currentInput.clear()
        updateDisplay()
    }

    // Function to clear input
    private fun allClearInput() {
        firstNum = null
        currentInput.clear()
        currentOperator = ""
        updateDisplay()
    }

    // Function to update the display
    private fun updateDisplay() {
        tvInput.text = currentInput.toString()
    }

    private fun deleteCharacter(){
        if(currentInput.isEmpty()) return
        val length: Int = currentInput.lastIndex
        currentInput.deleteAt(length)
        updateDisplay()
    }
}


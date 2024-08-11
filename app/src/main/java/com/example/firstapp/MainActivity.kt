package com.example.firstapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var inputText: EditText
    private lateinit var result: TextView
    private lateinit var button: Button
    private lateinit var countText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        inputText = findViewById(R.id.editText)
        result = findViewById(R.id.result)
        button = findViewById(R.id.button)
        countText = findViewById(R.id.sizeTextResult)
        onButtonClick(button)
        onButtonClick(button)
    }

    fun onButtonClick(view: View) {
        result.text = inputText.text.toString().reversed()
        onInputText(button)
    }

    fun onInputText(view: View) {
        var count = 0
        for (letter in result.text) {
            if (letter != ' ' && letter != '\n' && letter != '\t') {
                count++
            }
        }
        countText.text = "Количество введенных символов: $count"
    }
}
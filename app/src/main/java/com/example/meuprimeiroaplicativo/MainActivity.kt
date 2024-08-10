package com.example.meuprimeiroaplicativo

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Random

class MainActivity : AppCompatActivity() {

    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText: EditText = findViewById(R.id.edit_Number)
        val txtResult: TextView = findViewById(R.id.txt_Result)
        val btnGenerate: Button = findViewById(R.id.btn_generation)

        prefs = getSharedPreferences("banco", Context.MODE_PRIVATE)
        val result = prefs.getString("result", null)

        if (result != null && result.isNotBlank()) {
            txtResult.text = "Última aposta: $result"
        }

        btnGenerate.setOnClickListener {
            val text = editText.text.toString()
            numberGenerator(text, txtResult)
        }
    }

    private fun numberGenerator(text: String, txtResult: TextView) {
        if (text.isNotEmpty()) {
            val qtd = text.toInt()

            if (qtd in 6..15) {
                val numbers = mutableSetOf<Int>()
                val random = Random()

                while (numbers.size < qtd) {
                   // numbers.add(random.nextInt(1, 61))
                    numbers.add(random.nextInt(60) + 1)
                }

                val sortedNumbers = numbers.sorted()
                val resultText = if (sortedNumbers.isNotEmpty()) {
                    sortedNumbers.joinToString(" - ")
                } else {
                    "Nenhum número gerado"
                }
                txtResult.text = resultText

                val editor = prefs.edit()
                editor.putString("result", resultText)
                val saved = editor.commit()
                Log.i("Teste", "Foi salvo: $saved, Números: ${sortedNumbers.joinToString()}")
            } else {
                Toast.makeText(this, "Informe um número entre 6 e 15", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "Informe um número entre 6 e 15", Toast.LENGTH_LONG).show()
        }
    }
}

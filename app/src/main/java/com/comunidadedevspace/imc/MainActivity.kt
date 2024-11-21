package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

const val KEY_IMC_RESULT = "ResultActivity.KEY_IMC"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtWeight = findViewById<TextInputEditText>(R.id.edt_weight)
        val edtHeight = findViewById<TextInputEditText>(R.id.edt_height)
        val btnCalculate = findViewById<Button>(R.id.btn_calculate)

        btnCalculate.setOnClickListener {
            val weightStr: String = edtWeight.text.toString()
            val heightStr: String = edtHeight.text.toString()
            if(weightStr.isEmpty() || heightStr.isEmpty()) {
                Snackbar.make(
                    edtHeight,
                    "Preencha todos os campos",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                val weight = weightStr.toFloat()
                val height = heightStr.toFloat()
                val imc = weight / (height * height)
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_IMC_RESULT, imc)
                startActivity(intent)
            }

        }
    }
}
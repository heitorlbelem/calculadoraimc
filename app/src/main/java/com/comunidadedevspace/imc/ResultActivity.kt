package com.comunidadedevspace.imc

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val imc = intent.getFloatExtra(KEY_IMC_RESULT, 0f)
        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassification = findViewById<TextView>(R.id.tv_classification)

        var classification: String? = null
        var classificationColor: Int? = null

        if(imc <= 18.5f) {
            classification = "MAGREZA"
            classificationColor = R.color.red
        } else if (imc <= 24.9f) {
            classification = "NORMAL"
            classificationColor = R.color.lime_green
        } else if (imc <= 29.9f) {
            classification = "SOBREPESO"
            classificationColor = R.color.gold
        } else if (imc <= 39.9f) {
            classification = "OBESIDADE"
            classificationColor = R.color.orange
        } else {
            classification = "OBESIDADE GRAVE"
            classificationColor = R.color.red
        }

        tvResult.text = imc.toString()
        tvClassification.text = classification
        tvClassification.setTextColor(ContextCompat.getColor(this, classificationColor))
    }
}
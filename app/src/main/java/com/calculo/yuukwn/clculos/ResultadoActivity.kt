package com.calculo.yuukwn.clculos

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.example.logonpf.imc.extension.format
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        if (intent != null) {
            val peso = intent.getStringExtra("PESO").toDouble()
            val altura = intent.getStringExtra("ALTURA").toDouble()

            val imc = peso / (altura * altura)

            tvResult.setText(imc.format(1))

            if (imc <= 18.5) {
                alteraImage(R.drawable.abaixo)
                tvStatus.text = "abaixo do peso"
            } else if (imc <= 24.9) {
                alteraImage(R.drawable.ideal)
                tvStatus.text = "Peso ideal"
            } else if (imc <= 29.9) {
                alteraImage(R.drawable.sobre)
                tvStatus.text = "Sobrepeso"
            } else if (imc <= 34.9) {
                alteraImage(R.drawable.obesidade)
                tvStatus.text = "obesidade I"
            } else if (imc <= 39.9) {
                alteraImage(R.drawable.obesidade)
                tvStatus.text = "Obesidade II (severa)"
            } else {
                alteraImage(R.drawable.obesidade)
                tvStatus.text = "Obesidade III (morbida)"

            }
        }
    }


    fun alteraImage(idImagem: Int) {
        ivStatus.setImageDrawable(ContextCompat.getDrawable(this, idImagem))
    }
}
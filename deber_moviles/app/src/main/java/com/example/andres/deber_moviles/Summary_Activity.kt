package com.example.andres.deber_moviles

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_summary_.*

class Summary_Activity : AppCompatActivity() {


    var rating =""
    var sumario =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary_)
        capturarDatos()
        rating_txt.text = "Has calificado esta App con: ${this.rating} estrellas"
        sumario_txt.text = this.sumario


    }

    fun capturarDatos(){
        this.rating = intent.getStringExtra("rating")
        this.sumario = intent.getStringExtra("info")
    }
}

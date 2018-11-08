package com.example.andres.movilesgr22018

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        boton_navegar.setOnClickListener{
            /*Log.i("navegacion","Hola")
            Log.w("navegacion","Hola")
            Log.d("navegacion","Hola")
            Log.e("navegacion","Hola")
            Log.v("navegacion","Hola")*/
            irAPantallaDeBotonoes()
        }


    }

    fun irAPantallaDeBotonoes(){
        // INTENT: ir de una pantalla a otra
        val intentIrABotones = Intent(this,ButtonActivity::class.java)
        this.startActivity(intentIrABotones)
    }
}

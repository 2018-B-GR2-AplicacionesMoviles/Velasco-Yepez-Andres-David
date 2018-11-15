package com.example.andres.movilesgr22018

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent_respuesta.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        boton_navegar.setOnClickListener{
           /* Log.i("navegacion","Hola")
            Log.w("navegacion","Hola")
            Log.d("navegacion","Hola")
            Log.e("navegacion","Hola")
            Log.v("navegacion","Hola")*/
            irAPantallaDeBotonoes()
        }

        boton_respuesta.setOnClickListener{
            irApantallaDeRespuesta()
        }



    }

    fun enviarRespuestaPropio(){

    }

    fun irApantallaDeRespuesta(){
        val intentIrRespuesta = Intent(this,IntentRespuestaActivity::class.java)
        this.startActivity(intentIrRespuesta)
    }

    fun irAPantallaDeBotonoes(){
        // INTENT: ir de una pantalla a otra
       val intentIrABotones = Intent(this,ButtonActivity::class.java)
        // Parametros para ser enviados
        intentIrABotones.putExtra("nombre","Andres")// Parceleable sirve para serializar informacion siempre cuando ese tipo de dato no existe para otro proceso
        intentIrABotones.putExtra("apellido","Velasco")
        /*val intentIrABotones = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, 'A')
            putExtra(AlarmClock.EXTRA_HOUR, 15)
            putExtra(AlarmClock.EXTRA_MINUTES, 16)
        }*/
        this.startActivity(intentIrABotones)
    }
}

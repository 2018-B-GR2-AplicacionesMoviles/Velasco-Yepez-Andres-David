package com.example.usrdel.a2018movilesgr2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boton_navegar
                .setOnClickListener {
                    /*
                    Log.i("navegacion","Hola")
                    Log.w("navegacion","Hola")
                    Log.d("navegacion","Hola")
                    Log.e("navegacion","Hola")
                    Log.v("navegacion","Hola")
                    */
                    this.irAPantallaDeBotones()
                }
        button_intent_respuesta
                .setOnClickListener {
                    this.irAPantallaDeIntentRespuesta()
                }

        button_ciclo_vida
                .setOnClickListener {
                    this.irAPantallaCicloVida()
                }
        button_intent_parcelable
                .setOnClickListener{
                    this.irActividadIntent()
                }
        button_adaptador
                .setOnClickListener{
                    this.irActividadAdaptador()
                }
    }

    fun irActividadAdaptador(){
        val intentActividad = Intent(
                this,
                AdaptadorActivity::class.java
        )
        this.startActivity(intentActividad)
    }
    fun irActividadIntent(){
        val intentActividad = Intent(
                this,
                ParcelableActivity::class.java
        )

        val adrian = Usuario("Andrian",29, Date(1989,6,10),12.00)
        val cachetes = Mascota("cachetes",adrian)
        intentActividad.putExtra("usuario",adrian)
        intentActividad.putExtra("mascota",cachetes)
        this.startActivity(intentActividad)
    }
    fun irAPantallaCicloVida() {
        val intentCicloVida = Intent(
                this,
                CicloVidaActivity::class.java
        )
        this.startActivity(intentCicloVida)
    }


    fun irAPantallaDeBotones() {
        // INTENT
        val intentIrABotones = Intent(this, ButtonActivity::class.java)
        intentIrABotones.putExtra("nombre", "Adrian")
        intentIrABotones.putExtra("apellido", "Eguez")
        this.startActivity(intentIrABotones)
    }

    fun irAPantallaDeIntentRespuesta() {
        // INTENT
        val intentRespuesta = Intent(this, IntentRespuestaActivity::class.java)
        this.startActivity(intentRespuesta)
    }

}

package com.example.andres.movilesgr22018

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_button.*

class ButtonActivity : AppCompatActivity() {
    var nombre:String = ""
    var apellido:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)
        this.capturarDatosDelIntent()
        // Con el id del textView
        act_but_nombre_apellido
                .text = "${this.nombre} ${this.apellido}"

        but_input_correo.setOnClickListener {
            enviarIntentCorreo()
        }
    }

    fun capturarDatosDelIntent(){
        this.nombre = intent.getStringExtra("nombre")
        this.apellido = intent.getStringExtra("apellido")

    }

    fun enviarIntentCorreo(){
        val correo = correo_txt.text
        val subject = asunto_txt.text
        val texto = texto_txt.text

        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/html" // tipo del intent
        intent.putExtra(Intent.EXTRA_EMAIL,arrayOf(correo,"velasco.andrs@gmail.com"))
        intent.putExtra(Intent.EXTRA_SUBJECT,subject)
        intent.putExtra(Intent.EXTRA_TEXT,texto)

        startActivity(intent) // No esperamos una respuesta

    }
}

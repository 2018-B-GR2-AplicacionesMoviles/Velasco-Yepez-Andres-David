package com.example.andres.deber_moviles

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewDebug
import kotlinx.android.synthetic.main.activity_info.*

class Info_Activity : AppCompatActivity() {
    var nombre:String = ""
    var correo:String = ""
    var ocupacion:String =""
    var sexo:String =""
    var fecha = ""
    var sumario=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        this.capturarDatosDelIntent()
        img_btn.setOnClickListener {
            info_txt.text = sumario
        }

        enviar.setOnClickListener{
            Log.i("Rating","R: ${rating_w.rating.toString()}")
            enviarRating()
        }
        color_btn.setOnClickListener{
            if(color_btn.isChecked){
                img_btn.background = getDrawable((R.drawable.icono_oscuro))
            }else{
                img_btn.background = getDrawable((R.drawable.ic_launcher_foreground))
            }
        }

    }

    fun enviarRating(){
        val intentIrSummary = Intent(this,Summary_Activity::class.java)
        intentIrSummary.putExtra("rating","${rating_w.rating}")
        intentIrSummary.putExtra("info",this.sumario)
        this.startActivity(intentIrSummary)
    }

    fun capturarDatosDelIntent(){
        //this.nombre = intent.getParcelableExtra<>()
        this.nombre = intent.getStringExtra("nombre")
        this.correo = intent.getStringExtra("correo")
        this.ocupacion = intent.getStringExtra("ocupacion")
        this.sexo = intent.getStringExtra("sexo")
        this.fecha = intent.getStringExtra("fecha")
        this.sumario = "Nombre: ${nombre}" +
                "\nCorreo: ${correo}" +
                "\nOcupacion: ${ocupacion}" +
                "\nSexo: ${sexo}" +
                "\nFecha Nacimiento: ${fecha}"
    }

}

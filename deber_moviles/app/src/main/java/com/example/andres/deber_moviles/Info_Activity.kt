package com.example.andres.deber_moviles

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_info.*

class Info_Activity : AppCompatActivity() {
    var nombre:String = ""
    var correo:String = ""
    var ocupacion:String =""
    var sexo:String =""
    var fecha = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        img_btn.setOnClickListener {
            this.capturarDatosDelIntent()
            info_txt.text = "Nombre: ${nombre}" +
                    "\nCorreo: ${correo}" +
                    "\nOcupacion: ${ocupacion}" +
                    "\nSexo: ${sexo}" +
                    "\nFecha Nacimiento: ${fecha}"
        }
    }

    fun capturarDatosDelIntent(){
        //this.nombre = intent.getParcelableExtra<>()
        this.nombre = intent.getStringExtra("nombre")
        this.correo = intent.getStringExtra("correo")
        this.ocupacion = intent.getStringExtra("ocupacion")
        this.sexo = intent.getStringExtra("sexo")
        this.fecha = intent.getStringExtra("fecha")

    }

}

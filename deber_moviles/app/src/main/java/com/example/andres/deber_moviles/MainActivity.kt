package com.example.andres.deber_moviles

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registrar_btn.setOnClickListener{
            irAPantallaInfo()
        }
    }

    fun irAPantallaInfo(){
        var ocupacion = "Ninguna"
        var nombre = nombre_txt.text
        var sexo = ""
        var fecha = fecha_txt.text
        var correo = correo_txt.text
        var es_ok = true
        if(estudiante_ck.isChecked){ocupacion="Estudiante"}
        if(es_femenino.isChecked){sexo="Femenino"}
        if(es_masculino.isChecked){sexo="Masculino"}
        if(nombre.isEmpty()){es_ok=false}
        if(fecha.isEmpty()){es_ok=false}
        if(correo.isEmpty()){es_ok=false}
        if(es_ok){
            // INTENT: ir de una pantalla a otra
            val intentIrAInfo = Intent(this,Info_Activity::class.java)
            Log.w("navegacion", nombre.toString())
            intentIrAInfo.putExtra("nombre",nombre.toString())
            //intentIrAInfo.putExtra("nombre",nombre)// Parceleable sirve para serializar informacion siempre cuando ese tipo de dato no existe para otro proceso
            intentIrAInfo.putExtra("correo",correo.toString())
            //intentIrAInfo.putExtra("clave",clave)
            intentIrAInfo.putExtra("ocupacion",ocupacion)
            intentIrAInfo.putExtra("sexo",sexo)
            intentIrAInfo.putExtra("fecha",fecha.toString())

            this.startActivity(intentIrAInfo)
        }else{
            aviso_txt.text = "Todos los campos deben ser llenados"
        }
    }

}

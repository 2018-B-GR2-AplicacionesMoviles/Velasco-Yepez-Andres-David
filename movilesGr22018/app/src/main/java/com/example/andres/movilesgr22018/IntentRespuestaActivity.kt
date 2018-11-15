package com.example.andres.movilesgr22018

import android.app.Activity
import android.content.Intent
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent_respuesta.*

class IntentRespuestaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_respuesta)

        val texto = intent.getStringExtra(Intent.EXTRA_TEXT)
        Log.i("intent-texto","Texto ${texto}")
        enviar.setOnClickListener{
            this.enviarIntentRespuesta()
        }
    }

    fun enviarIntentRespuesta(){
        // Seleccionar el URI DEL TELEFONO
        val intentRespuesta = Intent(Intent.ACTION_PICK,ContactsContract.CommonDataKinds.Phone.CONTENT_URI)
        this.startActivityForResult(intentRespuesta, requestCodeContactos)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode){
            requestCodeContactos->{
                when(resultCode){
                    RESULT_OK ->{
                        Log.i("contactos","data: ${data}")
                        var cursor:Cursor? = null
                        try {
                            var numeroTelefono: String? = null
                            var nombre: String? = null
                            var uri = data?.data
                            cursor = contentResolver.query(uri,null,null,null,null,null)
                            cursor!!.moveToFirst()
                            val indiceTelefono = cursor!!.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                            val indiceNombre = cursor!!.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)

                            numeroTelefono = cursor!!.getString(indiceTelefono)
                            nombre = cursor!!.getString(indiceNombre)


                            Log.i("Contacctos","Telefono ${numeroTelefono} Nombre: ${nombre}")

                        }catch (e:Exception){
                            Log.i("Contactos", "Error")
                        }
                    }
                    RESULT_CANCELED ->{
                        Log.i("contactos","No se selecciono ningun contacto")
                    }
                }

            }
            else->{
                Log.i("Indefinido","indefinido")
            }
        }

    }

    companion object {
        val requestCodeContactos = 101
    }


}

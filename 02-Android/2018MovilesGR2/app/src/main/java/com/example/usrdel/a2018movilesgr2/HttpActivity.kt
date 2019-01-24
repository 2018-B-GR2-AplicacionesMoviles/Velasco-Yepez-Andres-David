package com.example.usrdel.a2018movilesgr2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.google.gson.Gson
import javax.xml.transform.Result

class HttpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http)

        val url = "http://172.29.56.249:1337/Estudiante"
        var gson = Gson()
        val parametros = listOf("2" to "2")


        url
                .httpPost(parametros)
                .responseString{ request, response, result ->
                    Log.i("http","Request: $request")
                    Log.i("http","Request: $response")
                    Log.i("http","Request: $result")

                    when(result){
                        is com.github.kittinunf.result.Result.Failure -> {
                            val exepcion = result.getException()
                            Log.i("http","Error: $exepcion")
                        }
                        is com.github.kittinunf.result.Result.Success ->{
                            val data = result.get()
                            //val usuarioClase = Klaxon().parse<UsuarioHttp>(usuarioString)
                            Log.i("http","Datos: $data")
                        }
                    }
                }
    }
}

class UsuarioHttp(var nombre:String, var apellido:String,var createdAt:Int,var updatedAt:Int,var id:Int){}

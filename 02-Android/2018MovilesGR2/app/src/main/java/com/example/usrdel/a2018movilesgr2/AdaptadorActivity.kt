package com.example.usrdel.a2018movilesgr2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_adaptador.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.util.Log
import android.view.View

class AdaptadorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adaptador)
        val arregloUsuarios = ArrayList<Usuario>()
        val usuario1=Usuario("adrian",29, Date(1989,10,21),12.00)
        val usuario2=Usuario("pedro",30, Date(1939,10,21),34.00)
        arregloUsuarios.add(usuario1)
        arregloUsuarios.add(usuario2)

        val adaptadorUsuarios=ArrayAdapter<Usuario>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                arregloUsuarios
        )
        // Seteo el adaptador
        spinner.adapter = adaptadorUsuarios

        // Escucho evento
        spinner
                .onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                            parent: AdapterView<*>?,
                            view: View?,
                            position: Int,
                            id: Long) {
                        Log.i("adaptador", "${parent}")
                        Log.i("adaptador", "${view}")
                        Log.i("adaptador", "${position}")
                        Log.i("adaptador", "${id}")
                        val usuario = arregloUsuarios[position]
                        Log.i("adaptador", "${usuario.nombre}")
                    }

                    override fun onNothingSelected(
                            parent: AdapterView<*>?) {
                        Log.i("adaptador", "${parent}")
                    }
                }
    }
}

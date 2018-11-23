package com.example.usrdel.a2018movilesgr2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_adaptador.*
import java.util.*

class AdaptadorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adaptador)

        val arregloUsuarios = ArrayList<Usuario>();
        val arregloMascotas = ArrayList<Mascota>();

        val usuarioUno = Usuario(
                "Adrian",
                29,
                Date(1989, 6, 10),
                12.00)
        val usuarioDos = Usuario(
                "Vicente",
                32,
                Date(1912, 3, 23),
                15.00)

        val mascotaUno = Mascota("Cachetes", usuarioUno)
        val mascotaDos = Mascota("Orejas", usuarioDos)

        arregloUsuarios.add(usuarioUno)
        arregloUsuarios.add(usuarioDos)

        arregloMascotas.add(mascotaUno)
        arregloMascotas.add(mascotaDos)

        // ADAPTADOR

        val adaptadorUsuarios = ArrayAdapter<Usuario>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                arregloUsuarios
        )

        val adaptadorMascota = ArrayAdapter<Mascota>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                arregloMascotas
        )
        // Seteo el adaptador
        spinner_usuarios.adapter = adaptadorUsuarios
        lista.adapter = adaptadorMascota
        // Escucho evento
        spinner_usuarios
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

        lista
                .onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                            parent: AdapterView<*>?,
                            view: View?,
                            position: Int,
                            id: Long) {
                        val mascota = arregloMascotas[position]
                        Log.i("adaptador-lista", "${mascota.nombre}")
                    }

                    override fun onNothingSelected(
                            parent: AdapterView<*>?) {
                        Log.i("adaptador-lista", "${parent}")
                    }
                }


    }
}
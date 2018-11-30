package andres.moviles.epn.examenapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_listar.*
import java.util.ArrayList

class ListarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar)
        val arregloPelicula = BaseDeDatos.Peliculas;


        val adaptadorPeliculas = ArrayAdapter<Pelicula>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                arregloPelicula
        )
        peliculas_view.adapter = adaptadorPeliculas
        peliculas_view
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
                        val pelicula = arregloPelicula[position]
                        Log.i("adaptador", "${pelicula.nombre}")
                        actualizar(pelicula)
                    }

                    override fun onNothingSelected(
                            parent: AdapterView<*>?) {
                        Log.i("adaptador", "${parent}")
                    }
                }
    }

    fun actualizar(pelicula:Pelicula){
        val intentActividadIntent = Intent(
                this,
                ModificarActivity::class.java
        )
        intentActividadIntent.putExtra("pelicula",pelicula)
        startActivity(intentActividadIntent)
    }
}

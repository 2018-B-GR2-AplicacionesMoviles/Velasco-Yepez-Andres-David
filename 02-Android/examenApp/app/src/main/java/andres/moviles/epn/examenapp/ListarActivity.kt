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
        //val arregloPelicula = BaseDeDatos.Peliculas;
        var arregloPelicula = BaseDeDatos.Peliculas


        val adapter = ArrayAdapter<Pelicula>(
                this,
                android.R.layout.simple_list_item_1,
                BaseDeDatos.Peliculas
        )
        peliculas_view.adapter = adapter;
        peliculas_view.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val pelicula = arregloPelicula[position]
            enviar_pelicula(pelicula,position)
        }


    }

    fun enviar_pelicula(pelicula: Pelicula,pos:Int){
        val intentActividadIntent = Intent(
                this,
                ModificarActivity::class.java
        )
        intentActividadIntent.putExtra("pelicula",pelicula)
        intentActividadIntent.putExtra("pos",pos)
        startActivity(intentActividadIntent)
    }
}

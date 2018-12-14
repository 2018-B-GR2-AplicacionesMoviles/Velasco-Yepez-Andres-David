package andres.moviles.epn.examenapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_crear.*
import kotlinx.android.synthetic.main.activity_modificar.*

class ModificarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modificar)
        val Pelicula = intent.getParcelableExtra<Pelicula?>("pelicula")
        nombre_txt2.setText(Pelicula?.nombre)
        genero_txt2.setText(Pelicula?.genero)
        director_txt2.setText(Pelicula?.director)
        precio_txt2.setText(Pelicula?.precio)
        var posicion = intent.getIntExtra("pos",0);

        guardar_btn2.setOnClickListener {
            actualizar(posicion)
        }
        cancelar_btn2.setOnClickListener {
            cancelar()
        }
         borrar_btn.setOnClickListener {
            borrar(posicion)
        }
    }

    fun actualizar(posicion:Int){
        var pelicula= Pelicula(nombre = nombre_txt2.text.toString(),director = director_txt2.text.toString(),genero = genero_txt2.text.toString(),precio =precio_txt2.text.toString())
        Log.i("actualizar-bdd", BaseDeDatos.Peliculas.toString())
        Log.i("actualizar-pos", posicion.toString())
        Log.i("actualizar-nuevo",pelicula.toString())
        BaseDeDatos.Peliculas[posicion]=pelicula
        Log.i("actualizar-bdd-ac", BaseDeDatos.Peliculas.toString())
        intentListar()
    }

    fun intentListar(){
        val intentActividadIntent = Intent(
                this,
                ListarActivity::class.java
        )
        startActivity(intentActividadIntent)
    }
    fun cancelar(){
        intentListar()
    }
    fun borrar(posicion:Int){
        BaseDeDatos.Peliculas.removeAt(posicion)
        intentListar()
    }

}

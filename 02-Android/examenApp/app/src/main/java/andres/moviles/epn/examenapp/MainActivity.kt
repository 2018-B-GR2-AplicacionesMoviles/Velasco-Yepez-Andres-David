package andres.moviles.epn.examenapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BaseDeDatos.agregarPelicula(Pelicula("Tiburon",genero = "terror",precio = "5.50",director = "Mark Gagellos"))
        BaseDeDatos.agregarPelicula(Pelicula("Star wars",genero ="terror",precio = "20,00",director = "George L."))
        BaseDeDatos.agregarPelicula(Pelicula("Spiderman 5",genero = "accion",precio = "30.00",director = "Samuel Smith"))
        add_btn.setOnClickListener{
            this.crear()
        }

        listar_btn.setOnClickListener{
            this.listar()
        }
    }

    fun crear(){
        val intentActividadIntent = Intent(
                this,
                CrearActivity::class.java
        )
        startActivity(intentActividadIntent)
    }
    fun listar(){
        val intentActividadIntent = Intent(
                this,
                ListarActivity::class.java
        )
        startActivity(intentActividadIntent)
    }
}

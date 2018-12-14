package andres.moviles.epn.examenapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_crear.*
import kotlinx.android.synthetic.main.activity_modificar.*

class CrearActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear)
        guardar_btn.setOnClickListener {
            guardar()
        }
        cancelar_btn.setOnClickListener {
            cancelar()
        }
    }

    fun guardar(){
        var pelicula= Pelicula(nombre = nombre_txt.text.toString(),director = Director_txt.text.toString(),genero = genero_txt.text.toString(),precio =precio_txt.text.toString())
        BaseDeDatos.agregarPelicula(pelicula)
        val intentActividadIntent = Intent(
                this,
                ListarActivity::class.java
        )
        startActivity(intentActividadIntent)
    }
    fun cancelar(){
        val intentActividadIntent = Intent(
                this,
                MainActivity::class.java
        )
        startActivity(intentActividadIntent)
    }
}

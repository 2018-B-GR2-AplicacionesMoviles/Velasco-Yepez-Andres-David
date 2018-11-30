package andres.moviles.epn.examenapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
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

        guardar_btn2.setOnClickListener {
            actualizar()
        }
        cancelar_btn2.setOnClickListener {
            cancelar()
        }
         borrar_btn.setOnClickListener {
            borrar()
        }
    }

    fun actualizar(){
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
    fun borrar(){
        val intentActividadIntent = Intent(
                this,
                ListarActivity::class.java
        )
        startActivity(intentActividadIntent)
    }

}

package com.example.usrdel.a2018movilesgr2

import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fragment.*
import kotlinx.android.synthetic.main.fragment_blank.*

class FragmentActivity : AppCompatActivity() {

    lateinit var fragmentoActual: Fragment    //  Para no inicializar la variable luego si

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)


        button_crear_primer
                .setOnClickListener{
                    crearFragmentoUno()
                }
    }

    fun crearFragmentoUno(){

        // Manager
        val fragmentManager = supportFragmentManager
        //  Transacciones
        val fragmentTransaction = fragmentManager.beginTransaction()
        // Crear instancia de fragmento
        val primerFragment = BlankFragment()

        var argumentos = Bundle()
        argumentos.putString("nombre","Andres Velasco")
        argumentos.putInt("edad",22)
        primerFragment.arguments = argumentos
        // Add fragmento
        //fragmentTransaction.remove(fragmentoActual)
        fragmentTransaction.add(R.id.fragmento_primer,primerFragment)
        //fragmentoActual = primerFragment
        // Commit
        //primerFragment.txt_view_primer_fragmento.setText("Andres Velasco")
        fragmentTransaction.commit()
    }

}

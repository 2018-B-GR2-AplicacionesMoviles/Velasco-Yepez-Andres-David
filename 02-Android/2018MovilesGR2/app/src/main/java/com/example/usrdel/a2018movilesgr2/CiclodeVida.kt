package com.example.usrdel.a2018movilesgr2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_ciclode_vida.*

class CiclodeVida : AppCompatActivity() {

    var contador = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contador_btn.setOnClickListener{
            this.aumentar(1)
        }

    }

    fun aumentar(suma:Int){
        this.contador +=suma
        contador_txt.text=this.contador.toString()

    }

    override fun onStart() {
        super.onStart()
        Log.i("ciclo-vida","On create")

    }

    override fun onResume() {
        super.onResume()
        Log.i("ciclo-vida","On resume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("ciclo-vida","On pause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("ciclo-vida","On stop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("ciclo-vida","On restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ciclo-vida","On Destroy")
    }

    override fun onSaveInstanceState(outState: Bundle?) {

        Log.i("ciclo-vida","On onSaveInstanceState")
        outState?.run {
            putInt(SAVE_INSTANCE_STATE_CONTADOR,contador)
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val tieneContadorGuardado = savedInstanceState.get(SAVE_INSTANCE_STATE_CONTADOR) as Int //
        contador = tieneContadorGuardado
        this.aumentar(0)
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("ciclo-vida","On Restore Instance State")
    }

    companion object {
        val SAVE_INSTANCE_STATE_CONTADOR = "contador"
    }
}

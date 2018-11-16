package com.example.usrdel.a2018movilesgr2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class CiclodeVida : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciclode_vida)

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
}

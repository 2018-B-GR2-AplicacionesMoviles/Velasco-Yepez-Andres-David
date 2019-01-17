package com.example.usrdel.a2018movilesgr2

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log


class SqliteHelper(context:Context?) :
        SQLiteOpenHelper(context,
                "moviles", // Nombre de la base de datos
                null,
                1) {

    override fun onCreate(baseDeDatos: SQLiteDatabase?) {

        val crearTablaUsuario = "CREATE TABLE " +
                "usuario " +
                "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre VARCHAR(50)," +
                "descripcion VARCHAR(50)" +
                ")"
        Log.i("bdd", "Creando la tabla de usuario \n$crearTablaUsuario")
        baseDeDatos?.execSQL(crearTablaUsuario)
    }

    override fun onUpgrade(baseDeDatos: SQLiteDatabase?,
                           antiguaVersion: Int,
                           nuevaVersion: Int) {

    }

    fun existeUsuarioFormulario(): RespuestaUsuarioGuardado {

        val statement = "select * from usuario where id=1;"

        val dbReadable = readableDatabase

        val resultado = dbReadable.rawQuery(statement, null)

        val respuestaUsuario = RespuestaUsuarioGuardado(null, null)

        if (resultado.moveToFirst()) {
            do {
                respuestaUsuario.nombre = resultado.getString(1)
                respuestaUsuario.descripcion = resultado.getString(2)
            } while (resultado.moveToNext())
        }

        resultado.close()

        dbReadable.close()

        return respuestaUsuario
    }

    fun crearUsuarioFormulario(nombre: String,
                               descripcion: String): Boolean {
        // Base de datos de escritura
        val dbWriteable = writableDatabase
        val cv = ContentValues()

        // Valores de los campos
        cv.put("nombre", nombre)
        cv.put("descripcion", descripcion)

        val resultado: Long = dbWriteable
                .insert(
                        "usuario", // Nombre de la tabla
                        null,
                        cv)

        dbWriteable.close()

        return if (resultado.toInt() == -1) false else true

    }

    fun actualizarUsuarioFormulario(nombre: String,
                                    descripcion: String): Boolean {
        // Base de datos de escritura
        val dbWriteable = writableDatabase
        val cv = ContentValues()

        // Valores de los campos

        cv.put("nombre", nombre)
        cv.put("descripcion", descripcion)

        val resultado = dbWriteable
                .update(
                        "usuario", // Nombre de la tabla
                        cv, // Valores a actualizarse
                        "id=?", // Where
                        arrayOf("1") // Parametros
                )

        dbWriteable.close()

        return if (resultado.toInt() == -1) false else true

    }

    fun eliminarUsuarioFormulario():Boolean{
        val dbWriteable = this.writableDatabase
        val parametros = arrayOf("1")
        val nombreTabla = "usuario"
        val clausulaWhere = "id = ?"
        val respuesta = dbWriteable.delete(
                nombreTabla,
                clausulaWhere,
                parametros
        )
        return  if(respuesta == -1 )false else true
    }


}







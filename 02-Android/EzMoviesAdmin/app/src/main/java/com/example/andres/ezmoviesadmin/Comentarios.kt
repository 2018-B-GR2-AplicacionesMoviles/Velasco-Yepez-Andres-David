package com.example.andres.ezmoviesadmin

import android.os.Parcel
import android.os.Parcelable
import com.github.kittinunf.result.Result

data class Comentario(val contenido:String,val createdAt:Long,val updatedAt:Long,val id:Int )

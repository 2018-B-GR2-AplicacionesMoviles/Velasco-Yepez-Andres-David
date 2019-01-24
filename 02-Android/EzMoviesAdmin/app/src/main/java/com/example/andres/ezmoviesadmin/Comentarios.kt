package com.example.andres.ezmoviesadmin

import android.os.Parcel
import android.os.Parcelable
import com.github.kittinunf.result.Result

class ComentariosResponse(val success: ArrayList<Comentario>){
}


class Comentario(val contenido:String,val createdAt:Long,val updatedAt:Long,val id:Int ):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readLong(),
            parcel.readLong(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(contenido)
        parcel.writeLong(createdAt)
        parcel.writeLong(updatedAt)
        parcel.writeInt(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Comentario> {
        override fun createFromParcel(parcel: Parcel): Comentario {
            return Comentario(parcel)
        }

        override fun newArray(size: Int): Array<Comentario?> {
            return arrayOfNulls(size)
        }
    }
}
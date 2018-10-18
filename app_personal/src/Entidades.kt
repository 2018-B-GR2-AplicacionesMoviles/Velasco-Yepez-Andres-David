
import java.util.*


class Genero{
    val nombreGenero:String
    constructor(nGenero: String){
        nombreGenero = nGenero
    }
}

class Pelicula(val nombre: String,val genero: Genero, val precio:Double){
    override fun toString(): String{
        return "Nombre:  ${this.nombre} Genero: ${this.genero.nombreGenero} Precio: ${this.precio}"
    }
}



class Usuario(val nombre: String, val apellido: String, val cedula: String){
    override fun toString(): String{
        return "nombre:  ${this.nombre} apellido: ${this.apellido} cedula: ${this.cedula}"
    }
}

class Detalle(val pelicula: Pelicula,val factura:Factura){
    override fun toString(): String {
        return "${this.pelicula} ${this.pelicula.precio} \n"
    }
}
class Factura(val fechaFactura: Date,val codFactura:String,val usuario: Usuario)



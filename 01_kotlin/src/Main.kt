/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

package Java.util.Date

fun main(args: Array<String>) {
    System.out.println("Hola mundo");
    println("Hello, world!!!");
    // Int edad = 22;
    // Mutar -> Cambiarse / Reasignar
    var edad: Int = 22; // La variable edad es un entero
    edad = 10
    // Inmutable -> Cambiarse / No se puede reasignar
    val edadInmutable: Int = 29;
    // Duck Typing
    var curso = 101; // Infei que es Int
    var nombre:String = "Andres"
    var apellido: Char = 'H';
    var casado = false;
    var sueldo = 10.1;
    //var fechaNacimiento = Date();
    //println(fechaNacimiento.toString())
    when (casado){
        false -> println("Feliz ${nombre}" ) //template string
        true -> println("Triste $nombre")  //template string, sin operaciones sobre la variable
        else -> {
            println("No me voy a ejecutar")
            println("Ni yo tampoco")
        }
    }

    var bono = if (casado) 1000.00 else 0.00;
    val sueldoTotal = calcularSueldo(bono);
    println(sueldoTotal)
    val andres = Usuario("Andres", "Velasco","Yepez")
    println(andres)
    
    println(BaseDeDatos.Usuarios) // []
    BaseDeDatos.agregarUsuario("Andres")
    println(BaseDeDatos.Usuarios) // ["Adrian]

}

fun calcularSueldo(bono:Double): Double{
    var sueldo =  10.1
    return sueldo + bono
}

class Usuario(public val nombre: String){ // 1er constructor
    var apellido: String? = null
    var apellidoMaterno: String? = null
    constructor(vNombre: String, vApellido: String,vApellidoMaterno: String):this(vNombre){ // llamar al primer constructor
        this.apellido= vApellido
        this.apellidoMaterno = vApellidoMaterno
    }
    /*public val nombre: String
    constructor(vNombre: String){
        nombre=vNombre
    }*/
    override fun toString(): String{
        // ? operador si es string
        val apellidoMayusculas =  if (!apellido.isNullOrBlank()) this.apellido?.toUpperCase() else ""
        val apellidoMaternoMayusculas =  if (!apellidoMaterno.isNullOrBlank()) this.apellidoMaterno?.toUpperCase() else ""

        return "Hola ${this.nombre} $apellidoMayusculas $apellidoMaternoMayusculas"
    }
}
//Para que sea heredable
open class Animal(var nombre: String){

}
//No se pone el var, porque fue definido en la clase padre,
class Tortuga(nombre:String,var pesoCaparazon:Double): Animal(nombre){
    //Se ejectuta segundo
    init {
        println("$nombre $pesoCaparazon")
    }
}

var animal = Animal("Caballo")
var george = Tortuga("George",12.5)

class Ejemplo{
    var nombre: String
    //Se ejecuta segundo, no es constructor primario
    constructor(nNombre:String){
        println("Estoy en el constructor ")
        nombre = nNombre
    }
    //Se ejectuta primero
    init {
        println("Estoy en el INIT")
    }
}

val ejemplo = Ejemplo("Andres")


class BaseDeDatos{
    companion object {
        val Usuarios: ArrayList<String> = ArrayList()
                fun agregarUsuario(nombre:String){
                    Usuarios.add(nombre)
                }
    }
}

fun datosIniciales(){
    //Cargar los datos Iniciales
    BaseDeDatos.agregarUsuario("Juan")
}



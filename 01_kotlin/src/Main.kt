/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
//package java.util.Date;

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
    println(sueldoTotal);
    val andres = Usuario("Andres", "Velasco","Yepez")
    println(andres)
}

fun calcularSueldo(bono:Double): Double{
    var sueldo =  10.1
    return sueldo + bono;
}

class Usuario(public val nombre: String){ // 1er constructor
    public var apellido: String? = null
    public var apellidoMaterno: String? = null
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
fun menu(){
    println("BIENVENIDO AL SISTEMAS DE VENTA DE PELICULAS")
    print("Escriba el nombre de la pelicula: ")
    val entrada = readLine()!!
    val respuesta = AppController.buscarPelicula(entrada)
    if (respuesta!=null){
        println("\n Pelicula Encontrada: " +
                "\n Nombre: ${respuesta.nombre} " +
                "\n Genero: ${respuesta.genero} " +
                "\n Precio: ${respuesta.precio}")
    }else{
        println("Pelicula no encontrada")
    }

}

fun main(args: Array<String>){
    menu()
}

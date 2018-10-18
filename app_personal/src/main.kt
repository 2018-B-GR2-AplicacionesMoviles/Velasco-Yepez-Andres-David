fun setData(){
    BaseDeDatos.agregarPeliculas(Pelicula("Garganta profunda",genero = Genero("terror"),precio = 2.50))
    BaseDeDatos.agregarPeliculas(Pelicula("Venom",genero = Genero("terror"),precio = 20.00))
    BaseDeDatos.agregarPeliculas(Pelicula("Spiderman 5",genero = Genero("accion"),precio = 12.75))
    BaseDeDatos.agregarPeliculas(Pelicula("Freddy vs Tinky winky",genero = Genero("terror"),precio = 2.00))
    BaseDeDatos.agregarPeliculas(Pelicula("ZZZ",genero = Genero("terror"),precio = 9.50))

}


fun menu(){

    loop@ do {
        println("BIENVENIDO AL SISTEMAS DE VENTA DE PELICULAS")
        println("Valor del carrito: ${AppController.totalCarrito()}")
        println("1. Buscar Pelicula ")
        println("2. Salir ")

        print("Escoga una opcion: ")
        val entrada = readLine()!!
        when(entrada){
            "1" -> {
                // Llama a la busqueda
                print("\nEscribe el nombre de la pelicula: ")
                val nombrePelicula = readLine()!!
                val respuesta = AppController.buscarPelicula(nombrePelicula)
                if (respuesta != null) { // Si existe la pelicula en la BD
                    // Imprimir informacion de la pelicula
                    println("Pelicula Encontrada: " +
                            "\nNombre: ${respuesta.nombre} " +
                            "\nGenero: ${respuesta.genero.nombreGenero} " +
                            "\nPrecio: ${respuesta.precio}")

                    subMenu(respuesta)

                } else {
                    println("Pelicula no encontrada")

                }

            }
            "2" -> {
                // Salir de la aplicacion
                if (AppController.carritoCompra.size > 0){
                    println("Desea Salir sin confirmar su compra?")
                    subMenuCompra()
                }
                println("Fin")
                break@loop
            }
            else -> {
                println("Ha ingresado una opcion incorrecta")
            }
        }

    }while (true)

}

// SubMenu Referente a agregar una pelicula al carrito del compras
fun subMenu(pelicula: Pelicula){
    loop@ do{
        print("Agregar al carrito Y/N: ")
        val respuesta = readLine()!!
        when(respuesta){
            "Y","y" -> {
                AppController.agregar(pelicula)
                subMenuCompra()
            }
            "N","n" ->{
                break@loop
            }
            else ->{
                println("Error al Ingresar la respuesta")
            }
        }
        break@loop

    }while (true)
}

fun subMenuCompra(){

    loop@ do{
        print("Finalizar Compra Y/N (Escriba N para seguir comprando): ")
        val respuesta = readLine()!!
        when(respuesta){
            "Y","y"  -> {
                print("\nIngresa tu nombre: ")
                val nombre = readLine()!!
                print("\nIngresa tu apellido: ")
                val apellido = readLine()!!
                print("\nIngresa tu cedula: ")
                val cedula = readLine()!!
                println("Compra realizada con exito: ")
                println("${AppController.comprar(nombre,apellido,cedula)}")
                break@loop
            }
            "N","n"->{
                break@loop
            }
            else ->{
                println("Error al Ingresar la respuesta")
            }

        }
        break@loop

    }while (true)

}


fun main(args: Array<String>){
    setData()
    menu()
}



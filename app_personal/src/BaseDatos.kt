class BaseDeDatos{
    companion object {
        val USUARIOS: ArrayList<Usuario> = ArrayList()
        val Peliculas: ArrayList<Pelicula> = ArrayList()
        val Generos: ArrayList<Genero> = ArrayList()
        val Detalles: ArrayList<Detalle> = ArrayList()
        val Facturas: ArrayList<Factura> = ArrayList()

        fun agregarCliente(usuario:Usuario){
            USUARIOS.add(usuario)
        }
        fun agregarPeliculas(pelicula: Pelicula){
            Peliculas.add(pelicula)
        }
        fun agregarGeneros(genero:Genero){
            Generos.add(genero)
        }
        fun agregarFacturas(factura: Factura){
            Facturas.add(factura)
        }

        fun agregarDetalles(detalle: Detalle){
            Detalles.add(detalle)
        }
    }
}
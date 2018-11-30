package andres.moviles.epn.examenapp

class BaseDeDatos{
    companion object {
        val Peliculas: ArrayList<Pelicula> = ArrayList()


        fun agregarPelicula(pelicula:Pelicula){
            Peliculas.add(pelicula)
        }
    }
}
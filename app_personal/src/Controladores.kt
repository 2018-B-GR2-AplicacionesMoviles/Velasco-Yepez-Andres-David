import java.util.*
import kotlin.collections.ArrayList


class AppController {

    companion object {
        var carritoCompra = ArrayList<Pelicula>()

        fun buscarPelicula(nombre: String): Pelicula? {
            var Peliculas = BaseDeDatos.Peliculas
            for (pelicula in Peliculas) {
                if (pelicula.nombre == nombre) {
                    return pelicula
                }
            }
            return null
        }


        fun RecopilarInfo(nombre: String, apellido: String, cedula: String): Usuario {
            var usuario = Usuario(nombre, apellido, cedula)
            return usuario
        }

        fun agregar(pelicula: Pelicula) {
            carritoCompra.add(pelicula)
        }

        fun comprar(nombre: String, apellido: String, cedula: String): String {
            val fecha = Date()
            var ListaDetalles = ArrayList<Detalle>()
            var factura = Factura(fecha, fecha.toString() + 1, RecopilarInfo(nombre, apellido, cedula))
            var total: Double = 0.00
            for (pelicula in carritoCompra) {
                var detalle = Detalle(pelicula, factura)
                ListaDetalles.add(detalle)
                total += pelicula.precio
                BaseDeDatos.agregarDetalles(detalle)
            }
            BaseDeDatos.agregarFacturas(factura)
            var reporte = ""
            for (detalle in ListaDetalles) {
                reporte += "\n"+detalle
            }

            reporte += "___________________________________:\n Total: ${total}"
            return reporte
        }

        fun totalCarrito():Double{
            var total: Double = 0.00
            for (pelicula in carritoCompra){
                total += pelicula.precio
            }
            return  total
        }
    }
}


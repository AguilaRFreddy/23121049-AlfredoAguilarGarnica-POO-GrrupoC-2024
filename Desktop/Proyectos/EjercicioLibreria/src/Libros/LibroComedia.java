package Libros;

import Libros.utils.cosntants.Genero;
import Libreria.Libreria;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class LibroComedia extends Books {
    public LibroComedia(String titulo, LocalDate fechaLanzamiento, String authorName, int libroID, double precio, String editorial, Genero genero, int stock) {
        super(titulo, fechaLanzamiento, authorName, precio, editorial, Genero.COMEDIA, stock);
    }
    @Override
    protected void filtrarPorPrecio(Double precio) {
      Libreria.libros.get(Genero.COMEDIA).stream().filter(libro -> libro.getPrecio() > precio).forEach(libro -> System.out.println(libro.toString()));
    }
    @Override
    protected void filtrarPorInicialAutor(String inicial) {
       Libreria.libros.get(Genero.COMEDIA).stream().map(libro -> libro.getAuthorName()).forEach(libro -> System.out.println(libro.toString()));

}
 // Método para filtrar libros de acción por nombre del autor, precio y stock
  public static List<LibroTerror> filtrarPorNombreAutorPrecioStock(List<LibroTerror> libros, String nombreAutor, double precioMaximo, int stockMinimo) {
    return libros.stream()
            .filter(libro -> libro.getAuthorName().equalsIgnoreCase(nombreAutor))
            .filter(libro -> libro.getPrecio() <= precioMaximo)
            .filter(libro -> libro.getStock() >= stockMinimo)
            .collect(Collectors.toList());
  }
}

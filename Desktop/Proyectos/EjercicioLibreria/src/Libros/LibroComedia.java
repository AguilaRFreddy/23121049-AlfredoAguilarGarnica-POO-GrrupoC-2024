package Libros;

import Libros.utils.cosntants.Genero;
import Libreria.Libreria;
import java.time.LocalDate;

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
}

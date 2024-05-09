package Libros;

import Libros.utils.cosntants.Genero;
import Libros.utils.cosntants.TerrorSubgenero;

import java.time.LocalDate;

import Libreria.Libreria;

public class LibroAccion extends Books {
    private TerrorSubgenero clasificacion;

    public LibroAccion(String titulo, LocalDate fechaLanzamiento, String authorName, int libroID, double precio,
            String editorial, Genero genero, int stock, TerrorSubgenero clasificacion) {
        super(titulo, fechaLanzamiento, authorName, precio, editorial, Genero.ACCION, stock);
        this.clasificacion = clasificacion;
    }

    @Override
    protected void filtrarPorPrecio(Double precio) {
      Libreria.libros.get(Genero.ACCION).stream().filter(libro -> libro.getPrecio() > precio).forEach(libro -> System.out.println(libro.toString()));
    }

    @Override
    protected void filtrarPorInicialAutor(String inicial) {
       Libreria.libros.get(Genero.COMEDIA).stream().map(libro -> libro.getAuthorName()).forEach(libro -> System.out.println(libro.toString()));

}

}

package Libros;

import Libros.utils.cosntants.Genero;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Books {
    private int id;
    private String titulo;
    private LocalDate fechaLanzamiento;
    private String authorName;
    //    boolean libroDisponible;
    private double precio;
    private String editorial;
    private Genero genero;
    private int stock;
    public static int CODIGO_LIBRO = 1;


    public Books(String titulo, LocalDate fechaLanzamiento, String authorName, double precio, String editorial, Genero genero, int stock) {
        this.id = CODIGO_LIBRO;
        this.titulo = titulo;
        this.fechaLanzamiento = fechaLanzamiento;
        this.authorName = authorName;
        this.precio = precio;
        this.editorial = editorial;
        this.genero = genero;
        this.stock = stock;
        CODIGO_LIBRO++;
    }

    public Books(String titulo, LocalDate fechaLanzamiento, String authorName, double precio, String editorial, int stock) {
        this.titulo = titulo;
        this.fechaLanzamiento = fechaLanzamiento;
        this.authorName = authorName;
        this.precio = precio;
        this.editorial = editorial;
        this.stock = stock;
    }
    /*
    public void mostrarLibros(){
        for (Books buscarLibro : listaLibros){
            System.out.println(buscarLibro.mostrarLibros());
        }

}*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public static void setCODIGO_LIBRO(int cODIGO_LIBRO) {
        CODIGO_LIBRO = cODIGO_LIBRO;
    }

    protected abstract void filtrarPorPrecio(Double precio);
    protected abstract void filtrarPorInicialAutor(String inicial);

    public static int getCODIGO_LIBRO() {
        return CODIGO_LIBRO;
    }
}
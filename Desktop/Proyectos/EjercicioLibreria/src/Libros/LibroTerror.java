package Libros;

import Libros.utils.cosntants.Genero;
import Libros.utils.cosntants.TerrorSubgenero;
import Libreria.Libreria;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static Libros.utilslibros.LibrosUtils.registrarLibro;

public class LibroTerror extends Books{
    private static TerrorSubgenero subgenero;
    public LibroTerror(String titulo, LocalDate fechaLanzamiento, String authorName, int libroID, double precio, String editorial, Genero genero, int stock, TerrorSubgenero clasificacion) {
        super(titulo, fechaLanzamiento, authorName, precio, editorial, Genero.TERROR, stock);
        this.subgenero = subgenero;
    }
    public static void registrarLibroTerror(){
        Scanner leer = new Scanner(System.in);
        ArrayList<String>datosLibro = registrarLibro();
        String nombre = datosLibro.get(0);
        String autor = datosLibro.get(2);
        String editorial = datosLibro.get(4);
        LocalDate Fecha = LocalDate.parse(datosLibro.get(1));
        double precio = Double.parseDouble(datosLibro.get(4));
        int stock = Integer.parseInt(datosLibro.get(5));
        System.out.println("Ingresa el subgénero del libro: ");
        System.out.println("1. Monjas. 2. Psicológico.");
        int opcion = leer.nextInt();
        try {
            switch(opcion){
                case 1:
                    subgenero = TerrorSubgenero.MONJAS;
                    break;
                case 2:
                    subgenero = TerrorSubgenero.PSICOLOGICO;
                    break;
            }
        } catch (Exception e) {
            System.out.println("Ingrese una opción válida.");
        }
    }
    @Override
    protected void filtrarPorPrecio(Double precio) {
      Libreria.libros.get(Genero.COMEDIA).stream().filter(libro -> libro.getPrecio() > precio).forEach(libro -> System.out.println(libro.toString()));
    }
    @Override
    protected void filtrarPorInicialAutor(String inicial) {
       Libreria.libros.get(Genero.TERROR).stream().map(libro -> libro.getAuthorName()).forEach(libro -> System.out.println(libro.toString()));

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

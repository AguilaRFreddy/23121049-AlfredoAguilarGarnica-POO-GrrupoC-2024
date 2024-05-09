package Libros.utilslibros;

import Libros.Books;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LibrosUtils {
    public static ArrayList<String>  registrarLibro() {
        Scanner leer = new Scanner(System.in);
        ArrayList<String> datosLibro = new ArrayList<>();
        System.out.println("Ingresa el título: ");
        String tittle = leer.nextLine();
        System.out.println("Ingresa el año de lanzamiento: ");
        int añoLanzamiento = leer.nextInt();
        System.out.println("Ingresa el mes de lanzamiento: ");
        int mesLanzamiento = leer.nextInt();
        System.out.println("Ingresa el dia de lanzamiento: ");
        int diaLanzamiento = leer.nextInt();
        LocalDate fechaLanzamiento = LocalDate.of(añoLanzamiento, mesLanzamiento, diaLanzamiento);
        System.out.println("Ingresa el nombre del autor: ");
        String authorName = leer.nextLine();
        System.out.println("Ingresa el precio del libro: ");
        Double precio = leer.nextDouble();
        System.out.println("Ingresa la editorial: ");
        String editorial = leer.nextLine();
        System.out.println("Ingresa el stock: ");
        int stock = leer.nextInt();

        Books newBook = new Books(tittle, fechaLanzamiento, authorName, precio, editorial, stock);
        datosLibro.addAll(Arrays.asList(tittle, String.valueOf(fechaLanzamiento), authorName, String.valueOf(precio), editorial, String.valueOf(stock)));
        System.out.println("Código de barras: " + newBook.getId());
        return datosLibro;
    }
}

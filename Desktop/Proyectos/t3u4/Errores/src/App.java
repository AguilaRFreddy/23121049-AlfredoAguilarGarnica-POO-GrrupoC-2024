import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 intentar pasar cadena a int");
        System.out.println("2 intento de acceso a objeto vacio");
        System.out.println("3 intentar acceder a un indice fuera de el arreglo");
        System.out.println("4 intentar dividir entre 0");
        System.out.println("5 intentar leer un numero entero");
        System.out.println("6 intentar acceder a un elemento de la lista");
        System.out.println("7 verificacion de edad no negativa");
        System.out.println("8 intentar convertir cadena a numero double ");
        System.out.println("9 intentar dividir captacion de errores general");
        System.out.println("10 valiodar fecha actual o anterior a la actual ");
        System.out.println("11 SALIR");

        int op = scanner.nextInt();
        do {

            switch (op) {
                case 1:
                    System.out.println("ingresa cadena a transformar a numero");
                    String cadena = scanner.nextLine();
                    try {
                        int numero = Integer.parseInt(cadena);
                    } catch (NumberFormatException e) {
                        System.out.println("La cadena no se puede convertir a un número.");
                    }

                    break;
                case 2:
                    try {
                        String cadenaNull = null;
                        int length = cadenaNull.length();
                    } catch (NullPointerException e) {
                        System.out.println("El objeto es null.");
                    }
                    break;
                case 3:
                    int[] arr = { 1, 2, 3 };
                    try {
                        int indice = arr[5];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("El índice está fuera del rango del arreglo.");
                    }

                    break;
                case 4:
                    System.out.println("Ingresa el numero a dividir entre 0");
                    int dividendo = scanner.nextInt();

                    try {
                        int resultado = dividendo / 0;
                    } catch (ArithmeticException e) {
                        System.out.println("División por cero.");
                    }

                    break;
                case 5:

                    try {
                        System.out.print("Ingresa un número entero: ");
                        int num = scanner.nextInt();
                        System.out.println("El número que ingresaste es: " + num);
                    } catch (Exception e) {
                        System.out.println("Ha ocurrido un error: " + e.getMessage());
                    } finally {
                        scanner.close();
                    }

                    break;
                case 6:

                    ArrayList<String> lista = new ArrayList<>();
                    lista.add("Manzana");
                    lista.add("Banana");
                    lista.add("Cereza");
                    System.out.println("La lista tiene 3 elementos teniendo indice maximo 2");
                    int indice = scanner.nextInt(); // Índice fuera del rango de la lista

                    try {
                        String elemento = lista.get(indice);
                        System.out.println("El elemento en el índice " + indice + " es: " + elemento);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Error: El índice está fuera del rango de la lista.");
                    }

                    break;
                case 7:
                    try {
                        System.out.println("Ingresa edad");
                        int age = scanner.nextInt();
                        if (age < 0) {
                            throw new IllegalArgumentException("La edad no puede ser negativa.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 8:
                    System.out.println("Ingresa cadena a convertir");
                    String numeroString = scanner.nextLine();

                    try {
                        double numero = Double.parseDouble(numeroString);
                        System.out.println("Número convertido: " + numero);
                    } catch (NumberFormatException e) {
                        System.err.println("Error: La cadena no se puede convertir a un número decimal.");
                    }

                    break;
                case 9:
                    try {
                        System.out.print("Ingrese el dividendo: ");
                        int dividendo1 = scanner.nextInt();
                        System.out.print("Ingrese el divisor: ");
                        int divisor = scanner.nextInt();
                        int resultado = dividendo1 / divisor;
                        System.out.println("El resultado de la división es: " + resultado);
                    } catch (Exception e) {
                        System.err.println("Error: " + e.getMessage());
                    }

                    break;
                case 10:

                    scanner.nextLine();
                    System.out.println("ingresa una fecha con formato yyyy-MM-dd");
                    String fechaIngresada = scanner.nextLine();

                    // Obtener la fecha actual
                    Date fechaActual = new Date();

                    // Formateador de fecha para analizar la fecha ingresada
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                    try {
                        // Convertir la fecha ingresada a un objeto Date
                        Date fechaIngresadaDate = sdf.parse(fechaIngresada);

                        // Comparar la fecha ingresada con la fecha actual
                        if (fechaIngresadaDate.before(fechaActual) || fechaIngresadaDate.equals(fechaActual)) {
                            System.out.println("La fecha ingresada es valida");
                        } else {
                            System.out.println("La fecha ingresada aun no sucede");
                        }
                    } catch (ParseException e) {
                        System.err.println("Error: Formato de fecha incorrecto.");
                    }

                    break;

                default:
                    break;
            }
        } while (op != 11);

    }
}

package usuarios;

import usuarios.utils.Rol;
import Libreria.Libreria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static Libreria.Libreria.usuarioVerificar;

public class DatosComun {
    public static ArrayList<String> obtenerDatosComun(Rol rol) {
        Scanner leer = new Scanner(System.in);
        ArrayList<String> datosComun = new ArrayList<String>();
        String rolUser = rol == Rol.CLIENTE ? "Cliente" : rol == Rol.ASISTENTE ? "Asistente" : "Gerente";
        System.out.println("Ingresa el nombre: ");
        String name = leer.nextLine();
        System.out.println("Ingresa el apellido: ");
        String surname = leer.nextLine();
        int telefono = validarTelefonoCliente();
        String telphone = String.valueOf(telefono);
        int añoNacimiento = 0;
        int mesNacimiento = 0;
        int diaNacimiento = 0;
        boolean fechaValida = false;

        // Se asegura de que se ingrese una fecha válida
        do {
            try {
                System.out.println("Ingresa año de nacimiento:");
                añoNacimiento = leer.nextInt();
                System.out.println("Ingresa mes de nacimiento:");
                mesNacimiento = leer.nextInt();
                System.out.println("Ingresa día de nacimiento:");
                diaNacimiento = leer.nextInt();
                LocalDate fechaCompleta = LocalDate.of(añoNacimiento, mesNacimiento, diaNacimiento);
                fechaValida = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Por favor, ingresa valores enteros para el año, mes y día de nacimiento.");
                leer.nextLine(); // Limpia el buffer del scanner
            }
        } while (!fechaValida);

        leer.nextLine(); // Limpiar el buffer del scanner después de los nextInt() anteriores
        LocalDate fechaCompleta = LocalDate.of(añoNacimiento, mesNacimiento, diaNacimiento);
        String fechaNacimientoCompleta = fechaCompleta.toString();
        System.out.println("Ingresa el RFC: ");
        String RFC = leer.nextLine();
        String username = validateUser();
        System.out.println("Ingresa la contraseña: ");
        String password = leer.nextLine();
        datosComun.addAll(Arrays.asList(name, surname, telphone, RFC, username, password, fechaNacimientoCompleta));
        return datosComun;
    }
    public static int validarTelefonoCliente() {
        Scanner leer = new Scanner(System.in);
        int telefono = 0;
        boolean telefonoValido = true;
        do {
            try {
                System.out.println("Ingresa el teléfono del cliente: ");
                telefono = leer.nextInt();
                telefonoValido = false;
            } catch (java.util.InputMismatchException e) {
                System.out.println("El valor ingresado no es un número entero. Favor de ingresar un número válido.");
                leer.nextLine(); // Limpiar el buffer del scanner para evitar un bucle infinito
            }
        } while (telefonoValido);
        return telefono;
    }
    public static String validateUser() {
        Scanner leer = new Scanner (System.in);
        String userName = "" ;
        boolean userValidation = true;
        do {
            System.out.println("Ingresa el nombre de la cuenta: ");
            userName = leer.nextLine();
            userValidation = false;
            for ( Usuario buscarNombreCliente : usuarioVerificar.values()) {
                if (buscarNombreCliente.getUserName().equals(userName)) {
                    userValidation = true;
                    break;
                }
            }
            if (userValidation) {
                System.out.println("El usuario ya ha sido registrado. Inténtelo de nuevo.");
            }
        } while (userValidation);
        return userName;
    }
    public static boolean validateUserToBeRemoved(String userName) {
        for ( Usuario buscarNombre : usuarioVerificar.values()) {
            if (buscarNombre.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }
    public static boolean isGerente(String userManager) {
        for (Usuario findUserManager : Libreria.usuarios.get(Rol.GERENTE)) {
            if (findUserManager.getUserName() == userManager) {
                return true;
            }
        }
        return false;
    }
}

package Usuarios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import Libreria.Libreria;
import Usuarios.utils.EmpleadoUtils;
import Usuarios.utils.Rol;

public class Gerente extends Usuario implements EmpleadoUtils {
    private LocalDate fechaInicio;
    private double sueldo;
    private String rfc, ine;

    public Gerente(String nombre, String apellido, String telefono, double sueldo, String rfc, String ine,
            String nombreUsuario, String contrasena, String fechaNacimiento) {
        super(nombre, apellido, telefono, Rol.GERENTE, nombreUsuario, contrasena, fechaNacimiento);
        this.sueldo = sueldo;
        this.ine = ine;
        this.rfc = rfc;
        this.fechaInicio = LocalDate.now();
    }

    public void checarEntrada() {
        System.out.println("Entrada con huella");
    }

    public void checarSalida() {
        System.out.println("Salida con huella");
    }

    @Override

    public String toString() { // Aqui lo estamos sobreescribiendo gracias al override y con eso el programa
                               // toma primero en cuenta la clase hija que el metodo de la clase padre
        return String.format("%s, Sueldo: %.2f, RFC: %s, INE: %s",
                super.toString(), this.sueldo, this.rfc, this.ine) + "Fecha de inicio: " + this.fechaInicio;
    }

    public static void registrarGerente() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun = Libreria.obtenerDatosComun(Rol.GERENTE);

        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String nombreUsuario = datosComun.get(3);
        String contraseña = datosComun.get(4);
        String fechaNacimiento = datosComun.get(5);
        System.out.print("RFC: ");
        String rfc = scanner.nextLine();
        System.out.print("INE: ");
        String ine = scanner.nextLine();
        System.out.print("Sueldo: ");
        double sueldo = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline left-over

        Gerente gerente = new Gerente(nombre, apellido, telefono, sueldo, rfc.toUpperCase(), ine.toUpperCase(),
                nombreUsuario, contraseña, fechaNacimiento);

        // Agregar al HashMap, verificando si la llave ya existe
        if (!Libreria.usuarios.containsKey(Rol.GERENTE)) {
            Libreria.usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());
        }
        Libreria.usuarios.get(Rol.GERENTE).add(gerente);
        System.out.println("\nRegistro exitoso");
    }

    public static void mostrarGerentes() {
        System.out.println("\nGerentes en la biblioteca");
        int x = 1;
        if (Libreria.usuarios.containsKey(Rol.GERENTE)) {
            for (Usuario usuario : Libreria.usuarios.get(Rol.GERENTE)) {
                Gerente gerente = (Gerente) usuario;
                System.out.println("\n---- Asistente " + x + " ----\n");
                System.out.println(gerente.toString());
                x++;
            }
        }
    }

}

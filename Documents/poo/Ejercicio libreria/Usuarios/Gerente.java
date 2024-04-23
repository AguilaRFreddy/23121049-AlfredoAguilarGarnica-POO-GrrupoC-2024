package Usuarios;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import Libreria.Libreria;
import Usuarios.utils.Rol;

public class Gerente extends Usuario{
    private LocalDate fechaInicio;
    private double sueldo;
    private String rfc, ine;
    
    public Gerente(String nombre, String apellido, String telefono, double sueldo, String rfc, String ine, String nombreUsuario, String contrasena) {
        super(nombre, apellido, telefono, Rol.GERENTE, nombreUsuario, contrasena);
        this.sueldo = sueldo;
        this.ine = ine;
        this.rfc = rfc;
        this.fechaInicio = LocalDate.now();
    }

    @Override

    public String toString() { //Aqui  lo estamos sobreescribiendo gracias al override y con eso el programa toma primero en cuenta la clase hija que el metodo de la clase padre
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
        System.out.print("RFC: ");
        String rfc = scanner.nextLine();
        System.out.print("INE: ");
        String ine = scanner.nextLine();
        System.out.print("Sueldo: ");
        double sueldo = scanner.nextDouble();
        
        Gerente gerente = new Gerente(nombre, apellido, telefono, sueldo, rfc.toUpperCase(), ine.toUpperCase(), nombreUsuario, contraseña);
        if(!Libreria.usuarios.containsKey(Rol.GERENTE)) {
            Libreria.usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());   //eso va a entrar cuando la llave no exista, o sea que el hash este vacio, si no lo va a ignorar (en la segunda vez)
        }

        Libreria.usuarios.get(Rol.GERENTE).add(gerente); //aqui lo agrega en un lista especifica de clientes
        System.out.println("\nRegistro exitoso");
    }


    public static void mostrarGerentes() {
        if(!Libreria.usuarios.containsKey(Rol.GERENTE) || Libreria.usuarios.get(Rol.GERENTE).isEmpty()) {
            System.out.println("\nNo hay gerentes registrados aún");
        }
        else {
            System.out.println("\nGerentes en la biblioteca");
            int x = 1;
            for(Usuario usuario : Libreria.usuarios.get(Rol.GERENTE)) {
                Gerente gerente = (Gerente) usuario;         //parseo
                System.out.println("\n---- Gerente " + x + " ----\n");
                System.out.println(gerente.toString());
                x++;
            }
        }
    }


}

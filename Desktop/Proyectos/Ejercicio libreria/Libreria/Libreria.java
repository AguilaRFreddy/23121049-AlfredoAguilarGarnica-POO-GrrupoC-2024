package Libreria;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import Usuarios.Asistente;
import Usuarios.Cliente;
import Usuarios.Gerente;
import Usuarios.Usuario;
import Usuarios.utils.Rol;

//Hash table: usa un hash (algo asi como un buscador) para encontrar un elemento gracias a una llave, esto 
//para evitar recorrer todo un arrayList
//HashMap<String, String> nombre = new HashMap

//nombre.put("inglaterra", "london")

//modificar inicio sesion iternaod todoo el hasmpa, registros de todos, telefono y nombre usuario, menos libros, un usuario puede teer 2 roles, ver que pedo con el login

public class Libreria {

    // @SuppressWarnings("rawTypes") //sirve para poder meter lo que quieras a un
    // arrayList

    // private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ArrayList<Libro> libros = new ArrayList<Libro>();
    public static HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<Rol, ArrayList<Usuario>>();
    private Usuario usuarioEnSesion;

    public Libreria() {
        Gerente gerente = new Gerente("limy", "Tinajero", "4433544310", 20000, "hfdgdigfji", "GFHBGFD", "limy13_",
                "13Noviembre", "fecha");
        Asistente asistente = new Asistente("Juan", "Rivera", "4433210990", 15000, "RUJU1234123", "juan3424", "limy13",
                "fecha");
        usuarios.put(Rol.GERENTE, new ArrayList<>(Arrays.asList(gerente)));
        usuarios.put(Rol.ASISTENTE, new ArrayList<>(Arrays.asList(asistente)));

    }

    Usuario verificarInicioSesion(String nombreUsuario, String contrasena) {
        for (ArrayList<Usuario> listaUsuarios : usuarios.values()) {
            for (Usuario usuario : listaUsuarios) {
                if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
                    usuarioEnSesion = usuario;
                    return usuario;
                }
            }
        }
        return null;
    }

    public void registrarLibro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n---- Registrar libro ----");
        System.out.println("\nIngresa los siguientes datos para continuar con el registro: ");
        System.out.print("\nTítulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Género: ");
        String genero = scanner.nextLine();
        System.out.print("Idioma: ");
        String idioma = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();

        Libro libro = new Libro(titulo, autor, genero, idioma, precio);
        libros.add(libro);
        System.out.println("\nRegistro exitoso");
    }

    public void registrarCliente() {
        Cliente.registrarCliente();
    }

    public void registrarAsistente() {
        Asistente.registrarAsistente();
    }

    public void registrarGerente() {
        Gerente.registrarGerente();
    }

    public static ArrayList<String> obtenerDatosComun(Rol rol) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun = new ArrayList<String>();
        String rolUsuario = rol == Rol.CLIENTE ? "Cliente" : rol == Rol.ASISTENTE ? "Asistente" : "Gerente";
        // condiciones
        // operador
        // ternario,
        // es lo
        // mismo
        // que un
        // if y es
        // para no
        // tantas

        System.out.println(String.format("Bienvenido al registro del %s", rolUsuario));
        System.out.println("\nIngresa los siguientes datos para continuar con el registro: ");
        System.out.print("\nNombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        String telefono = registrarTelefonoUsuario();
        String nombreUsuario = registrarNombreUsuario();
        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine();

        System.out.print("Se registrara fecha de nacimiento: ");
        System.out.println("Ingresa dia dd");
        int ddString = scanner.nextInt();
        System.out.println("Ingresa mes MM");
        int MMString = scanner.nextInt();
        System.out.println("Ingresa ano YYYY");
        int YYYYString = scanner.nextInt();
        LocalDate fecha = LocalDate.of(YYYYString, MMString, ddString);
        DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        String fechaNacimientoString = fecha.format(patron);

        datosComun.addAll(Arrays.asList(nombre, apellido, telefono, nombreUsuario, contraseña, fechaNacimientoString));
        // te
        // agrega
        // todos
        // estos
        // datos
        // de
        // un
        // jalon
        return datosComun;
    }

    public void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("\nNo hay libros registrados aún");
        } else {
            System.out.println("\nLibros en la biblioteca");
            int x = 1;
            for (Libro i : libros) {
                System.out.println("\n---- Libro " + x + " ----\n");
                System.out.println(i.getData());
                x++;
            }
        }
    }

    public void mostrarClientes() {
        Cliente.mostrarClientes();
    }

    public void mostrarAsistentes() {
        Asistente.mostrarAsistentes();
    }

    public void mostrarGerentes() {
        Gerente.mostrarGerentes();
    }

    public void eliminarUsuario(Rol rol) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n---- Eliminar usuario ----\n");
        System.out.print("Ingrese el nombre de usuario que desea eliminar: ");
        String nombreUsuario = scanner.nextLine();

        if (usuarios.containsKey(rol)) {
            ArrayList<Usuario> listaUsuarios = usuarios.get(rol);
            boolean encontrado = false;

            Iterator<Usuario> it = listaUsuarios.iterator();
            while (it.hasNext()) {
                Usuario usuario = it.next();
                if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                    if (!usuarioEnSesion.getNombreUsuario().equals(nombreUsuario)) {
                        it.remove(); // Elimina de forma segura usando Iterator
                        System.out.println("\nUsuario eliminado exitosamente.");
                    } else {
                        System.out.println("\nNo puedes eliminarte a ti mismo.");
                    }
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("\nEste nombre no pertenece a ningún usuario en el rol de " + rol);
            }
        } else {
            System.out.println("\nNo hay usuarios registrados con el rol de " + rol);
        }
    }

    private static Scanner scanner = new Scanner(System.in);

    public static String registrarTelefonoUsuario() {
        boolean telefonoExistente = true;
        String telefono = "";

        do {
            System.out.println("\nIngresa el teléfono: ");
            telefono = scanner.nextLine();
            telefonoExistente = false;

            // Iterar sobre todas las listas de usuarios en el HashMap
            for (ArrayList<Usuario> listaUsuarios : usuarios.values()) {
                for (Usuario usuario : listaUsuarios) {
                    if (usuario.getTelefono().equals(telefono)) {
                        telefonoExistente = true;
                        System.out.println("El teléfono ya se encuentra registrado. Intenta de nuevo.");
                        break;
                    }
                }
                if (telefonoExistente) {
                    break; // Salir del bucle externo si se encuentra el teléfono
                }
            }
        } while (telefonoExistente);

        return telefono;
    }

    public static String registrarNombreUsuario() {
        String nombreUsuario = "";
        boolean nombreUsuarioExistente = true;

        do {
            System.out.println("\nIngresa el nombre de usuario: ");
            nombreUsuario = scanner.nextLine();
            nombreUsuarioExistente = false;

            // Iterar sobre todas las listas de usuarios en el HashMap
            for (ArrayList<Usuario> listaUsuarios : usuarios.values()) {
                for (Usuario usuario : listaUsuarios) {
                    if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                        nombreUsuarioExistente = true;
                        System.out.println("Ya existe un registro con ese nombre de usuario. Intenta de nuevo.");
                        break;
                    }
                }
                if (nombreUsuarioExistente) {
                    break; // Salir del bucle externo si se encuentra el nombre de usuario
                }
            }
        } while (nombreUsuarioExistente);

        return nombreUsuario;
    }

}

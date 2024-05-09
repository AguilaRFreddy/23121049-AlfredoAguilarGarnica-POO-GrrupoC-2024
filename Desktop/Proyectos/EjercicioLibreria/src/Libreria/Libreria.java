package Libreria;
import Libros.Books;
import Libros.LibroTerror;
import Libros.utils.cosntants.Genero;
import usuarios.Administrador;
import usuarios.Asistente;
import usuarios.Cliente;
import usuarios.Usuario;
import usuarios.utils.Rol;

import java.util.*;

public class Libreria {
    public static final HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap <Rol, ArrayList<Usuario>>();
    public static final HashMap<String, Usuario> usuarioVerificar = new HashMap <String, Usuario>();
    public static final HashMap<Genero, ArrayList<Books>> libros = new HashMap <Genero, ArrayList<Books>>();
    public Libreria() {
       inicializarHashmap();
        Asistente newAsistente = new Asistente("Pancho", "Villa", "4432087308",
                13000.0, "PAHCKQI34", "IOCEDKCK", "PANCHOVILLA", "TORTILLACONSAL",
                "fjdnjnfdjn");
        usuarios.get(Rol.ASISTENTE).add(newAsistente);
        usuarioVerificar.put("PANCHOVILLA", newAsistente);
        Cliente newCliente = new Cliente("CHIPI", "CHAPA", "4432087308",
                  "CHIPI", "CAPICHI093", "efjnfekdn");
        usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());
        usuarios.get(Rol.CLIENTE).add(newCliente);
        usuarioVerificar.put("CHIPI", newCliente);
    }
    Scanner leer = new Scanner (System.in);
    //@SuppressWarnings("rayTypes") //Podemos decirle qué ignorar de una lista.
    //En este caso podemos omitir el tipo de ArrayList con el rayTypes
    public Usuario verificarInicioDeSesion(String userName, String contrasena) {
        if (usuarioVerificar.containsKey(userName)) {
            Usuario usuarioAVerificar = usuarioVerificar.get(userName);
            if (usuarioAVerificar.getContraseña().equals(contrasena)) {//Verifica la contraseña
                    return usuarioAVerificar;
                }
            }
        return null;
    }

    public static void registrarCliente() {
        Cliente.registrarCliente();
    }
    public void verCliente() {
        Cliente.mostrarInformacionCliente();
    }
    public void eliminarCliente() {
        Cliente.eliminarCliente();
    }
    public void verListaClientes() {
        Cliente.mostrarClientesEnLista();
    }
    public void modificarCliente() {
    }
    public void registrarAsistente() {
        Asistente.registrarAsistente();
    }
    public void eliminarAsistente() {
        Cliente.eliminarCliente();
    }
    public void verListaAsistentes() {
        Cliente.mostrarClientesEnLista();
    }
    public void modificarAsistente() {
    }
    public void registrarGerente() {
        Administrador.registrarGerente();
    }
    public void eliminarGerente() {
        Administrador.eliminarGerente();
    }
    public void verListaGerentes() {
        Administrador.mostrarGerentesEnLista();
    }
    public void modificarGerente() {
    }
    public void registrarLibroTerror() {
        LibroTerror.registrarLibroTerror();
    }

    public void inicializarHashmap(){
        usuarios.put(Rol.ASISTENTE, new ArrayList<Usuario>());
        usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());
        usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());

        libros.put(Genero.TERROR, new ArrayList<>());
        libros.put(Genero.COMEDIA, new ArrayList<>());
        libros.put(Genero.ACCION, new ArrayList<>());
        
    }
    /*
    public void registrarLibro() {
        System.out.println("Ingresa el título: ");
        String tittle = leer.nextLine();
        System.out.println("Ingresa la fecha de lanzamiento: ");
        String fechaLanzamiento = leer.nextLine();
        System.out.println("Ingresa el nombre del autor: ");
        String authorName = leer.nextLine();
        Books newBook = new Books (tittle, fechaLanzamiento, authorName);
        System.out.println("Código de barras: " + newBook.getLibroID());
        listaLibros.add(newBook);
    }
    public void mostrarLibros(){
        for (Books buscarLibro : listaLibros){
            System.out.println(buscarLibro.mostrarLibros());
        }
    } */
}
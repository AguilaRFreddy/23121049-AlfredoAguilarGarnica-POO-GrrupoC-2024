package usuarios;
import Libreria.Libreria;
import usuarios.utils.Rol;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Cliente extends Usuario {
    private LocalDate fechaRegistro;
    public Cliente(String nombre, String apellido, String telefono, String userName, String contraseña, String fechaNacimiento) {
        super(nombre, apellido, telefono, Rol.CLIENTE, userName, contraseña, fechaNacimiento);
        this.fechaRegistro = LocalDate.now(); //Trae la fecha actual de la computadora.
    }
    public String toString() {
        return String.format("%s, Fecha registro: %s", super.toString(), fechaRegistro);
    }
//    @Override //Indica que se está sobre escribiendo un método, por eso sale el simbolito de crculitos azules..
//    public String mostrarInfo() {
//        return String.format("%s, Fecha registro: %s", super.mostrarInfo(), fechaRegistro);
//    }
public static void registrarCliente() {
    ArrayList<String> datosComun = DatosComun.obtenerDatosComun(Rol.CLIENTE);
    String nameCoustomer = datosComun.get(0);
    String apellidoCoustomer = datosComun.get(1);
    String telphoneCoustomer = datosComun.get(2);
    String usernameCoustomer = datosComun.get(3);
    String passwordCoustomer = datosComun.get(4);
    String fechaNacimiento = datosComun.get(5);

    Cliente newCoustomer = new Cliente (nameCoustomer, apellidoCoustomer,
            telphoneCoustomer, usernameCoustomer, passwordCoustomer, fechaNacimiento);
    if (!Libreria.usuarios.containsKey(Rol.CLIENTE)) {
        Libreria.usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());
    }
    //si es el primer cliente a registrar, va a crear la lista.
    Libreria.usuarios.get(Rol.CLIENTE).add(newCoustomer);

    Libreria.usuarioVerificar.put(usernameCoustomer, newCoustomer);
    //Un hash map puede tener el comportamiento de las claves, en este caso, las listas.
    System.out.println("ID: " + newCoustomer.getId());
    System.out.println("El cliente " + newCoustomer.getUserName() + " registrado con éxito. ");
    System.out.println("Bienvenido al mundo de los libros.");
}
    public static void mostrarInformacionCliente() {
        Scanner leer = new Scanner (System.in);
        System.out.println("Ingrese el nombre de usuario del cliente: ");
        String showCoustumer = leer.nextLine();
        if (Libreria.usuarioVerificar.containsKey(showCoustumer)) {
            Usuario mostrararUsuario = Libreria.usuarioVerificar.get(showCoustumer);
            System.out.println(mostrararUsuario.toString());
        }
    }
    public static void mostrarClientesEnLista(){
        for (Map.Entry<String, Usuario> entry : Libreria.usuarioVerificar.entrySet()) {
            Usuario usuario = entry.getValue();
            if (usuario instanceof Cliente) {
                Cliente mostrarCliente = (Cliente) usuario;
                System.out.println(mostrarCliente.toString());
            }
        }
    }
    public static void eliminarCliente() {
        Scanner leer = new Scanner (System.in);
        System.out.println("Ingresar el nombre de usuario a eliminar:");
        String userToBeRemoved = leer.nextLine();
        if (Libreria.usuarioVerificar.containsKey(userToBeRemoved)) {
            Usuario eliminarUsuario = Libreria.usuarioVerificar.remove(userToBeRemoved);
            Libreria.usuarios.remove(eliminarUsuario);
            System.out.println("\n**El cliente ha sido eliminado.**");
            return;
        }
        System.out.println("No fue posible eliminar ese cliente.");
    }
}
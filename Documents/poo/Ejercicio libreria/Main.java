import Libreria.Menu;
import Usuarios.Asistente;
import Usuarios.Cliente;
import Usuarios.Usuario;
import Usuarios.Gerente;
import Usuarios.utils.Rol;

public class Main {
    public static void main(String[] args) {
       // System.out.println(Rol.ASISTENTE);

       // Cliente - Ver los libros, consultar rentas
       // Asistente - CRUD (create, read, update, delete) - Clientes y libros 
       // Gerente - CRUD completo del sistema además de realizar rentas

       //Cliente cliente = new Cliente("Juan", "Rivera", "443390");
       //System.out.println(cliente.toString());

       //Asistente asistente = new Asistente("Geovanny", "Pérez", "443567", 43.7, "FRED677GG");
       //System.out.println(asistente.toString());

       //Gerente gerente = new Gerente("Hugo", "Garcia", "4474689", 100, "GHFUJJG877", "HUJHHIHJK88");
        //System.out.println(gerente.toString());

        Menu menu = new Menu();
        menu.iniciarSesion();
    }
    
}

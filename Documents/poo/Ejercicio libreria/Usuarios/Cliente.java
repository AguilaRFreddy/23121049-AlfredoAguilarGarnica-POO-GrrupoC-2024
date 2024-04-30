package Usuarios;
import java.time.LocalDate;

import Libreria.Libreria;
import Usuarios.utils.Rol;

public class Cliente extends Usuario {

    private LocalDate fechaRegistro; //Este tipo de datos manejan fechas (local)
    //retorna la fecha de hoy 2024-04-09
    
    public Cliente (String nombre, String apellido, String telefono, String nombreUsuario, String contrasena) {
        super(nombre, apellido, telefono, Rol.CLIENTE, nombreUsuario, contrasena);
        this.fechaRegistro = LocalDate.now(); //accede a la fecha actual
    }

    //toString() obtiene la direccion de memoria
    @Override//existe en la clase padre, pero la estamos sobreescribiendo en la clase hija

    public String toString() { //Aqui  lo estamos sobreescribiendogracias al override y con eso el programa toma primero en cuenta la clase hija que el metodo de la clase padre
        return String.format("%s, Fecha de registro: %s", super.toString(), this.fechaRegistro);
    }
   

    public void registrarCliente() {
        ArrayList<String> datosComun = Libreria.obtenerDatosComun(Rol.CLIENTE);
        
        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String nombreUsuario = datosComun.get(3);
        String contraseña = datosComun.get(4);

        Cliente cliente = new Cliente(nombre, apellido, telefono, nombreUsuario, contraseña);

        if(!usuarios.containsKey(Rol.CLIENTE)) {
            usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());   //eso va a entrar cuando la llave no exista, o sea que el hash este vacio, si no lo va a ignorar (en la segunda vez)

        }

        usuarios.get(Rol.CLIENTE).add(cliente); //aqui lo agrega en un lista especifica de clientes
        System.out.println("\nCliente registrado exitosamente");
    }

}

package usuarios;
import usuarios.utils.Rol;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Usuario {
//    Suponer que el gerente y asistente tengan un metodo para ver entrada y salida.
    private static int CANTIDAD_USUARIOS = 1;
    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private Rol rol;
    private String userName;
    private String contraseña;
    private String fechaNacimiento;

    public Usuario(String nombre, String apellido, String telefono, Rol rol, String userName, String contraseña, String fechaNacimiento) {
        this.id = CANTIDAD_USUARIOS;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.rol = rol;
        this.fechaNacimiento = fechaNacimiento;
        this.userName = userName;
        this.contraseña = contraseña;
        CANTIDAD_USUARIOS++;
    }
    @Override
    public String toString() {
        return String.format("ID: %d, Nombre completo: %s %s, Teléfono: %s, Rol: %s , Nombre de usuario: %s Fecha De Nacimiento : %s ",
                id, nombre, apellido, telefono, rol, userName, fechaNacimiento);
    }

    public static int getCantidadUsuarios() {
        return CANTIDAD_USUARIOS;
    }

    public static void setCantidadUsuarios(int cantidadUsuarios) {
        CANTIDAD_USUARIOS = cantidadUsuarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
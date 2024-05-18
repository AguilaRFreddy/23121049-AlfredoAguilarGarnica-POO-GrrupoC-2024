package utilsGlobal;
import usuarios.Usuario;

/*
Proceso 1.
    Iniciar sesión implica: Valdiar objetos.
        1. Si sale bien, devolvemos el usuario.
            Mandar llamar a UsuarioEnSesion
            UsuarioEnSesion.setUsuarioActual(usuario)
        2. Sino, regresamos un error.
    Suponiendo que esamos en la clase para editar los datos:
        usuario = UsuarioEnSesion.obtenerInstancia() -- Para valdiar que modificamos la información de ese usuario, un sólo usuario.
    En caso de que regresemos al login,

        */
public class UsuarioEnSesion {
    private static UsuarioEnSesion instance;
    private Usuario usuarioActual;
//    Esta instancia es la que está guardando el objeto y sus datos, por lo que debemos usar gets para retornarla.

    private UsuarioEnSesion () {}
    public static UsuarioEnSesion obtenerInstancia () {
        if (instance == null) {
            instance = new UsuarioEnSesion();
        }
        return instance;
    }
    public void cerrarSesion() {
        boolean datosCorrectos = true;
        String usuario = null;
        String contrasena = null;
    }
    public Usuario getUsuarioActual() {
        return usuarioActual;
    }
    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }
    public boolean hayUsuarioEnSesion () {
        return usuarioActual == null;
//        Si es igual a null, no hay nadie en sesión.
    }
}
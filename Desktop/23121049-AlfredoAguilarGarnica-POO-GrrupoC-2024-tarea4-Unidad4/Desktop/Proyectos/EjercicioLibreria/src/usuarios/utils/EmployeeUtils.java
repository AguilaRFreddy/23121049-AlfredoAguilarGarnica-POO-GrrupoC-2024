package usuarios.utils;

public interface EmployeeUtils {
    /*
    Gerente
    -Con huella.
    Asistente
    -Con correo.
    La clase permite que sólo gerente y asistente pueda hacer esto,
     para evitar meterlo en Usuarios y que otros roles lo usen.
    */
    public void checkEntry();
    public void checkOut();
}

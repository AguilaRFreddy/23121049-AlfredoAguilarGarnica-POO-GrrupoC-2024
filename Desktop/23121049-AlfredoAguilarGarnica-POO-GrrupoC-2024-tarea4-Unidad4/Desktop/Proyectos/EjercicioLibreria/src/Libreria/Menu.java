package Libreria;
import usuarios.Usuario;
import utilsGlobal.UsuarioEnSesion;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Menu {
    Scanner leer = new Scanner(System.in);
    Libreria libreria = new Libreria();
    public void inicioSistema () {
        int opcionInicial = 0;
        DataManager.leerUsuariosJSON();
         DataManager.leerLibrosJSON();
        do {
        System.out.println("Bienvenido a la Biblioteca.");
        System.out.println("Escribir la opción con número.");
        System.out.println("1. Inicar sesión. 2. Salir del programa.");
        opcionInicial = leer.nextInt();
            switch (opcionInicial) {
                case 1:
                    iniciarSesion();
                    break;
                case 2:
                    System.out.println("Hasta la próxima.");
                    break;
            }
        } while(opcionInicial != 2);
    }
    public void iniciarSesion() {
        boolean datosCorrectos = false;
        do {System.out.println("Iniciar sesión para continuar.");
            System.out.println("Usuario: ");
            String usuario = leer.nextLine();
            System.out.println("Contraseña: ");
            String contrasena = leer.nextLine();
            Usuario usuarioActual = libreria.verificarInicioDeSesion(usuario, contrasena);
            if (usuarioActual != null) {
            //Datos correctos y mostrar el menú correspondido.
               datosCorrectos = true;
                UsuarioEnSesion.obtenerInstancia().setUsuarioActual(usuarioActual);
               seleccionarMenu();
            }
            else {
                System.out.println("Usuario o contraseña incorrectos Inténtelo de nuevo, por favor.");
            }
        } while (!datosCorrectos);
    }
    public void seleccionarMenu() {
        Usuario usuario =  UsuarioEnSesion.obtenerInstancia().getUsuarioActual();
        switch (usuario.getRol()) {
            case CLIENTE -> mostrarMenuParaClientes();
            case ASISTENTE -> mostrarMenuParaAsistentes();
            case GERENTE -> mostrarMenuParaGerente();
        }
    }
    private void mostrarMenuParaClientes() {
        //Hacer menú para cada usuario con sus opciones,
        // pero cada caso será vacío, sólo tendrá el break.
        System.out.println("Menú de Cliente.");
        System.out.println("\n1. Ver libros. \n2. Consultar libros rentados. " +
                "\n3. Mostrar mis datos. \n4. Editar mis datos. \n5.Salir.");
        System.out.println("Ingrese la opción a realizar: ");
        int opcionCliente = leer.nextInt();
        do {
            switch (opcionCliente) {
                case 1:
                    leer.nextLine();
                    break;
                case 2:
                    leer.nextLine();
                    break;
                case 3:
                    libreria.verCliente();
                    leer.nextLine();
                    break;
                case 4:
                    leer.nextLine();
                    break;
                case 5:
                    DataManager.escribirUsuariosJSON(Libreria.usuarios);
                    DataManager.escribirLibrosJSON(Libreria.libros);
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    System.out.println("No olvides en qué página te quedaste. Hasta la próxima. ");
                    break;
                default :
                    System.out.println("Ingrese una opción existente.");
            }
        } while(opcionCliente != 5);
    }
    private void mostrarMenuParaAsistentes() {
        System.out.println("Menú de Asistente.");
        System.out.println();
        int opcionCliente;
        do {
        System.out.println("\n1. Registrar cliente. " +
                "\n2. Registrar libro. " +
                "\n3. Mostrar clientes." +
                "\n4. Mostrar libro." +
                "\n5. Mostrar libros rentados." +
                "\n6. Actualizar información de cliente." +
                "\n7. Actualizar información de Libro." +
                "\n8. Eliminar cliente." +
                "\n9. Eliminar Libro. MOSTRAR CLIENTE INFO." +
                "\n10. Mostrar listra de clientes." +
                "\n11. Salir.");
        System.out.println();
            System.out.println("Ingrese la opción a realizar: ");
             opcionCliente = leer.nextInt();
            switch (opcionCliente) {
                case 1:
                    leer.nextLine();
                    libreria.registrarCliente();
                    break;
                case 2:
                    menuRegistrarLibro();
                    leer.nextLine();
                    break;
                case 3:
                    leer.nextLine();
                    libreria.verCliente();
                    break;
                case 4:
                    leer.nextLine();
                    break;
                case 5:
                    leer.nextLine();
                    break;
                case 6:
                    leer.nextLine();
                    break;
                case 7:
                    leer.nextLine();
                    break;
                case 8:
                    leer.nextLine();
                    libreria.eliminarCliente();
                    break;
                case 9:
                    leer.nextLine();
                    libreria.verCliente();
                    break;
                case 10:
                    leer.nextLine();
                    libreria.verListaClientes();
                    break;
                case 11:
                    DataManager.escribirUsuariosJSON(Libreria.usuarios);
                    DataManager.escribirLibrosJSON(Libreria.libros);
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    System.out.println("Hasta la próxima. ");
                    break;
                default :
                    System.out.println("Ingrese una opción existente.");
            }
        } while(opcionCliente != 11);
    }
    private void mostrarMenuParaGerente() {
        System.out.println();
        System.out.println("Menú de Gerente.");
        System.out.println();
        int opcionGerente;
        do {
        System.out.println("1. Registrar cliente. " +
                "\n2. Registrar libro. " +
                "\n3. Registrar asistente." +
                "\n4. Registrar gerente." +
                "\n5. Mostrar clientes." +
                "\n6. Mostrar libros." +
                "\n7. Mostrar libros rentados." +
                "\n8. Mostrar asistentes." +
                "\n9. Mostrar gerentes." +
                "\n10. Actualizar información de cliente." +
                "\n11. Actualizar información de Libro." +
                "\n12. Actualizar información de asistente." +
                "\n13. Eliminar cliente." +
                "\n14. Eliminar Libro." +
                "\n15. Eliminar asistente." +
                "\n16. Eliminar gerente." +
                "\n17. Rentar libro." +
                "\n18. Salir.");
        System.out.println("Ingrese la opción a realizar: ");
         opcionGerente = leer.nextInt();
            switch (opcionGerente) {
                case 1:
                    leer.nextLine();
                    libreria.registrarCliente();
                    break;
                case 2:
                    menuRegistrarLibro();
                    break;
                case 3:
                    leer.nextLine();
                    libreria.registrarAsistente();
                    break;
                case 4:
                    leer.nextLine();
                    libreria.registrarGerente();
                    break;
                case 5:
                    leer.nextLine();
                    libreria.verListaClientes();
                    break;
                case 6:
                    leer.nextLine();
                    break;
                case 7:
                    leer.nextLine();
                    libreria.verListaAsistentes();
                    break;
                case 8:
                    leer.nextLine();
                    libreria.verListaAsistentes();
                    break;
                case 9:
                    libreria.verListaGerentes();
                    leer.nextLine();
                    break;
                case 10:
                    leer.nextLine();
                    break;
                case 11:
                    leer.nextLine();
                    break;
                case 12:
                    leer.nextLine();
                    break;
                case 13:
                    libreria.eliminarCliente();
                    break;
                case 14:
                    leer.nextLine();
                    break;
                case 15:
                    leer.nextLine();
                    libreria.eliminarAsistente();
                    break;
                case 16:
                    libreria.eliminarGerente();
                    leer.nextLine();
                    break;
                case 17:
                    leer.nextLine();
                    break;
                case 18:
                    System.out.println("Hasta la próxima. ");
                    DataManager.escribirUsuariosJSON(Libreria.usuarios);
                    DataManager.escribirLibrosJSON(Libreria.libros);
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    break;
                default :
                    System.out.println("Ingrese una opción existente.");
            }
        } while(opcionGerente != 18);
    }
//Clase singleton. Sólo permite crear un objeto, es decir, tiene un sólo constructo y para poder crear algo debe salir algo.
//En este caso, va a permitir dar acceso a los datos del usuario que inicie sesión, hasta que la cierre. Es de tipo privado y crea un método estático.
//Este método invoca al constructor privado para crear un objteto y lo guarda en un campo estático, las siguientes llamadas a este método en cualquier parte del programa, devuelven el objeto almacenado.
public void menuRegistrarLibro(){
    Scanner leer = new Scanner(System.in);
    int opcionRegistrarLibro = 0;
    boolean opcionCorrecta = false;
    do {

        System.out.println("Señala el tipo de libro que desea registrar: ");
        System.out.println("1. Accion 2. Comedia. 3. Terror. 4. Salir");

        while(!opcionCorrecta){
        try {
            opcionRegistrarLibro = leer.nextInt();

            if (opcionRegistrarLibro>4 || opcionRegistrarLibro<1){
                throw new InputMismatchException();
            }

            opcionCorrecta = true;

        } catch (InputMismatchException e) {
            System.out.println("Ingresaste un valor incorrecto. Inténtelo de nuevo, por favor.");
            leer.nextLine();
        }
        }
        opcionCorrecta = false;
//        Aquí podemos ver que hay dos excepciones. Cual sea de las dos que se cumpla,
//        mandará el mensaje dentro del catch.
        switch (opcionRegistrarLibro){
            case 1:
                System.out.println("Acción.");
                break;
            case 2:
                System.out.println("Comedia.");
                break;
            case 3:
                System.out.println("Terror.");
                break;
        }
    } while(opcionRegistrarLibro != 4);
    leer.nextLine();
}
}
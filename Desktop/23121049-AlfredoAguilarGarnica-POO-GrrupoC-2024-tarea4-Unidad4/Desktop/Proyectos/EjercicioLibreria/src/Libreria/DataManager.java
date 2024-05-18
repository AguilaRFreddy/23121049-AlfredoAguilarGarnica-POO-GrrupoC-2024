package Libreria;
import Libros.Books;
import Libros.utils.cosntants.Genero;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import usuarios.Usuario;
import usuarios.utils.Rol;

public class DataManager {

    // Método para escribir los datos de libros en un archivo JSON
    public static void escribirLibrosJSON(HashMap<Genero, ArrayList<Books>> librosPorCategoria) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("libros.json")) {
            gson.toJson(librosPorCategoria, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para leer los datos de libros desde un archivo JSON
    public static Map<String, List<Books>> leerLibrosJSON() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("libros.json")) {
            return gson.fromJson(reader, Map.class); // Gson infiere el tipo de mapa automáticamente
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para escribir los datos de usuarios en un archivo JSON
    public static void escribirUsuariosJSON(HashMap<Rol, ArrayList<Usuario>> usuariosPorRol) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("usuarios.json")) {
            gson.toJson(usuariosPorRol, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para leer los datos de usuarios desde un archivo JSON
    public static Map<Rol, List<Usuario>> leerUsuariosJSON() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("usuarios.json")) {
            return gson.fromJson(reader, Map.class); // Gson infiere el tipo de mapa automáticamente
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

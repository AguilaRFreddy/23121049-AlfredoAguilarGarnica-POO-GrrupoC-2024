import Libreria.Menu;
import Libreria.Libreria;
import usuarios.Asistente;
import usuarios.Cliente;
import usuarios.utils.Rol;

import java.time.format.DateTimeFormatter;

public class Main {
    public static void main (String [] args) {
        Menu menuPrueba = new Menu();
        menuPrueba.inicioSistema();
    }
}

//LocalDate
/*
Se puede usar localDate.now(id de la zona donde se quiere saber la hora)
Con LocalDate.of(año, mes, dia), se puede usar para generar una fecha específica.
 */

//LocalTime
/*
LocalTime.now(sirve para saber la hora exacta, con hora, minutos y segundos)
LocalTime.of(Para agregar de manera manual las horas, minutos y segundos)
 */

//LocalDayTime
/*
LocalDayTime.now(Agrega la fecha completa y una hora, tiene una T intermedia para separar
entre la fecha y la hora.)
LocalDayTime.of(podemos pasarle un LocalDate y un LocalTime, para que los junte)
LocalDayTime
 */

//DateTimeFormatter
/*
Sirve para modificar el formato del LocalDateTime, aplicado en cualquier forma que le estemos
pasando.
DateTimeFormatter --- = DateTimeFormatter.ofParttern(aquí dentro va el nuevo símbolo a
implementar)
EJEMPLO
DateTimeFormatter prueba = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss")
También puede pasarse a un String, poniendo lo siguiente.
String timePrueba = fechaCompleta.format(prueba)
 */

//Nomenclatura.
/*
    YYYY - year
    dd - day of the month
    MM - month of the year
    HH -hour
    mm - minutes
    ss - seconds
*/

//Cada uno de estas funciones tiene diferentes modos de uso, según los datos que le
//querramos pasar.



//TRY-CATCH
/*
try{
}catch(ArithmeticExeption error){
sout(error)
}
Ignora el error y manda un aviso para poder seguir con el flujo del programa.
catch(e) = Puede haber diferentes errores, usualmente sólo se pone la e, pero hay más.
Pueden ponerse varios catch.
Exception error = Excepción genérica. Revisa todo el programa para encontrar los errores.
 */

//Finally
/*
Parte del try-catch
Sirve para hacer el proceso, marcar el error, el tipo de error.
Sirve para hacer una operación extra.

 */
import java.util.Scanner;
public class Circulo extends Figura {
    Scanner scanner = new Scanner(System.in);
    @Override
    protected void area() {
        System.out.println("Se calculara el area");
     System.out.println("Ingresa radio");
     float radio = scanner.nextFloat();
     float pi = (float) 3.1416;
     float A = pi * radio*radio ;
System.out.println("El area es: " + A);
    }

    @Override
    protected void primetro() {
        System.out.println("Se calculara Perimetro");
      System.out.println("Ingresa lado diametro"); 
      float diametro = scanner.nextFloat();
      float pi = (float) 3.1416;
     float P = pi * diametro ;
     System.out.println("El perimetro es: "+ P);
    }

}

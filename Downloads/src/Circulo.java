import java.util.Scanner;
public class Circulo implements Figura {
    Scanner scanner = new Scanner(System.in);
    @Override
    public void area() {
        System.out.println("\nSe calculara el area Circulo");
     System.out.println("Ingresa radio");
     float radio = scanner.nextFloat();
     float pi = (float) 3.1416;
     float A = pi * radio*radio ;
System.out.println("El area es: " + A);
    }

    @Override
    public void perimetro() {
        System.out.println("\nSe calculara Perimetro Circulo");
      System.out.println("Ingresa lado diametro"); 
      float diametro = scanner.nextFloat();
      float pi = (float) 3.1416;
     float P = pi * diametro ;
     System.out.println("El perimetro es: "+ P);
    }

}

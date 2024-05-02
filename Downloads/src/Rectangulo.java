import java.util.Scanner;

public class Rectangulo implements Figura {
    Scanner scanner = new Scanner(System.in);
    @Override
    public void area() {
        System.out.println("\n Se calculara el area Rectangulo");
     System.out.println("Ingresa base");
     float b = scanner.nextFloat();
     System.out.println("Ingresa altura");
     float h = scanner.nextFloat();
     float A = (b*h);
System.out.println("El area es: " + A);
    }

    @Override
    public void perimetro() {
        System.out.println("\n Se calculara Perimetro Rectangulo");
      System.out.println("Ingresa base"); 
      float l1 = scanner.nextFloat();
      System.out.println("Ingresa altura"); 
      float l2 = scanner.nextFloat(); 
     float P = 2*l1 + 2*l2 ;
     System.out.println("El perimetro es: "+ P);
    }

}

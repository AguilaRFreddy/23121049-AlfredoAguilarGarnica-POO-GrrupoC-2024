import java.util.Scanner;

public class Rectangulo extends Figura {
    Scanner scanner = new Scanner(System.in);
    @Override
    protected void area() {
        System.out.println("Se calculara el area");
     System.out.println("Ingresa base");
     float b = scanner.nextFloat();
     System.out.println("Ingresa altura");
     float h = scanner.nextFloat();
     float A = (b*h);
System.out.println("El area es: " + A);
    }

    @Override
    protected void primetro() {
        System.out.println("Se calculara Perimetro");
      System.out.println("Ingresa base"); 
      float l1 = scanner.nextFloat();
      System.out.println("Ingresa altura"); 
      float l2 = scanner.nextFloat(); 
     float P = 2*l1 + 2*l2 ;
     System.out.println("El perimetro es: "+ P);
    }

}

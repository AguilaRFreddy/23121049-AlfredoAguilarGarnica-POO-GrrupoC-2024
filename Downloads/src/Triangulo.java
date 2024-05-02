import java.util.Scanner;

public class Triangulo implements Figura {
Scanner scanner = new Scanner(System.in);
    @Override
    public void area() {
        System.out.println("\nSe calculara el area Triangulo ");
     System.out.println("Ingresa base");
     float b = scanner.nextFloat();
     System.out.println("Ingresa altura");
     float h = scanner.nextFloat();
     float A = (b*h)/2;
System.out.println("El area es: " + A);
    }

    @Override
    public void perimetro() {
        System.out.println("\nSe calculara Perimetro Triangulo ");
      System.out.println("Ingresa lado 1"); 
      float l1 = scanner.nextFloat();
      System.out.println("Ingresa lado 2"); 
      float l2 = scanner.nextFloat();
      System.out.println("Ingresa lado 3"); 
      float l3 = scanner.nextFloat();
     float P = l1 + l2 + l3;
     System.out.println("El perimetro es: "+ P);
    }


}

import java.util.Scanner;

public class Cuadrado implements Figura {
    Scanner scanner = new Scanner(System.in);
    @Override
    public void area() {
        System.out.println("\nSe calculara el area Cuadrado");
        System.out.println("Ingresa lado");
        float L = scanner.nextFloat();    
        float A = L*L;
   System.out.println("El area es: " + A);
    }

    @Override
    public void perimetro() {
        System.out.println("\nSe calculara Perimetro Cuadrado");
        System.out.println("Ingresa lado"); 
        float l1 = scanner.nextFloat();
       float P = 4*l1;
       System.out.println("El perimetro es: "+ P);
    }

}


   

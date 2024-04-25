import java.util.Scanner;

public class Cuadrado extends Figura {
    Scanner scanner = new Scanner(System.in);
    @Override
    protected void area() {
        System.out.println("Se calculara el area");
        System.out.println("Ingresa lado");
        float L = scanner.nextFloat();    
        float A = L*L;
   System.out.println("El area es: " + A);
    }

    @Override
    protected void primetro() {
        System.out.println("Se calculara Perimetro");
        System.out.println("Ingresa lado"); 
        float l1 = scanner.nextFloat();
       float P = 4*l1;
       System.out.println("El perimetro es: "+ P);
    }

}


   

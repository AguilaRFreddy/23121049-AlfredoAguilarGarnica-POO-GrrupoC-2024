import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int op;
        do {
    
        System.out.println("Ingresa el caso de la figura");
        System.out.println("1 triangulo");
        System.out.println("2 cuadrado");
        System.out.println("3 rectangulo");
        System.out.println("4 circulo");
        System.out.println("5 SALIR");
 op = scanner.nextInt();
switch (op) {
    case 1:
        Triangulo triangulo = new Triangulo();
        triangulo.area();
        triangulo.perimetro();

        break;
        case 2:
        Cuadrado cuadrado = new Cuadrado();
        cuadrado.area();
        cuadrado.perimetro();

        break;
        case 3:
        Rectangulo rectangulo = new Rectangulo();
        rectangulo.area();
        rectangulo.perimetro();
        break;
        case 4:
        Circulo circulo = new Circulo();
        circulo.area();
        circulo.perimetro(); 
        break;

    default:
        break;
}
} while (op!=5);
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o numerador: ");
        var numerador = scanner.nextInt();

        System.out.print("Informe o denominador: ");
        var denominador = scanner.nextInt();

        try {
            int resultado = numerador/denominador;
            System.out.println(numerador/denominador);
        } catch (ArithmeticException e) {
            System.out.println("Opa! Não é possível dividir por zero!");
        }
    }
}
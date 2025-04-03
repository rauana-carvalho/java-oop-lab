import java.util.InputMismatchException;
import java.util.Scanner;

public class Divisao {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Insira o primeiro número");
            double primeiroNumero = input.nextDouble();
            System.out.println("Insira o segundo número");
            double segundoNumero = input.nextDouble();
            
            if (segundoNumero == 0) {
                throw new ArithmeticException("Impossível dividir por zero");
            }
            
            double division = primeiroNumero / segundoNumero;
            System.out.printf("A divisão dos dois números é %.2f%n", division);
        } catch (InputMismatchException ex) {
            System.out.println("Ambos os números devem ser double.");
        } catch (ArithmeticException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

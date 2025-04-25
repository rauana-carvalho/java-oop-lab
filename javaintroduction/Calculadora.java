package javaintroduction;
//java calculadora - run
//javac calculadora.java - compile


public class Calculadora {

    public static double soma(double x, double y) {
        return x + y;
    }

    public static double sub(double x, double y) {
        return x - y;
    }

    public static double mult(double x, double y) {
        return x * y;
    }

    public static double div(double x, double y) {
        if (y != 0) {
            return x / y;
        } else {
            System.out.println("Não é possível dividir por 0");
            return Double.NaN;
        }
    }

    public static void main(String[] args) {
        double a = 2.6, b = 1.0;

        System.out.println("Soma: " + soma(a, b));
        System.out.println("Subtração: " + sub(a, b));
        System.out.println("Multiplicação: " + mult(a, b));
        System.out.println("Divisão: " + div(a, b));
    }
}

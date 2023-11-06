import org.w3c.dom.ls.LSOutput;

public class Refactoring {
    public static void main(String[] args) {
        System.out.print("1 + 2 = ");
        int resultado = getResultado(1, 2);

        System.out.print(resultado);
    }

    private static int getResultado(int sumando1, int sumando2) {
        return sumando1 + sumando2;
    }


    // Método para restar números
    public int subtract(int num1, int num2) {
        int result;
        result = num1 - num2;
        return result;
    }

    // Método para realizar la multiplicación
    public int multiply(int num1, int num2) {
        int result;
        result = num1 * num2;
        return result;
    }
}

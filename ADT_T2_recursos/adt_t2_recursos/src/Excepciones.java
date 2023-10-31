public class Excepciones {

    public static void main(String[] args) {

        try {
            getInt();
            System.out.println("Tras convertir en entero");
            return;
        }
        catch (NumberFormatException | NullPointerException e){
            // Código que ejecutaremos en caso de este tipo de excepción
            System.out.println("Contenido no compatible");
        }
        finally {
            System.out.println("En block finally");
        }

        System.out.println(printNumber());

    }

    private static void getInt () {
        int myInt = Integer.parseInt("patata");
    }

    private static int printNumber()  {
        try {
            return 3;
        }
        catch (Exception e) {
            return 4;
        }
        finally {
            return 5;
        }
    }
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {
    public static void main(String[] args) {

        //OPCIÓN 1
        lecturaSimple();
        //OPCIÓN 2
        lecturaConRecursos();
    }

    public static void lecturaSimple() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("archivo.txt"));

            // Operaciones con el reader
            imprimirPrimeraLinea(reader);

        } catch (IOException e) {
            // Manejo de excepción
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // Manejo de excepción al cerrar
                }
            }
        }
    }

    public static void lecturaConRecursos () {
        try (BufferedReader reader = new BufferedReader(new FileReader("archivo.txt"))) {

            // Operaciones con el reader
            imprimirPrimeraLinea(reader);

        } catch (IOException e) {
            // Manejo de excepción
        }
    }

    public static void imprimirPrimeraLinea(BufferedReader reader) throws IOException {
        String linea = reader.readLine();
        System.out.println(linea);
    }
}

//Clase donde
import java.io.File;

public class Booleanos {
    public static void main(String[] args) {
        // Crear un objeto File para un archivo específico
        File file = new File("archivos_prueba/archivo.txt");

        if (!file.exists()){
            System.out.println("No existe el fichero o directorio.");
        } else if (file.isDirectory()) {
            System.out.println("Es un directorio.");
        }

        // Verificar si el archivo puede ser leído
        if (file.canRead()) {
            System.out.println("El archivo es legible.");
        } else {
            System.out.println("El archivo no es legible.");
        }

        // Verificar si el archivo puede ser escrito
        if (file.canWrite()) {
            System.out.println("El archivo es escribible.");
        } else {
            System.out.println("El archivo no es escribible.");
        }

        // Verificar si el archivo puede ser ejecutado
        if (file.canExecute()) {
            System.out.println("El archivo es ejecutable.");
        } else {
            System.out.println("El archivo no es ejecutable.");
        }
    }
}

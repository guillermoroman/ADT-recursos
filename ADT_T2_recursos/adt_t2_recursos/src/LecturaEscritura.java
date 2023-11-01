import java.io.File;
import java.io.IOException;

public class LecturaEscritura {
    public static void main(String[] args) {

        try {
            File fich = new File("ficheroDePrueba.txt");
            if (fich.createNewFile()) {
                System.out.println("Fichero creado: " + fich.getName());
            } else {
                System.out.println("El fichero ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error.");
            e.printStackTrace();
        }
    }
}

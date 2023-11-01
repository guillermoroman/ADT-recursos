import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LecturaEscritura {
    public static void main(String[] args) {

        escribirEnArchivo("ficheroDePrueba.txt");

        imprimirArchivo("ficheroDePrueba.txt");


    }
    public static void escribirEnArchivo(String nombreDeArchivo){

        try {
            File fich = new File(nombreDeArchivo);
            if (fich.createNewFile()) {
                System.out.println("Fichero creado: " + fich.getName());
            } else {
                System.out.println("El fichero ya existe.");
            }

            FileWriter fw = new FileWriter(fich);
            fw.write("Este es un texto escrito con FileWriter");
            fw.close();

            BufferedWriter bw = new BufferedWriter(new FileWriter(fich, true));
            bw.write("\nEsta es una nueva linea.");

            bw.close();

        } catch (IOException e) {
            System.out.println("Ha ocurrido un error.");
            e.printStackTrace();
        }
    }
    public static void imprimirArchivo(String nombreDeArchivo){

    }
}

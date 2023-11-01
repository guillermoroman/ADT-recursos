import java.io.*;

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
        try {
            File fich = new File(nombreDeArchivo);
            FileReader fr = new FileReader(fich);

            int caracter;

            while ((caracter = fr.read()) != -1){
                System.out.print((char)caracter);
            }
            fr.close();

        } catch (IOException e) {
            System.out.println("Error de lectura");
            e.printStackTrace();
        }
    }
}

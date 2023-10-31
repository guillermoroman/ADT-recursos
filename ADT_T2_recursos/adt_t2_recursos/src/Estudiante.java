import java.io.IOException;
import java.io.RandomAccessFile;

// Ejemplo de uso de RandomAccessFile como pequeña base de datos
public class Estudiante {
    private int id;
    private String nombre;
    private double calificacion;

    public static void main(String[] args) {
        añadirEstudiantesDeEjemplo();
    }

    public static void añadirEstudiantesDeEjemplo() {

        Estudiante[] estudiantes = {
                new Estudiante(1, "Juan",  8.56),
                new Estudiante(2, "María", 6.83),
                new Estudiante(3, "Sara", 9.23),
                new Estudiante(4, "Jacinto", 5.45),
                new Estudiante(5, "Mario", 7.83)
        };

        try {
            RandomAccessFile raf = new RandomAccessFile("estudiantes.dat", "rw");

            for (Estudiante estudiante : estudiantes) {
                raf.writeInt(estudiante.getId());
                raf.writeChars(String.format ("%-20s", estudiante.getNombre()));
                raf.writeDouble(estudiante.getCalificacion());

            }

            raf.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public Estudiante (int id, String nombre, double calificacion) {
        this.id = id;
        this.nombre = nombre;
        this.calificacion = calificacion;
    }

    private String getNombre() {
        return this.nombre;
    }

    private double getCalificacion(){
        return this.calificacion;
    }

    private int getId(){
        return this.id;
    }

    public String toString() {
        return "Nombre: " + this.getNombre() + ". ID: " + this.getId() + ". Calificación: " + this.getCalificacion();
    }
}

// Ejemplo de uso de RandomAccessFile como pequeña base de datos
public class Estudiante {
    private int id;
    private String nombre;
    private double calificacion;

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

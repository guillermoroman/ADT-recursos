# RandomAccessFile
Vamos a crear un programa que nos ayude a comprender cómo funciona la clase RandomAccessFile y el acceso aleatorio a archivos. Cuando hablamos de acceso aleatorio, recordemos que nos referimos a poder acceder a una parte deseada de un archivo, sin necesidad de leer previamente los registros que se encontrarán en el archivo antes del lugar al que queremos acceder.

Veamos primero una representación de cómo se guardan en memoria
## 1. Creación de la clase Estudiante
1. Declarar atributos
```java
private int id;  
private String nombre;  
private double calificacion;
```
2. Crear constructor
```java
public Estudiante (int id, String nombre, double calificacion) {  
    this.id = id;  
    this.nombre = nombre;  
    this.calificacion = calificacion;  
}
```
3. Crear getters
```java
private String getNombre() {  
    return this.nombre;  
}  
  
private double getCalificacion(){  
    return this.calificacion;  
}  
  
private int getId(){  
    return this.id;  
}
```
5. Crear toString
```java
public String toString() {  
    return "Nombre: " + this.getNombre() + ". ID: " + this.getId() + ". Calificación: " + this.getCalificacion();  
}
```

## 2. Método añadirEstudiantesDeEjemplo
1. Crear array
```java
Estudiante[] estudiantes = {  
        new Estudiante(1, "Juan",  8.56),  
        new Estudiante(2, "María", 6.83),  
        new Estudiante(3, "Sara", 9.23),  
        new Estudiante(4, "Jacinto", 5.45),  
        new Estudiante(5, "Mario", 7.83)  
};
```
2. Imprimir por pantalla los contenido del array con un foreach para comprobar que funciona
```java
for (Estudiante estudiante : estudiantes) {  
    System.out.println(estudiante);  
}
```


## 3. Escribir con raf en archivo.dat (solo primer registro)
1. Crear objeto `RandomAccessFile` y meterlo en bloque `try{} catch {}`, y cerrarlo. Le pasamos la ruta de acceso y el modo lectura o lectura y escritura(`"r"`, `"rw"`, ...).
```java
try{
	RandomAccessFile raf = new RandomAccessFile("estudiantes.dat", "rw");
	raf.close();
}
```

2. De forma alternativa se puede utilizar un `try-with-resources`para no tener que cerrar el archivo manualmente:
```java
try (RandomAccessFile raf = new RandomAccessFile("estudiantes.dat", "rw")) {
    
} catch (IOException e) {
    e.printStackTrace();
}
```

4. Sentencias para el int y el double
```java
raf.writeInt(estudiante.getId());  
raf.writeDouble(estudiante.getCalificacion());
```

5. Explicar el formateo de cadenas
   `"%-20s"`: Es una cadena de formato que indica cómo se desea formatear la cadena de entrada.
   - `%`: Es el carácter de inicio para indicar que se va a aplicar un formato.
   - `-`: Indica que el texto se alineará a la izquierda.
   - `20`: Especifica el ancho mínimo de la cadena. Si la cadena de entrada es más corta que este ancho, se rellenará con espacios en blanco hasta alcanzar este ancho.
   - `s`: Indica que se está formateando una cadena de texto (`String`).
   Ejemplo para main:
   ```java
   String  ejemplo = "qué tal?";  
   System.out.println(ejemplo);  
   String ejemplo2 = String.format ("%-20s", ejemplo);  
   System.out.println(ejemplo2);
   ```
6. Sentencia de escritura para el nombre
```java
raf.writeChars(String.format("%-20s", estudiante.getNombre()));
```

## 4. Pruebas de lectura

1. Comencemos a leer el primer registro.
```java
int id = raf.readInt();  
System.out.println(id);  
```

2. Prueba lectura errónea a propósito: leer un `double`o un `char`para ver cómo el programa nos interpreta el valor binario que encuentra guardado.
```java
double idErroneo = raf.readDouble();  
System.out.println(idErroneo);
```

3. Lo que yo quiero leer aquí es un `String`o, visto de otra forma, un array de `char`. Sacamos los caracteres a un array `char[]`y lo convertimos en `String`. Hacemos un `trim()`

```java
char[] nombreChars = new char[20];  
for (int i = 0; i < nombreChars.length; i++) {  
    nombreChars[i] = raf.readChar();  
}  
String nombre = new String (nombreChars).trim();
```

4. Leemos el double.
```java
double calificacion = raf.readDouble();
```

5. Creamos una instancia de estudiante con los datos obtenidos y lo imprimimos por pantalla.
```java
Estudiante estudiante = new Estudiante(id, nombre, calificacion);  
System.out.println(estudiante);
```

## 5. Implementamos el salto de registro

1. Podemos probar a imprimir por pantalla los valores del tamaño de cada uno de los tipos de dato que vamos a utilizar:
```java
System.out.println(Integer.BYTES);
System.out.println(Character.BYTES);
System.out.println(Double.BYTES);
```

2. Guardamos el tamaño total en un la variable `tamañoRegistro`.
```java
int tamañoRegistro = (Integer.BYTES + (20 * Character.BYTES) + Double.BYTES);  
```

3. Movemos el puntero por ejemplo a la posición necesaria para leer el registro 3 (justo después del registro 2).
```java
raf.seek(2 * tamañoRegistro);
```

4. Hacemos el método más flexible

```java
public static void lecturaDeRegistro(int n) {
// ....
raf.seek((n-1) * tamañoRegistro);
}
```


# Aplicaciones de Random Access File

`RandomAccessFile` es una clase en Java que permite leer y escribir en cualquier parte de un archivo, es decir, puedes acceder a cualquier posición del archivo sin leer o escribir desde el principio hasta esa posición. Esto es útil para archivos grandes donde acceder a una posición específica sin tener que recorrer todo el archivo puede ser mucho más eficiente.

#### Aplicaciones de `RandomAccessFile`:

1. **Bases de Datos**: Las bases de datos necesitan acceder y modificar registros específicos sin leer o escribir todo el archivo de la base de datos. `RandomAccessFile` es útil en implementaciones simples de bases de datos.

2. **Edición de Archivos Grandes**: Si estás trabajando con archivos muy grandes y solo necesitas modificar una pequeña sección del archivo, `RandomAccessFile` puede ser útil para evitar la lectura o escritura de todo el archivo.

3. **Implementación de Cachés**: Para sistemas que necesitan un acceso rápido a ciertos datos sin recorrer todo un conjunto de datos.

4. **Juegos**: Algunos juegos guardan su estado en archivos. Si un juego solo necesita actualizar una pequeña parte del estado, puede usar `RandomAccessFile` para escribir solo esa parte.

5. **Sistemas de Archivos**: Al construir sistemas de archivos personalizados o trabajar con particiones de disco.

6. **Manipulación de Archivos Binarios**: A veces es necesario modificar archivos binarios en posiciones específicas, especialmente en aplicaciones que trabajan con formatos de archivo personalizados.

7. **Aplicaciones Multimedia**: Por ejemplo, al trabajar con archivos de video o audio, donde se puede necesitar saltar a un punto específico del archivo para reproducir o editar.

8. **Logs y Archivos de Registro**: En sistemas donde los logs son extensos y es necesario acceder a puntos específicos de manera eficiente.

Es importante mencionar que, aunque `RandomAccessFile` es poderoso, no es siempre la herramienta más adecuada para todas las aplicaciones. En muchos casos, las bases de datos relacionales o los sistemas de archivos especializados son más apropiados. Sin embargo, para ciertas aplicaciones personalizadas o específicas, `RandomAccessFile` ofrece una flexibilidad que puede ser invaluable.
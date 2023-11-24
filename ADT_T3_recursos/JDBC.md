
## Maven MariaDB en IntelliJ

1. Añadir la dependencia al archivo `pom.xml`.
```xml
<dependencies>
    <dependency>
        <groupId>org.mariadb.jdbc</groupId>
        <artifactId>mariadb-java-client</artifactId>
        <version>2.1.2</version>
    </dependency>
</dependencies>
```
2. Refrescar el archivo `pom.xml`.
3. Conexión
```java
// URL de conexión a la base de datos
String url = "jdbc:mysql://localhost:3306/nombre_bd";  
// Nombre de usuario y contraseña  
String usuario = "root";  
String contrasena = "";
```


## Maven PostgreSQL en IntelliJ

1. Añadir la dependencia al archivo `pom.xml`.
```XML
<dependencies>  
    <dependency>        
	    <groupId>org.postgresql</groupId>  
        <artifactId>postgresql</artifactId>  
        <version>42.5.1</version>  
    </dependency>
</dependencies>
```
2. Refrescar el archivo `pom.xml`.
3. Conexión
```java
// URL de conexión a la base de datos
String url = "jdbc:postgresql://localhost:5432/postgres";  
// "jdbc:mysql://localhost:3306/nombreDeTuBaseDeDatos";  
// Nombre de usuario y contraseña  
String usuario = "guillermoroman";  
String contrasena = "";
```


## Maven en Eclipse



## JAR MariaDB en IntelliJ
1. Descargar driver (archivo JAR): https://mariadb.com/downloads/connectors/connectors-data-access/java8-connector
2. Añadir la librería:
	1. File > Project Structure > Modules > + > JARs or directories
	2. Locate the file.
	3. Apply. OK.
3. Veremos el archivo jar en External Libraries dentro del navegador de archivos.

## JAR PostgreSQL en IntelliJ
1. Descargar driver (archivo JAR): https://jdbc.postgresql.org
2. Añadir la librería:
	1. File > Project Structure > Modules > + > JARs or directories
	2. Locate the file.
	3. Apply. OK.
3. Veremos el archivo jar en External Libraries dentro del navegador de archivos.

```java
String url = "jdbc:postgresql://localhost:5432/[nombre_db]";
String usuario = "[usuario]";  
String contrasena = "[clave]";  
  
// Establecer la conexión  
try (Connection connection = DriverManager.getConnection(url, usuario, contrasena)) {  
    if (connection != null) {  
        System.out.println("Conectado con éxito a la base de datos.");  
    }  
} catch (SQLException e) {
```

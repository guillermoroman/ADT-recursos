
## Primeros pasos
IntelliJ
1. Crear proyecto Maven
2. Agregar Hibernate en el POM
3. Agregar base de datos
4. Agregar JUnit si se desean realizar pruebas


## Dependencias

MariaDB
```xml
<!-- https://mvnrepository.com/artifact/org.mariadb.jdbc/mariadb-java-client -->  
<dependency>  
    <groupId>org.mariadb.jdbc</groupId>  
    <artifactId>mariadb-java-client</artifactId>  
    <version>3.3.2</version>  
</dependency>
```

Hibernate
```xml
<!-- https://mvnrepository.com/artifact/org.hibernate.orm/hibernate-core -->
<dependency>
    <groupId>org.hibernate.orm</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>6.4.1.Final</version>
</dependency>

```


Añadir el archivo `hibernate.cfg.xml`a la carpeta de recursos.

```xml
<?xml version='1.0' encoding='utf-8'?>
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD//EN" "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
    <session-factory>
        <property name="hibernate.connection.driver_class">
            org.mariadb.jdbc.Driver
        </property>
        <property name="hibernate.connection.url">
            jdbc:mariadb://localhost:3306/hibernate_clase?createDatabaseIfNotExist=true
        </property>
        <property name="hibernate.connection.username">root</property>
        <property name="hibernate.connection.password"></property>
        <property name="hibernate.connection.pool_size">50</property>
        <property name="show_sql">true</property>
        <property name="hibernate.format_sql">true</property>
        <property name="hibernate.use_sql_comments">true</property>
        <property name="hibernate.hbm2ddl.auto">create</property>
        <mapping class="com.example.model.Employee" />
    </session-factory>
</hibernate-configuration>
```

## Creación de base de datos y tablas
Sentencia SQL para creación de tablas:

```sql
create database hibernate_clase;

use hibernate_clase;

create table sede(
	id_sede integer auto_increment not null,
	nom_sede char (20) not null,
	primary key(id_sede)
);

create table departamento(
	id_depto integer auto_increment not null,
	nom_depto char(32) not null,
	id sede integer not null,
	primary key(id_depto),
	foreign key fk_depto_sede(id_sede) references sede(id_sede)
);

create table empleado (
	dni char(9) not null,
	nom_emp char (40) not null,
	id_depto integer not null,
	primary key(dni),
	foreign key fk_empleado_depto(id_depto) references departamento(id_depto)
) ;

create table empleado_datos_prof(
	dni char (9) not null,
	categoria char(2) not null,
	sueldo_bruto_anual decimal (8,2),
	primary key(dni),
	foreign key fk_empleado_datosprof_empl(dni) references empleado(dni)
);

create table proyecto (
	id_proy integer auto_increment not null,
	f_inicio date not null,
	f_fin date,
	nom_proy char(20) not null,
	primary key(id_proy)
);

create table proyecto_sede (
	id_proy integer not null,
	id_sede integer not null,
	f_inicio date not null,
	f_fin date,
	primary key(id_proy, id_sede),
	foreign key fk_proysede_proy (id_proy) references proyecto(id_proy),
	foreign key fk proysede_sede (id_sede) references sede (id_sede)
);

CREATE USER 'libro_ad'@'localhost' IDENTIFIED BY '(password)';

GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP , EXECUTE

ON proyecto_orm.* TO 'libro_ad'@'localhost';

```


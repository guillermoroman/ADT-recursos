# Ejercicio Hibernate - Relaciones

Para demostrar el uso de diferentes tipos de relaciones en Hibernate, vamos a crear una pequeña aplicación que gestione una relación entre `Profesor` y `Curso`, donde un profesor puede impartir varios cursos, pero un curso solo lo imparte un profesor. También modelaremos una relación entre `Curso` y `Estudiante`, donde un curso puede tener muchos estudiantes y un estudiante puede inscribirse en muchos cursos. Esto nos permite ver relaciones `@OneToMany`, `@ManyToOne`, y `@ManyToMany`.

### Paso 1: Configuración del Proyecto

Asegúrate de tener gestionar apropiadamente las dependencias en el archivo `pom.xml` y de añadir la clase `HibernateUtil` y configurar el archivo `hibernate.cfg.xml`.

### Paso 2: Creación de las Entidades

#### Entidad Profesor

Atributos: 
- nombre
- email
- cursos

#### Entidad Curso

Atributos:
- nombre
- creditos
- profesor
- alumnos

#### Entidad Estudiante

Atributos:
- nombre
- email
- cursos


### Paso 3: Operaciones CRUD

Crea tests para añadir datos e imprimirlos por pantallal poniendo a prueba las relaciones entre las entidades.





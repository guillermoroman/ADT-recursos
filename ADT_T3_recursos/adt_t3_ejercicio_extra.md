

**Tarea: Sistema de Registro de Productos para una Tienda**

**Objetivo:** Desarrollar un sistema simple para gestionar productos y proveedores en una tienda.

**Estructura del Proyecto:**
2. **Modelo de Datos:** Dentro del paquete `modelo`, crear clases `Producto` y `Proveedor` con atributos básicos y métodos get/set.

**Tareas a Realizar:**
1. **Base de Datos:** 
   - Crear una base de datos llamada `tienda`.
   - Crear dos tablas: `productos` y `proveedores`.
2. **Conexión a la Base de Datos:** 
   - Crear una clase `ConexionBD` con un método estático `obtenerConexion()` que devuelve una conexión a la base de datos.
3. **DAO y Implementación:**
   - En el paquete `dao`, crear interfaces `ProductoDAO` y `ProveedorDAO` para operaciones CRUD.
   - Implementar estas interfaces en `ProductoDAOImpl` y `ProveedorDAOImpl`.
4. **Creación y Población de Tablas:**
   - En una clase `InicializadorBD`, agregar métodos para crear tablas y para insertar datos de prueba.
5. **Pruebas en el Main:**
   - En la clase principal `Main`, probar la creación de tablas, inserción de datos y algunas operaciones CRUD básicas.

**Instrucciones Específicas:**
- Las clases `Producto` y `Proveedor` deben incluir atributos como `id`, `nombre`, `precio`, `nombreProveedor`, etc., con métodos get y set.
- La clase `Producto`incluirá los atributos: `id`, `nombre`, `precio`, `id_proveedor`.
- La clase `Proveedor`incluirá los atributos: `id`, `nombre`, `dirección`, `email`.
- La clase `ConexionBD` gestionará los detalles de conexión a la base de datos.
- `InicializadorBD` se encargará de la creación de las tablas y la inserción inicial de datos.
- Las interfaces DAO definirán métodos como `agregar`, `obtenerPorId`, `obtenerTodos`, `actualizar` y `eliminar`.
- En `Main`, demostrar la funcionalidad del sistema con ejemplos de uso de los métodos DAO.

# Practica-jpa-java
---
### ✅ ***¡ Importante!***

#### ► Nombre de bases de datos en mySQL - phpMyAdmin  →  bd_jpa
---
#### ► Configuración para aplication.properties para este ejercicio:

spring.application.name=Jpa     
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/bd_jpa?useSSL=false&serverTimeZone=UTC
spring.datasource.username=root
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

---->      NOTA:
           -  Línea 1 →  Jpa es el nombre del proyecto 
           -  Línea 2 →  Configuro update porque compara lo que hay en mi BD y actualiza las diferencias, si le pusiera create, reemplazaria lo que tengo en mi BD por lo que cree en mi proyecto cada vez.
           -  Línea 3 →   bd_jpa hace alusión a la base de datos relacional que deseo vincular
           -  Línea 4 →   si tengo otro userName (en phpMyadmin) o más de uno, debo colocarlo 
           -  Línea 5 →   Colocar contraseña de mi gestor de BD, si no tengo dejarlo vacío

--- 

#### Aplicación práctica de conceptos MVC, inyección de dependencias y conexión con bases de datos MySQL; 

#### → Spring Boot 

##### Inicializar un nuevo proyecto desde Spring initializr ►  https://start.spring.io/
- en este se puede configurar nombre del proyecto, agregar dependencias, extenciones etc ( Maven, jar, JDK 17)
DEPENDENCIAS :
- Spring Web
- Spring Boot DevTools
- Lombok
- Spring Data JPA
- H2 Database

#####   De igual manera se puede inicializar el proyecto desde Spring tool suite
      - file → new → Spring Started Project 
      - se colocan las configuraciones : nombre, maven, lenguaje,  versión jdk, extension de empaquetamiento (jar o war)
      - ----> next 
      - Se adicionan las dependencias a utilizar 
      - ---->  finish
      

####  Spring JPA
-  para trabajar el **tema de persistencia**, primero se debe tener creada una base de datos con la cual se quiere conectar el proyecto
-  JPA lo que hace es crear las tablas que esten notadas con JPA en nuestro proyecto
-  las clases- **modelo de objetos  referenciadas con (@Entity)**  serían las tablas ( en nuestra base de datos ( productos, clientes, carrito de compras, etc.)
-  **los atributos se mapean**, las propiedades de las clases se asocian a columnas (@Column, @ID, etc.)
-  **Se configuran las relaciones** entre entidades mediante anotaciones (@OneToMany, @ManyToOne, etc.)
-  **Se gestionan transacciones y consultas**, permite ejecutar operaciones CRUD, utilizar JPQL(*Java Persistence Query Lenguage) y criterios par aconsultar datos.
---->      NOTA:
           **HIBERNATE**
           - Es una imp'lementación de LPA y uno de los OMR (*Object RElational MApping*) más populares de Java.
           - Funciona como un **puente** entre el modelo de objetos en java y la base de datos relacional.
           - Hace que la persistencia sea transparente (sincronizada) y  se automatice el mapeo (traduce operaciones Crud sobre objetos en sentencias SQL.




### *Conceptos*
Inversión de Control (IoC):
Es un principio de diseño en el que se invierte el flujo tradicional de control en un programa. En lugar de que el código de alto nivel decida cuándo y cómo se llaman los componentes o servicios, se delega esa responsabilidad a un contenedor o framework. Esto permite que el sistema sea más flexible y modular, ya que los componentes se "inyectan" o se conectan entre sí de forma automática según una configuración externa.

Estructura Desacoplada:
Se refiere a una arquitectura de software donde los componentes o módulos están diseñados de manera independiente. Esto significa que los cambios en un componente tienen un impacto mínimo (o nulo) en otros componentes. Un sistema desacoplado mejora la mantenibilidad, escalabilidad y facilita la reutilización, ya que cada módulo se comunica a través de interfaces bien definidas en lugar de depender directamente de la implementación concreta de otros módulos.

Inyección de Dependencia:
Es una técnica que permite implementar el principio de Inversión de Control. Consiste en suministrar (inyectar) a un componente o clase las dependencias que necesita para funcionar, en lugar de que el propio componente las cree o gestione. Esto se puede hacer a través del constructor, setters o interfaces. La inyección de dependencia favorece la reutilización y la prueba unitaria, ya que se pueden sustituir fácilmente las dependencias por implementaciones "falsas" o simuladas durante las pruebas.
---

1. Entidad (Entity)
La entidad representa una tabla en la base de datos. Se anota con @Entity y, opcionalmente, se puede usar @Table para definir el nombre de la tabla. Cada campo de la entidad se corresponde con una columna.

---->   NOTA: 
        - Se usan anotaciones de Lombok (como @Getter, @Setter, etc.) para reducir el código repetitivo. Si no lo usas, deberás generar manualmente los métodos getters, setters, constructores y toString.
        - La anotación @GeneratedValue se utiliza para generar automáticamente el valor del identificador.

2. Repositorio (Repository)
El repositorio es la capa de acceso a datos. Se extiende de JpaRepository para poder utilizar métodos CRUD y consultas personalizadas.
---->    NOTA:
         - La anotación @Repository permite que Spring reconozca esta interfaz como un componente de acceso a datos.

3. Servicio (Service)
La capa de servicio contiene la lógica de negocio. Aquí se inyecta el repositorio y se exponen métodos que el controlador utilizará.
---->     NOTA:
          - Se usa @Service para definir esta clase como un componente de negocio.
          - La inyección de dependencias se realiza con @Autowired para obtener una instancia del repositorio.

4. Controlador REST (RestController)
El controlador se encarga de exponer los endpoints (puntos de acceso) de la API. Se anota con @RestController y se define un mapeo base (por ejemplo, /usuarios).
---->     NOTA:
           - La anotación @RestController combina @Controller y @ResponseBody, lo que hace que los métodos retornen directamente objetos en formato JSON.
           - @RequestMapping("/usuarios") define la ruta base.
           - Cada método está mapeado a un endpoint específico usando anotaciones como @GetMapping, @PostMapping y @DeleteMapping.
           - Se utiliza @PathVariable para capturar parámetros de la URL y @RequestBody para recibir datos en formato JSON.


# API de Gestión de Tareas
API RESTful desarrollada con Spring Boot 3.5.5 para gestionar usuarios y tareas. Permite registro, login,y operaciones CRUD sobre tareas.
Tecnologías:
- Java 21.0.8
- Spring Boot 3.5.5
- Maven 3.9.11
- Spring Security
- JPA + Hibernate
- Base de datos: MYSQL

Como ejecutar el proyecto:
1. Clona el repositorio
2. Importa en IntelliJ como proyecto Maven
3. Ejecuta la clase `ApirestGestionTareasApplication`
4. Accede a `http://localhost:8080`

Como ejecutar pruebas unitarias:
1. Clic derecho en gestionTareasServicios
2. Clic en Run 'Test in 'gestionTaresServicios''

Endpoints Principales 
Usuarios:
- `POST /usuarios` : Registro
- `POST /login` : Autenticación

Tareas:
- `GET /tareas/{usuarioId}` : Listar tareas por id usuario
- `POST /tareas/{usuarioId}`: Crear tarea por id usuario
- `PUT /tareas/{tareaId}/usuario/{usuarioId}` : Editar tarea por id tarea e id usuario
- `DELETE /tareas/{tareaId}/usuario/{usuarioId}` : Eliminar tarea por id usuario e id tarea

Pruebas unitarias:
- UsuarioServiciosTest: prueba creación de usuario y validación de email duplicado

Colección postman:
- Incluye registro, login y operaciones CRUD
- Exportada en formato `.json` 
Ubicacion: Denttro de la apirest-gestionTares -> Postman

Configuración de la base de datos:
Antes de ejecutar el proyecto, asegurse de tener creada la base de datos:
- Nombre: `tareas`
- Motor: MySQL 
- Usuario:`root`
- Contraseña: `admin`


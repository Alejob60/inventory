# Inventory API

Proyecto de prueba técnica desarrollado para QPAlliance.

Este proyecto implementa una API REST básica de inventario utilizando Java 17, Spring Boot 3.2.5, y Clean Architecture. Permite gestionar productos y alertas de stock bajo.

## Tecnologías utilizadas

- Java 17
- Spring Boot 3.2.5
- Gradle
- H2 Database (en memoria)
- JPA/Hibernate
- Validaciones con Jakarta Validation
- JUnit 5 para pruebas

## Estructura del proyecto

El proyecto sigue los principios de Clean Architecture:

- `domain/`: Entidades de negocio y contratos.
- `application/`: Casos de uso (servicios de aplicación).
- `infrastructure/`: Controladores REST y adaptadores de persistencia.
- `shared/`: Manejo de excepciones y utilidades comunes.

## Requisitos previos

- Java 17 instalado
- Gradle instalado
- IntelliJ IDEA 

## Instalación y ejecución

1. Clonar el repositorio:
   ```bash
   git clone <url-del-repositorio>
   cd inventory
   ```

2. Compilar y levantar la aplicación:
   ```bash
   ./gradlew bootRun
   ```

3. La API estará disponible en:
   ```
   http://localhost:8080
   ```

## Endpoints disponibles

### Crear un producto

- **POST** `/products`
- Body JSON:

```json
{
  "name": "Producto de ejemplo",
  "code": "P001",
  "currentStock": 10,
  "minStock": 5
}
```

### Listar todos los productos

- **GET** `/products`

### Listar productos con stock bajo

- **GET** `/products/alerts`

## Validaciones de entrada

La API valida los siguientes campos al crear un producto:

- `name`: obligatorio, no puede estar vacío.
- `code`: obligatorio, no puede estar vacío.
- `currentStock`: obligatorio, número entero mayor o igual a 0.
- `minStock`: obligatorio, número entero mayor o igual a 0.

En caso de error, se retornan respuestas HTTP con código 400 y detalles del problema.

## Pruebas

Para ejecutar los tests:

```bash
./gradlew test
```

El proyecto incluye pruebas unitarias básicas para los endpoints principales.

## Notas

- La base de datos utilizada es H2 en memoria, por lo tanto los datos se eliminan cada vez que se reinicia la aplicación.
- Se utilizó una estructura modular para facilitar la escalabilidad futura.

## Designed by: Alejandro Benavides
    email: alejob600@gmail.com
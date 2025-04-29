1. Para diseñar un sistema MRP modular y escalable, utilizaría Clean Architecture combinada con principios de Domain-Driven Design (DDD).

    Clean Architecture permite separar la lógica de negocio de las implementaciones técnicas, haciendo que sea más fácil agregar módulos como predicción de demanda o reportes BI sin afectar el sistema principal.

    Además, consideraría una arquitectura basada en eventos (Event-Driven Architecture) para que los nuevos módulos puedan suscribirse a eventos como "Producto actualizado" o "Orden de producción creada" y reaccionar de forma independiente.

    Esta combinación permite escalar el sistema de forma segura y mantener un alto nivel de mantenibilidad.
2. Para asegurar un rendimiento óptimo:

   - Implementaría índices en las columnas más consultadas, como código de producto y estado de stock.
   - Utilizaría paginación y consultas optimizadas para listar productos.
   - Aplicaría caché en consultas frecuentes utilizando Redis o una solución en memoria.
   - Procesaría alertas de bajo stock de forma asíncrona usando colas de mensajes como RabbitMQ.
   - Validaría los datos de entrada a nivel de DTO para evitar validaciones costosas a nivel de base de datos.
   - Aplicaría principios de consulta proactiva y evitaría operaciones N+1 mediante configuraciones correctas de JPA.

3.
# logica 

    import java.util.LinkedHashMap;
    import java.util.List;
    import java.util.Map;
    
    public class UniqueNumberFinder {

        public static Integer findFirstUnique(List<Integer> numbers) {
            Map<Integer, Integer> counts = new LinkedHashMap<>();
            for (Integer num : numbers) {
                counts.put(num, counts.getOrDefault(num, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
                if (entry.getValue() == 1) {
                    return entry.getKey();
                }
            }
            return null;
        }
}

### ejemplo de uso:
    List<Integer> lista = List.of(4, 5, 1, 2, 0, 4, 1, 0);
    System.out.println(findFirstUnique(lista)); // Output: 5


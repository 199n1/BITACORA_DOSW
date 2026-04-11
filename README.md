# BITACORA_DOSW
## Notas de clase
### link preparcial: https://github.com/199n1/ECI-SportLife

 ## 1. INYECCIÓN DE DEPENDENCIAS (DI)
### Definición 

- La inyección de dependencias es un patrón de diseño en el cual una clase no es responsable de crear las instancias de los objetos que necesita, sino que estas le son proporcionadas desde el exterior (por ejemplo, por un framework como Spring).

- Esto permite que las clases dependan de abstracciones (interfaces) en lugar de implementaciones concretas, reduciendo el acoplamiento entre componentes.

###  Analogía

Imagina que tienes un restaurante:

 Sin DI → tú cocinas todo
 Con DI → el restaurante te sirve la comida

 Tú solo usas el servicio, no te preocupas por cómo se hace

 Ejemplo
class Carro {
Motor motor;

    Carro(Motor motor) {
        this.motor = motor;
    }
}
- Ventajas 
Reduce el acoplamiento
Facilita el mantenimiento
Permite hacer pruebas con mocks
Hace el sistema más flexible y escalable
 ## 2. INVERSIÓN DE CONTROL (IoC)
### Definición

- La inversión de control es un principio donde el flujo del programa ya no es controlado por el programador directamente, sino por un framework o contenedor (como Spring).

- Es decir, en lugar de que tú decidas cuándo y cómo crear objetos, el framework lo hace por ti.

- Analogía
Sin IoC → tú organizas todo
Con IoC → alguien más organiza todo por ti
 Diferencia clave
IoC → concepto general
DI → forma específica de implementarlo 
## 3. ENDPOINT vs HTTP VERBS 
### Endpoint

Un endpoint es una URL específica que representa un recurso dentro de una API.

Ejemplo:

/users
 HTTP Verb

Es el método que indica qué acción se realizará sobre ese recurso.

- Diferencia clave
Concepto	Qué es
Endpoint	Dirección
Verbo HTTP	Acción
- Analogía
Endpoint = dirección de una casa 🏠
Verbo = lo que haces (entrar, salir, pintar)
 ## 4. IDEMPOTENCIA 
### Definición

La idempotencia es una propiedad de algunas operaciones HTTP en la que realizar la misma petición múltiples veces produce el mismo resultado en el sistema que realizarla una sola vez.

- Analogía

Apagar una luz:

Da igual cuántas veces lo hagas → queda apagada
- Importante
- GET ✔️
- PUT ✔️
- DELETE ✔️
- POST ❌
## 5. ARQUITECTURA EN CAPAS
### Definición

Es un modelo de diseño donde la aplicación se divide en capas independientes, cada una con una responsabilidad específica.

- Capas
- Controller → recibe requests HTTP
- Service → lógica de negocio
- Repository → acceso a base de datos
- Analogía
- Controller → recepcionista
- Service → jefe
- Repository → archivador
 ## 6. TIPOS DE PRUEBAS
### Definición general

- Las pruebas de software son procesos diseñados para verificar que un sistema funciona correctamente y cumple con los requisitos.

🔹 Pruebas Unitarias

Evalúan componentes individuales (métodos o clases).

 - Rápidas y aisladas

🔹 Pruebas Funcionales

Evalúan el comportamiento completo del sistema desde el punto de vista del usuario.

🔹 Pruebas de Carga

Evalúan cómo responde el sistema bajo alta demanda.

🔹 Caja Negra vs Blanca
Caja negra → sin ver código
Caja blanca → con acceso al código
## 7. TDD (TEST DRIVEN DEVELOPMENT) 
### Definición

TDD es una metodología de desarrollo donde primero se escriben las pruebas antes del código.

-  Ciclo
- Escribir test (falla)
- Escribir código mínimo
- Refactorizar
- Analogía

Primero haces el examen → luego estudias lo que necesitas

## 8. MOCK vs STUB
### Definiciones
Stub: devuelve datos predefinidos
Mock: verifica interacciones entre objetos
 ## 9. COBERTURA
### Definición

Es una métrica que indica qué porcentaje del código ha sido ejecutado durante las pruebas.

-  Importante

Alta cobertura no significa alta calidad

## 10. BUENAS PRÁCTICAS API
- Usar sustantivos: /users
- Usar jerarquías: /users/{id}/loans
- Usar query params para filtros
- Mantener consistencia
 

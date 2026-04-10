# BITACORA_DOSW
## Notas de clase
### link preparcial: https://github.com/199n1/ECI-SportLife

 ## 1. INYECCIÓN DE DEPENDENCIAS (DI)
### Definición 

- La inyección de dependencias es un patrón de diseño en el cual una clase no es responsable de crear las instancias de los objetos que necesita, sino que estas le son proporcionadas desde el exterior (por ejemplo, por un framework como Spring).

- Esto permite que las clases dependan de abstracciones (interfaces) en lugar de implementaciones concretas, reduciendo el acoplamiento entre componentes.

###  Analogía

Imagina que tienes un restaurante:

❌ Sin DI → tú cocinas todo
✅ Con DI → el restaurante te sirve la comida

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
⚠️ Diferencia clave
IoC → concepto general
DI → forma específica de implementarlo 
## 3. ENDPOINT vs HTTP VERBS 
### Endpoint

Un endpoint es una URL específica que representa un recurso dentro de una API.

Ejemplo:

/users
🧠 HTTP Verb

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
 ## 11. RESPUESTAS A PREGUNTAS TIPO PARCIAL
 1. ¿PUT es siempre idempotente?

Sí, en teoría PUT es idempotente porque enviar la misma solicitud varias veces debería dejar el recurso en el mismo estado.
Sin embargo, esto depende de la implementación. Si el backend agrega lógica adicional (como logs o cambios secundarios), podría romper esta propiedad.

 2. ¿GET puede modificar datos?

En teoría no, ya que es un método seguro.
Pero en la práctica sí puede hacerlo si está mal implementado, por ejemplo:

GET /increaseCounter
3. ¿Por qué DI mejora testing?

Porque permite reemplazar dependencias reales por mocks o stubs, lo que hace que las pruebas sean más rápidas, controladas y aisladas.

4. ¿Qué pasa si no separas capas?
Código difícil de mantener
Mayor acoplamiento
Difícil testing
Errores más frecuentes
5. ¿Mock vs Stub diferencia real?
Stub → simula datos
Mock → valida comportamiento
6. ¿Cómo evitar préstamos duplicados?
Validar en backend si ya existe préstamo activo
Usar restricciones lógicas o únicas 7. ¿Qué problema resuelve TDD?
Reduce errores desde el inicio
Define comportamiento antes del código
Mejora diseño
 8. ¿Por qué Swagger mejora desarrollo?
Documentación automática
Permite probar endpoints
Facilita comunicación entre equipos
9. ¿Qué pasa si no versionas una API?
Rompes clientes existentes
Dificultas mantenimiento
Generas inconsistencias
 10. ¿Qué prueba usarías para login?
Funcional → flujo completo
Unitaria → validación de credenciales


1. ¿Qué es REST y sus principios?

REST es un estilo arquitectónico para diseñar APIs basado en:

Cliente-servidor
Stateless
Cacheable
Interfaz uniforme
Sistema en capas

---------

2. API vs API REST
   API → cualquier interfaz entre sistemas
   REST → tipo de API con reglas específicas
3. Stateless

Cada request contiene toda la información, el servidor no guarda contexto.

4. Recurso en REST

Entidad accesible vía URL
Ej: /users

5. URI vs URL
   URI → identificador
   URL → tipo de URI que incluye ubicación
6. ¿Por qué sustantivos?

Porque representan recursos
✔️ /users
❌ /getUsers

7. Status codes

Indican resultado de la petición (200, 404, 500)

8. Query vs Path params
   Path → identifica recurso (/users/1)
   Query → filtra (?page=1)
9. JSON vs XML

JSON es más ligero, legible y eficiente

10. Caching

Guardar respuestas para mejorar rendimiento

11. ¿REST sin HTTP?

Sí, pero HTTP es el estándar práctico

12. Problemas no stateless
    difícil escalar
    mayor consumo de memoria
13. Bajo acoplamiento

Porque cliente y servidor son independientes

14. Usar verbos en endpoints

Rompe estándar y claridad

15. API escalable
    Stateless
    caching
    balanceo de carga
    ⚙️ 2. ARQUITECTURA
16. Capas
    Controller → entrada
    Service → lógica
    Repository → datos
17. Service no BD

Para mantener separación de responsabilidades

18. DTO

Objeto para transferir datos sin exponer entidades

19. Problema que resuelve DI

Reduce acoplamiento

20. Usar new en todo

Código rígido y difícil de testear

21. DI y escalabilidad

Permite cambiar implementaciones fácilmente

22. Controller con lógica

Difícil mantenimiento y testing

23. Cohesión y acoplamiento
    Alta cohesión → clases claras
    Bajo acoplamiento → independientes
24. Sin Service

Pierdes organización y escalabilidad

25. DI sin Spring

Sí, manualmente con constructores

26. DI rendimiento

Impacto mínimo, beneficio alto

27. Cuándo no usar DI

En sistemas muy simples

🌐 3. HTTP
28. Headers

Metadatos del request

29. Request contiene
    método
    URL
    headers
    body
30. Response contiene
    status code
    headers
    body
31. POST no idempotente

Crea recursos nuevos cada vez

32. Método seguro

No modifica datos (GET)

33. DELETE sin recurso

Puede devolver 404 o 204

34. PUT vs POST
    PUT → reemplaza
    POST → crea
35. PUT no idempotente (trampa)

Si genera efectos secundarios (logs, contadores)

36. Mal uso HTTP

Confusión, errores, mala API

37. PATCH eficiente

Envía solo cambios

🧪 4. TESTING
38. Prueba unitaria

Prueba un componente aislado

39. Prueba funcional

Prueba flujo completo

40. Cobertura

Porcentaje de código probado

41. Ventajas TDD
    menos errores
    mejor diseño
42. Mock

Simula comportamiento y verifica llamadas

43. Stub

Devuelve datos simulados

44. TDD mejora diseño

Obliga a pensar antes de codificar

45. Servicios externos en tests

Hace pruebas lentas e inestables

46. Prueba aislada

No depende de otros sistemas

47. Pruebas rápidas

Permiten feedback inmediato

48. Prueba rendimiento

Prueba de carga

49. Test mal diseñado
    dependencias externas
    no determinístico
50. Cobertura vs calidad

Mejor buenas pruebas

🔐 5. SEGURIDAD
51. Autenticación

Verifica identidad

52. Autorización

Define permisos

53. JWT

Token con información del usuario

54. JWT y stateless

No necesita sesión

55. No validar backend

Vulnerabilidades

56. Vulnerabilidad

Debilidad explotable

57. Contraseñas plano

Grave problema de seguridad

58. No confiar frontend

Usuario puede manipular datos

59. Token mal implementado

Riesgo de acceso indebido

⚠️ 6. ERRORES Y LOGS
60. Centralizar errores

Código limpio y consistente

61. Status code

Resultado HTTP

62. Try/catch en todos lados

Código sucio y repetitivo

63. Info no en error

Datos sensibles

64. Error estándar
    {
    "code": "USER_NOT_FOUND",
    "message": "Usuario no existe"
    }
65. Log crítico

ERROR

📊 7. DISEÑO
66. Endpoints profundos

Difíciles de mantener

67. Naming inconsistente

Confusión

68. Separar validaciones

Claridad y mantenimiento

69. Mal endpoint
    /getAllUsersDataNow
70. Buen endpoint
    /users
    🧠 8. ANÁLISIS
71. Falla en producción
    carga
    datos reales
    configuración
72. Sistema lento
    BD
    red
    logs
73. Microservicios vs monolito
    micro → flexible
    mono → simple
74. Sin logs

Difícil detectar errores

75. Falla bajo carga
    optimizar
    escalar
    caching

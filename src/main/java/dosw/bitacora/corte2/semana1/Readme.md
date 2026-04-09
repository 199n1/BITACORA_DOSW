# DOSW Learning Analytics System

## Tabla de contenido

2. [Conceptos clave de Streams](#conceptos-clave-de-streams)
3. [Operaciones intermedias vs terminales](#operaciones-intermedias-vs-terminales)
4. [Ejercicio 1 — Filtrar por equipo](#ejercicio-1--filtrar-por-equipo)
5. [Ejercicio 2 — Nombres ordenados](#ejercicio-2--nombres-ordenados)
6. [Ejercicio 3 — Promedio general](#ejercicio-3--promedio-general)
7. [Ejercicio 4 — Promedio por materia](#ejercicio-4--promedio-por-materia)
8. [Ejercicio 5 — Mejor estudiante](#ejercicio-5--mejor-estudiante)
9. [Ejercicio 6 — Reprobadas por equipo](#ejercicio-6--reprobadas-por-equipo)
10. [Ejercicio 7 — Top 3 aprobados](#ejercicio-7--top-3-aprobados)
11. [Ejercicio 8 — Estado académico](#ejercicio-8--estado-académico)
12. [Ejercicio 9 — Materia más reprobada](#ejercicio-9--materia-más-reprobada)
13. [Ejercicio 10 — Pipeline completo NARANJA](#ejercicio-10--pipeline-completo-naranja)
14. [Pruebas unitarias](#pruebas-unitarias)
15. [Git Flow — flujo de trabajo](#git-flow--flujo-de-trabajo)
16. [Cheatsheet rápido](#cheatsheet-rápido)





## Conceptos clave de Streams

Un Stream es una **secuencia de elementos** sobre la que se aplican operaciones encadenadas. Se abre desde una colección con `.stream()`, se procesan los elementos con operaciones intermedias, y se cierra con una operación terminal.

```
colección.stream()
    .operaciónIntermedia1(...)   ← devuelve Stream, no ejecuta aún
    .operaciónIntermedia2(...)   ← devuelve Stream, no ejecuta aún
    .operaciónTerminal(...)      ← aquí sí se ejecuta todo
```

**Importante:** los streams son lazy. Nada se procesa hasta que se llama la operación terminal.

Un stream **solo puede usarse una vez**. Si necesitas recorrerlo dos veces, debes crearlo de nuevo desde la colección.
```java
lista.stream()
.filter(...)    // ← aún no ejecuta nada
.map(...)       // ← aún no ejecuta nada
.collect(...)   // ← AQUÍ se ejecuta todo de una sola vez
```

1. ¿Cuál es mi dato de entrada?
   Siempre una colección: List<Estudiante>, List<Nota>, etc.
2. ¿Qué transformaciones necesito aplicar?
   Piénsalo como una cadena de pasos: filtrar → transformar → agrupar → ordenar...
3. ¿Qué forma tiene mi resultado?
   ¿Una lista? ¿Un número? ¿Un mapa? Esto te dice qué operación terminal usar.
---

## Operaciones intermedias vs terminales

| Tipo | Operación | Qué hace | Retorna |
|------|-----------|----------|---------|
| Intermedia | `filter(pred)` | Deja pasar los que cumplen la condición | `Stream<T>` |
| Intermedia | `map(func)` | Transforma cada elemento en otra cosa | `Stream<R>` |
| Intermedia | `flatMap(func)` | Transforma y aplana listas anidadas | `Stream<R>` |
| Intermedia | `sorted()` | Ordena (orden natural) | `Stream<T>` |
| Intermedia | `sorted(comp)` | Ordena con comparador propio | `Stream<T>` |
| Intermedia | `limit(n)` | Toma solo los primeros n elementos | `Stream<T>` |
| Intermedia | `mapToDouble(func)` | Convierte a stream de primitivos double | `DoubleStream` |
| Terminal | `collect(collector)` | Empaqueta en lista, mapa, set... | depende |
| Terminal | `average()` | Promedio de un DoubleStream | `OptionalDouble` |
| Terminal | `max(comp)` | Máximo según comparador | `Optional<T>` |
| Terminal | `count()` | Cuenta elementos | `long` |

**`flatMap` vs `map`:**
- `map` → transforma 1 elemento en 1 elemento.
- `flatMap` → transforma 1 elemento en 0..N elementos y aplana. Usado cuando cada elemento contiene una lista interna (ej: cada Estudiante tiene `List<Nota>`).

---

## Ejercicio 1 — Filtrar por equipo

**Qué pide:** retornar solo los estudiantes cuyo equipo sea `"NARANJA"`.
**Estrategia solucion:** necesito recorrer todos los estudiantes y para cada uno hacer una pregunta: ¿su equipo es NARANJA? Si sí, lo dejo pasar. Si no, lo descarto. Eso es exactamente lo que hace filter.Operación clave: filter(condicion) — pasa solo los elementos donde la condición es true.
**Retorna:** `List<Estudiante>`

**Solución:**
```java
public List<Estudiante> obtenerEstudiantesNaranja(List<Estudiante> estudiantes) {
    return estudiantes.stream()
            .filter(e -> "NARANJA".equals(e.getEquipo()))
            .collect(Collectors.toList());
}
```

**Por qué `"NARANJA".equals(e.getEquipo())` y no al revéz?**
Si `e.getEquipo()` retorna `null`, llamar `null.equals("NARANJA")` lanza `NullPointerException`. Poner la constante primero evita ese error: `"NARANJA".equals(null)` retorna `false` sin explotar.

**Traza con datos de ejemplo:**
```
[Ana/NARANJA, Carlos/NARANJA, Luis/AZUL, Pedro/VERDE]
       ↓ filter(NARANJA)
[Ana/NARANJA, Carlos/NARANJA]
```

---

## Ejercicio 2 — Nombres ordenados

**Qué pide:** retornar solo los nombres de todos los estudiantes, en orden A→Z.

**Estrategia solucion:** hay dos pasos distintos aquí. Primero tengo que transformar cada Estudiante en un String (su nombre). Luego tengo que ordenar esos strings. Son dos operaciones separadas encadenadas
**Operaciones clave**

- map(transformador) — convierte cada elemento en otra cosa
- sorted() — ordena según el orden natural del tipo
**Retorna:** `List<String>`

**Solución:**
```java
public List<String> obtenerNombresOrdenados(List<Estudiante> estudiantes) {
    return estudiantes.stream()
            .map(Estudiante::getNombre)
            .sorted()
            .collect(Collectors.toList());
}
```

**`Estudiante::getNombre` es una method reference.** Equivale a escribir `e -> e.getNombre()`. Se usa cuando la lambda solo llama un método sin nada más.

**`sorted()` sin argumentos** usa el orden natural. Para `String` eso es orden alfabético (comparación lexicográfica según Unicode). Si quisieras invertir: `sorted(Comparator.reverseOrder())`.



## Ejercicio 3 — Promedio general

**Qué pide:** calcular el promedio de **todos** los puntajes del sistema (de todos los estudiantes juntos).

**Retorna:** `double`

**Solución:**
```java
public double calcularPromedioGeneral(List<Estudiante> estudiantes) {
    return estudiantes.stream()
            .flatMap(e -> e.getNotas().stream())
            .mapToDouble(Nota::getPuntaje)
            .average()
            .orElse(0.0);
}
```

**Por qué `flatMap`?**
Cada estudiante tiene una `List<Nota>`. Si usaras `map`, tendrías un `Stream<List<Nota>>` (un stream de listas). Con `flatMap` abres cada lista y obtienes un `Stream<Nota>` plano con todas las notas juntas.

```
[Estudiante1(notas=[N1,N2]), Estudiante2(notas=[N3,N4])]
     ↓ flatMap(e -> e.getNotas().stream())
[N1, N2, N3, N4]   ← stream plano de todas las notas
     ↓ mapToDouble(getPuntaje)
[4.8, 4.6, 3.8, 2.5]   ← DoubleStream
     ↓ average()
OptionalDouble[3.925]
     ↓ orElse(0.0)
3.925
```

**`average()` retorna `OptionalDouble`** porque si el stream está vacío no hay promedio. `orElse(0.0)` desenvuelve el Optional y retorna 0 si no había datos.

---

## Ejercicio 4 — Promedio por materia

**Qué pide:** dado UN estudiante, retornar un mapa con el promedio de cada materia.

**Retorna:** `Map<String, Double>` → `{"DOSW": 4.2, "BD": 3.8, "REDES": 4.5}`

**Solución:**
```java
public Map<String, Double> calcularPromedioPorMateria(Estudiante estudiante) {
    return estudiante.getNotas().stream()
            .collect(Collectors.groupingBy(
                    Nota::getMateria,
                    Collectors.averagingDouble(Nota::getPuntaje)
            ));
}
```

**`groupingBy` con downstream collector:**
`groupingBy` agrupa los elementos por una clave. Su segunda forma acepta un "downstream collector" que define qué hacer con los elementos de cada grupo.

```
groupingBy(clasificador, dowstreamCollector)
                ↑                 ↑
          clave del mapa    qué se hace con cada grupo
```

`averagingDouble(Nota::getPuntaje)` calcula el promedio de los puntajes del grupo. Si un estudiante tiene dos notas de DOSW (4.0 y 5.0), el valor del mapa para "DOSW" será 4.5.

**Si un estudiante solo tiene una nota por materia**, el promedio es igual al puntaje. Aun así esta solución es correcta para el caso general.

---

## Ejercicio 5 — Mejor estudiante

**Qué pide:** retornar el estudiante con el **promedio general más alto** de toda la lista.

**Retorna:** `Estudiante`

**Solución:**
```java
public Estudiante obtenerMejorEstudiante(List<Estudiante> estudiantes) {
    return estudiantes.stream()
            .max(Comparator.comparingDouble(e ->
                    e.getNotas().stream()
                            .mapToDouble(Nota::getPuntaje)
                            .average()
                            .orElse(0.0)
            ))
            .orElseThrow(() -> new NoSuchElementException("No hay estudiantes registrados"));
}
```

**`Comparator.comparingDouble(keyExtractor)`** crea un Comparator que extrae un `double` de cada elemento y compara por ese número. Aquí el double extraído es el promedio de cada estudiante, calculado con un stream anidado.

**Stream anidado dentro de un Comparator:** es completamente válido. Para cada estudiante que `max` evalúa, se ejecuta el stream interno que calcula su promedio. Esto sucede por cada comparación que necesita hacer `max`.

**`max()` retorna `Optional<Estudiante>`** porque si la lista está vacía no hay máximo. `orElseThrow()` lanza una excepción descriptiva en ese caso.

---

## Ejercicio 6 — Reprobadas por equipo

**Qué pide:** contar cuántas notas reprobadas tiene cada equipo en total.

**Retorna:** `Map<String, Long>` → `{"NARANJA": 1, "AZUL": 1, "VERDE": 3}`

**Solución:**
```java
public Map<String, Long> contarReprobadasPorEquipo(List<Estudiante> estudiantes) {
    return estudiantes.stream()
            .collect(Collectors.groupingBy(
                    Estudiante::getEquipo,
                    Collectors.summingLong(e ->
                            e.getNotas().stream()
                                    .filter(n -> !n.isAprobada())
                                    .count()
                    )
            ));
}
```

**`summingLong(mapper)`** es un downstream collector que suma los valores `long` que produce la función mapper para cada elemento del grupo.

**Traza con datos de ejemplo:**
```
Grupo NARANJA: [Ana, Carlos]
  Ana    → notas reprobadas: 0
  Carlos → notas reprobadas: 1
  summingLong → 1

Grupo AZUL: [Luis]
  Luis → notas reprobadas: 1
  summingLong → 1

Grupo VERDE: [Pedro]
  Pedro → notas reprobadas: 3
  summingLong → 3

Resultado: {"NARANJA": 1, "AZUL": 1, "VERDE": 3}
```

---

## Ejercicio 7 — Top 3 aprobados

**Qué pide:** los 3 estudiantes con más materias aprobadas, en orden descendente.

**Retorna:** `List<Estudiante>`

**Solución:**
```java
public List<Estudiante> obtenerTop3Aprobados(List<Estudiante> estudiantes) {
    return estudiantes.stream()
            .sorted(Comparator.comparingLong((Estudiante e) ->
                    e.getNotas().stream()
                            .filter(Nota::isAprobada)
                            .count()
            ).reversed())
            .limit(3)
            .collect(Collectors.toList());
}
```

**Por qué se necesita el cast explícito `(Estudiante e)`?**
Cuando se encadena `.reversed()` después de `comparingLong`, Java pierde la inferencia del tipo genérico. El cast explícito le dice al compilador el tipo del lambda para que pueda resolver el genérico correctamente. Sin él el código no compila.

**Orden de las operaciones:**
1. `sorted(...reversed())` → ordena de mayor a menor por aprobadas.
2. `limit(3)` → toma solo los primeros 3 (que ya son los de mayor puntaje).
3. `collect(toList())` → empaqueta.

Si la lista tiene menos de 3 estudiantes, `limit(3)` simplemente toma todos los que hay sin error.

---

## Ejercicio 8 — Estado académico

**Qué pide:** clasificar cada estudiante en `"ALTO RENDIMIENTO"`, `"REGULAR"` o `"RIESGO"` según su promedio.

**Retorna:** `Map<String, List<Estudiante>>`

| Categoría | Condición |
|-----------|-----------|
| ALTO RENDIMIENTO | promedio >= 4.5 |
| REGULAR | promedio >= 3.5 y < 4.5 |
| RIESGO | promedio < 3.5 |

**Solución:**
```java
public Map<String, List<Estudiante>> clasificarPorEstadoAcademico(List<Estudiante> estudiantes) {
    return estudiantes.stream()
            .collect(Collectors.groupingBy(e -> {
                double promedio = e.getNotas().stream()
                        .mapToDouble(Nota::getPuntaje)
                        .average()
                        .orElse(0.0);
                if (promedio >= 4.5) {
                    return "ALTO RENDIMIENTO";
                } else if (promedio >= 3.5) {
                    return "REGULAR";
                } else {
                    return "RIESGO";
                }
            }));
}
```

**`groupingBy` con lambda de bloque:** el clasificador puede ser una lambda compleja con lógica interna. Lo que retorne la lambda es la clave del mapa. `groupingBy` sin downstream collector usa `toList()` por defecto, por eso el valor del mapa es `List<Estudiante>`.

**Ojo con el orden de las condiciones:** primero se verifica `>= 4.5` (el caso más restrictivo). Luego `>= 3.5`. El `else` captura todo lo demás. Si pones las condiciones al revés, un estudiante con 4.8 caería en "REGULAR" porque 4.8 >= 3.5 también es verdadero.

---

## Ejercicio 9 — Materia más reprobada

**Qué pide:** encontrar el nombre de la materia que tiene más reprobaciones en todo el sistema.

**Retorna:** `String`

**Solución:**
```java
public String obtenerMateriaConMasReprobaciones(List<Estudiante> estudiantes) {
    return estudiantes.stream()
            .flatMap(e -> e.getNotas().stream())
            .filter(n -> !n.isAprobada())
            .collect(Collectors.groupingBy(Nota::getMateria, Collectors.counting()))
            .entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse("Sin reprobaciones");
}
```



**`entrySet()`** retorna el conjunto de pares clave-valor de un mapa. Cada `Map.Entry` tiene `.getKey()` y `.getValue()`. Es la forma de convertir un mapa en stream para procesarlo.

**`Collectors.counting()`** es equivalente a contar cuántos elementos cayeron en cada grupo. Retorna `Long`.

---

## Ejercicio 10 — Pipeline completo NARANJA

**Qué pide:** un pipeline encadenado que:
1. Filtre solo estudiantes del equipo NARANJA.
2. Tome todas sus notas.
3. Filtre solo las aprobadas.
4. Agrupe por materia y calcule el promedio.
5. Ordene descendente por promedio.
6. Retorne un `LinkedHashMap` que preserve el orden.

**Retorna:** `LinkedHashMap<String, Double>`

**Solución:**
```java
public LinkedHashMap<String, Double> promedioAprobadosNaranjaOrdenado(List<Estudiante> estudiantes) {
    return estudiantes.stream()
            .filter(e -> "NARANJA".equals(e.getEquipo()))
            .flatMap(e -> e.getNotas().stream())
            .filter(Nota::isAprobada)
            .collect(Collectors.groupingBy(
                    Nota::getMateria,
                    Collectors.averagingDouble(Nota::getPuntaje)
            ))
            .entrySet().stream()
            .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
            .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (e1, e2) -> e1,
                    LinkedHashMap::new
            ));
}
```

**Por qué `LinkedHashMap` y no `HashMap`?**
`HashMap` no garantiza ningún orden de iteración. Si ordenas el stream y luego recolectas en `HashMap`, el orden se pierde al guardar las entradas. `LinkedHashMap` mantiene el orden de inserción, así que si insertas en orden descendente, al recorrerlo después el orden se conserva.

**El cuarto argumento de `toMap`:**
`Collectors.toMap` tiene una variante con 4 parámetros:
```java
toMap(
    keyMapper,       // cómo extraer la clave
    valueMapper,     // cómo extraer el valor
    mergeFunction,   // qué hacer si hay dos entradas con la misma clave
    mapSupplier      // qué implementación de Map usar
)
```
`(e1, e2) -> e1` es la función de merge. Dice "si hay clave duplicada, quédate con la primera". En la práctica no debería haber duplicados porque `groupingBy` ya garantiza claves únicas, pero Java exige que se provea esta función cuando se especifica el `mapSupplier`.

`LinkedHashMap::new` es una method reference al constructor. Equivale a `() -> new LinkedHashMap<>()`.



---

## Pruebas unitarias

### Estructura y anotaciones JUnit 5

```java
@BeforeEach          // se ejecuta ANTES de cada @Test, para reiniciar datos
void setUp() { ... }

@Test                // marca un método como prueba
@DisplayName("...")  // nombre legible para el reporte
void miPrueba() { ... }
```

### Afirmaciones más usadas (Assertions)

| Método | Qué verifica |
|--------|-------------|
| `assertEquals(esperado, actual)` | los dos valores son iguales |
| `assertTrue(condicion)` | la condición es verdadera |
| `assertFalse(condicion)` | la condición es falsa |
| `assertNotNull(objeto)` | el objeto no es null |
| `assertInstanceOf(Clase.class, objeto)` | el objeto es instancia de la clase |
| `assertThrows(Excepcion.class, lambda)` | la lambda lanza esa excepción |

### Cobertura mínima del 80%

JaCoCo mide cuántas líneas del código fuente son ejecutadas por los tests. Con la configuración del `pom.xml` el build falla si la cobertura cae por debajo del 80%.

```
mvn verify     → compila + pruebas + genera reporte de cobertura
```

El reporte HTML queda en: `target/site/jacoco/index.html`

### Por qué `@BeforeEach` y no datos estáticos

Si pusieras los datos como campos estáticos, un test que modifique la lista afectaría a todos los siguientes. `@BeforeEach` garantiza que cada test empieza con datos frescos e independientes.

---

## Git Flow — flujo de trabajo

### Flujo correcto para esta semana

```bash
# Inicializar el proyecto (solo la primera vez)
git init
git flow init         # acepta los nombres por defecto

# Crear la rama para el trabajo de esta semana
git flow feature start semana1-analytics

# Trabajar y hacer commits descriptivos (uno por tarea lógica)
git add src/main/java/dosw/bitacora/corte2/semana1/Nota.java
git add src/main/java/dosw/bitacora/corte2/semana1/Estudiante.java
git commit -m "feat: agregar modelos Nota y Estudiante"

git add src/main/java/dosw/bitacora/corte2/semana1/Ejercicio1.java
git commit -m "feat: ejercicio 1 - filtrar equipo NARANJA"

# ... un commit por cada ejercicio o grupo lógico ...

git add src/test/java/dosw/bitacora/corte2/semana1/EjerciciosTest.java
git commit -m "test: pruebas unitarias para los 10 ejercicios"

# Finalizar la feature (se mezcla a develop automáticamente)
git flow feature finish semana1-analytics

# Subir develop al remoto
git push origin develop
```



### Convención de mensajes de commit

```
feat:     nueva funcionalidad
test:     añadir o modificar pruebas
fix:      corrección de un bug
refactor: cambio que no agrega ni quita funcionalidad
docs:     cambios solo en documentación
```

---

## Cheatsheet rápido

### Importaciones más usadas en estos ejercicios

```java
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Collections;
import java.util.stream.Collectors;
```

### Patrones recurrentes

**Filtrar y recolectar:**
```java
lista.stream().filter(x -> condicion).collect(Collectors.toList())
```

**Transformar y recolectar:**
```java
lista.stream().map(Clase::getAtributo).collect(Collectors.toList())
```

**Aplanar listas anidadas:**
```java
lista.stream().flatMap(x -> x.getSubLista().stream())
```

**Agrupar y contar:**
```java
.collect(Collectors.groupingBy(Clase::getClave, Collectors.counting()))
```

**Agrupar y promediar:**
```java
.collect(Collectors.groupingBy(Clase::getClave, Collectors.averagingDouble(Clase::getValor)))
```

**Agrupar y sumar:**
```java
.collect(Collectors.groupingBy(Clase::getClave, Collectors.summingLong(x -> expresion)))
```

**Máximo por un atributo:**
```java
lista.stream().max(Comparator.comparingDouble(x -> x.getAtributo())).orElseThrow()
```

**Top N descendente:**
```java
lista.stream()
     .sorted(Comparator.comparingLong((Tipo x) -> x.getAtributo()).reversed())
     .limit(N)
     .collect(Collectors.toList())
```

**Operar sobre entradas de un mapa:**
```java
mapa.entrySet().stream()
    .max(Map.Entry.comparingByValue())
    .map(Map.Entry::getKey)
    .orElse(valorDefecto)
```

**Recolectar en LinkedHashMap preservando orden:**
```java
.collect(Collectors.toMap(
    Map.Entry::getKey,
    Map.Entry::getValue,
    (e1, e2) -> e1,
    LinkedHashMap::new
))
```

### Optional — desenvolver valores que pueden no existir

`average()`, `max()`, `findFirst()` y similares retornan `Optional` porque pueden no tener resultado.

| Método | Comportamiento |
|--------|---------------|
| `.orElse(valor)` | retorna el valor si Optional está vacío |
| `.orElseThrow()` | lanza `NoSuchElementException` si está vacío |
| `.orElseThrow(supplier)` | lanza la excepción que proveas |
| `.map(func)` | transforma el valor interno si existe |
| `.isPresent()` | retorna true si hay valor |

### Method references — cuándo usarlas

Reemplaza lambdas que solo llaman un método:

| Lambda | Method reference equivalente |
|--------|------------------------------|
| `e -> e.getNombre()` | `Estudiante::getNombre` |
| `n -> n.getPuntaje()` | `Nota::getPuntaje` |
| `n -> n.isAprobada()` | `Nota::isAprobada` |
| `() -> new LinkedHashMap<>()` | `LinkedHashMap::new` |
| `e -> e.getKey()` | `Map.Entry::getKey` |

---

## Comandos Maven útiles

```bash
mvn compile          # solo compilar
mvn test             # compilar + correr pruebas
mvn verify           # compilar + pruebas + cobertura JaCoCo
mvn clean            # limpiar carpeta target/
mvn clean verify     # limpio desde cero + todo
```

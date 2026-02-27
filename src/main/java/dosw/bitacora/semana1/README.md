## Streams y git flow

## GIT

- git checkout develop(cambia desde la rama donde estas parado a la rama develop)
- git pull origin develop(sincroniza el repositorio remoto con el actual)
- git checkout -b feature/semana1(crea la nueva rama semana1, desde la rama donde este parado)
- git add .(añade todos los archivos modificados)
- git commit -m "feat: ddff"(guarda los cambios que haz realizado en el repositorio local)
- git merge feature/semana1(fusiona fearure/semana1 con la rama actual)
- git push origin develop(subirlo a github)
- git branch -d feature/semana1(borra la rama)

git status              # ver qué archivos cambiaron
git branch              # ver en qué rama estás
git log --oneline       # ver historial de commits
git branch -a           # ver todas las ramas

    
### Operaciones:
- filter(): filtrar elementos según condición
- map(): transformar elementos
- sorted(): ordenar elementos
- distinct(): eliminar duplicados
- limit(): limitar número de elementos
- skip(): saltar elementos
- forEach(): iterar elementos
- collect(): recolectar en colección
- count(): contar elementos
- reduce(): reducir a un valor único
- findFirst(), findAny(): encontrar elementos
- anyMatch(), allMatch(), noneMatch(): verificar condiciones
- peek() es una operación intermedia que te deja "espiar" cada elemento del stream sin modificarlo ni consumirlo.

# Ejercicios Realizados:
## Ejercicio 1:
— Números pares mayores a 10 (Clase
)
Descripción: Dada una lista de números enteros ingresada por el usuario, obtener únicamente los números pares que sean mayores a 10.
Conceptos aplicados: stream(), filter(), toList()
- Primero le agregamos un filtro para los numeros pares, luego le agregamos otro filtro para los numeros mayores a 10 y finalemtne usamos to list para que nos de los numeros en una lista.


```java
List<String> result = numbers.stream()
        .filter(n -> n % 2 == 0)
        .filter(n -> n > 10)
        .toList();
```


## Ejercicio 2:
— Procesamiento de palabras (Clase)
Descripción: Dada una lista de palabras, filtrar las que tengan más de 4 caracteres, convertirlas a mayúsculas, ordenarlas alfabéticamente y contar el total resultante.
Conceptos aplicados: filter(), map(), sorted(), count()
- Primero le agregamos el filtro para la palabrabras que tengan mas de 4 caracteres,usamos touppercase para pasarlas a mayuscula.
```java
  List<String> processed = words.stream()
  .filter(w -> w.length() > 4)
  .map(String::toUpperCase)
  .sorted()
  .toList();

long count = processed.stream().count();
```

## Ejercicio 3:
— Usuarios activos (Clase)
Descripción: Dada una lista de usuarios (con atributos id, name, age, active), filtrar únicamente los usuarios activos, obtener sus nombres en mayúsculas y ordenarlos alfabéticamente.
Conceptos aplicados: filter() con referencia a método, map() encadenado, sorted()

```java
List<String> result = users.stream()
.filter(User::isActive)
.map(User::getName)
.map(String::toUpperCase)
.sorted()
.toList();
```
## Ejercicio 4:
Filtrar mayores de edad (Casa)
Descripción: Dado un listado de usuarios con los mismos atributos anteriores, filtrar únicamente las personas mayores de edad (≥ 18 años) y obtener sus nombres.
Conceptos aplicados: filter() con lambda, map(), toList()
```java
List<String> result = users.stream()
.filter(u -> u.getAge() >= 18)
.map(User::getName)
.toList();
```

## Ejercico 5:
 — Validación de lote de transacciones (Casa)
Descripción: Dada una lista de transacciones bancarias, usar Streams para inspeccionar cada transacción con peek, verificar si existe alguna no aprobada y retornar si el lote es válido.
Conceptos aplicados: peek(), anyMatch(), operación terminal con efecto secundario
```java
boolean hasUnapproved = transactions.stream()
.peek(t -> System.out.println("Procesando: " + t))
.anyMatch(t -> !t.isApproved());

boolean isValid = !hasUnapproved;
```

# SOLID
- S = unica responsabilidad
- O = principio abirto/cerrado
- L = Principio de sustitucion de liskov
- I = Segregacion de interfaces
- D = Inversion de dependencias.


# Autoevaluacion semanal:
¿Que entendia mal antes?
- NO entendia la diferencia entre map() y forEach(), tambien pensaba que los streams modificaba directamente la coleccion original
¿Que entiendo ahora?
- que los streams son inmutables y no modifican la fuente, tambien aprendi los demas principios de solid , la sustitucion de liskov, segregacion de interfaces..


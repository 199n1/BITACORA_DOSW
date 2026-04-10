#  Análisis de Requerimientos — Plataforma de Batallas Bakugan

> Documento de análisis de requerimientos para una startup que desarrolla una plataforma web de colección y combate estratégico basada en Bakugan.

---

##  Descripción del Proyecto

La plataforma permite a los usuarios **coleccionar criaturas Bakugan, mejorarlas y enfrentarse en combates estratégicos** no en tiempo real. El sistema incluye mecánicas de progresión, gestión de inventario y emparejamiento justo entre jugadores, con capacidad de escalar hacia eventos especiales, rankings y modos cooperativos.

El cliente ha expresado inquietudes específicas relacionadas con:
- El balance entre criaturas y habilidades
- La posibilidad de hacer emparejamientos justos entre jugadores
- La persistencia de la información de las partidas
- La facilidad de evolución del sistema a futuro

---


## 1. Identificación y Clasificación de Requerimientos

A partir del enunciado se extrajeron tanto **requerimientos explícitos** (mencionados directamente) como **requerimientos implícitos** (supuestos razonables para cualquier sistema web de este tipo, como autenticación, seguridad y disponibilidad).

### Criterio de clasificación

- **Funcional (RF):** Describe **QUÉ hace** el sistema — una acción, comportamiento o dato que el sistema procesa o gestiona. Implica lógica de negocio ejecutable.
- **No Funcional (RNF):** Describe **CÓMO se comporta** el sistema — un atributo de calidad medible (rendimiento, seguridad, escalabilidad, disponibilidad).

---

### 1.1 Requerimientos Funcionales

| ID | Nombre | Descripción (El sistema debe...) | Módulo |
|----|--------|----------------------------------|--------|
| RF-01 | Registro de usuarios | El sistema debe permitir a los usuarios registrarse con correo, contraseña y datos básicos de perfil. | Autenticación |
| RF-02 | Autenticación de usuarios | El sistema debe permitir iniciar y cerrar sesión de forma segura mediante credenciales válidas. | Autenticación |
| RF-03 | Colección de criaturas Bakugan | El sistema debe permitir al usuario poseer, visualizar y gestionar una colección personal de criaturas Bakugan. | Inventario |
| RF-04 | Adquisición de criaturas | El sistema debe ofrecer un mecanismo para que los usuarios obtengan nuevas criaturas (compra, sorteo, recompensa o intercambio). | Inventario |
| RF-05 | Mejora / evolución de criaturas | El sistema debe permitir al usuario mejorar o evolucionar sus criaturas usando recursos o puntos obtenidos en combates. | Progresión |
| RF-06 | Combate estratégico entre jugadores | El sistema debe permitir que dos jugadores se enfrenten en combates estratégicos por turnos, determinando un ganador con base en estadísticas y habilidades. | Combate |
| RF-07 | Emparejamiento justo (matchmaking) | El sistema debe emparejar jugadores con niveles y poder de criaturas similares para garantizar combates equilibrados. | Combate |
| RF-08 | Balance de criaturas y habilidades | El sistema debe aplicar un modelo de balance que impida que una criatura o combinación de habilidades sea dominante de forma injusta. | Combate |
| RF-09 | Persistencia de partidas | El sistema debe almacenar el historial completo de combates, incluyendo resultado, criaturas usadas y estadísticas por jugador. | Historial |
| RF-10 | Gestión de inventario | El sistema debe permitir al usuario organizar, filtrar y consultar su inventario de criaturas y recursos. | Inventario |
| RF-11 | Sistema de recursos / moneda interna | El sistema debe gestionar una moneda o puntos de juego que sirvan para mejorar criaturas y adquirir ítems. | Economía |
| RF-12 | Perfil de jugador y estadísticas | El sistema debe mostrar a cada usuario su perfil con estadísticas de victorias, derrotas y progresión. | Perfil |
| RF-13 | Ranking global de jugadores | El sistema debe calcular y mostrar un ranking de los mejores jugadores, actualizado periódicamente. | Rankings |
| RF-14 | Notificaciones de combate | El sistema debe notificar al jugador cuando sea su turno o cuando reciba un reto de combate. | Combate |
| RF-15 | Recuperación de contraseña | El sistema debe permitir al usuario recuperar el acceso a su cuenta mediante correo electrónico. | Autenticación |

---

### 1.2 Requerimientos No Funcionales

| ID | Nombre | Descripción (El sistema debe...) | Módulo |
|----|--------|----------------------------------|--------|
| RNF-01 | Consistencia / determinismo del combate | El sistema debe garantizar que los resultados de un combate sean deterministas: los mismos inputs siempre producen el mismo resultado. | Combate |
| RNF-02 | Disponibilidad del sistema | El sistema debe estar disponible al menos el 99% del tiempo mensual (máximo 7.2 h de inactividad/mes). | Infraestructura |
| RNF-03 | Seguridad de datos de usuario | El sistema debe cifrar contraseñas con bcrypt (factor ≥ 12) y todas las comunicaciones con HTTPS / TLS 1.2+. | Autenticación |
| RNF-04 | Rendimiento bajo carga | El sistema debe responder el 95% de las peticiones en menos de 2 segundos con hasta 500 usuarios concurrentes. | Infraestructura |
| RNF-05 | Escalabilidad del sistema | La arquitectura debe permitir agregar nuevos módulos (eventos, cooperativo, etc.) sin rediseñar el núcleo del sistema. | Arquitectura |
| RNF-06 | Usabilidad web responsive | La interfaz debe ser accesible y funcional en dispositivos de escritorio y móviles (mínimo 360 px de ancho). | Frontend |
| RNF-07 | Persistencia y respaldo de datos | El sistema debe realizar copias de seguridad automáticas de la base de datos al menos una vez al día. | Infraestructura |
| RNF-08 | Extensibilidad del modelo de datos | El modelo de datos debe soportar nuevas criaturas, habilidades y modos de juego sin migraciones destructivas. | Arquitectura |

---

## 2. Priorización de Requerimientos

**Criterios aplicados:**
- 🔴 **Alta:** Crítico para el MVP; sin él el sistema no puede lanzarse o el negocio no existe.
- 🟡 **Media:** Importante para la experiencia y retención, pero puede diferirse una iteración.
- 🟢 **Baja:** Deseable; mencionado como posible mejora futura.

| ID | Nombre | Prioridad | Justificación |
|----|--------|-----------|---------------|
| RF-01 | Registro de usuarios | 🔴 Alta | Sin registro no existe ninguna funcionalidad base. |
| RF-02 | Autenticación de usuarios | 🔴 Alta | Requisito previo para toda acción del usuario. |
| RF-03 | Colección de criaturas Bakugan | 🔴 Alta | Núcleo del valor de negocio ofrecido. |
| RF-04 | Adquisición de criaturas | 🔴 Alta | Sin adquisición no hay progresión posible. |
| RF-05 | Mejora / evolución de criaturas | 🔴 Alta | Central para retención y progresión del usuario. |
| RF-06 | Combate estratégico | 🔴 Alta | Propósito central de la plataforma. |
| RF-07 | Emparejamiento justo | 🔴 Alta | Preocupación explícita del cliente. |
| RF-08 | Balance de criaturas | 🔴 Alta | Preocupación explícita del cliente. |
| RF-09 | Persistencia de partidas | 🔴 Alta | Preocupación explícita del cliente; base para rankings. |
| RF-10 | Gestión de inventario | 🟡 Media | Mejora la experiencia pero no bloquea el core. |
| RF-11 | Moneda interna | 🔴 Alta | Habilita la progresión y retención. |
| RF-12 | Perfil y estadísticas | 🟡 Media | Necesario para motivar progresión; depende de RF-09. |
| RF-13 | Ranking global | 🟡 Media | Mencionado como funcionalidad futura; aumenta retención. |
| RF-14 | Notificaciones de combate | 🟡 Media | Clave para combates no en tiempo real. |
| RF-15 | Recuperación de contraseña | 🔴 Alta | Seguridad básica; supuesto razonable. |
| RNF-01 | Determinismo del combate | 🔴 Alta | Mencionado explícitamente; afecta confianza del usuario. |
| RNF-02 | Disponibilidad ≥ 99% | 🔴 Alta | Plataforma en línea; downtime implica pérdida de usuarios. |
| RNF-03 | Seguridad y cifrado | 🔴 Alta | Requisito legal y de confianza del usuario. |
| RNF-04 | Rendimiento bajo carga | 🟡 Media | Relevante al escalar; no crítico en lanzamiento inicial. |
| RNF-05 | Escalabilidad | 🔴 Alta | Cliente menciona evolución futura como prioridad. |
| RNF-06 | Responsive | 🟡 Media | Plataforma web; usuarios acceden desde varios dispositivos. |
| RNF-07 | Respaldo de datos | 🔴 Alta | Pérdida de datos destruye la confianza; preocupación del cliente. |
| RNF-08 | Extensibilidad del modelo | 🔴 Alta | Directamente ligado a la inquietud sobre funciones futuras. |

---

## 3. Flujos del Sistema

### 3.1 Flujo Básico — Registro e inicio de sesión

**Funcionalidad:** TC-01 — Iniciar sesión  
**Actores:** Estudiante, Graduado, Profesor, Personal Administrativo, Familiares, Capitán, Administrador, Organizador  
**Precondición:** El usuario debe estar registrado en el sistema y el sistema debe estar disponible.

#### Datos de entrada

| Nombre | Descripción | Tipo de campo | Reglas / Aplicación | Obligatorio |
|--------|-------------|---------------|---------------------|-------------|
| Correo | Correo del usuario para poder identificarse | String | Correo institucional (@escuelaing..) para estudiantes, profesores, administrativos; Gmail para familiares | Sí |
| Contraseña | Clave del usuario (secreta) | String | Mínimo 8 caracteres | Sí |

#### Datos de salida

| Nombre | Descripción | Tipo de campo | Reglas / Aplicación | Obligatorio |
|--------|-------------|---------------|---------------------|-------------|
| Mensaje confirmación | "Bienvenido [nombre]", si las credenciales son correctas | String | Es visible solo si el correo y contraseña coinciden con la base de datos | Sí |
| Mensaje de error | Correo o contraseña incorrectos | String | La página destino cambia según el rol (organizador, árbitro…) | Sí |
| Redirección a la página | El sistema lo lleva a su panel según su rol | String | Es visible solo si el correo o contraseña no coinciden con la base de datos | No |

#### Flujo básico

| Paso | Actor | Descripción | Excepciones |
|------|-------|-------------|-------------|
| 1 | Usuario | Ingresa a inicio de sesión | |
| 2 | Usuario | Digita su correo y contraseña | |
| 3 | Usuario | Da click en iniciar sesión | |
| 4 | Usuario | Es verificado con la base de datos los datos ingresados | TH-01 Credenciales Incorrectas |
| 5 | Usuario | Es redirigido a su página correspondiente | |

#### Flujo alterno

| Paso | Actor | Descripción | Excepciones |
|------|-------|-------------|-------------|
| TH-01 | Usuario | Se muestra el mensaje "correo o contraseña incorrectos" | El usuario puede reintentar |

**Notas y comentarios:** El sistema bloquea el acceso después de 5 intentos fallidos.

---

### 3.2 Flujo Básico — Combate entre jugadores

**Precondición:** El jugador debe estar autenticado y tener al menos una criatura en su inventario.

#### Flujo básico

| Paso | Actor | Descripción | Excepciones |
|------|-------|-------------|-------------|
| 1 | Jugador A | Selecciona sus criaturas para el combate | |
| 2 | Sistema | Busca un oponente con poder similar (matchmaking) | TH-01 Sin oponente disponible |
| 3 | Sistema | Crea la sala de combate y notifica a ambos jugadores | |
| 4 | Jugador A | Selecciona habilidad / acción de turno | |
| 5 | Sistema | Calcula resultado del turno de forma determinista | |
| 6 | Jugador B | Selecciona habilidad / acción de turno | |
| 7 | Sistema | Repite pasos 4–6 hasta que un jugador no tenga criaturas activas | |
| 8 | Sistema | Determina ganador, otorga recursos y guarda historial | |

#### Flujo alterno

| Paso | Actor | Descripción | Excepciones |
|------|-------|-------------|-------------|
| TH-01 | Sistema | Notifica que no hay oponentes disponibles en este momento | El jugador puede reintentar o esperar en cola |
| TH-02 | Sistema | Contabiliza derrota automática al jugador inactivo pasado el tiempo límite de turno | El jugador puede ser penalizado con reducción de puntos |

**Notas y comentarios:** Los resultados del combate son deterministas; los mismos inputs producen siempre el mismo resultado.

---

### 3.3 Flujo Básico — Mejora de criatura

**Precondición:** El usuario debe estar autenticado, tener la criatura en inventario y contar con recursos suficientes.

#### Flujo básico

| Paso | Actor | Descripción | Excepciones |
|------|-------|-------------|-------------|
| 1 | Usuario | Accede a su inventario y selecciona una criatura | |
| 2 | Usuario | Selecciona la opción "Mejorar" | |
| 3 | Sistema | Muestra costo en moneda interna y estadísticas resultantes | |
| 4 | Usuario | Confirma la mejora | |
| 5 | Sistema | Descuenta recursos, actualiza estadísticas y guarda cambios | TH-01 Recursos insuficientes |

#### Flujo alterno

| Paso | Actor | Descripción | Excepciones |
|------|-------|-------------|-------------|
| TH-01 | Sistema | Muestra mensaje "recursos insuficientes" e indica cuánto falta | El usuario puede continuar jugando para obtener más recursos |

---

## 4. Identificación de Dependencias y Bloqueos

```
RF-01 (Registro)
  └── RF-02 (Autenticación)
        └── RF-03 (Colección)
              ├── RF-04 (Adquisición)  ←── también depende de RF-11
              ├── RF-05 (Mejora)       ←── también depende de RF-11
              └── RF-06 (Combate)
                    ├── RF-07 (Matchmaking)  ←── también depende de RF-09
                    ├── RF-08 (Balance)
                    ├── RF-09 (Persistencia)
                    │     └── RF-12 (Perfil)
                    │           └── RF-13 (Ranking)
                    └── RF-14 (Notificaciones)
```

### Tabla de dependencias

| ID | Depende de | Descripción del bloqueo / dependencia |
|----|-----------|--------------------------------------|
| RF-02 | RF-01 | Autenticación depende de que el registro exista. |
| RF-03 | RF-02 | Gestionar colección requiere usuario autenticado. |
| RF-04 | RF-03, RF-11 | Adquirir criaturas requiere inventario y moneda activos. |
| RF-05 | RF-03, RF-11 | Mejorar criaturas requiere tenerlas y tener recursos suficientes. |
| RF-06 | RF-02, RF-03 | Combatir requiere sesión activa y criaturas disponibles en inventario. |
| RF-07 | RF-06, RF-09 | El matchmaking necesita datos de combates pasados para calcular nivel. |
| RF-08 | RF-06 | El balance se aplica dentro del motor de combate. |
| RF-12 | RF-09 | El perfil de jugador se nutre del historial de combates persistido. |
| RF-13 | RF-09, RF-12 | El ranking requiere estadísticas acumuladas por jugador. |
| RF-14 | RF-06 | Las notificaciones se disparan por eventos de combate. |
| RNF-01 | RF-06 | El determinismo es un atributo del motor de combate. |
| RNF-05 | RNF-08 | La escalabilidad se facilita con un modelo de datos extensible. |

###  Bloqueos críticos identificados

- La indefinición del **mecanismo de combate** (Ambigüedad #2) bloquea RF-06, RF-07, RF-08 y RNF-01.
- La decisión sobre **monetización** (Ambigüedad #1) puede bloquear RF-04 y RF-11 si implica cumplimiento legal adicional (regulación de loot boxes).
- La ausencia de un **panel de administración** definido puede bloquear la gestión de balance (RF-08) si no hay herramientas internas para ajustar parámetros.

---
### Matriz de trazabilidad

| Código de requerimiento | Requerimiento | Historia de usuario | Tareas principales |
|-------------------------|---------------|---------------------|--------------------|
| RF-01 | Registro de usuarios | Como nuevo usuario quiero registrarme en la plataforma con mi correo y contraseña para poder acceder al sistema. | Endpoint de registro, validación de correo, hash de contraseña, DTO Register |
| RF-02 | Autenticación de usuarios | Como usuario registrado quiero iniciar sesión con mis credenciales para poder usar la plataforma según mi rol. | AuthController, AuthService, DTO Login, generación de token JWT |
| RF-03 | Colección de criaturas | Como jugador quiero ver y gestionar mi colección personal de criaturas Bakugan para conocer mis activos de juego. | ColeccionController, ColeccionService, modelo Criatura, endpoint listar colección |
| RF-04 | Adquisición de criaturas | Como jugador quiero obtener nuevas criaturas mediante el mecanismo definido para ampliar mi colección. | Endpoint adquisición, lógica de sorteo/compra, actualización de inventario, descuento de moneda |
| RF-05 | Mejora / evolución de criaturas | Como jugador quiero mejorar mis criaturas usando los recursos obtenidos en combates para aumentar su poder. | MejoraController, MejoraService, validación de recursos, actualización de stats de criatura |
| RF-06 | Combate estratégico | Como jugador quiero enfrentarme a otro jugador en un combate estratégico por turnos para competir en la plataforma. | CombateController, CombateService, motor de turnos, determinación de ganador |
| RF-07 | Emparejamiento justo (matchmaking) | Como jugador quiero ser emparejado con oponentes de nivel similar para tener combates equilibrados. | MatchmakingService, algoritmo de emparejamiento por poder, endpoint buscar oponente |
| RF-08 | Balance de criaturas y habilidades | Como administrador quiero que el sistema aplique reglas de balance para que ninguna criatura domine injustamente. | BalanceService, parámetros de balance configurables, validación de win-rate |
| RF-09 | Persistencia de partidas | Como jugador quiero que mis combates queden guardados para poder consultar mi historial de juego. | HistorialController, HistorialService, modelo Partida, endpoint guardar resultado |
| RF-10 | Gestión de inventario | Como jugador quiero filtrar y organizar mi inventario de criaturas para encontrar las que necesito fácilmente. | InventarioController, filtros por tipo/nivel/poder, endpoint listar con query params |
| RF-11 | Moneda / recursos internos | Como jugador quiero acumular y gastar moneda interna para mejorar mis criaturas y adquirir ítems. | EconomiaService, modelo Transaccion, endpoint consultar saldo, validación de fondos |
| RF-12 | Perfil de jugador y estadísticas | Como jugador quiero ver mi perfil con mis victorias y derrotas para seguir mi progresión. | PerfilController, PerfilService, cálculo de estadísticas, endpoint perfil por usuario |
| RF-13 | Ranking global | Como jugador quiero ver el ranking de los mejores jugadores para conocer mi posición en la plataforma. | RankingController, RankingService, cálculo de puntuación, endpoint top jugadores |
| RF-14 | Notificaciones de combate | Como jugador quiero recibir una notificación cuando sea mi turno para no perder mis combates activos. | NotificacionService, integración de eventos, endpoint estado de combate activo |
| RF-15 | Recuperación de contraseña | Como usuario quiero recuperar el acceso a mi cuenta por correo electrónico en caso de olvidar mi contraseña. | Endpoint recuperación, generación de token temporal, envío de correo, reset de contraseña |
| RNF-01 | Determinismo del combate | Como jugador quiero que los resultados del combate sean consistentes para confiar en la plataforma. | Prueba de determinismo: mismo input → mismo output en 100 ejecuciones |
| RNF-02 | Disponibilidad ≥ 99% | Como usuario quiero que la plataforma esté disponible cuando la necesite para jugar sin interrupciones. | Configuración de servidor, monitoreo de uptime, alertas de caída |
| RNF-03 | Seguridad y cifrado | Como usuario quiero que mis datos estén protegidos para confiar en la plataforma. | bcrypt en contraseñas, HTTPS/TLS 1.2+, auditoría de seguridad |
| RNF-04 | Rendimiento bajo carga | Como usuario quiero que la plataforma responda rápido incluso con muchos usuarios conectados. | Prueba de carga: P95 < 2 s con 500 usuarios simultáneos |
| RNF-05 | Escalabilidad | Como equipo de desarrollo queremos poder agregar nuevos módulos sin rediseñar el sistema base. | Revisión de arquitectura, diseño modular, documentación de extensión |
| RNF-06 | Responsive | Como jugador quiero usar la plataforma desde mi celular o computador sin problemas de visualización. | Prueba responsiva en Chrome / Firefox / Safari móvil (min. 360 px) |
| RNF-07 | Respaldo de datos | Como administrador quiero que los datos se respalden diariamente para no perder información en caso de fallo. | Configuración de backups automáticos, prueba de restauración en < 4 h |
| RNF-08 | Extensibilidad del modelo | Como desarrollador quiero que el modelo de datos permita agregar nuevas criaturas y modos sin migraciones destructivas. | Revisión de modelo de datos, prueba de agregación de nueva criatura sin romper BD |


##  ¿Cómo identificar las Tareas Principales?

Las tareas principales son los **componentes técnicos que el equipo de desarrollo necesita construir** para que ese requerimiento funcione. No es lo que hace el usuario, sino **lo que tiene que existir en el código/sistema** para satisfacer ese requerimiento.

---

### La fórmula mental para identificarlas

Cuando leas un requerimiento, hazte estas 3 preguntas:

- **¿Quién recibe la petición?** → Controller / Endpoint
- **¿Quién ejecuta la lógica?** → Service
- **¿Con qué datos viaja la información?** → DTO / Modelo
---

### Cómo identificarlas según el tipo de requerimiento

| Tipo de requerimiento | Tareas típicas |
|-----------------------|----------------|
| Autenticación / Usuarios | Controller + Service + DTO + seguridad (hash, token) |
| Consulta / Listado | Controller + Service + endpoint con filtros + query params |
| Creación / Modificación | Controller + Service + DTO de entrada + validaciones + modelo actualizado |
| Notificación / Eventos | Service de eventos + integración (email, websocket) + trigger |
| No Funcional (rendimiento, seguridad) | Configuración de infraestructura, pruebas, herramientas (bcrypt, HTTPS, prueba de carga) |

---

### Truco clave

Lee el requerimiento y completa esta oración mentalmente:

> *"Para que esto funcione, alguien tiene que **recibir la petición** → Controller, alguien tiene que **procesar la lógica** → Service, y los datos tienen que viajar como → DTO."*

Eso te da directamente las 3 tareas principales mínimas de cualquier requerimiento funcional.

---

### Ejemplo paso a paso

Requerimiento: **"El sistema debe permitir iniciar sesión"**

| Pregunta | Respuesta | Tarea |
|----------|-----------|-------|
| ¿Quién recibe la petición HTTP del usuario? | El controlador de autenticación | `AuthController` |
| ¿Quién valida las credenciales y genera el token? | El servicio de autenticación | `AuthService` |
| ¿Con qué estructura llegan el correo y contraseña? | Un objeto de transferencia de datos | `DTO Login` |
| ¿Qué protocolo de seguridad se necesita? | Token de sesión | `JWT / Token` |

**Resultado:** `AuthController, AuthService, DTO Login, generación de token JWT`

### El patrón que se repite casi siempre

#### 🔵 Controller
Recibe la petición HTTP del usuario y la delega al Service.
No contiene lógica de negocio, solo dirige el tráfico.

**Ejemplo:**
- `AuthController` → recibe el POST de login
- `CombateController` → recibe el POST de iniciar combate
- `RankingController` → recibe el GET de consultar ranking

---

#### 🟢 Service
Contiene toda la lógica de negocio. Es quien realmente
"piensa" y toma decisiones. El Controller lo llama,
él hace el trabajo.

**Ejemplo:**
- `AuthService` → valida credenciales, genera el token JWT
- `CombateService` → calcula el resultado del turno, determina ganador
- `RankingService` → calcula puntuaciones y ordena jugadores

---

#### 🟡 DTO (Data Transfer Object)
Es el "molde" con el que viajan los datos entre capas.
Define exactamente qué campos se reciben o se devuelven.
Evita exponer directamente el modelo de la base de datos.

**Ejemplo:**
- `DTO Login` → recibe `{ correo, contraseña }`
- `DTO Register` → recibe `{ nombre, correo, contraseña, rol }`
- `DTO CombateResultado` → devuelve `{ ganador, turnos, experienciaGanada }`

---

#### 🟠 Modelo / Entidad
Representa la tabla en la base de datos.
Es la estructura del objeto tal como se guarda.

**Ejemplo:**
- `Usuario` → tabla con id, nombre, correo, contraseña, rol
- `Criatura` → tabla con id, nombre, poder, nivel, tipo
- `Partida` → tabla con id, jugador1, jugador2, ganador, fecha

---

####  Endpoints (rutas HTTP)

Los endpoints son las URLs concretas que expone el sistema.
Cada uno tiene un método HTTP que indica qué tipo de acción realiza:

| Método | Para qué se usa | Ejemplo |
|--------|-----------------|---------|
| `GET` | Consultar / listar información | `GET /jugadores` → lista todos los jugadores |
| `POST` | Crear un nuevo recurso | `POST /auth/login` → iniciar sesión |
| `PUT` | Actualizar un recurso completo | `PUT /criaturas/{id}` → editar criatura completa |
| `PATCH` | Actualizar solo un campo | `PATCH /criaturas/{id}/nivel` → subir solo el nivel |
| `DELETE` | Eliminar un recurso | `DELETE /inventario/{id}` → eliminar criatura del inventario |

---

### El patrón que se repite casi siempre
---

## 6. Análisis de Ambigüedades

Se identificaron **5 aspectos** del enunciado que son ambiguos, están incompletos o requieren validación formal con el cliente **antes** de proceder al diseño técnico.

### Ambigüedad #1 — Mecanismo de adquisición de criaturas

| Campo | Detalle |
|-------|---------|
| **Tipo** | Incompleto |
| **Descripción** | El enunciado menciona "coleccionar criaturas" pero no especifica cómo se adquieren: ¿compra con dinero real, moneda interna, sorteo aleatorio (gacha), misiones o intercambio entre jugadores? |
| **Pregunta al cliente** | ¿Cuál es el modelo de adquisición de criaturas? ¿Habrá monetización con dinero real (microtransacciones)? |
| **Impacto** | Afecta el diseño de economía interna, regulaciones legales (loot boxes) y el modelo de negocio completo. |

---

### Ambigüedad #2 — Definición de "combate estratégico" ⚠️ Bloqueante

| Campo | Detalle |
|-------|---------|
| **Tipo** | Ambiguo |
| **Descripción** | El enunciado indica que los combates no son en tiempo real y deben ser estratégicos, pero no define el mecanismo: ¿turnos con tiempo límite (ej. 24 h por turno)?, ¿selección de habilidades previa al combate?, ¿sistema de cartas?, ¿automatizado con IA? |
| **Pregunta al cliente** | ¿Cómo funciona exactamente un combate? ¿Los jugadores toman decisiones durante el combate o solo configuran su equipo antes de que el sistema resuelva el resultado? |
| **Impacto** | Determina completamente la arquitectura del motor de combate y toda la experiencia de usuario. **Bloquea RF-06, RF-07, RF-08 y RNF-01.** |

---

### Ambigüedad #3 — Criterio de balance de criaturas

| Campo | Detalle |
|-------|---------|
| **Tipo** | Ambiguo / Requiere validación |
| **Descripción** | El cliente menciona "balance entre criaturas y habilidades" como preocupación, pero no hay criterio cuantitativo. No se sabe si habrá criaturas raras más poderosas intencionalmente (como en el juego original Bakugan) o si todas deben estar equilibradas. |
| **Pregunta al cliente** | ¿Es aceptable que criaturas raras sean más poderosas? ¿Qué porcentaje de win-rate máximo se considera balanceado? |
| **Impacto** | Afecta el diseño del sistema de balance, el matchmaking y la estrategia de monetización. |

---

### Ambigüedad #4 — Alcance de funcionalidades futuras

| Campo | Detalle |
|-------|---------|
| **Tipo** | Incompleto |
| **Descripción** | Se mencionan eventos especiales, rankings y modos cooperativos como posibles futuras funcionalidades, pero sin prioridad ni detalle. No hay claridad sobre si deben diseñarse desde el inicio o solo contemplarse en la arquitectura. |
| **Pregunta al cliente** | ¿Cuáles de estas funcionalidades son compromisos para versiones futuras y cuáles son solo ideas? ¿Hay fechas tentativas? |
| **Impacto** | Afecta decisiones de arquitectura (escalabilidad) y el roadmap del producto. |

---

### Ambigüedad #5 — Modelo de usuarios y roles

| Campo | Detalle |
|-------|---------|
| **Tipo** | Incompleto |
| **Descripción** | El enunciado solo menciona "usuarios" de forma genérica. No se define si habrá roles como administradores del sistema, moderadores, usuarios premium ni si existirá un panel de administración. |
| **Pregunta al cliente** | ¿Existirán diferentes tipos de usuario? ¿Habrá panel de administración para gestionar el balance y los eventos? |
| **Impacto** | Afecta el modelo de autenticación, permisos, desarrollo del backend y la herramienta de ajuste de balance. |

---

## 7. Módulos del Sistema

```
Plataforma Bakugan
├──  Autenticación     (RF-01, RF-02, RF-15, RNF-03)
├──  Inventario        (RF-03, RF-04, RF-10)
├──  Progresión        (RF-05)
├──  Economía          (RF-11)
├──  Combate          (RF-06, RF-07, RF-08, RF-14, RNF-01)
├── Historial         (RF-09)
├──  Perfil            (RF-12)
├──  Rankings          (RF-13)
└──   Infraestructura  (RNF-02, RNF-04, RNF-05, RNF-06, RNF-07, RNF-08)
```

---

## 8. Conclusiones



| Métrica | Valor |
|---------|-------|
| Total de requerimientos identificados | 23 |
| Requerimientos funcionales | 15 |
| Requerimientos no funcionales | 8 |
| Prioridad Alta | 14 |
| Prioridad Media | 9 |
| Ambigüedades identificadas | 5 |
| Módulos del sistema | 9 |
| Requerimientos bloqueados por ambigüedades | 4 (RF-06, RF-07, RF-08, RNF-01) |


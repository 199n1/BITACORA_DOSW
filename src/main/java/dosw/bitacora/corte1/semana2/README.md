# Patrones 

## Ejercicio 1: Patron creacional factory method
- El Factory Method es un patrón de diseño que nos dice: no crees los objetos directamente con new en el código principal. En cambio, delega esa responsabilidad a una clase especializada llamada Creator.
La idea central es que el código principal trabaja con una interfaz general, y no sabe ni le importa qué tipo concreto de objeto se está creando por dentro.
Ejemplo:Imagina que vas a una cafetería y pides "un café". No te importa si el barista usa una máquina espresso, una prensa francesa o una cafetera de goteo. Tú solo pides café y lo recibes. El barista es el Creator y el café es el Producto.
Estructura del patrón

Interfaz Producto → define qué puede hacer el objeto (enviar una notificación).
Productos Concretos → las clases reales (Email, SMS, Push).
Creator Abstracto → declara el Factory Method y tiene lógica común reutilizable.
Creators Concretos → sobreescriben el Factory Method y deciden qué producto crear.
Interfaz Notificacion
Esta interfaz es el "contrato". Cualquier tipo de notificación debe poder enviarse. No importa cómo lo haga por dentro, solo debe cumplir con este método. Esto nos permite trabajar con polimorfismo: tratar a todos los tipos de notificación de la misma manera.
Productos Concretos
Cada clase concreta implementa la interfaz Notificacion a su manera. El @Override nos dice que estamos sobreescribiendo el método de la interfaz. Lo mismo aplica para SMS y Push, solo cambia cómo muestran el mensaje.
Creator Abstracto
El Creator abstracto tiene dos cosas: el Factory Method (abstracto, que las subclases deben implementar) y el método notificar() que usa ese Factory Method. Fíjate que notificar() no sabe qué tipo de Notificacion va a recibir, solo sabe que puede llamar enviar().
Creators Concretos
Cada Creator concreto solo sobreescribe crearNotificacion() para devolver su tipo de producto. Todo el trabajo real lo hereda del Creator abstracto.

## Ejercicio 2: Patrón Estructural Adapter
- El patrón Adapter es exactamente lo que su nombre dice: un adaptador. Su función es hacer que dos clases incompatibles puedan trabajar juntas sin modificar ninguna de las dos.
Esto pasa mucho en la vida real del programador: tienes código viejo que no puedes tocar, y código nuevo que necesita usarlo. El Adapter actúa como traductor entre ambos.
Ejemplo:Es como el adaptador de enchufes que usas cuando viajas a otro país. El enchufe de tu cargador es el mismo (tu sistema), el tomacorriente del hotel es diferente (clase incompatible), y el adaptador en el medio hace que funcionen juntos sin modificar ninguno de los dos.
Estructura del patrón

Client → el sistema que usa la interfaz (nuestro Main).
Client Interface (Impresora) → el contrato que el sistema espera.
Adapter → implementa la interfaz y traduce las llamadas a la clase incompatible.
Service → la clase existente que no podemos modificar.


## Ejercicio 3: Patrón de Comportamiento Memento
- El patrón Memento permite guardar el estado interno de un objeto en un momento dado y restaurarlo después. Es básicamente la función Ctrl+Z (deshacer) de cualquier editor.
Lo importante es que el estado se guarda sin violar el encapsulamiento: el objeto que guarda los estados no puede leer ni modificar lo que está guardando.
- Ejemplo: Imagina que le sacas una foto a tu cuarto antes de desordenarlo. Si quieres volver a como estaba, miras la foto y ordenas todo igual. Tú no le dices a la foto cómo hacerlo, simplemente la usas como referencia. La foto es el Memento.

## Ejercicio 4 : Principios SOLID, Calculadora
- Esta es la pregunta más común en este ejercicio. La respuesta está en dos principios SOLID: SRP y OCP.
SRP dice que cada clase debe tener una sola razón para cambiar. Si todas las operaciones están en una clase y necesitas cambiar cómo funciona la división, estás tocando la misma clase donde está la suma. Eso no tiene sentido.
OCP dice que debes poder agregar funcionalidad nueva sin modificar el código existente. Con clases separadas, agregar Potencia o Modulo es crear una clase nueva, sin tocar nada más.
## ¿Qué aprendí?

Entendí cómo el Factory Method me permite crear objetos sin que el código principal sepa cuáles son exactamente, cómo el Adapter hace que dos clases incompatibles puedan trabajar juntas sin tocarlas, y cómo el Memento guarda estados anteriores sin romper el encapsulamiento
## ¿Qué se me dificultó?
entender el patrón Adapter, porque al principio no veía la diferencia entre simplemente modificar las clases existentes y crear un adapter. Con el tiempo entendí que en proyectos reales no siempre puedes tocar el código viejo, ya sea porque no es tuyo, porque otros dependen de él, o porque está en una librería externa. También me costó entender el Memento porque los tres roles (Originator, Memento, Caretaker) se parecen mucho al principio y confundí quién hace qué.

package dosw.bitacora.semana2.ejercicio2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Mensaje msg = new Mensaje("Hola Mundo", "Ana", "2025-01-01");

        List<Impresora> impresoras = List.of(
                new ImpresoraSimpleAdapter(),
                new ImpresoraDetalladaAdapter()
        );
        impresoras.forEach(i -> {
            System.out.println("--- Impresora ---");
            i.imprimir(msg);
        });
    }
}

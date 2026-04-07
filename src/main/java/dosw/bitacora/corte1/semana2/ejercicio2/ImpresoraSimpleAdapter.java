package dosw.bitacora.corte1.semana2.ejercicio2;

public class ImpresoraSimpleAdapter implements Impresora {
    private final ImpresoraSimple impresora = new ImpresoraSimple();

    @Override
    public void imprimir(Mensaje mensaje) {
        impresora.imprimir(mensaje.getTexto());
    }
}

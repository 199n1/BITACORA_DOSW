package dosw.bitacora.semana2.ejercicio2;

public class ImpresoraDetalladaAdapter implements Impresora {
    private final ImpresoraDetallada impresora = new ImpresoraDetallada();

    @Override
    public void imprimir(Mensaje mensaje) {
        impresora.imprimirDetalle(mensaje.getTexto(), mensaje.getAutor(), mensaje.getFecha());
    }
}

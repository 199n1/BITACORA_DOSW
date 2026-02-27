package dosw.bitacora.semana2.ejercicio3;

public class Main {
    public static void main(String[] args) {
        Editor editor       = new Editor();
        Historial historial = new Historial();

        editor.setTexto("Versión inicial");
        historial.push(editor.guardar());

        editor.setTexto("Versión con cambios");
        historial.push(editor.guardar());

        editor.setTexto("Versión incorrecta");
        System.out.println("Actual     : " + editor.getTexto());

        editor.restaurar(historial.pop());
        System.out.println("Deshacer 1 : " + editor.getTexto());

        editor.restaurar(historial.pop());
        System.out.println("Deshacer 2 : " + editor.getTexto());
    }
}

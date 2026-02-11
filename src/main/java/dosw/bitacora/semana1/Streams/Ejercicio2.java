package dosw.bitacora.semana1.Streams;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese las palabras separadas por espacios: ");
        List<String> words = Arrays.asList(scanner.nextLine().split(" "));

        List<String> processed = words.stream()
                .filter(w -> w.length() > 4)
                .map(String::toUpperCase)
                .sorted()
                .toList();

        long count = processed.stream().count();

        System.out.println(processed);
        System.out.println(count);
        scanner.close();
    }
}

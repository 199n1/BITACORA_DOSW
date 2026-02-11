package dosw.bitacora.semana1.Streams;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite los números separados por espacios: ");
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .toList();

        List<Integer> result = numbers.stream()
                .filter(n -> n % 2 == 0)
                .filter(n -> n > 10)
                .toList();

        System.out.println(result);
        scanner.close();
    }
}

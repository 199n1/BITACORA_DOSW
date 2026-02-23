package dosw.bitacora.semana1.Streams;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<User> users = new ArrayList<>();

        System.out.print("¿Cuántos usuarios? ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("Usuario " + (i + 1) + ":");
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Nombre: ");
            String name = scanner.nextLine();
            System.out.print("Edad: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.print("Activo (true/false): ");
            boolean active = Boolean.parseBoolean(scanner.nextLine());
            users.add(new User(id, name, age, active));
        }

        List<String> result = users.stream()
                .filter(u -> u.getAge() >= 18)
                .map(User::getName)
                .toList();

        System.out.println(result);
        scanner.close();
    }
}
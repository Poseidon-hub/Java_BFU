package Lab1;

import java.util.Scanner;

public class Lab1_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод натурального числа n
        System.out.print("Введите натуральное число n: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Введите положительное натуральное число.");
        } else {
            System.out.println("Сиракузская последовательность для числа " + n + ":");

            int steps = 0; // Счётчик шагов

            // Вывод последовательности
            while (n != 1) {
                System.out.print(n + " ");
                if (n % 2 == 0) {
                    n /= 2; // Если число чётное
                } else {
                    n = 3 * n + 1; // Если число нечётное
                }
                steps++; // Увеличиваем счётчик шагов
            }
            System.out.print(n); // Последний элемент последовательности (1)

            // Вывод количества шагов
            System.out.println("\nКоличество шагов до достижения 1: " + steps);
        }

        scanner.close();
    }


}

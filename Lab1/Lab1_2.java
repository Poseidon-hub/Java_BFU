package Lab1;

import java.util.Scanner;

public class Lab1_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод натурального числа n
        System.out.print("Введите натуральное число n: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Введите положительное натуральное число.");
        } else {
            int alternatingSum = 0;

            System.out.println("Введите " + n + " чисел:");
            for (int i = 1; i <= n; i++) {
                int number = scanner.nextInt();
                if (i % 2 == 0) {
                    alternatingSum -= number; // Вычитаем, если номер чётный
                } else {
                    alternatingSum += number; // Прибавляем, если номер нечётный
                }
            }

            // Вывод результата
            System.out.println("Знакочередующаяся сумма: " + alternatingSum);
        }

        scanner.close();
    }

}

package Lab1;

import java.util.Scanner;

public class Lab1_5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод трехзначного числа
        System.out.print("Введите положительное трехзначное число: ");
        int number = scanner.nextInt();

        if (number < 100 || number > 999) {
            System.out.println("Ошибка: введите положительное трехзначное число.");
        } else {
            // Извлечение цифр числа
            int digit1 = number / 100; // Первая цифра
            int digit2 = (number / 10) % 10; // Вторая цифра
            int digit3 = number % 10; // Третья цифра

            // Сумма и произведение цифр
            int sum = digit1 + digit2 + digit3;
            int product = digit1 * digit2 * digit3;

            // Проверка на "дважды четное" число
            if (sum % 2 == 0 && product % 2 == 0) {
                System.out.println("Число является 'дважды четным'.");
            } else {
                System.out.println("Число не является 'дважды четным'.");
            }
        }

        scanner.close();
    }

}

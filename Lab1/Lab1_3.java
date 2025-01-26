package Lab1;

import java.util.Scanner;

public class Lab1_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод координат клада
        System.out.print("Введите координаты клада (x и y): ");
        int treasureX = scanner.nextInt();
        int treasureY = scanner.nextInt();

        int currentX = 0;
        int currentY = 0;
        int steps = 0;

        System.out.println("Введите указания карты (направление и шаги, завершите ввод словом 'стоп'):");

        while (true) {
            String direction = scanner.next();

            if (direction.equals("стоп")) {
                break;
            }

            int distance = scanner.nextInt();
            steps++;

            switch (direction) {
                case "север":
                    currentY += distance;
                    break;
                case "юг":
                    currentY -= distance;
                    break;
                case "восток":
                    currentX += distance;
                    break;
                case "запад":
                    currentX -= distance;
                    break;
            }

            // Проверка, достигли ли мы клада
            if (currentX == treasureX && currentY == treasureY) {
                System.out.println("Минимальное количество указаний: " + steps);
                scanner.close();
                return;
            }
        }

        scanner.close();
    }

}

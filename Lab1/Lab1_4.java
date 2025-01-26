package Lab1;

import java.util.Scanner;

public class Lab1_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод количества дорог
        System.out.print("Введите количество дорог: ");
        int numRoads = scanner.nextInt();

        int bestRoad = 0;
        int maxHeight = 0;

        for (int road = 1; road <= numRoads; road++) {
            System.out.print("Введите количество туннелей на дороге " + road + ": ");
            int numTunnels = scanner.nextInt();

            int minHeightOnRoad = Integer.MAX_VALUE;

            System.out.println("Введите высоты туннелей для дороги " + road + ":");
            for (int i = 0; i < numTunnels; i++) {
                int tunnelHeight = scanner.nextInt();
                if (tunnelHeight < minHeightOnRoad) {
                    minHeightOnRoad = tunnelHeight;
                }
            }

            if (minHeightOnRoad > maxHeight) {
                maxHeight = minHeightOnRoad;
                bestRoad = road;
            }
        }

        System.out.println("Номер дороги: " + bestRoad);
        System.out.println("Максимальная высота грузовика: " + maxHeight);

        scanner.close();
    }

}

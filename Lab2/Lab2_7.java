package Lab2;

public class Lab2_7 {

    public static int[] findMaxInEachRow(int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым.");
        }

        int[] maxElements = new int[array.length]; // Массив для хранения максимальных элементов

        // Проходим по каждой строке массива
        for (int i = 0; i < array.length; i++) {
            int maxInRow = array[i][0]; // Предполагаем, что первый элемент строки — максимальный

            // Проходим по каждому элементу строки
            for (int j = 1; j < array[i].length; j++) {
                if (array[i][j] > maxInRow) {
                    maxInRow = array[i][j]; // Обновляем максимальный элемент
                }
            }

            maxElements[i] = maxInRow; // Сохраняем максимальный элемент строки в результирующий массив
        }

        return maxElements;
    }

    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[] result = findMaxInEachRow(array);

        System.out.println("Максимальные элементы в каждой строке:");
        for (int max : result) {
            System.out.print(max + " ");
        }
    }
}
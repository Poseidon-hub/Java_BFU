package Lab2;

public class Lab2_6 {

    public static int sumOfArray(int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым.");
        }

        int sum = 0; // Переменная для хранения суммы

        // Проходим по каждой строке массива
        for (int i = 0; i < array.length; i++) {
            // Проходим по каждому элементу строки
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j]; // Добавляем элемент к сумме
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int result = sumOfArray(array);
        System.out.println("Сумма всех элементов массива: " + result);
    }
}

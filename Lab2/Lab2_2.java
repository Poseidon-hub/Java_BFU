package Lab2;

public class Lab2_2 {

    public static int[] merge(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] result = new int[n + m]; // Результирующий массив

        int i = 0, j = 0, k = 0; // Индексы для arr1, arr2 и result

        // Пока есть элементы в обоих массивах
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++]; // Добавляем элемент из arr1
            } else {
                result[k++] = arr2[j++]; // Добавляем элемент из arr2
            }
        }

        // Если остались элементы в arr1
        while (i < n) {
            result[k++] = arr1[i++];
        }

        // Если остались элементы в arr2
        while (j < m) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8, 10};

        int[] mergedArray = merge(arr1, arr2);

        // Вывод результата
        System.out.print("Объединенный массив: ");
        for (int num : mergedArray) {
            System.out.print(num + " ");
        }
    }
}
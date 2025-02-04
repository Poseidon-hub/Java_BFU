package Lab2;

public class Lab2_8 {

    public static int[][] rotate90CounterClockwise(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
            throw new IllegalArgumentException("Матрица должна быть квадратной и не пустой.");
        }

        int n = matrix.length;
        int[][] rotatedMatrix = new int[n][n];

        // Транспонирование матрицы
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedMatrix[i][j] = matrix[j][i];
            }
        }

        // Обратный порядок столбцов
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = rotatedMatrix[i][j];
                rotatedMatrix[i][j] = rotatedMatrix[i][n - 1 - j];
                rotatedMatrix[i][n - 1 - j] = temp;
            }
        }

        return rotatedMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        int[][] rotatedMatrix = rotate90CounterClockwise(matrix);

        System.out.println("Матрица после поворота на 90 градусов против часовой стрелки:");
        printMatrix(rotatedMatrix);
    }
}

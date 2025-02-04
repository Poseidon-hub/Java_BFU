package Lab2;

public class Lab2_3 {

    public static int maxSubarraySum(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым.");
        }

        int maxCurrent = nums[0]; // Максимальная сумма подмассива, заканчивающегося на текущем элементе
        int maxGlobal = nums[0];  // Максимальная сумма подмассива, найденная на данный момент

        // Проходим по массиву, начиная со второго элемента
        for (int i = 1; i < nums.length; i++) {
            // Обновляем maxCurrent: либо продолжаем текущий подмассив, либо начинаем новый
            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);

            // Обновляем maxGlobal, если текущий подмассив имеет большую сумму
            if (maxCurrent > maxGlobal) {
                maxGlobal = maxCurrent;
            }
        }

        return maxGlobal;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maxSubarraySum(nums);
        System.out.println("Максимальная сумма подмассива: " + result);
    }
}
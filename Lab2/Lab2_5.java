package Lab2;

import java.util.Arrays;

public class Lab2_5 {

    public static int[] findPair(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        Arrays.sort(nums); // Сортируем массив
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            } else if (sum < target) {
                left++; // Увеличиваем сумму
            } else {
                right--; // Уменьшаем сумму
            }
        }

        return null; // Пара не найдена
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = findPair(nums, target);

        if (result != null) {
            System.out.println("Пара найдена: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("Пара не найдена.");
        }
    }
}
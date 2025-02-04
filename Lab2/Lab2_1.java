package Lab2;

import java.util.HashMap;
import java.util.Map;

public class Lab2_1 {

    public static String longestUniqueSubstring(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        // Карта для хранения последнего индекса каждого символа
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        int maxStart = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // Если символ уже встречался и его индекс больше или равен началу текущей подстроки
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= start) {
                // Сдвигаем начало подстроки за последний индекс повторяющегося символа
                start = charIndexMap.get(currentChar) + 1;
            }

            // Обновляем последний индекс текущего символа
            charIndexMap.put(currentChar, end);

            // Обновляем максимальную длину и начало подстроки, если текущая подстрока длиннее
            if (end - start + 1 > maxLength) {
                maxLength = end - start + 1;
                maxStart = start;
            }
        }

        // Возвращаем подстроку с максимальной длиной
        return s.substring(maxStart, maxStart + maxLength);
    }

    public static void main(String[] args) {
        String input = "abcabcbb";
        String result = longestUniqueSubstring(input);
        System.out.println("Наибольшая подстрока без повторяющихся символов: " + result);
    }
}
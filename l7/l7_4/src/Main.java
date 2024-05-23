//В тексте найти и напечатать n символов (и их количество), встречающихся наиболее часто.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст на русском языке:");
        String input = scanner.nextLine();

        System.out.println("Введите количество наиболее часто встречающихся символов для вывода:");
        int n = scanner.nextInt();

        // Подсчет количества каждого символа
        Map<Character, Integer> charCountMap = countChars(input);

        // Получение n наиболее часто встречающихся символов
        List<Map.Entry<Character, Integer>> sortedCharCount = getMostFrequentChars(charCountMap, n);

        // Вывод результатов
        System.out.println("Наиболее часто встречающиеся символы:");
        for (Map.Entry<Character, Integer> entry : sortedCharCount) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static Map<Character, Integer> countChars(String input) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char ch : input.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) { // Учитываем только буквы и цифры
                charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
            }
        }
        return charCountMap;
    }

    private static List<Map.Entry<Character, Integer>> getMostFrequentChars(Map<Character, Integer> charCountMap, int n) {
        List<Map.Entry<Character, Integer>> charCountList = new ArrayList<>(charCountMap.entrySet());
        charCountList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        return charCountList.subList(0, Math.min(n, charCountList.size()));
    }
}

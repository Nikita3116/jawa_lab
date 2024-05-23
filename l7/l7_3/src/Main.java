//Найти и напечатать, сколько раз повторяется в тексте каждое слово, которое встречается в нем.
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст на русском языке:");
        String input = scanner.nextLine();

        // Разделение текста на слова и подсчет их частоты
        Map<String, Integer> wordCountMap = countWords(input);

        // Вывод результатов
        System.out.println("Частота слов в тексте:");
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static Map<String, Integer> countWords(String input) {
        Map<String, Integer> wordCountMap = new HashMap<>();
        String[] words = input.split("\\P{L}+"); // Разделение по не буквенным символам

        for (String word : words) {
            if (!word.isEmpty()) {
                word = word.toLowerCase(); // Приведение слова к нижнему регистру
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        return wordCountMap;
    }
}

//Ввести текст и список слов. Для каждого слова из заданного списка найти, сколько раз оно встречается в тексте,
// и рассортировать слова по убыванию количества вхождений.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Пример текста
        String input = "Это пример текста. В этом тексте некоторые слова повторяются. Повторяются слова и некоторые фразы.";

        // Пример списка слов
        String[] words = {"текст", "слова", "повторяются", "пример", "фразы"};

        // Подсчет количества вхождений каждого слова из списка
        Map<String, Integer> wordCountMap = countWords(input, words);

        // Сортировка слов по убыванию количества вхождений
        List<Map.Entry<String, Integer>> sortedWordCountList = sortWordsByFrequency(wordCountMap);

        // Вывод результата
        System.out.println("Слова по убыванию количества вхождений:");
        for (Map.Entry<String, Integer> entry : sortedWordCountList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static Map<String, Integer> countWords(String input, String[] words) {
        Map<String, Integer> wordCountMap = new HashMap<>();
        String[] inputWords = input.toLowerCase().split("\\P{L}+");

        // Инициализация карты с нулевыми значениями
        for (String word : words) {
            wordCountMap.put(word.trim().toLowerCase(), 0);
        }

        // Подсчет вхождений слов
        for (String word : inputWords) {
            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            }
        }

        return wordCountMap;
    }

    private static List<Map.Entry<String, Integer>> sortWordsByFrequency(Map<String, Integer> wordCountMap) {
        List<Map.Entry<String, Integer>> wordCountList = new ArrayList<>(wordCountMap.entrySet());
        wordCountList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        return wordCountList;
    }
}

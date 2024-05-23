//Найти наибольшее количество предложений текста, в которых есть одинаковые слова.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Пример текста с предложениями
        String input = "Это первое предложение. Это второе предложение! Третье предложение? Здесь есть общие слова. Еще одно предложение с общими словами.";

        // Разделение текста на предложения
        String[] sentences = input.split("[.!?]\\s*");

        // Подсчет уникальных слов в каждом предложении
        List<Set<String>> sentenceWordSets = new ArrayList<>();
        for (String sentence : sentences) {
            Set<String> words = new HashSet<>(Arrays.asList(sentence.toLowerCase().split("\\P{L}+")));
            words.remove(""); // Удалить пустые строки, если есть
            sentenceWordSets.add(words);
        }

        // Поиск максимального количества предложений с общими словами
        int maxSentencesWithCommonWord = findMaxSentencesWithCommonWord(sentenceWordSets);

        // Вывод результата
        System.out.println("Наибольшее количество предложений с общими словами: " + maxSentencesWithCommonWord);
    }

    private static int findMaxSentencesWithCommonWord(List<Set<String>> sentenceWordSets) {
        Map<String, Set<Integer>> wordToSentencesMap = new HashMap<>();

        for (int i = 0; i < sentenceWordSets.size(); i++) {
            for (String word : sentenceWordSets.get(i)) {
                wordToSentencesMap.computeIfAbsent(word, k -> new HashSet<>()).add(i);
            }
        }

        int maxSentencesWithCommonWord = 0;
        for (Set<Integer> sentences : wordToSentencesMap.values()) {
            maxSentencesWithCommonWord = Math.max(maxSentencesWithCommonWord, sentences.size());
        }

        return maxSentencesWithCommonWord;
    }
}

//Найти такое слово в первом предложении, которого нет ни в одном из остальных предложений.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Пример текста с предложениями
        String input = "Это первое предложение. Это второе предложение! Третье предложение? Здесь есть общие слова. Еще одно предложение с общими словами.";

        // Разделение текста на предложения
        String[] sentences = input.split("[.!?]\\s*");

        if (sentences.length == 0) {
            System.out.println("Текст не содержит предложений.");
            return;
        }

        // Извлечение слов из первого предложения
        Set<String> firstSentenceWords = new HashSet<>(Arrays.asList(sentences[0].toLowerCase().split("\\P{L}+")));
        firstSentenceWords.remove(""); // Удалить пустые строки, если есть

        // Извлечение слов из остальных предложений
        Set<String> otherSentencesWords = new HashSet<>();
        for (int i = 1; i < sentences.length; i++) {
            otherSentencesWords.addAll(Arrays.asList(sentences[i].toLowerCase().split("\\P{L}+")));
        }
        otherSentencesWords.remove(""); // Удалить пустые строки, если есть

        // Поиск уникальных слов в первом предложении
        firstSentenceWords.removeAll(otherSentencesWords);

        // Вывод результата
        if (firstSentenceWords.isEmpty()) {
            System.out.println("Нет слов в первом предложении, которые отсутствуют в остальных предложениях.");
        } else {
            System.out.println("Слова в первом предложении, которые отсутствуют в остальных предложениях: " + firstSentenceWords);
        }
    }
}

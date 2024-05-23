//Все слова текста рассортировать в порядке убывания их длин,
// при этом все слова одинаковой длины рассортировать в порядке возрастания в них количества гласных букв.

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Пример текста
        String input = "Это пример текста. В этом тексте некоторые слова повторяются. Повторяются слова и некоторые фразы.";

        // Получение списка слов
        List<String> words = Arrays.stream(input.toLowerCase().split("\\P{L}+"))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.toList());

        // Сортировка слов по убыванию длины и по возрастанию количества гласных
        words.sort(Comparator.comparingInt(String::length)
                .reversed()
                .thenComparingInt(Main::countVowels));

        // Вывод результата
        System.out.println("Слова, отсортированные по длине и количеству гласных:");
        for (String word : words) {
            System.out.println(word + " (длина: " + word.length() + ", гласные: " + countVowels(word) + ")");
        }
    }

    // Метод для подсчета количества гласных в слове
    private static int countVowels(String word) {
        int count = 0;
        String vowels = "аеёиоуыэюяaeiou";
        for (char c : word.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }
}

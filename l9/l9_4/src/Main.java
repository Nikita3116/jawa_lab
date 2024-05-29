//Задана коллекция строк:
//Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
// Убрать первый символ и вернуть числа.

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");

        List<Integer> numbers = collection.stream()
                .map(s -> s.substring(1)) // Удаляем первый символ каждой строки
                .map(Integer::parseInt) // Преобразуем оставшуюся строку в число
                .collect(Collectors.toList()); // Собираем результаты в список

        System.out.println(numbers); // Вывод: [1, 2, 3, 1]
    }
}

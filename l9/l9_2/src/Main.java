//Задана коллекция строк. Вернуть два элемента начиная со второго.
//Использовать ТОЛЬКО методы Stream API. Циклов и условий быть не должно.
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> strings = List.of("Первый", "Второй", "Третий", "Четвертый");

        List<String> result = strings.stream()
                .skip(1)
                .limit(2)     // Ограничиваем поток двумя элементами
                .collect(Collectors.toList()); // Собираем результат в список

        System.out.println(result);
    }
}

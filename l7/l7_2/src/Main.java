//В тексте после буквы Р, если она не последняя в слове,
// ошибочно напечатана буква А вместо О. Внести исправления в текст.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст на русском языке:");
        String input = scanner.nextLine();

        // Исправление текста
        String correctedText = correctText(input);

        // Вывод исправленного текста
        System.out.println("Исправленный текст:");
        System.out.println(correctedText);
    }

    private static String correctText(String input) {
        StringBuilder corrected = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if ((current == 'Р' || current == 'р') && i + 1 < input.length() && (input.charAt(i + 1) == 'А' || input.charAt(i + 1) == 'а')) {
                corrected.append(current).append(Character.isUpperCase(input.charAt(i + 1)) ? 'О' : 'о');
                i++; // Пропустить следующую 'А' или 'а'
            } else {
                corrected.append(current);
            }
        }
        return corrected.toString();
    }
}

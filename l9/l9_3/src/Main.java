//Найти самый минимальны возраст человека, у которого есть буква “e” в имени.

import java.util.Arrays;
import java.util.Collection;

class People{
    public String name;
    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
public class Main {
    public static void main(String[] args) {
        Collection<People> people = Arrays.asList(
                new People("Ivan", 16),
                new People("Petr", 23),
                new People("Maria", 42)
        );
        int minAge = people.stream()
                .filter(p -> p.name.contains("e")) // Фильтруем людей с буквой 'e' в имени
                .mapToInt(People::getAge) // Преобразуем поток People в поток возрастов
                .min() // Ищем минимальное значение
                .orElse(-1); // В случае, если таких людей нет, возвращаем -1

        System.out.println("Minimal age of people with 'e' in their name: " + minAge);
    }
}

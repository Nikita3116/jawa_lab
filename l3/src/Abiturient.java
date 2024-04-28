import java.util.Arrays;
import java.util.Comparator;

public class Abiturient {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private String phone;
    private int[] grades;

    // Конструктор
    public Abiturient(int id, String lastName, String firstName, String middleName,
                      String address, String phone, int[] grades) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.phone = phone;
        this.grades = grades;
    }

    // Методы set и get
    public void setId(int id) { this.id = id; }
    public int getId() { return id; }

    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getLastName() { return lastName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getFirstName() { return firstName; }

    public void setMiddleName(String middleName) { this.middleName = middleName; }
    public String getMiddleName() { return middleName; }

    public void setAddress(String address) { this.address = address; }
    public String getAddress() { return address; }

    public void setPhone(String phone) { this.phone = phone; }
    public String getPhone() { return phone; }

    public void setGrades(int[] grades) { this.grades = grades; }
    public int[] getGrades() { return grades; }

    // Вспомогательный метод для подсчета среднего балла
    public double getAverageGrade() {
        return Arrays.stream(grades).average().orElse(0.0);
    }

    // Переопределение метода toString
    @Override
    public String toString() {
        return "Abiturient{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", grades=" + Arrays.toString(grades) +
                ", average=" + String.format("%.2f", getAverageGrade()) +
                '}';
    }

    // Методы для работы с массивом объектов
    public static void printAbiturientsWithBadGrades(Abiturient[] abiturients, int minPassingGrade) {
        for (Abiturient abiturient : abiturients) {
            for (int grade : abiturient.getGrades()) {
                if (grade < minPassingGrade) {
                    System.out.println(abiturient);
                    break;
                }
            }
        }
    }

    public static void printAbiturientsWithAverageAbove(Abiturient[] abiturients, double average) {
        for (Abiturient abiturient : abiturients) {
            if (abiturient.getAverageGrade() > average) {
                System.out.println(abiturient);
            }
        }
    }

    public static void printTopNAbiturients(Abiturient[] abiturients, int n) {
        Arrays.sort(abiturients, Comparator.comparingDouble(Abiturient::getAverageGrade).reversed());
        for (int i = 0; i < Math.min(n, abiturients.length); i++) {
            System.out.println(abiturients[i]);
        }
    }

    public static void main(String[] args) {
        // Создание массива объектов класса Abiturient
        Abiturient[] abiturients = {
                new Abiturient(1, "Иванов", "Иван", "Иванович", "г. Москва", "287273", new int[]{3, 4, 5,5,}),
                new Abiturient(2, "Петров", "Петр", "Петрович", "г. Москва", "459267", new int[]{3,4,4,4,3}),
                new Abiturient(3, "Иванов", "Николай", "Иванович", "г. Москва", "273829",new int[]{5,5,4,5,4})

        };

        // Вывод абитуриентов с неудовлетворительными оценками
        System.out.println("Абитуриенты с неудовлетворительными оценками:");
        printAbiturientsWithBadGrades(abiturients, 3);

        // Вывод абитуриентов средний балл у которых выше заданного
        System.out.println("\nАбитуриенты со средним баллом выше 4.5:");
        printAbiturientsWithAverageAbove(abiturients, 4.5);

        // Выбор и вывод n абитуриентов с самым высоким средним баллом
        System.out.println("\nЛучшие 2 абитуриента по среднему баллу:");
        printTopNAbiturients(abiturients, 2);
    }
}

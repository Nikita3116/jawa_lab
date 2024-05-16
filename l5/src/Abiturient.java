import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

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
                      String address, String phone, int[] grades) throws InvalidGradeException {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.phone = phone;
        setGrades(grades);
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

    public void setGrades(int[] grades) throws InvalidGradeException {
        for (int grade : grades) {
            if (grade < 1 || grade > 5) {
                throw new InvalidGradeException("Оценки должны быть в диапазоне от 1 до 5.");
            }
        }
        this.grades = grades;
    }

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

    // Метод для ввода абитуриентов с клавиатуры
    public static Abiturient inputAbiturient(Scanner scanner) throws InputDataException, InvalidGradeException {
        try {
            System.out.println("Введите ID:");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.println("Введите фамилию:");
            String lastName = scanner.nextLine();

            System.out.println("Введите имя:");
            String firstName = scanner.nextLine();

            System.out.println("Введите отчество:");
            String middleName = scanner.nextLine();

            System.out.println("Введите адрес:");
            String address = scanner.nextLine();

            System.out.println("Введите телефон:");
            String phone = scanner.nextLine();

            System.out.println("Введите оценки (через пробел):");
            String[] gradesStr = scanner.nextLine().split(" ");
            int[] grades = Arrays.stream(gradesStr).mapToInt(Integer::parseInt).toArray();

            return new Abiturient(id, lastName, firstName, middleName, address, phone, grades);
        } catch (InputMismatchException e) {
            throw new InputDataException("Некорректный ввод данных.");
        } catch (NumberFormatException e) {
            throw new InputDataException("Оценки должны быть числовыми значениями.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Введите количество абитуриентов:");
            int numAbiturients = scanner.nextInt();
            scanner.nextLine(); // consume newline

            Abiturient[] abiturients = new Abiturient[numAbiturients];
            for (int i = 0; i < numAbiturients; i++) {
                System.out.printf("Введите данные для абитуриента %d:\n", i + 1);
                abiturients[i] = inputAbiturient(scanner);
            }

            // Вывод абитуриентов с неудовлетворительными оценками
            System.out.println("Абитуриенты с неудовлетворительными оценками:");
            printAbiturientsWithBadGrades(abiturients, 3);

            // Вывод абитуриентов средний балл у которых выше заданного
            System.out.println("\nАбитуриенты со средним баллом выше 4.5:");
            printAbiturientsWithAverageAbove(abiturients, 4.5);

            // Выбор и вывод n абитуриентов с самым высоким средним баллом
            System.out.println("\nЛучшие 2 абитуриента по среднему баллу:");
            printTopNAbiturients(abiturients, 2);

        } catch (InputDataException | InvalidGradeException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Произошла непредвиденная ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

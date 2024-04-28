import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите числитель и знаменатель для первой дроби:");
        System.out.print("Числитель: ");
        int numerator1 = scanner.nextInt();
        System.out.print("Знаменатель: ");
        int denominator1 = scanner.nextInt();
        SimpleFraction fraction1 = new SimpleFraction(new Number(numerator1), new Number(denominator1));

        System.out.println("Введите числитель и знаменатель для второй дроби:");
        System.out.print("Числитель: ");
        int numerator2 = scanner.nextInt();
        System.out.print("Знаменатель: ");
        int denominator2 = scanner.nextInt();
        SimpleFraction fraction2 = new SimpleFraction(new Number(numerator2), new Number(denominator2));

        scanner.close();

        fraction1.display(); // Выводит первую дробь
        fraction2.display(); // Выводит вторую дробь
        SimpleFraction sumResult = fraction1.add(fraction2);
        System.out.println("Результат сложения: ");
        System.out.println("Строка "+sumResult.toString());
        sumResult.display();

        SimpleFraction subtractResult = fraction1.subtract(fraction2);
        System.out.println("Результат вычитания: ");
        subtractResult.display();

        SimpleFraction multiplyResult = fraction1.multiply(fraction2);
        System.out.println("Результат умножения: ");
        multiplyResult.display();

        SimpleFraction divideResult = fraction1.divide(fraction2);
        System.out.println("Результат деления: ");
        divideResult.display();
    }

}

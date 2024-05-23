//	Сложить два многочлена заданной степени, если коэффициенты многочленов хранятся в объекте HashMap.

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // Создание двух многочленов в виде HashMap
        HashMap<Integer, Integer> polynomial1 = new HashMap<>();
        polynomial1.put(0, 2); // 2
        polynomial1.put(1, 3); // 3x
        polynomial1.put(2, 5); // 5x^2

        HashMap<Integer, Integer> polynomial2 = new HashMap<>();
        polynomial2.put(0, 1); // 1
        polynomial2.put(1, -3); // -3x
        polynomial2.put(3, 4); // 4x^3

        // Выводим исходные многочлены
        System.out.println("Polynomial 1: " + polynomialToString(polynomial1));
        System.out.println("Polynomial 2: " + polynomialToString(polynomial2));

        // Складываем два многочлена
        HashMap<Integer, Integer> result = addPolynomials(polynomial1, polynomial2);

        // Выводим результирующий многочлен
        System.out.println("Resulting Polynomial: " + polynomialToString(result));
    }

    // Метод для сложения двух многочленов
    public static HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> poly1, HashMap<Integer, Integer> poly2) {
        HashMap<Integer, Integer> result = new HashMap<>(poly1);

        for (Map.Entry<Integer, Integer> entry : poly2.entrySet()) {
            result.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }

        return result;
    }

    // Метод для представления многочлена в виде строки
    public static String polynomialToString(HashMap<Integer, Integer> polynomial) {
        StringBuilder result = new StringBuilder();
        boolean firstTerm = true;

        for (int i = polynomial.size() - 1; i >= 0; i--) {
            if (polynomial.containsKey(i)) {
                int coefficient = polynomial.get(i);
                if (coefficient != 0) {
                    if (!firstTerm && coefficient > 0) {
                        result.append("+");
                    }
                    if (i == 0) {
                        result.append(coefficient);
                    } else if (i == 1) {
                        result.append(coefficient).append("x");
                    } else {
                        result.append(coefficient).append("x^").append(i);
                    }
                    firstTerm = false;
                }
            }
        }
        return result.toString();
    }
}

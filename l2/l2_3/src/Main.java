import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество строк матрицы:");
        int rows = scanner.nextInt();
        System.out.println("Введите количество столбцов матрицы:");
        int cols = scanner.nextInt();

        double[][] matrix = new double[rows][cols];

        // Заполнение матрицы случайными числами
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Math.random() * 20.0 - 10.0;
            }
        }

        System.out.println("Сгенерированная матрица:");
        for (double[] row : matrix) {
            for (double num : row) {
                System.out.printf("%.2f ", num);
            }
            System.out.println();
        }

        ArrayList<Double> maxIncreasing = new ArrayList<>();
        ArrayList<Double> maxDecreasing = new ArrayList<>();
        for (double[] row : matrix) {
            ArrayList<Double> temp = findMaxSequence(row, true);
            if (temp.size() > maxIncreasing.size()) {
                maxIncreasing = temp;
            }
            temp = findMaxSequence(row, false);
            if (temp.size() > maxDecreasing.size()) {
                maxDecreasing = temp;
            }
        }

        System.out.print("Наибольшая возрастающая последовательность: ");
        for (double num : maxIncreasing) {
            System.out.printf("%.2f ", num);
        }
        System.out.println();

        System.out.print("Наибольшая убывающая последовательность: ");
        for (double num : maxDecreasing) {
            System.out.printf("%.2f ", num);
        }
        System.out.println();
        scanner.close();
    }

    private static ArrayList<Double> findMaxSequence(double[] row, boolean isIncreasing) {
        ArrayList<Double> maxSequence = new ArrayList<>();
        ArrayList<Double> currentSequence = new ArrayList<>();

        for (int i = 0; i < row.length; i++) {
            if (i == 0 || (isIncreasing && row[i] > row[i - 1]) || (!isIncreasing && row[i] < row[i - 1])) {
                currentSequence.add(row[i]);
            } else {
                if (currentSequence.size() > maxSequence.size()) {
                    maxSequence = new ArrayList<>(currentSequence);
                }
                currentSequence.clear();
                currentSequence.add(row[i]);
            }
        }
        if (currentSequence.size() > maxSequence.size()) {
            maxSequence = new ArrayList<>(currentSequence);
        }

        return maxSequence; // Возвращаем массив с наибольшей последовательностью
    }
}

import java.util.Scanner;

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

        // Вычисление и вывод сумм
        for (double[] row : matrix) {
            double sum = findSumBetweenFirstTwoPositive(row);
            System.out.printf("Сумма между первым и вторым положительным элементами: %.2f\n", sum);
        }
        scanner.close();
    }

    private static double findSumBetweenFirstTwoPositive(double[] row) {
        int firstPositiveIndex = -1;
        int secondPositiveIndex = -1;
        for (int i = 0; i < row.length; i++) {
            if (row[i] > 0) {
                if (firstPositiveIndex == -1) {
                    firstPositiveIndex = i;
                } else {
                    secondPositiveIndex = i;
                    break;
                }
            }
        }

        if (firstPositiveIndex != -1 && secondPositiveIndex != -1) {
            double sum = 0;
            for (int i = firstPositiveIndex + 1; i < secondPositiveIndex; i++) {
                sum += row[i];
            }
            return sum;
        }
        return 0; // Если в строке меньше двух положительных элементов, сумма будет равна 0
    }
}

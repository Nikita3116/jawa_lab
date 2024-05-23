//Выполнить задания на основе варианта 1 лабораторной работы 3, контролируя состояние потоков
// ввода/вывода. При возникновении ошибок, связанных с корректностью выполнения математических операций,
// генерировать и обрабатывать исключительные ситуации. Предусмотреть обработку исключений,
// возникающих при нехватке памяти,
// отсутствии требуемой записи (объекта) в файле, недопустимом значении поля и т.д.
//4.	Определить класс Матрица размерности (n x n). Класс должен содержать несколько конструкторов.
// Реализовать методы для сложения, вычитания, умножения матриц.
// Объявить массив объектов. Создать методы, вычисляющие первую и вторую нормы матрицы
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Matrix {
    private final double[][] data;
    private final int n;

    public Matrix(int size) {
        this.n = size;
        data = new double[size][size];
    }

    public Matrix(double[][] data) {
        if (data.length != data[0].length) {
            throw new IllegalArgumentException("Matrix must be square.");
        }
        this.n = data.length;
        this.data = new double[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(data[i], 0, this.data[i], 0, n);
        }
    }

    // Метод для ввода матрицы с клавиатуры
    public static Matrix inputMatrix(int size, Scanner scanner) {
        double[][] data = new double[size][size];
        System.out.println("Введите элементы матрицы:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                data[i][j] = scanner.nextDouble();
            }
        }
        return new Matrix(data);
    }

    // Сложение матриц
    public Matrix add(Matrix other) {
        if (this.n != other.n) {
            throw new IllegalArgumentException("Matrices must have the same size to add.");
        }
        Matrix result = new Matrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return result;
    }

    // Вычитание матриц
    public Matrix subtract(Matrix other) {
        if (this.n != other.n) {
            throw new IllegalArgumentException("Matrices must have the same size to subtract.");
        }
        Matrix result = new Matrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result.data[i][j] = this.data[i][j] - other.data[i][j];
            }
        }
        return result;
    }

    // Умножение матриц
    public Matrix multiply(Matrix other) {
        if (this.n != other.n) {
            throw new IllegalArgumentException("Matrices must have the same size to multiply.");
        }
        Matrix result = new Matrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result.data[i][j] += this.data[i][k] * other.data[k][j];
                }
            }
        }
        return result;
    }

    // Вычисление первой нормы матрицы
    public double firstNorm() {
        double maxSum = 0;
        for (int i = 0; i < n; i++) {
            double sum = 0;
            for (int j = 0; j < n; j++) {
                sum += Math.abs(data[i][j]);
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    // Вычисление второй нормы матрицы
    public double secondNorm() {
        double maxSum = 0;
        for (int j = 0; j < n; j++) {
            double sum = 0;
            for (int i = 0; i < n; i++) {
                sum += Math.abs(data[i][j]);
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    // Вспомогательный метод для вывода матрицы
    public void printMatrix() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%8.2f", data[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Введите количество матриц:");
            int numMatrices = scanner.nextInt();

            ArrayList<Matrix> matrices = new ArrayList<>();
            for (int i = 0; i < numMatrices; i++) {
                System.out.printf("Введите размер матрицы %d: ", i + 1);
                int size = scanner.nextInt();
                Matrix matrix = Matrix.inputMatrix(size, scanner);
                matrices.add(matrix);
            }

            // Инициализация для отслеживания минимальных норм
            double minFirstNorm = Double.MAX_VALUE;
            double minSecondNorm = Double.MAX_VALUE;
            Matrix minFirstNormMatrix = null;
            Matrix minSecondNormMatrix = null;

            // Вычисление минимальных норм для массива матриц
            for (Matrix matrix : matrices) {
                double firstNorm = matrix.firstNorm();
                double secondNorm = matrix.secondNorm();

                if (firstNorm < minFirstNorm) {
                    minFirstNorm = firstNorm;
                    minFirstNormMatrix = matrix;
                }
                if (secondNorm < minSecondNorm) {
                    minSecondNorm = secondNorm;
                    minSecondNormMatrix = matrix;
                }
            }

            // Вывод матриц с наименьшей первой и второй нормами
            System.out.println("Matrix with the smallest first norm:");
            if (minFirstNormMatrix != null) {
                minFirstNormMatrix.printMatrix();
            }

            System.out.println("\nMatrix with the smallest second norm:");
            if (minSecondNormMatrix != null) {
                minSecondNormMatrix.printMatrix();
            }

        } catch (InputMismatchException e) {
            System.err.println("Ошибка ввода: введите числовые значения.");
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Произошла непредвиденная ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

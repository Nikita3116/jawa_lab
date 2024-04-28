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

    // Сложение матриц
    public Matrix add(Matrix other) {
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
        Matrix[] matrices = {
                new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}),
                new Matrix(new double[][]{{9, 8, 7}, {6, 5, 4}, {3, 2, 1}}),
        };

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
    }
}

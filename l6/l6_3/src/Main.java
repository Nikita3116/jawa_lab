//3.	Во входном файле хранятся две разреженные матрицы А и В.
// Построить циклически связанные списки СА и СВ, содержащие ненулевые элементы соответственно матриц А и В.
// Просматривая списки, вычислить: а) сумму S = A + B; б) произведение P = A * B.
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> CA = new HashMap<>();
        HashMap<Integer, Integer> CB = new HashMap<>();

        char[] matrix = new char[54];
        int[] matrix1 = new int[9];
        int[] matrix2 = new int[9];

        int kol = 0;
        try (FileReader reader = new FileReader("C:/Users/User/IdeaProjects/jawa_lab/Matrix.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                matrix[kol] = (char) c;
                kol++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Обработка строки для удаления пробелов и новых строк
        String data = new String(matrix).trim();
        String[] tokens = data.split("\\s+");

        // Проверка, что количество токенов соответствует ожиданиям
        if (tokens.length != 18) {
            System.out.println("Ошибка: Некорректный формат входного файла.");
            return;
        }

        // Заполнение matrix1 и matrix2 из токенов
        for (int i = 0; i < 9; i++) {
            matrix1[i] = Integer.parseInt(tokens[i]);
            matrix2[i] = Integer.parseInt(tokens[i + 9]);
        }

        // Построение циклически связанных списков
        createCyclicList(CA, matrix1);
        createCyclicList(CB, matrix2);

        System.out.println("CA: " + CA);
        System.out.println("CB: " + CB);

        // Вычисление суммы и произведения матриц
        int[] matrix_S = new int[9];
        int[] matrix_P = new int[9];

        System.out.println("Сумма матриц: ");
        for (int i = 0; i < 9; i++) {
            matrix_S[i] = matrix1[i] + matrix2[i];
            System.out.print(matrix_S[i] + " ");
            if ((i + 1) % 3 == 0) {
                System.out.println();
            }
        }

        System.out.println("Умножение матриц: ");
        for (int i = 0; i < 9; i++) {
            matrix_P[i] = matrix1[i] * matrix2[i];
            System.out.print(matrix_P[i] + " ");
            if ((i + 1) % 3 == 0) {
                System.out.println();
            }
        }
    }

    // Метод для построения циклически связанного списка
    private static void createCyclicList(HashMap<Integer, Integer> map, int[] matrix) {
        int first = 0;
        boolean first_check = false;
        int t = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] > 0) {
                map.put(matrix[i], t);
                t = matrix[i];
                if (!first_check) {
                    first = matrix[i];
                    first_check = true;
                }
            }
        }
        map.replace(first, t);
    }
}

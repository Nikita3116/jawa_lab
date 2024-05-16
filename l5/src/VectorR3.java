import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class VectorR3 {
    private double x, y, z;

    public VectorR3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Метод для проверки ортогональности с другим вектором
    public boolean isOrthogonal(VectorR3 other) {
        return (this.x * other.x + this.y * other.y + this.z * other.z) == 0;
    }

    // Метод для проверки пересечения с другим неортогональным вектором
    public boolean intersects(VectorR3 other) {
        return !this.isCollinear(other) && !this.isOrthogonal(other);
    }

    // Проверка на коллинеарность
    private boolean isCollinear(VectorR3 other) {
        try {
            double kx = this.x / other.x;
            double ky = this.y / other.y;
            double kz = this.z / other.z;
            return (kx == ky) && (ky == kz);
        } catch (ArithmeticException e) {
            return false;
        }
    }

    // Проверка на компланарность
    public static boolean areCoplanar(VectorR3 v1, VectorR3 v2, VectorR3 v3) {
        double volume = v1.x * (v2.y * v3.z - v3.y * v2.z) -
                v1.y * (v2.x * v3.z - v3.x * v2.z) +
                v1.z * (v2.x * v3.y - v3.x * v2.y);
        return volume == 0;
    }

    // Метод для сравнения векторов
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof VectorR3)) return false;
        VectorR3 other = (VectorR3) obj;
        return Double.compare(this.x, other.x) == 0 &&
                Double.compare(this.y, other.y) == 0 &&
                Double.compare(this.z, other.z) == 0;
    }

    @Override
    public String toString() {
        return String.format("Vector(%f, %f, %f)", x, y, z);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<VectorR3> vectors = new ArrayList<>();

        try {
            System.out.println("Введите количество векторов:");
            int n = scanner.nextInt();

            for (int i = 0; i < n; i++) {
                System.out.println("Введите координаты вектора " + (i + 1) + " (x y z):");
                double x = scanner.nextDouble();
                double y = scanner.nextDouble();
                double z = scanner.nextDouble();
                vectors.add(new VectorR3(x, y, z));
            }

            // Проверяем ортогональность всех пар векторов
            for (int i = 0; i < vectors.size(); i++) {
                for (int j = i + 1; j < vectors.size(); j++) {
                    if (vectors.get(i).isOrthogonal(vectors.get(j))) {
                        System.out.printf("%s ортогонален %s%n", vectors.get(i), vectors.get(j));
                    }
                }
            }

            // Проверяем компланарность всех троек векторов
            for (int i = 0; i < vectors.size(); i++) {
                for (int j = i + 1; j < vectors.size(); j++) {
                    for (int k = j + 1; k < vectors.size(); k++) {
                        if (VectorR3.areCoplanar(vectors.get(i), vectors.get(j), vectors.get(k))) {
                            System.out.printf("%s, %s и %s компланарны%n", vectors.get(i), vectors.get(j), vectors.get(k));
                        }
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.err.println("Ошибка ввода: введите числовые значения.");
        } catch (ArithmeticException e) {
            System.err.println("Ошибка математической операции: " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("Ошибка: попытка обращения к объекту по нулевой ссылке.");
        } catch (Exception e) {
            System.err.println("Произошла непредвиденная ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

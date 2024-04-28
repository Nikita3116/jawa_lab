import java.util.ArrayList;
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
        double kx = this.x / other.x;
        double ky = this.y / other.y;
        double kz = this.z / other.z;
        return (kx == ky) && (ky == kz);
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
        return this.x == other.x && this.y == other.y && this.z == other.z;
    }

    @Override
    public String toString() {
        return String.format("Vector(%f, %f, %f)", x, y, z);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество векторов:");
        int n = scanner.nextInt();
        ArrayList<VectorR3> vectors = new ArrayList<>();

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
                    System.out.printf("%s is orthogonal to %s%n", vectors.get(i), vectors.get(j));
                }
            }
        }

        // Проверяем компланарность всех троек векторов
        for (int i = 0; i < vectors.size(); i++) {
            for (int j = i + 1; j < vectors.size(); j++) {
                for (int k = j + 1; k < vectors.size(); k++) {
                    if (areCoplanar(vectors.get(i), vectors.get(j), vectors.get(k))) {
                        System.out.printf("%s, %s, and %s are coplanar%n", vectors.get(i), vectors.get(j), vectors.get(k));
                    }
                }
            }
        }
        scanner.close();
    }
}

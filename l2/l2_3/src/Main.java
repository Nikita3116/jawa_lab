import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Размер матрицы: ");
        Scanner console = new Scanner(System.in);
        int n1 = console.nextInt();

        double[][] twoArray = new double[n1][n1];

        System.out.println("Диапазон случайных чисел: ");
        int n2 = console.nextInt();
        int n3 = console.nextInt();

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n1; j++) {
                twoArray[i][j] = (Math.random() * ((n3 - n2))) + n2;
                System.out.print(twoArray[i][j] + " ");
            }
            System.out.println();
        }

        int one_i = 0;
        double[] oneArray = new double[n1 * n1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n1; j++) {
                oneArray[one_i] = twoArray[i][j];
                one_i++;
            }
        }

        ArrayList<Double> Vozrost_1 = new ArrayList<>();
        ArrayList<Double> Vozrost_2 = new ArrayList<>();
        ArrayList<Double> Ybuv_1 = new ArrayList<>();
        ArrayList<Double> Ybuv_2 = new ArrayList<>();

        int new_arr = 0;
        for (int i = 0; i < n1 * n1; i++) {
            if (i == 0) {
                Vozrost_1.add(oneArray[i]);
            } else if (oneArray[i] > oneArray[i - 1]) {
                Vozrost_1.add(oneArray[i]);
            } else if (Vozrost_1.size() > Vozrost_2.size()) {
                Vozrost_2 = (ArrayList<Double>) Vozrost_1.clone();
                Vozrost_1.clear();
                new_arr = 1;
            }
            if (new_arr == 1){
                Vozrost_1.add(oneArray[i]);
                new_arr = 0;
            }
        }

        int new_arr2 = 0;
        for (int i = 0; i < n1 * n1; i++) {
            if (i == 0) {
                Ybuv_1.add(oneArray[i]);
            } else if (oneArray[i] < oneArray[i - 1]) {
                Ybuv_1.add(oneArray[i]);
            } else if (Ybuv_1.size() > Ybuv_2.size()) {
                Ybuv_2 = (ArrayList<Double>) Ybuv_1.clone();
                Ybuv_1.clear();
                new_arr2 = 1;
            }
            if (new_arr2 == 1){
                Ybuv_1.add(oneArray[i]);
                new_arr2 = 0;
            }
        }

        System.out.println("Возрастающие числа");
        if (Vozrost_2.size() > Vozrost_1.size()){
            for (int i = 0; i < Vozrost_2.size(); i++) {
                System.out.println(Vozrost_2.get(i));
            }
        } else {
            for (int i = 0; i < Vozrost_1.size(); i++) {
                System.out.println(Vozrost_1.get(i));
            }
        }

        System.out.println("Убывающие числа");
        if (Ybuv_2.size() > Ybuv_1.size()){
            for (int i = 0; i < Ybuv_2.size(); i++) {
                System.out.println(Ybuv_2.get(i));
            }
        } else {
            for (int i = 0; i < Ybuv_1.size(); i++) {
                System.out.println(Ybuv_1.get(i));
            }
        }
    }
}

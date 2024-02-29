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

        double[] SumArray = new double[n1];
        double sum = 0;
        boolean first = false;
        boolean second = false;
        for(int i = 0; i < n1; i++){
            for(int j = 0; j < n1; j++){
                if (first && !second){
                    sum += twoArray[i][j];
                }
                if (twoArray[i][j] > 0 && first){
                    second = true;
                }
                if (twoArray[i][j] > 0){
                    first = true;
                }
            }
            if (!second){
                sum = 0;
            }
            SumArray[i] = sum;
            second = false;
            first = false;
            sum = 0;
        }

        for (int i = 0; i < n1; i++) {
            System.out.println(SumArray[i]);
        }
    }
}
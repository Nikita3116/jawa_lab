import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        HashSet<Integer> array = new HashSet<Integer>();

        System.out.println("Сколько будет чисел: ");
        int col = console.nextInt();
        for (int i = 0; i < col; i++) {
            array.add(console.nextInt());
        }

        int kol = -1;
        while (kol != 1){
            int i = 0;
            int[] arr = new int[array.size()];
            for (int ele:array){
                arr[i++] = ele;
            }
            int kol_array = array.size();
            array.clear();
            for (int j = 0; j <= kol_array - 1; j += 2) {
                if (j+1 == kol_array){
                    array.add(arr[j]);
                }else {
                    array.add(arr[j] + arr[j+1]);
                }
            }
            System.out.println(array);
            kol = array.size();
        }
    }
}

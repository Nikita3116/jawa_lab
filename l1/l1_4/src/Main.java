import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Сколько чисел будет вводится?");
        Scanner console = new Scanner(System.in);
        int col = console.nextInt();

        ArrayList<Float> arrayList = new ArrayList<>();
        System.out.println("Вводите числа");
        for (int i = 0; i < col; i++){
            arrayList.add(console.nextFloat());
        }

        boolean check;
        for (int i = 0; i < col - 1; i++){
            check = false;
            if (i == 0){
                if (arrayList.get(i) == arrayList.get(i + 1)/2){
                    check = true;
                }
            }
            else if (arrayList.get(i) == (arrayList.get(i + 1) + arrayList.get(i - 1))/2){
                check = true;
            }
            else if (i == col - 1 ){
                if (arrayList.get(i) == arrayList.get(i - 1)/2){
                    check = true;
                }
            }

            if (check){
                System.out.println(arrayList.get(i));
            }
        }
    }
}
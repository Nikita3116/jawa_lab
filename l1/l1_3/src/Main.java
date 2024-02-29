import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        System.out.println("Сколько чисел будет вводится?");
        Scanner console = new Scanner(System.in);
        int col = console.nextInt();

        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println("Вводите числа");
        for (int i = 0; i < col; i++){
            arrayList.add(console.next());
        }

        String str;
        for (int i = 0; i < col; i++){
            str = arrayList.get(i);
            boolean check = true;
            if (str.length() == 1){
                System.out.print(str + " ");
            }
            else {
                for (int j = 0; j < str.length(); j++){
                    if (str.charAt(j) != str.charAt(str.length() - j - 1)) {
                        check = false;
                    }
                }
                if (check){
                    System.out.print(str + " ");
                }
            }

        }
    }
}
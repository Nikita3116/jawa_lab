import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Сколько слов будет вводится?");
        Scanner console = new Scanner(System.in);
        int col = console.nextInt();

        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println("Вводите слова");
        for (int i = 0; i < col; i++) {
            arrayList.add(console.next());
        }

        int[] HowSimvol; // объявление массива для количества уникальных символов
        HowSimvol = new int[col];

        int kol;
        String slovo;
        int pov = 0;

        for(int i = 0; i < col; i++){
            slovo = arrayList.get(i);
            for (int j = 0; j < slovo.length(); j++){
                for (int k = j; k >= 0; k--){
                    if (slovo.charAt(j) == slovo.charAt(k)){
                        pov++;
                    }
                }
                if (pov == 1){
                    HowSimvol[i]++;
                }
                pov = 0;
            }
        }

        int min = 100000;
        int min_i = 0;
        for(int i = 0; i < col; i++){
            if (HowSimvol[i] < min){
                min = HowSimvol[i];
                min_i = i;
            }
        }

        System.out.println(arrayList.get(min_i));
    }
}
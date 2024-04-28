import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("Сколько строк будет вводится?");
        Scanner console = new Scanner(System.in);
        int col = console.nextInt();

        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println("Вводите строки");
        for (int i = 0; i < col; i++){
            arrayList.add(console.next());
        }

        float Srdlina = 0;
        for(int i = 0; i < col; i++){
            Srdlina += arrayList.get(i).length();
        }
        Srdlina /= col;
        System.out.println("Средняя длина:" + Srdlina);

        for(int i = 0; i < col; i++){
            if (arrayList.get(i).length() < Srdlina){
                System.out.println(arrayList.get(i) + "," + arrayList.get(i).length());
            }
        }

        for(int i = 0; i < col; i++){
            if (arrayList.get(i).length() > Srdlina){
                System.out.println(arrayList.get(i) + "," + arrayList.get(i).length());
            }
        }
        System.out.println("Kulinich");
        Date now = new Date();
        System.out.println("Задание получено: Fri Feb 09 14:30:00 GMT+03:00 2024");
        System.out.println("Текущая дата и время: " + now);
    }
}
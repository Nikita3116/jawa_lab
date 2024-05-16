import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] objects = new String[9];
        HashMap<Integer, String> C1 = new HashMap<>();

        int kol = 0;
        try(FileReader reader = new FileReader("C:/Users/User/IdeaProjects/jawa_lab/Objects.txt"))
        {
            int c;
            while((c=reader.read())!=-1){
                objects[kol] = Character.toString((char)c);
                kol++;
            }
        } catch (IOException e) {
        }

        int j = 3;
        for (int i = 0; i < 9; i += 3) {
            C1.put(j, objects[i]);
            j--;
        }

        TreeMap<Integer, String> sorted_C1 = new TreeMap<>();
        sorted_C1.putAll(C1);

        System.out.println(C1);

        Iterator<Integer> keyIter = C1.keySet().iterator();
        HashMap<String, Integer> C2 = new HashMap<>();
        while (keyIter.hasNext()) {
            Integer key = keyIter.next();
            String value = C1.get(key);
            C2.put(value, key);
        }

        Iterator<Integer> keyIter2 = C2.values().iterator();
        HashMap<Integer, String> C3 = new HashMap<>();
        while (keyIter2.hasNext()) {
            Integer key = keyIter2.next();
            String value = C1.get(key);
            C3.put(key, value);
        }

        System.out.println(C3);
    }
}

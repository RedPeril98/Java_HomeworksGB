package Task_3;
import java.io.FileReader;
import java.io.IOException;

public class Main_3 {

// Сравнить время выполнения замены символа "а" на "А" любой строки содержащей >1000 символов средствами String и StringBuilder.

    public static void main(String[] args) throws Exception {
        StringBuilder builder = new StringBuilder();
        try (FileReader reader = new FileReader("C:/file3.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                builder.append((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        Time(builder);
    }

    public static void Time(StringBuilder builder1) {
        String str = new String(builder1);
        String oldCh = "a";
        String newCh = "A";
        long start = System.currentTimeMillis();
        str = str.replace(oldCh, newCh);
        System.out.println(str);
        long finish = System.currentTimeMillis();
        long dif = finish - start;
        System.out.println("String: " + dif);

        start = System.currentTimeMillis();
        int ind;
        for (int i = 0; i < str.length(); i++) {
            if (builder1.charAt(i) == 'a') {
                ind = builder1.indexOf(oldCh, i);
                builder1.replace(ind, ind + 1, newCh);
            }
        }
        System.out.println(builder1);
        finish = System.currentTimeMillis();
        dif = finish - start;
        System.out.println("StringBuilder: " + dif);
    }
}
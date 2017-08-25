import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by dreikaa on 6/4/17.
 */
public class Crypto {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(reader);
//        for (char c = 'a'; c <= 'z'; c++) {
//            System.out.println("code=" + (int) c + "\t   sumbol=" + c);
//        }
        String s = "hello";
        System.out.println(s);
        System.out.println(crypto(s));
        System.out.println(antyCrypto(crypto(s)));
    }

    public static String crypto(String s) {
        char[] mass = s.toCharArray();
        for (int i = 0; i < mass.length; i++) {
            System.out.print((int) mass[i] + " ");
            System.out.println(mass[i]);
            if (((int) mass[i] <= 103) && ((int) mass[i] >= 97)) {
                mass[i] = (char) ((int) mass[i] + 5);
            }
            if (((int) mass[i] <= 110) && ((int) mass[i] > 103)) {
                mass[i] = (char) ((int) mass[i] + 4);
            }
            if (((int) mass[i] <= 117) && ((int) mass[i] >= 110)) {
                mass[i] = (char) ((int) mass[i] + 3);
            }
            if (((int) mass[i] <= 122) && ((int) mass[i] >= 117)) {
                if ((int) mass[i] + 2 > 122) {
                    mass[i] = (char) ((int) mass[i] - 23);
                }
                mass[i] = (char) ((int) mass[i] + 2);
            }
        }
        s = "";
        for (int i = 0; i < mass.length; i++) {
            s += mass[i];
        }
        return s;
    }

    public static String antyCrypto(String s) {
        char[] mass = s.toCharArray();
        for (int i = 0; i < mass.length; i++) {
            System.out.print((int) mass[i] + " ");
            System.out.println(mass[i]);
            if (((int) mass[i] <= 103) && ((int) mass[i] >= 97)) {
                mass[i] = (char) ((int) mass[i] - 6);
            }
            if (((int) mass[i] <= 110) && ((int) mass[i] > 103)) {
                mass[i] = (char) ((int) mass[i] - 5);
            }
            if (((int) mass[i] <= 117) && ((int) mass[i] >= 110)) {
                mass[i] = (char) ((int) mass[i] - 4);
            }
            if (((int) mass[i] <= 122) && ((int) mass[i] >= 117)) {
                if ((int) mass[i] - 3 > 97) {
                    mass[i] = (char) ((int) mass[i] + 22);
                }
                mass[i] = (char) ((int) mass[i] - 3);
            }
        }
        s = "";
        for (int i = 0; i < mass.length; i++) {
            s += mass[i];
        }
        return s;
    }
}

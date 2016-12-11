import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by dreikaa on 12/11/16.
 */
public class Newton {
    public static ArrayList<double[]> massf = new ArrayList<>();
    public static ArrayList<double[]> massJ = new ArrayList<>();
    public static ArrayList<double[]> invertMassJ = new ArrayList<>();
    public static double[] x0 = {0, 0};
    public static double[] f = {0, 0};
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        massf.add(createMass());
        massf.add(createMass()); // задаем уравнения системы
        createMassJ(); //ищем якобиан
        invertMassJ(); //обратный якобиан
        //toString(massf.get(0));
        writeNewton();
    }

    public static double[] createMass() throws IOException { // создание массива коэффициентов системы
        double[] mass = new double[5];
        String[] massS = reader.readLine().split(" ");
        for (int i = 0; i < massS.length; i++) {
            mass[i] = Double.parseDouble(massS[i]);
        }
        return mass;
    }

    public static void toString(double[] mass) {
        System.out.print("(");
        if (mass[0] != 0) {
            System.out.print(mass[0] + "x^2");
        }
        if (mass[1] != 0) {
            if (mass[1] > 0) {
                System.out.print("+" + mass[1] + "x");
            }
            if (mass[1] < 0) {
                System.out.print(mass[1] + "x");
            }
        }
        if (mass[2] != 0) {
            if (mass[2] > 0) {
                System.out.print("+" + mass[2] + "y^2");
            }
            if (mass[2] < 0) {
                System.out.print(mass[2] + "y^2");
            }
        }
        if (mass[3] != 0) {
            if (mass[3] > 0) {
                System.out.print("+" + mass[3] + "y");
            }
            if (mass[3] < 0) {
                System.out.print(mass[3] + "y");
            }
        }
        if (mass[4] != 0) {
            if (mass[4] > 0) {
                System.out.print("+" + mass[4]);
            }
            if (mass[4] < 0) {
                System.out.print(mass[4]);
            }
        }
        System.out.print(")");

    }

    public static void writeNewton() {
        System.out.print("||x0||   ");
        System.out.print("||" + x0[0] + "||" + "                                                      ");
        System.out.print("||");
        toString(invertMassJ.get(0));
        System.out.print("   ");
        toString(invertMassJ.get(1));
        System.out.print("||    ||");
        toString(massf.get(0));
        System.out.print("||");
        System.out.println();

        System.out.print("||  || = ||   ||  -1/(");
        toString(massJ.get(0));
        System.out.print("");
        toString(massJ.get(3));
        System.out.print(" - ");
        toString(massJ.get(1));
        System.out.print("");
        toString(massJ.get(2));
        System.out.print(")");
        System.out.println("||                         ||    ||                             ||");

        System.out.print("||x1||   ");
        System.out.print("||" + x0[1] + "||" + "                                                      ");
        System.out.print("||");
        toString(invertMassJ.get(2));
        System.out.print("   ");
        toString(invertMassJ.get(3));
        System.out.print("||    ||");
        toString(massf.get(1));
        System.out.print("||");
        System.out.println();

    }

    public static void invertMassJ() throws IOException { //задание массива массивов коэффициентов производных
        invertMassJ.add(0, massJ.get(3));
        invertMassJ.add(1, MatFunc.matrixTimes(massJ.get(1), -1));
        invertMassJ.add(2, MatFunc.matrixTimes(massJ.get(2), -1));
        invertMassJ.add(3, massJ.get(0));
    }

    public static void nextItter(){

    }

    public static void createMassJ() throws IOException { //задание массива массивов коэффициентов производных
        for (int i = 0; i < 4; i++) {
            massJ.add(new double[5]);
        }
        massJ.get(0)[1] = 2 * massf.get(0)[0];
        massJ.get(0)[4] = massf.get(0)[1];
        massJ.get(2)[1] = 2 * massf.get(1)[0];
        massJ.get(2)[4] = massf.get(1)[1]; //кладем коэффициенты учитывая производную

        massJ.get(1)[3] = 2 * massf.get(0)[2];
        massJ.get(1)[4] = massf.get(0)[3];
        massJ.get(3)[3] = 2 * massf.get(1)[2];
        massJ.get(3)[4] = massf.get(1)[3];
    }

}

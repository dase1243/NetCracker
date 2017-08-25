//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//
///**
// * Created by dreikaa on 12/11/16.
// */
//public class Newton {
//    public static ArrayList<double[]> massf = new ArrayList<>();
//    public static ArrayList<double[]> massJ = new ArrayList<>();
//    public static ArrayList<double[]> invertMassJ = new ArrayList<>();
//    public static double[] massJa = {0, 0, 0, 0};
//    public static double[] invertMassJa = {0, 0, 0, 0};
//    public static double detInvertJ = 1;
//    public static double[] a = {0, 0};
//    public static double[] localization = {0, 1};
//    public static double[] x0 = {0, 0};
//    public static double[] f = {0, 0};
//    public static double A;
//    public static double B;
//    public static double C;
//    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//    public static void main(String[] args) throws IOException {
//        System.out.println((double) 1 / 3);
//        massf.add(createMass());
//        massf.add(createMass()); // задаем уравнения системы
//        createMassJ(); //ищем якобиан
//        invertMassJ(); //обратный якобиан
//        //toString(massf.get(0));
//        writeNewton();
//        findABC();
//        if (convergence()){
//            for (int i = 0; i < 10; i++) {
//                nextItter();
//            }
//        }
//    }
//
//    public static boolean convergence() {
//        if (A * B * C * 2 * 2 > 1) {
//            return true;
//        }
//        return false;
//    }
//
//    public static double[] createMass() throws IOException { // создание массива коэффициентов системы
//        double[] mass = new double[5];
//        String[] massS = reader.readLine().split(" ");
//        for (int i = 0; i < massS.length; i++) {
//            mass[i] = Double.parseDouble(massS[i]);
//        }
//        return mass;
//    }
//
//    public static void toString(double[] mass) {
//        System.out.print("(");
//        if (mass[0] != 0) {
//            System.out.print(mass[0] + "x^2");
//        }
//        if (mass[1] != 0) {
//            if (mass[1] > 0) {
//                System.out.print("+" + mass[1] + "x");
//            }
//            if (mass[1] < 0) {
//                System.out.print(mass[1] + "x");
//            }
//        }
//        if (mass[2] != 0) {
//            if (mass[2] > 0) {
//                System.out.print("+" + mass[2] + "y^2");
//            }
//            if (mass[2] < 0) {
//                System.out.print(mass[2] + "y^2");
//            }
//        }
//        if (mass[3] != 0) {
//            if (mass[3] > 0) {
//                System.out.print("+" + mass[3] + "y");
//            }
//            if (mass[3] < 0) {
//                System.out.print(mass[3] + "y");
//            }
//        }
//        if (mass[4] != 0) {
//            if (mass[4] > 0) {
//                System.out.print("+" + mass[4]);
//            }
//            if (mass[4] < 0) {
//                System.out.print(mass[4]);
//            }
//        }
//        System.out.print(")");
//
//    }
//
//    public static void writeNewton() {
//        System.out.print("||x0||   ");
//        System.out.print("||" + x0[0] + "||" + "                                                      ");
//        System.out.print("||");
//        toString(invertMassJ.get(0));
//        System.out.print("   ");
//        toString(invertMassJ.get(1));
//        System.out.print("||    ||");
//        toString(massf.get(0));
//        System.out.print("||");
//        System.out.println();
//
//        System.out.print("||  || = ||   ||  -1/(");
//        toString(massJ.get(0));
//        System.out.print("");
//        toString(massJ.get(3));
//        System.out.print(" - ");
//        toString(massJ.get(1));
//        System.out.print("");
//        toString(massJ.get(2));
//        System.out.print(")");
//        System.out.println("||                         ||    ||                             ||");
//
//        System.out.print("||x1||   ");
//        System.out.print("||" + x0[1] + "||" + "                                                      ");
//        System.out.print("||");
//        toString(invertMassJ.get(2));
//        System.out.print("   ");
//        toString(invertMassJ.get(3));
//        System.out.print("||    ||");
//        toString(massf.get(1));
//        System.out.print("||");
//        System.out.println();
//
//    }
//
//    public static void findA() {
//        double[][] massJ = new double[2][2];
//        massJ[0][0] = invertMassJ.get(0)[0] * a[0] * a[0] + invertMassJ.get(0)[1] * a[0] + invertMassJ.get(0)[2] *
//                a[1] * a[1] + invertMassJ.get(0)[3] * a[1] + invertMassJ.get(0)[4];
//
//        massJ[0][1] = invertMassJ.get(1)[0] * a[0] * a[0] + invertMassJ.get(1)[1] * a[0] + invertMassJ.get(1)[2] *
//                a[1] * a[1] + invertMassJ.get(1)[3] * a[1] + invertMassJ.get(1)[4];
//
//        massJ[1][0] = invertMassJ.get(2)[0] * a[0] * a[0] + invertMassJ.get(2)[1] * a[0] + invertMassJ.get(2)[2] *
//                a[1] * a[1] + invertMassJ.get(2)[3] * a[1] + invertMassJ.get(2)[4];
//
//        massJ[1][1] = invertMassJ.get(3)[0] * a[0] * a[0] + invertMassJ.get(3)[1] * a[0] + invertMassJ.get(3)[2] *
//                a[1] * a[1] + invertMassJ.get(3)[3] * a[1] + invertMassJ.get(3)[4];
//
//        A = MatFunc.firstNorm(massJ);
//    }
//
//    public static void findABC() {
//        double[][] massJ0 = new double[2][2];
//        massJ0[0][0] = invertMassJ.get(0)[0] * a[0] * a[0] + invertMassJ.get(0)[1] * a[0] + invertMassJ.get(0)[2] *
//                a[1] * a[1] + invertMassJ.get(0)[3] * a[1] + invertMassJ.get(0)[4];
//
//        massJ0[0][1] = invertMassJ.get(1)[0] * a[0] * a[0] + invertMassJ.get(1)[1] * a[0] + invertMassJ.get(1)[2] *
//                a[1] * a[1] + invertMassJ.get(1)[3] * a[1] + invertMassJ.get(1)[4];
//
//        massJ0[1][0] = invertMassJ.get(2)[0] * a[0] * a[0] + invertMassJ.get(2)[1] * a[0] + invertMassJ.get(2)[2] *
//                a[1] * a[1] + invertMassJ.get(2)[3] * a[1] + invertMassJ.get(2)[4];
//
//        massJ0[1][1] = invertMassJ.get(3)[0] * a[0] * a[0] + invertMassJ.get(3)[1] * a[0] + invertMassJ.get(3)[2] *
//                a[1] * a[1] + invertMassJ.get(3)[3] * a[1] + invertMassJ.get(3)[4];
//
//        double[][] massF = new double[2][2];
//        massF[0][0] = massf.get(0)[0] * a[0] * a[0] + massf.get(0)[1] * a[0] + massf.get(0)[2] *
//                a[1] * a[1] + massf.get(0)[3] * a[1] + massf.get(0)[4];
//        massF[1][0] = massf.get(1)[0] * a[0] * a[0] + massf.get(1)[1] * a[0] + massf.get(1)[2] *
//                a[1] * a[1] + massf.get(1)[3] * a[1] + massf.get(1)[4];
//        massF[0][1] = 0;
//        massF[1][1] = 0;
//
//
//        A = MatFunc.firstNorm(massJ0);
//        massF = MatFunc.multiply(massJ0, massF);
//        B = MatFunc.firstNorm(massF);
//        C = Math.max(Math.max(Math.max(massJ.get(0)[1], massJ.get(1)[3]), massJ.get(2)[1]), massJ.get(3)[3]);
//    }
//
//    public static void invertMassJ() throws IOException { //задание массива массивов коэффициентов производных
//        invertMassJ.add(0, massJ.get(3));
//        invertMassJ.add(1, MatFunc.matrixTimes(massJ.get(1), -1));
//        invertMassJ.add(2, MatFunc.matrixTimes(massJ.get(2), -1));
//        invertMassJ.add(3, massJ.get(0));
//    }
//
//    public static void nextItter() {
//        f[0] = massf.get(0)[0] * a[0] * a[0] + massf.get(0)[1] * a[0] + massf.get(0)[2] *
//                a[1] * a[1] + massf.get(0)[3] * a[1] + massf.get(0)[4];
//        f[1] = massf.get(1)[0] * a[0] * a[0] + massf.get(1)[1] * a[0] + massf.get(1)[2] *
//                a[1] * a[1] + massf.get(1)[3] * a[1] + massf.get(1)[4];
//
//        for (int i = 0; i < massJ.size(); i++) {
//            massJa[i] = massJ.get(i)[0] * a[0] * a[0] + massJ.get(i)[1] * a[0] + massJ.get(i)[2] *
//                    a[1] * a[1] + massJ.get(i)[3] * a[1] + massJ.get(i)[4];
//        }
//
//        for (int i = 0; i < invertMassJ.size(); i++) {
//            invertMassJa[i] = invertMassJ.get(i)[0] * a[0] * a[0] + invertMassJ.get(i)[1] * a[0] + invertMassJ.get(i)[2] *
//                    a[1] * a[1] + invertMassJ.get(i)[3] * a[1] + invertMassJ.get(i)[4];
//        }
//
//        detInvertJ = 1 / (invertMassJa[0] * invertMassJa[3] - invertMassJa[1] * invertMassJa[2]);
//        System.out.println(detInvertJ);
//        a[0] = a[0] - (invertMassJa[0] * f[0] + invertMassJa[1] * f[1]) * detInvertJ;
//        a[1] = a[1] - (invertMassJa[2] * f[0] + invertMassJa[3] * f[1]) * detInvertJ;
//    }
//
//    public static void createMassJ() throws IOException { //задание массива массивов коэффициентов производных
//        for (int i = 0; i < 4; i++) {
//            massJ.add(new double[5]);
//        }
//        massJ.get(0)[1] = 2 * massf.get(0)[0];
//        massJ.get(0)[4] = massf.get(0)[1];
//        massJ.get(2)[1] = 2 * massf.get(1)[0];
//        massJ.get(2)[4] = massf.get(1)[1]; //кладем коэффициенты учитывая производную
//
//        massJ.get(1)[3] = 2 * massf.get(0)[2];
//        massJ.get(1)[4] = massf.get(0)[3];
//        massJ.get(3)[3] = 2 * massf.get(1)[2];
//        massJ.get(3)[4] = massf.get(1)[3];
//    }
//
//}

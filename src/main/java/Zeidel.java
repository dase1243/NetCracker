import Jama.EigenvalueDecomposition;
import Jama.Matrix;
import org.ejml.data.Complex64F;
import org.ejml.data.DenseMatrix64F;
import org.ejml.factory.DecompositionFactory;
import org.ejml.interfaces.decomposition.EigenDecomposition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by drei on 15.11.2016.
 */
public class Zeidel {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static int norm = 1;
    public static double[][] mass;
    public static double[] x0;
    public static double[] f;

    public static void main(String[] args) throws IOException {
        int a = Integer.parseInt(reader.readLine());
        mass = createMass(a);
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[0].length; j++) {
                System.out.print(mass[i][j] + " ");
            }
            System.out.println();
        }
        double[] k;
        double[] k1 = new double[mass.length + 1];
        k1 = findCoeffZeidel(mass);
        for (int i = 0; i < k1.length; i++) {
            System.out.println(k1[i]);
        }
        System.out.println();
        k1 = findCoeffJacoby(mass);
        for (int i = 0; i < k1.length; i++) {
            System.out.println(k1[i]);
        }
        System.out.println();

        double[] x = Zeidel(mass, 100);
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]);
        }

//        k = findCoeffJacoby(mass);
//        System.out.println();
//        for (int i = 0; i < k.length; i++) {
//            k1[i] = k[k.length - i - 1];
//            System.out.println(k1[i]);
//        }
//        k = findCoeffZeidel(mass);
//        System.out.println();
//        for (int i = 0; i < k.length; i++) {
//            k1[i] = k[k.length - i - 1];
//            System.out.println(k1[i]);
//        }
//        Complex64F[] k2 = findRoots(k);
//        for (int i = 0; i < k2.length; i++) {
//            System.out.println(k2[i]);
//        }
//        System.out.println(convergence(mass));
//        x0 = new double[mass.length];
//        setX0();
//        f = new double[mass.length];
//        setF0();
//        System.out.println(thirdNorm(mass));
//        nextItterJacoby(x0, mass, f);
    }

    private static void setX0() throws IOException {
        String[] s = reader.readLine().split(" ");
        x0 = new double[mass.length];
        for (int i = 0; i < x0.length; i++) {
            x0[i] = Double.parseDouble(s[i]);
        }
    }

    private static void setF0() throws IOException {
        String[] s = reader.readLine().split(" ");
        f = new double[mass.length];
        for (int i = 0; i < f.length; i++) {
            f[i] = Double.parseDouble(s[i]);
        }
    }

    public static double[][] createMass(int a) throws IOException {
        //reading from console
        double[][] mass = new double[a][a];
        double[][] mass1;
        String s = reader.readLine();
        String[] massLine = s.split(" ");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                mass[i][j] = Double.parseDouble(massLine[a * i + j]);
            }
        }
        System.out.println(MatFunc.determinant(mass) + "determinant");
//        mass1 = mass;
//        mass = multiply(makeTran(mass1), mass);
        return mass;
    }

    public static double conditionality(double[][] mass) {
        double conditionality;
        Matrix matrix = new Matrix(mass);
        matrix.times(matrix.inverse());
        double[][] m = matrix.getArray();
        conditionality = m[0][0];
        return conditionality;
    }

    public static void setNorm(int a) {
        norm = a;
    }

    public static double[] Jacoby(double[][] mass, int n) throws IOException {
        if (!convergenceJacoby(mass)) {
            System.out.println("Not convergences");
            return null;
        }
        setX0();
        if (x0.length != mass.length) {
            System.out.println("Wrong x0");
            return null;
        }
        setF0();
        if (f.length != mass.length) {
            System.out.println("Wrong f0");
            return null;
        }
        for (int i = 0; i < n; i++) {
            nextItterJacoby(x0, mass, f);
        }
        return x0;
    }

    public static double[] Zeidel(double[][] mass, int n) throws IOException {
        if (!convergenceZeidel(mass)) {
            System.out.println("Not convergences");
            return null;
        }
        setX0();
        if (x0.length != mass.length) {
            System.out.println("Wrong x0");
            return null;
        }
        setF0();
        if (f.length != mass.length) {
            System.out.println("Wrong f0");
            return null;
        }
        for (int i = 0; i < n; i++) {
            nextItterZeidel(x0, mass, f);
        }
        return x0;
    }


    public static void nextItterJacoby(double[] x0, double[][] mass, double[] f) {
        if (x0.length != mass.length) {
            Zeidel.x0 = x0;
        }
        double[][] massl = new double[mass.length][mass[0].length];
        double[][] massd = new double[mass.length][mass[0].length];
        double[][] massu = new double[mass.length][mass[0].length];
        double[][] massx0 = new double[mass.length][mass[0].length];
        double[][] massf = new double[mass.length][mass[0].length];
        double[][] massRes;
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < 1; j++) {
                massx0[i][j] = x0[i];
            }
        }
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < 1; j++) {
                massf[i][j] = f[i];
            }
        }

        MatFunc.makeUDL(mass, massu, massd, massl);

        MatFunc.invert(MatFunc.matrixSum(massl, massd));
        massRes = MatFunc.multiply(massl, massf);
        MatFunc.matrixTimes(massl, -1);
        massl = MatFunc.multiply(massl, massu);
        massl = MatFunc.multiply(massl, massx0);
        MatFunc.matrixSum(massl, massRes);

        for (int i = 0; i < massl.length; i++) {
            for (int j = 0; j < 1; j++) {
                x0[i] = massl[i][j];
            }
        }

        Zeidel.x0 = x0;
    }

    public static void nextItterZeidel(double[] x0, double[][] mass, double[] f) {
        if (x0.length != mass.length) {
            Zeidel.x0 = x0;
        }
        double[][] massl = new double[mass.length][mass[0].length];
        double[][] massd = new double[mass.length][mass[0].length];
        double[][] massu = new double[mass.length][mass[0].length];
        double[][] massx0 = new double[mass.length][mass[0].length];
        double[][] massf = new double[mass.length][mass[0].length];
        double[][] massRes;
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < 1; j++) {
                massx0[i][j] = x0[i];
            }
        }
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < 1; j++) {
                massf[i][j] = f[i];
            }
        }

        MatFunc.makeUDL(mass, massu, massd, massl);

        MatFunc.invert(massd);
        MatFunc.matrixSum(massl, massu);
        massRes = MatFunc.multiply(massl, massd);
        MatFunc.matrixTimes(massRes, -1);
        massRes = MatFunc.multiply(massRes, massx0);
        massd = MatFunc.multiply(massd, massf);
        massRes = MatFunc.matrixSum(massRes, massd);

        for (int i = 0; i < massRes.length; i++) {
            for (int j = 0; j < 1; j++) {
                x0[i] = massRes[i][j];
            }
        }

        Zeidel.x0 = x0;
    }

    public static boolean convergenceZeidel(double[][] mass) {
        double[] k;
        k = findCoeffZeidel(mass);

        Complex64F[] complex = findRoots(k);

        for (int i = 0; i < complex.length; i++) {
            System.out.println(complex[i].toString() + "  root:" + i);
            if (Math.pow(complex[i].getReal() * complex[i].getReal() + complex[i].getImaginary() * complex[i].getImaginary(), 0.5) > 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean convergenceJacoby(double[][] mass) {
        double[] k;
        k = findCoeffJacoby(mass);

        Complex64F[] complex = findRoots(k);

        for (int i = 0; i < complex.length; i++) {
            System.out.println(complex[i].toString() + "  root:" + i);
            if (Math.pow(complex[i].getReal() * complex[i].getReal() + complex[i].getImaginary() * complex[i].getImaginary(), 0.5) > 1) {
                return false;
            }
        }
        return true;
    }

    public static double[] findCoeffJacoby(double[][] mass) {//положить мульты диагонали
        double[] k = new double[mass.length + 1];
        double[] k1;
        if (mass.length % 2 != 0) {
            k1 = Kplus(mass);
            k[0] = k1[0];
            for (int i = 1; i < k1.length; i++) {
                k[k.length - 1] += k1[i]; ///1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
            }
            k1 = Kminus(mass);
            for (int i = 0; i < k1.length; i++) {
                k[k.length - 2] += k1[i];
            }
        } else {
            k1 = Kplus(mass);
            k[0] = k1[0];
            for (int i = 1; i < k1.length; i++) {
                k[k.length - 1] += k1[i];
            }
            k1 = Kminus(mass);
            for (int i = 0; i < k1.length; i++) {
                if (i % 2 != 0) {
                    k[k.length - 3] += k1[i];
                }
            }
            for (int i = 0; i < k1.length; i++) {
                if (i % 2 == 0) {
                    k[k.length - 1] += k1[i];
                }
            }
        }
        if (k1.length == 1) {
            for (int i = 0; i < k.length; i++) {
                k[i] = 0;
            }
            k[0] = mass[0][0];
        }
        if (mass.length == 2) {
            for (int i = 0; i < k.length; i++) {
                k[i] = 0;
            }
            k[0] = mass[0][0] * mass[1][1];
            k[1] = -1 * mass[0][1] * mass[1][0];
        }
        k1 = new double[k.length];
        for (int i = 0; i < k.length; i++) {
            k1[i] = k[k.length - i - 1];
        }
        return k1;
    }

    public static double[] findCoeffZeidel(double[][] mass) {//положить мульты диагонали
        double[] k = new double[mass.length + 1];
        double[] k1;
        if (mass.length % 2 != 0) {
            k1 = Kplus(mass);
            k[0] = k1[0];
            for (int i = 1; i < k1.length; i++) {
                k[k.length - i - 1] = k1[i];
            }

            //(k.length + 1) / 2 - 1
            // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
            k1 = Kminus(mass);
            for (int i = 0; i < k1.length; i++) {
                k[k.length - 1 - (k.length + 1) / 2] += k1[i];
            }
        } else {
            k1 = Kplus(mass);
            k[0] = k1[0];
            for (int i = 1; i < k1.length; i++) {
                k[k.length - i - 1] = k1[i];
            }
            k1 = Kminus(mass);
            for (int i = 0; i < k1.length; i++) {
                if (i % 2 != 0) {
                    k[(k1.length / 2) - 1] += k1[i];
                }
            }
            for (int i = 0; i < k1.length; i++) {
                if (i % 2 == 0) {
                    k[k1.length / 2] += k1[i];
                }
            }
        }
        if (mass.length == 1) {
            for (int i = 0; i < k.length; i++) {
                k[i] = 0;
            }
            k[0] = mass[0][0];
        }
        if (mass.length == 2) {
            for (int i = 0; i < k.length; i++) {
                k[i] = 0;
            }
            k[0] = mass[0][0] * mass[1][1];
            k[2] = -1 * mass[0][1] * mass[1][0];
        }

        k1 = new double[k.length];
        for (int i = 0; i < k.length; i++) {
            k1[i] = k[k.length - i - 1];
        }
        return k1;
    }

    public static double[] Kplus(double[][] mass) { //положить мульты диагонали
        double[] k = new double[mass.length];
        for (int i = 0; i < mass.length; i++) {
            double mult = 1;
            for (int j = 0; j < mass.length; j++) {
                if (i + j >= mass.length) {
                    mult *= mass[j][j + i - mass.length];
                } else {
                    mult *= mass[j][j + i];
                }
            }
            k[i] = mult;
        }
        return k;
    }

    public static double[] Kminus(double[][] mass) { //положить мульты диагонали зеркальной
        double[] k;
        double[][] mass1 = new double[mass.length][mass.length];
        for (int i = 0; i < mass1.length; i++) {
            for (int j = 0; j < mass1.length; j++) {
                mass1[i][j] = mass[i][mass.length - j - 1];
            }
        }
        k = Kplus(mass1);
        for (int i = 0; i < k.length; i++) {
            k[i] *= -1;
        }
//        for (int i = 0; i <k.length ; i++) {
//            System.out.println(k[i]);
//        }
        return k;
    }

    public static Complex64F[] findRoots(double... coefficients) {
        int N = coefficients.length - 1;

        // Construct the companion matrix
        DenseMatrix64F c = new DenseMatrix64F(N, N);

        double a = coefficients[N];
        for (int i = 0; i < N; i++) {
            c.set(i, N - 1, -coefficients[i] / a);
        }
        for (int i = 1; i < N; i++) {
            c.set(i, i - 1, 1);
        }

        // use generalized eigenvalue decomposition to find the roots
        EigenDecomposition<DenseMatrix64F> evd = DecompositionFactory.eig(N, false);

        evd.decompose(c);

        Complex64F[] roots = new Complex64F[N];

        for (int i = 0; i < N; i++) {
            roots[i] = evd.getEigenvalue(i);
        }
        return roots;
    }
}

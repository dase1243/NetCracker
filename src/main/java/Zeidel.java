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
        double[] k;
        double[] k1 = new double[mass.length + 1];
        System.out.println(convergence(mass));


//        x0 = new double[mass.length];
//        setX0();
//        f = new double[mass.length];
//        setF0();
//        System.out.println(thirdNorm(mass));
//        for (int i = 0; i < 100; i++) {
//            nextItter(x0, mass, f);
//        }
//        // nextItter(x0, mass, f);
//        for (int i = 0; i < x0.length; i++) {
//            System.out.println(x0[i]);
//        }
//        System.out.println(secondNorm(mass));
//        mass = makeSim(mass);
//        setNorm(2);
//        for (int i = 0; i < mass.length; i++) {
//            for (int j = 0; j < mass[1].length; j++) {
//                System.out.print(mass[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    private static void setX0() throws IOException {
        String[] s = reader.readLine().split(" ");
        for (int i = 0; i < x0.length; i++) {
            x0[i] = Double.parseDouble(s[i]);
        }
    }

    private static void setF0() throws IOException {
        String[] s = reader.readLine().split(" ");
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
        System.out.println(determinant(mass));
//        mass1 = mass;
//        mass = multiply(mass, makeTran(mass1));
        return mass;
    }

    public static double[][] makeTran(double[][] mass) {
        double[][] tmp = new double[mass.length][mass[0].length];
        for (int i = 0; i < mass[0].length; i++) {
            for (int j = 0; j < mass.length; j++) {
                tmp[i][j] = mass[j][i];
            }
        }
        mass = tmp;
        return mass;
    }

    public static double[][] makeSim(double[][] mass) {
        //A^T*A
        double[][] massTr = makeTran(mass);
        int m = mass.length;
        int n = massTr[0].length;
        int o = massTr.length;
        double[][] massSim = new double[mass.length][mass[0].length];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < o; k++) {
                    massSim[i][j] += mass[i][k] * massTr[k][j];
                }
            }
        }
        return massSim;
    }

    public static double countNorm() {
        return 0;
    }

    public static double firstNorm(double[][] mass) {
        double maxStr = 0;
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < mass[0].length; j++) {
                maxStr += Math.abs(mass[i][j]);
            }
        }
        int strSum = 0;
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[0].length; j++) {
                strSum += Math.abs(mass[i][j]);
            }
            if (strSum > maxStr) {
                maxStr = strSum;
            }
            strSum = 0;
        }
        return maxStr;
    }

    public static double secondNorm(double[][] mass) {
        mass = makeTran(mass);
        double maxCol = firstNorm(mass);
        return maxCol;
    }

    public static double thirdNorm(double[][] mass) {
        double[] mass1;
        Matrix matrix = new Matrix(mass);
        EigenvalueDecomposition eigenvalueDecomposition = matrix.eig();
        mass1 = eigenvalueDecomposition.getRealEigenvalues();
        double max = mass1[0];
        for (int i = 0; i < mass1.length; i++) {
            if (mass1[i] > max) {
                max = mass1[i];
            }
        }
        return max;
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

    public static void nextItter(double[] x0, double[][] mass, double[] f) {
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

        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[0].length; j++) {
                if (i == j) {
                    massd[i][j] = mass[i][j];
                }
                if (i < j) {
                    massu[i][j] = mass[i][j];
                }
                if (i > j) {
                    massl[i][j] = mass[i][j];
                }
            }
        }

        System.out.println();
        for (int i = 0; i < massu.length; i++) {
            for (int j = 0; j < massu[1].length; j++) {
                System.out.print(massu[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < massd.length; i++) {
            for (int j = 0; j < massd[1].length; j++) {
                System.out.print(massd[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < massl.length; i++) {
            for (int j = 0; j < massl[1].length; j++) {
                System.out.print(massl[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < massl.length; i++) {
            for (int j = 0; j < massl[1].length; j++) {
                System.out.print(mass[i][j] + " ");
            }
            System.out.println();
        }

        invert(matrixSum(massl, massd));
        massRes = multiply(massl, massf);
        matrixTimes(massl, -1);
        massl = multiply(massl, massu);
        massl = multiply(massl, massx0);
        matrixSum(massl, massRes);


        System.out.println();
        for (int i = 0; i < massl.length; i++) {
            for (int j = 0; j < 1; j++) {
                x0[i] = massl[i][j];
            }
        }

        Zeidel.x0 = x0;
    }

    public static double[][] matrixTimes(double[][] mass, double d) {
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[0].length; j++) {
                mass[i][j] = mass[i][j] * d;
            }
        }
        return mass;
    }


    public static double[][] matrixSum(double[][] mass, double[][] mass1) {
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[0].length; j++) {
                mass[i][j] += mass1[i][j];
            }
        }
        return mass;
    }

    public static final void invert(double A[][]) {
        int n = A.length;
        int row[] = new int[n];
        int col[] = new int[n];
        double temp[] = new double[n];
        int hold, I_pivot, J_pivot;
        double pivot, abs_pivot;

        // установиим row и column как вектор изменений.
        for (int k = 0; k < n; k++) {
            row[k] = k;
            col[k] = k;
        }
        // начало главного цикла
        for (int k = 0; k < n; k++) {
            // найдем наибольший элемент для основы
            pivot = A[row[k]][col[k]];
            I_pivot = k;
            J_pivot = k;
            for (int i = k; i < n; i++) {
                for (int j = k; j < n; j++) {
                    abs_pivot = Math.abs(pivot);
                    if (Math.abs(A[row[i]][col[j]]) > abs_pivot) {
                        I_pivot = i;
                        J_pivot = j;
                        pivot = A[row[i]][col[j]];
                    }
                }
            }

            //перестановка к-ой строки и к-ого столбца с стобцом и строкой, содержащий основной элемент(pivot основу)
            hold = row[k];
            row[k] = row[I_pivot];
            row[I_pivot] = hold;
            hold = col[k];
            col[k] = col[J_pivot];
            col[J_pivot] = hold;
            // k-ую строку с учетом перестановок делим на основной элемент
            A[row[k]][col[k]] = 1.0 / pivot;
            for (int j = 0; j < n; j++) {
                if (j != k) {
                    A[row[k]][col[j]] = A[row[k]][col[j]] * A[row[k]][col[k]];
                }
            }
            // внутренний цикл
            for (int i = 0; i < n; i++) {
                if (k != i) {
                    for (int j = 0; j < n; j++) {
                        if (k != j) {
                            A[row[i]][col[j]] = A[row[i]][col[j]] - A[row[i]][col[k]] *
                                    A[row[k]][col[j]];
                        }
                    }
                    A[row[i]][col[k]] = -A[row[i]][col[k]] * A[row[k]][col[k]];
                }
            }
        }
        // конец главного цикла

        // переставляем назад rows
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                temp[col[i]] = A[row[i]][j];
            }
            for (int i = 0; i < n; i++) {
                A[i][j] = temp[i];
            }
        }
        // переставляем назад columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[row[j]] = A[i][col[j]];
            }
            for (int j = 0; j < n; j++) {
                A[i][j] = temp[j];
            }
        }
    }

    public static final double[][] multiply(final double A[][], final double B[][]) {
        int ni = A.length;
        int nk = A[0].length;
        int nj = B[0].length;
        double C[][] = new double[ni][nj];

        for (int i = 0; i < ni; i++)
            for (int j = 0; j < nj; j++) {
                C[i][j] = 0.0;
                for (int k = 0; k < nk; k++)
                    C[i][j] = C[i][j] + A[i][k] * B[k][j];
            }
        return C;
    }

    public static boolean convergence(double[][] mass) {
        double[] k = new double[mass.length + 1];
        k = findCoeff(mass);
        Complex64F[] complex = findRoots(k);
        for (int i = 0; i < complex.length; i++) {
            if (Math.pow((Math.pow(complex[i].getImaginary(), 2) + Math.pow(complex[i].getReal(), 2)), 0.5) > 1) {
                return false;
            }
        }
        return true;
    }

    public static final double determinant(final double A[][]) {
        int n = A.length;
        double D = 1.0;                 // определитель
        double B[][] = new double[n][n];  // рабочая матрица
        int row[] = new int[n];
        int hold, I_pivot;
        double pivot;
        double abs_pivot;

        // создаем рабочую матрицу
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                B[i][j] = A[i][j];
        // заполняем вектор перестановок
        for (int k = 0; k < n; k++) {
            row[k] = k;
        }
        // начало основного цикла
        for (int k = 0; k < n - 1; k++) {
            // находим наиболший элемент для основы
            pivot = B[row[k]][k];
            abs_pivot = Math.abs(pivot);
            I_pivot = k;
            for (int i = k; i < n; i++) {
                if (Math.abs(B[row[i]][k]) > abs_pivot) {
                    I_pivot = i;
                    pivot = B[row[i]][k];
                    abs_pivot = Math.abs(pivot);
                }
            }
            // если нашлась такая основа, то меняем знак определителя и меняем местами столбцы
            if (I_pivot != k) {
                hold = row[k];
                row[k] = row[I_pivot];
                row[I_pivot] = hold;
                D = -D;
            }
            // проверка на ноль
            if (abs_pivot < 1.0E-10) {
                return 0.0;
            } else {
                D = D * pivot;
                // делим на основу
                for (int j = k + 1; j < n; j++) {
                    B[row[k]][j] = B[row[k]][j] / B[row[k]][k];
                }
                //  внутренний цикл
                for (int i = 0; i < n; i++) {
                    if (i != k) {
                        for (int j = k + 1; j < n; j++) {
                            B[row[i]][j] = B[row[i]][j] - B[row[i]][k] * B[row[k]][j];
                        }
                    }
                }
            }
            // конец внутреннего цикла
        }
        // конец главного цикла
        return D * B[row[n - 1]][n - 1];
    }

    public static double[] findCoeff(double[][] mass) {//положить мульты диагонали
        double[] k = new double[mass.length + 1];
        double[] k1;
        if (mass.length % 2 != 0) {
            k1 = Kplus(mass);
            k[0] = k1[0];
            for (int i = 1; i < k1.length; i++) {
                k[k.length - 1] += k1[i];
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
                    k[k.length - 2] += k1[i];
                }
            }
            for (int i = 0; i < k1.length; i++) {
                if (i % 2 == 0) {
                    k[k.length - 1] += k1[i];
                }
            }
        }
        for (int i = 0; i < k.length; i++) {
            k1[i] = k[k.length - i - 1];
            System.out.println(k1[i]);
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


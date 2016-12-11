import Jama.EigenvalueDecomposition;
import Jama.Matrix;

/**
 * Created by dreikaa on 12/11/16.
 */
public class MatFunc {

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

    public static void makeUDL(double[][] mass, double[][] massu, double[][] massd, double[][] massl) {
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
    }

    public static double[][] matrixTimes(double[][] mass, double d) {
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[0].length; j++) {
                mass[i][j] = mass[i][j] * d;
            }
        }
        return mass;
    }

    public static double[] matrixTimes(double[] mass, double d) {
        for (int i = 0; i < mass.length; i++) {
            mass[i] = mass[i] * d;
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
}

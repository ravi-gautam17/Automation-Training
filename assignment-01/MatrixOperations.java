import java.util.Scanner;

public class MatrixOperations {

  
    public static int[][] readMatrix(Scanner sc, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

  

    public static int[][] add(int[][] a, int[][] b) {
        int r = a.length, c = a[0].length;
        int[][] result = new int[r][c];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                result[i][j] = a[i][j] + b[i][j];

        return result;
    }

    public static int[][] subtract(int[][] a, int[][] b) {
        int r = a.length, c = a[0].length;
        int[][] result = new int[r][c];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                result[i][j] = a[i][j] - b[i][j];

        return result;
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        int r1 = a.length, c1 = a[0].length, c2 = b[0].length;
        int[][] result = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    public static int[][] transpose(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        int[][] result = new int[c][r];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                result[j][i] = matrix[i][j];

        return result;
    }

    

    public static boolean isSquare(int[][] matrix) {
        return matrix.length == matrix[0].length;
    }

    public static boolean isDiagonal(int[][] matrix) {
        if (!isSquare(matrix)) return false;

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix.length; j++)
                if (i != j && matrix[i][j] != 0)
                    return false;

        return true;
    }

    public static boolean isIdentity(int[][] matrix) {
        if (!isSquare(matrix)) return false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j && matrix[i][j] != 1) return false;
                if (i != j && matrix[i][j] != 0) return false;
            }
        }
        return true;
    }

   




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        System.out.println("Enter Matrix A:");
        int[][] A = readMatrix(sc, r, c);

        System.out.println("Enter Matrix B:");
        int[][] B = readMatrix(sc, r, c);

        System.out.println("\nAddition:");
        printMatrix(add(A, B));

        System.out.println("\nSubtraction:");
        printMatrix(subtract(A, B));




        if (c == r) {

            System.out.println("\nMultiplication:");
            printMatrix(multiply(A, B));

        } else {

            System.out.println("\nMultiplication not possible");

        }

        System.out.println("\nTranspose of Matrix A:");
        printMatrix(transpose(A));

        System.out.println("\nIs Square Matrix: " + isSquare(A));
        System.out.println("Is Diagonal Matrix: " + isDiagonal(A));
        System.out.println("Is Identity Matrix: " + isIdentity(A));

        sc.close();
    }
}

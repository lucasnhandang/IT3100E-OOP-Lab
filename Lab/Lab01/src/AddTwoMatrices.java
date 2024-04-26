import java.util.Scanner;

public class AddTwoMatrices {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Choose how do you want to take the input:");
        System.out.println("Enter 0 for standard input, or 1 for a constant");

        int check = scn.nextInt();
        if(check == 0) { // std input
            System.out.println("Enter the number of rows:");
            int n = scn.nextInt();
            System.out.println("Enter the number of columns:");
            int m = scn.nextInt();

            double a[][] = new double[n][m];
            System.out.println("Enter the elements of matrix A:");
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < m; ++j) a[i][j] = scn.nextDouble();

            double b[][] = new double[n][m];
            System.out.println("Enter the elements of matrix B:");
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < m; ++j) b[i][j] = scn.nextDouble();

            double c[][] = new double[n][m];
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < m; ++j) c[i][j] = a[i][j] + b[i][j];

            System.out.println("Result after add two matrices A and B:");
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) System.out.print(c[i][j] + " ");
                System.out.print("\n");
            }
        }
        else {
            final double a[][] = {{1, 2, 3, 4}, {2, 3, 5, 8}};
            final double b[][] = {{10, 2, 3, 6}, {1, 2, 3, 4}};

            System.out.println("Matrix A:");
            for (int i = 0; i < 2; ++i) {
                for (int j = 0; j < 4; ++j) System.out.print(a[i][j] + " ");
                System.out.print("\n");
            }

            System.out.println("Matrix B:");
            for (int i = 0; i < 2; ++i) {
                for (int j = 0; j < 4; ++j) System.out.print(b[i][j] + " ");
                System.out.print("\n");
            }

            System.out.println("Result after add two matrices A and B:");
            for (int i = 0; i < 2; ++i) {
                for (int j = 0; j < 4; ++j) System.out.print(a[i][j] + b[i][j] + " ");
                System.out.print("\n");
            }
        }
    }
}

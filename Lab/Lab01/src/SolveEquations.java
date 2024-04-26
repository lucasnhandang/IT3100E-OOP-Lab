import java.util.Scanner;
import java.lang.Math;

public class SolveEquations {
    public static void FirstDeg (double a, double b) {
        if (a == 0) {
            if (b == 0)
                System.out.println("Infinite Solution.");
            else System.out.println("No Solution.");
        }
        else System.out.println("The root is: " + -b / a);
    }

    public static void SysFirstDeg (double d, double dx, double dy) {
        if (d != 0)
            System.out.println("The system equation has one root: (" + dx / d + ", " + dy / d + ")");
        else {
            if (dx == 0 && dy == 0) System.out.println("The system equation has infinite solution.");
            else System.out.println("The system equation has no solution.");
        }
    }

    public static void SecDeg (double a, double b, double c) {
        if (a == 0) FirstDeg(b, c);
        else {
            double delta = b * b - 4 * a *c;
            if (delta == 0) {
                double ans = -b / (2 * a);
                System.out.println("The equation has root: " + ans);
            }
            else if (delta < 0)
                System.out.println("The equation has no solution.");
            else {
                double ans1 = (-b + Math.sqrt(delta)) / (4 * a);
                double ans2 = (-b - Math.sqrt(delta)) / (4 * a);
                System.out.println("The equation has two roots: " + ans1 + ", " + ans2);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Solve the first-degree equation with one variable:");
        System.out.println("Enter a:");
        double a = scn.nextDouble();
        System.out.println("Enter b:");
        double b = scn.nextDouble();
        FirstDeg(a, b);

        System.out.println("The system of first-degree equations (linear system) with two variables:");
        System.out.println("Enter the matrix of coefficients:");
        double x[][] = new double[4][4];
        for (int i = 1; i <= 2; ++i)
            for (int j = 1; j <= 3; ++j)
                x[i][j] = scn.nextDouble();
        double det = x[1][1] * x[2][2] - x[1][2] * x[2][1];
        double dx = x[1][3] * x[2][2] - x[2][3] * x[1][2];
        double dy = x[1][1] * x[2][3] - x[2][1] * x[1][3];
        SysFirstDeg(det, dx, dy);

        System.out.println("Solve the second-degree equation with one variable:");
        System.out.println("Enter a:");
        a = scn.nextDouble();
        System.out.println("Enter b:");
        b = scn.nextDouble();
        System.out.println("Enter c:");
        double c = scn.nextDouble();
        SecDeg(a, b, c);
    }
}
import java.util.Scanner;

public class StarTriangle {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = scn.nextInt();

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= 2 * n - 1; ++j) {
                if(j <= n - i || j >= n + i) System.out.print(" ");
                else System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}

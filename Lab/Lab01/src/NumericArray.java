import java.util.Arrays;
import java.util.Scanner;

public class NumericArray {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Choose how do you want to take the input:");
        System.out.println("Enter 0 for standard input, or 1 for a constant");

        int check = scn.nextInt();
        double sum = 0; double avg = 0;
        if (check == 0) { // std input
            System.out.println("Enter the number of elements of the array:");
            int n = scn.nextInt();
            System.out.println("Enter n elements:");
            double a[] = new double[n];
            for (int i = 0; i < n; ++i) {
                a[i] = scn.nextDouble();
                sum += a[i];
                avg += a[i];
            }
            avg /= n;
            Arrays.sort(a);
            System.out.println("Sorted array: " + Arrays.toString(a));
            System.out.println("The sum: " + sum);
            System.out.println("The average value: " + avg);
        }
        else { // const
            final double[] a = {13.27, 211.98, 3, 102.9, 22, 33.42};
            for (int i = 0; i < a.length; ++i) {
                sum += a[i];
                avg += a[i];
            }
            avg /= a.length;
            Arrays.sort(a);
            System.out.println("Sorted array: " + Arrays.toString(a));
            System.out.println("The sum: " + sum);
            System.out.println("The average value: " + avg);
        }
    }
}

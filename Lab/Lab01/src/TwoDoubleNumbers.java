import java.util.Scanner;

public class TwoDoubleNumbers {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter 2 double numbers:");
        String s1 = scn.next();
        String s2 = scn.next();

        double a = Double.parseDouble(s1);
        double b = Double.parseDouble(s2);

        System.out.println("The sum: " + (a + b));
        System.out.println("The difference: " + (a - b));
        System.out.println("The product: " + (a * b));
        System.out.println("The quotient: " + (a / b));
    }
}

import java.util.Scanner;

public class NumOfDayOfMonth {
    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the month in either its full name, " +
                            "abbreviation, in 3 letters, or in number:");
        String[] monthNamesFull = {"January", "February", "March", "April", "May", "June"
        , "July", "August", "September", "October", "November", "December"};
        String[] monthNamesAbb = {"Jan.", "Feb.", "Mar.", "Apr.", "May", "June"
                , "July", "Aug.", "Sept.", "Oct.", "Nov.", "Dec."};
        String[] monthNames3Letter = {"Jan", "Feb", "Mar", "Apr", "May", "Jun"
                , "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] monthNamesInt = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};

        int month = -1;
        while(true) {
            String inp = scn.next();
            boolean ok = false;

            for (int i = 0; i < monthNamesFull.length; ++i) {
                if(inp.equals(monthNamesFull[i]))
                    ok = true;

                if(inp.equals(monthNamesAbb[i]))
                    ok = true;

                if(inp.equals(monthNames3Letter[i]))
                    ok = true;

                if(inp.equals(monthNamesInt[i]))
                    ok = true;

                if(ok) {
                    month = i + 1;
                    break;
                }
            }

            if(ok) break;
            else System.out.println("Invalid input. Please enter the month again.");
        }

        System.out.println("Enter the year in a non-negative number:");
        int year = -1;
        while(true) {
            String yr = scn.next();
            if(isNumeric(yr)) {
                year = Integer.valueOf(yr);
                break;
            }
            else System.out.println("Invalid input. Please enter the year again.");
        }

        //System.out.println(year);
        //System.out.println(month);

        System.out.println("The number of days of this month is: ");
        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8
            || month == 10 || month == 12) System.out.print("31");
        else if(month == 4 || month == 6 || month == 9 || month == 11)
            System.out.print("30");
        else {
            boolean leapYear = true;

            if((year % 100 == 0 && year % 400 != 0) || (year % 4 != 0))
                leapYear = false;

            if(leapYear) System.out.print("29");
            else System.out.print("28");
        }
    }
}

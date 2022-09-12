import java.util.Scanner;
import static java.lang.System.exit;

//***************************************************************
//
//  Developer:         Khue Nguyen
//
//  Program #:         11
//
//  File Name:         Program11.java
//
//  Course:            ITSE 2321 Object-Oriented Programming - Java
//
//  Due Date:          12/2/2021
//
//  Instructor:        Fred Kumi
//
//  Chapter:           11
//
//  Description:       Strings
//
//
//***************************************************************

public class Program11 {

    // Max length of user input
    private static final int MAX_SPACES = 7;

    public static void main(String[] args) {
        developerInfo();
        Program11 Check = new Program11();
        Check.convertAmount();
    }


    //***************************************************************
    //
    //  Method:       getAmount
    //
    //  Description:  Get user input for amount value
    //
    //  Parameters:   None
    //
    //  Returns:      String
    //
    //**************************************************************
    public String getAmount() {
        // Scanner to get user input
        Scanner in = new Scanner(System.in);

        // Get dollar amount
        System.out.print("Enter dollar amount to be printed: $");
        return in.nextLine().trim();
    }

    //***************************************************************
    //
    //  Method:       validAmount
    //
    //  Description:  method to check if input length is less than or equal to MAX_SPACES
    //
    //  Parameters:   string
    //
    //  Returns:      bool
    //
    //**************************************************************
    public boolean validAmount(String amount) {return (amount.length() <= MAX_SPACES);}

    //***************************************************************
    //
    //  Method:       getDollar
    //
    //  Description:  Get dollar amount
    //
    //  Parameters:   string
    //
    //  Returns:      long
    //
    //**************************************************************
    public long getDollar(String amount) {return (long) Float.parseFloat(amount);}

    //***************************************************************
    //
    //  Method:       getCent
    //
    //  Description:  Get cent amount
    //
    //  Parameters:   string, long
    //
    //  Returns:      long
    //
    //**************************************************************
    public long getCent(String amount, long dollars) {
        // convert cent to type long and round off to the nearest integer
        return Math.round((Float.parseFloat(amount) - dollars) * 100);
    }

    //***************************************************************
    //
    //  Method:       convertAmount
    //
    //  Description:  method to print value from dollar amount to words
    //
    //  Parameters:   None
    //
    //  Returns:      N/A
    //
    //**************************************************************
    public void convertAmount() {
        // Declare string variables for ones and tens
        String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {
                "",          // 0
                "",          // 1
                "Twenty",    // 2
                "Thirty",    // 3
                "Forty",     // 4
                "Fifty",     // 5
                "Sixty",     // 6
                "Seventy",   // 7
                "Eighty",    // 8
                "Ninety"     // 9
        };

        // call getAmount to get value from user input
        String amount = getAmount();

        // exit if input 0
        if (amount.equals("0")) exit(0);

        else if (validAmount(amount)) {

            // call methods to get values of dollar and cent
            long dollars = getDollar(amount);
            long cent = getCent(amount, dollars);

            //Check if dollar is 1000 and above. If yes, try again.
            if (dollars >= 1000) {
                System.out.print("Amount has to be less than $1000. Please try again.\n");
                convertAmount();
            } else {
                System.out.print("Amount in words:\t\t\t");

                if (Float.parseFloat(amount) < 20) {                        // if number is less than 20
                    System.out.print(ones[(int) Float.parseFloat(amount)]);
                } else if (Float.parseFloat(amount) < 100) {                // if number is less than 100
                    System.out.print(tens[(int) Float.parseFloat(amount) / 10] + ((Float.parseFloat(amount) % 10 != 0) ? " " : "") + ones[(int) Float.parseFloat(amount) % 10]);
                } else if (Float.parseFloat(amount) < 1000) {               // if number is less than 1000
                    System.out.print(ones[(int) Float.parseFloat(amount) / 100] + " Hundred " + ((Float.parseFloat(amount) % 100 != 0) ? tens[(int) Float.parseFloat(amount) % 100 / 10] + (((Float.parseFloat(amount) % 100) % 10 != 0) ? " " : "") + ones[(int) Float.parseFloat(amount) % 10] : ""));
                }

                // check for cent values and print accordingly
                if (dollars < 1) {
                    System.out.print(cent + " cents.\n");
                }
                else if (cent > 0) {
                    System.out.print(" and " + cent + "/100 dollars\n");
                } else {
                    System.out.print(" dollars.\n");
                }

            }
            // continue calling method
            convertAmount();
        } else{
                System.out.println("ERROR: Dollar amount cannot be greater than " + MAX_SPACES + " length.");
                convertAmount();
        }
    }

    //***************************************************************
    //
    //  Method:       developerInfo
    //
    //  Description:  The developer information method of the program
    //
    //  Parameters:   None
    //
    //  Returns:      N/A
    //
    //**************************************************************
    public static void developerInfo() {
        System.out.println("Name:    Khue Nguyen");
        System.out.println("Course:  ITSE 2321 Object-Oriented Programming");
        System.out.println("Program: Eleven \n");
    }

}


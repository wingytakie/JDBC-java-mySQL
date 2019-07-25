package Menu;

import UserfulJava.ReadInput;

import java.sql.SQLException;
import java.util.Scanner;

public class JDBCTest {


    public static void main(String[] args) throws SQLException {
        Boolean validInput = false;

        while (!validInput) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("***********************************************************");
            System.out.println("** Welcome to Wing's Bank. Please select your option.    **");
            System.out.println("***********************************************************");
            System.out.println("** 1. Transaction Details                                **");
            System.out.println("** 2. Customer Details                                   **");
            System.out.println("***********************************************************");
            System.out.println("** Enter X at anytime to exit the program.               **");
            System.out.println("***********************************************************");
            String userInput = new ReadInput().Input();
            if (userInput.equals("1")) {
                validInput = true;
                TransactionDetailsModuleName transactionDetailsModule = new TransactionDetailsModuleName();
            } else if (userInput.equals("2")) {
                validInput = true;
                CustomerDetailsModuleName customerDetailsModule = new CustomerDetailsModuleName();
            } else if (userInput.toLowerCase().equals("x")) {
                break;
            } else {
                System.out.println("Invalid input, please try again.");
                validInput = false;
            }
        }
    }
}

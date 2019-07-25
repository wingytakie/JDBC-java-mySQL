package Module;

import Interfaces.CustomerModule;
import UserfulJava.Initial;
import UserfulJava.ReadInput;
import UserfulJava.SQLQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDetailsModule implements CustomerModule {
    private boolean validSSN = false;
    private boolean validUserInput = false;
    private String sql, sql2, sql3 , sql4, sql5, sql6;
    private Statement myStmt;
    private ResultSet myRs;
    Initial initial;

    @Override
    public void AccountDetails(int ssn) throws SQLException{
        initial = new Initial();
        initial.checkSSN(ssn);

        if (initial.isValidSSNString()) {
            myStmt = initial.getMyStmt();
            sql = String.format(SQLQuery.AccountDetails, ssn);
            myRs = myStmt.executeQuery(sql);
            while(myRs.next()){
                System.out.println("Name:" + myRs.getString("FIRST_NAME") + myRs.getString("LAST_NAME") +
                        "  |  Credit Card No: " + myRs.getString("CREDIT_CARD_NO") + "  |  Email: " +
                        myRs.getString("CUST_EMAIL") + "  |  Phone No: " + myRs.getString("CUST_PHONE"));

            }
            validSSN = initial.isValidSSNString();
        }
        initial.CloseConnection();
    }

    @Override
    public void ModifyDetails(String type, String newInput, int ssn) throws SQLException {
        initial = new Initial();
        initial.checkSSN(ssn);
        String space = " ";

        if (initial.isValidSSNString()) {
            System.out.println("Your "+ (type.toLowerCase()).replace("_", space) + " will be modify to: " + newInput);
            System.out.println("Enter Y / Yes to confirm");
            String decision = new ReadInput().Input();
            decision = decision.toLowerCase();
            if (decision.equals("y") || decision.equals("yes")) {
                System.out.println("Proceeding >>> >>> >>>");

                myStmt = initial.getMyStmt();
                sql = String.format(SQLQuery.ModifyDetails, type, newInput, ssn);
                myStmt.executeUpdate(sql);
                validSSN = initial.isValidSSNString();
                System.out.println("Congrats! You have successfully modify your value to " + newInput +".");
            } else {
                System.out.println("Process have been canceled.");
            }
            initial.CloseConnection();
        }
    }

    @Override
    public void MonthlyBills(String year, String month, int ssn) throws SQLException{
        initial = new Initial();
        initial.checkSSN(ssn);
        myStmt = initial.getMyStmt();
        if (initial.isValidSSNString()) {

            sql = String.format(SQLQuery.MonthlyBills, year, month, ssn);
            myRs = myStmt.executeQuery(sql);
            while (myRs.next()) {
                System.out.println("Name:" + myRs.getString("FIRST_NAME") + myRs.getString("LAST_NAME") +
                        "  |  Date: " + month + "-" + myRs.getString("DAY") + "-" + year + "  |  Transaction Amount: " +
                        myRs.getString("TRANSACTION_VALUE") + "  |  Transaction ID: " + myRs.getString("TRANSACTION_ID"));
            }
            validSSN = initial.isValidSSNString();
        }
        initial.CloseConnection();
    }

    @Override
    public void BetweenDate(String day, String month, String year, String day2, String month2, String year2, int ssn) throws SQLException{
        initial = new Initial();
        initial.checkSSN(ssn);

        if (initial.isValidSSNString()) {
            myStmt = initial.getMyStmt();

            if (year.equals(year2)) {
                if (month.equals(month2)) { //Same year same Month;
                    sql = String.format(SQLQuery.DateSameYearMonth, ssn, year, month, day, day2);
                } else { //same year but not month
                    sql = String.format(SQLQuery.DateSameYearNotMonth, ssn, year, month, day);
                    sql2 = String.format(SQLQuery.DateSameYearNotMonth2, ssn, year, month, month2);
                    sql3 = String.format(SQLQuery.DateSameYearNotMonth3, ssn, year, month2, day2);
                }
            } else { //different year and month
                sql = String.format(SQLQuery.DateAllDiff, ssn, year, month, day);
                sql2 = String.format(SQLQuery.DateAllDiff2, ssn, year, month);
                sql3 = String.format(SQLQuery.DateAllDiff3, ssn, year, year2);
                sql4 = String.format(SQLQuery.DateAllDiff4, ssn, year2, month2);
                sql5 = String.format(SQLQuery.DateAllDiff5, ssn, year2, month2, day2);
            }
            System.out.println("Below is all your transaction between your " + month + "/" + day + "/" + year + " and " + month2 + "/" + day2 + "/" + year2 + ":");
            System.out.println("#################################################################################");
            if (!month.equals(month2)) {
                if (!year.equals(year2)) {
                    myRs = myStmt.executeQuery(sql5);
                    while (myRs.next()) {
                        System.out.println("Date:" + myRs.getString("MONTH") + "/" + myRs.getString("DAY") + "/" + myRs.getString("YEAR") +
                                "  |  Full Name: " + myRs.getString("FIRST_NAME") + myRs.getString("LAST_NAME") + "  |  Transaction Amount: " +
                                myRs.getString("TRANSACTION_VALUE") + "  |  Transaction ID: " + myRs.getString("TRANSACTION_ID"));
                    }
                    myRs = myStmt.executeQuery(sql4);
                    while (myRs.next()) {
                        System.out.println("Date:" + myRs.getString("MONTH") + "/" + myRs.getString("DAY") + "/" + myRs.getString("YEAR") +
                                "  |  Full Name: " + myRs.getString("FIRST_NAME") + myRs.getString("LAST_NAME") + "  |  Transaction Amount: " +
                                myRs.getString("TRANSACTION_VALUE") + "  |  Transaction ID: " + myRs.getString("TRANSACTION_ID"));
                    }
                    myRs = myStmt.executeQuery(sql3);
                    while (myRs.next()) {
                        System.out.println("Date:" + myRs.getString("MONTH") + "/" + myRs.getString("DAY") + "/" + myRs.getString("YEAR") +
                                "  |  Full Name: " + myRs.getString("FIRST_NAME") + myRs.getString("LAST_NAME") + "  |  Transaction Amount: " +
                                myRs.getString("TRANSACTION_VALUE") + "  |  Transaction ID: " + myRs.getString("TRANSACTION_ID"));
                    }
                    myRs = myStmt.executeQuery(sql2);
                    while (myRs.next()) {
                        System.out.println("Date:" + myRs.getString("MONTH") + "/" + myRs.getString("DAY") + "/" + myRs.getString("YEAR") +
                                "  |  Full Name: " + myRs.getString("FIRST_NAME") + myRs.getString("LAST_NAME") + "  |  Transaction Amount: " +
                                myRs.getString("TRANSACTION_VALUE") + "  |  Transaction ID: " + myRs.getString("TRANSACTION_ID"));
                    }
                    myRs = myStmt.executeQuery(sql);
                    while (myRs.next()) {
                        System.out.println("Date:" + myRs.getString("MONTH") + "/" + myRs.getString("DAY") + "/" + myRs.getString("YEAR") +
                                "  |  Full Name: " + myRs.getString("FIRST_NAME") + myRs.getString("LAST_NAME") + "  |  Transaction Amount: " +
                                myRs.getString("TRANSACTION_VALUE") + "  |  Transaction ID: " + myRs.getString("TRANSACTION_ID"));
                    }
                } else {
                    myRs = myStmt.executeQuery(sql3);
                    while (myRs.next()) {
                        System.out.println("Date:" + myRs.getString("MONTH") + "/" + myRs.getString("DAY") + "/" + myRs.getString("YEAR") +
                                "  |  Full Name: " + myRs.getString("FIRST_NAME") + myRs.getString("LAST_NAME") + "  |  Transaction Amount: " +
                                myRs.getString("TRANSACTION_VALUE") + "  |  Transaction ID: " + myRs.getString("TRANSACTION_ID"));
                    }
                    myRs = myStmt.executeQuery(sql2);
                    while (myRs.next()) {
                        System.out.println("Date:" + myRs.getString("MONTH") + "/" + myRs.getString("DAY") + "/" + myRs.getString("YEAR") +
                                "  |  Full Name: " + myRs.getString("FIRST_NAME") + myRs.getString("LAST_NAME") + "  |  Transaction Amount: " +
                                myRs.getString("TRANSACTION_VALUE") + "  |  Transaction ID: " + myRs.getString("TRANSACTION_ID"));
                    }
                    myRs = myStmt.executeQuery(sql);
                    while (myRs.next()) {
                        System.out.println("Date:" + myRs.getString("MONTH") + "/" + myRs.getString("DAY") + "/" + myRs.getString("YEAR") +
                                "  |  Full Name: " + myRs.getString("FIRST_NAME") + myRs.getString("LAST_NAME") + "  |  Transaction Amount: " +
                                myRs.getString("TRANSACTION_VALUE") + "  |  Transaction ID: " + myRs.getString("TRANSACTION_ID"));
                    }
                }
            } else {
                myRs = myStmt.executeQuery(sql);
                while (myRs.next()) {
                    System.out.println("Date:" + myRs.getString("MONTH") + "/" + myRs.getString("DAY") + "/" + myRs.getString("YEAR") +
                            "  |  Full Name: " + myRs.getString("FIRST_NAME") + myRs.getString("LAST_NAME") + "  |  Transaction Amount: " +
                            myRs.getString("TRANSACTION_VALUE") + "  |  Transaction ID: " + myRs.getString("TRANSACTION_ID"));
                }
                validSSN = initial.isValidSSNString();
            }
        }
        initial.CloseConnection();
    }

    @Override
    public boolean isValidUserInput(){
        if (validUserInput == false) {
            System.out.println("Invalid User input, please try again");
        }
        return validUserInput;
    }

    @Override
    public boolean isValidSSN(){
        return validSSN;
    }

}

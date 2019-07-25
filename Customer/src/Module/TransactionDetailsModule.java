package Module;

import Interfaces.TransactionModule;
import UserfulJava.Initial;
import UserfulJava.SQLQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDetailsModule implements TransactionModule {
    private String sql;
    private String sql2;
    private Statement myStmt;
    private ResultSet myRs;
    private boolean validSSN = false;
    private boolean validUserInput = false;
    Initial initial;

    @Override
    public void MonthYear(String zip, String month, String year, int ssn) throws SQLException{
        initial = new Initial();
        initial.checkSSN(ssn);

        if (initial.isValidSSNString()) {
            myStmt = initial.getMyStmt();
            sql = String.format(SQLQuery.ZipMonthYear, zip, month, year, ssn);
            myRs = myStmt.executeQuery(sql);
            while (myRs.next()) {
                System.out.println("Name:" + myRs.getString("FIRST_NAME") + myRs.getString("LAST_NAME") +
                        "  |  Date: " + month + "-" + myRs.getString("DAY") + "-" + year + "  |  Transaction Amount: " +
                        myRs.getString("TRANSACTION_VALUE") + "  |  Transaction ID: " + myRs.getString("TRANSACTION_ID"));
                validUserInput = true;
            }
            validSSN = initial.isValidSSNString();
        }
        initial.CloseConnection();
    }

    @Override
    public void ByType(String type, int ssn) throws SQLException{
        initial = new Initial();
        initial.checkSSN(ssn);

        if (initial.isValidSSNString()) {
            myStmt = initial.getMyStmt();
            if (type.equals("All")) {
                sql = String.format(SQLQuery.AllType, ssn);
            } else {
                sql = String.format(SQLQuery.ByType, type, ssn);
            }
            myRs = myStmt.executeQuery(sql);
            while (myRs.next()) {
                System.out.println("Full Name: " + myRs.getString("FIRST_NAME") + myRs.getString("LAST_NAME") +
                        "  |  Transaction Type: " + myRs.getString("TRANSACTION_TYPE") + "  |  Total Transaction Value: " +
                        myRs.getString("SUM(TRANSACTION_VALUE)") + "  |  Total Amount of Transaction By Type: " +
                        myRs.getString("COUNT(TRANSACTION_VALUE)"));
                validUserInput = true;
            }
            validSSN = initial.isValidSSNString();
        }
        initial.CloseConnection();
    }

    @Override
    public void BranchState(String state, int ssn) throws SQLException{
        initial = new Initial();
        initial.checkSSN(ssn);

        if (initial.isValidSSNString()) {
            myStmt = initial.getMyStmt();
            sql = String.format(SQLQuery.ByBranchState, state, ssn);
            myRs = myStmt.executeQuery(sql);
            while (myRs.next()) {
                System.out.println("Name:" + myRs.getString("customer.FIRST_NAME") + myRs.getString("customer.LAST_NAME") +
                        "  |  Date: " + myRs.getString("creditcard.MONTH") + "-" + myRs.getString("creditcard.DAY") + "-" + myRs.getString("creditcard.YEAR") + "  |  Transaction Amount: $" +
                        myRs.getString("creditcard.TRANSACTION_VALUE") + "  |  Transaction ID: " + myRs.getString("creditcard.TRANSACTION_ID"));
                validUserInput = true;
            }
            sql2 = String.format(SQLQuery.ByBranchStateTotal, state, ssn);
            myRs = myStmt.executeQuery(sql2);
            while (myRs.next()) {
                System.out.println("There are " + myRs.getString("COUNT(TRANSACTION_ID)") + " transactions in total. Total transaction value is: $" +
                        myRs.getString("SUM(TRANSACTION_VALUE)"));
            }

            validSSN = initial.isValidSSNString();
        }
        initial.CloseConnection();
    }

    @Override
    public boolean isValidUserInput() {
        if (validUserInput == false) {
            System.out.println("Invalid User input, please try again");
        }
        return validUserInput;
    }

    @Override
    public boolean isValidSSN() {
        return validSSN;
    }
}

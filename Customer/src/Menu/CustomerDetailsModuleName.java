
package Menu;

import Module.CustomerDetailsModule;
import UserfulJava.ReadInput;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;

public class CustomerDetailsModuleName {

    private boolean validInput = false;
    private boolean validUserInput = false;
    String ssn;
    String dataType;
    String newData;
    String year, year2;
    String month, month2;
    String date1, date2;
    String day, day2;
    int yearInt, yearInt2, monthInt, monthInt2, dayInt, dayInt2;
    int intSSN;

    public CustomerDetailsModuleName() throws SQLException {

        while (!validInput) {
            System.out.println("***********************************************************");
            System.out.println("**       Welcome to Transaction Detail Module.           **");
            System.out.println("**       Please select one of the following option.      **");
            System.out.println("***********************************************************");
            System.out.println("** 1. Check account details                              **");
            System.out.println("** 2. Modify existing account details                    **");
            System.out.println("** 3. Generate monthly bill for a credit card providing  **");
            System.out.println("**    month and year                                     **");
            System.out.println("** 4. Display transaction day between two date.          **");
            System.out.println("***********************************************************");

            String input = new ReadInput().Input();

            if (input.equals("1")) {
                AccountDetails();
                validInput = true;
            } else if (input.equals("2")) {
                ModifyDetails();
                validInput = true;
            } else if (input.equals("3")) {
                MonthlyBills();
                validInput = true;
            } else if (input.equals("4")) {
                BetweenDate();
                validInput = true;
            } else if (input.toLowerCase().equals("x")) {
                break;
            } else {
                System.out.println("***********************************************************");
                System.out.println("**       Invalid Input. Please try again.                **");
                System.out.println("***********************************************************");
            }
        }
    }

    private void AccountDetails() throws SQLException{
        while(!validInput){
            System.out.println("Enter your SSN");
            ssn = new ReadInput().Input();
            ssn = ssn.toLowerCase();
            if (ssn.equals("x")) {
                break;
            }
            intSSN = Integer.parseInt(ssn);
            CustomerDetailsModule customerDetailsModule = new CustomerDetailsModule();
            customerDetailsModule.AccountDetails(intSSN);
            validInput = customerDetailsModule.isValidSSN();
        }
    }

    private void ModifyDetails() throws  SQLException{
        while(!validUserInput) {
            validUserInput = true;
            System.out.println("Please select the details you like to modify:");
            System.out.println("First/Last name, Credit Card Number, Email, Phone number");
            dataType = new ReadInput().Input();
            dataType = dataType.toLowerCase();
            if (dataType.equals("first name") || dataType.equals("firstname") || dataType.equals("first")) {
                dataType = "FIRST_NAME";
            } else if (dataType.equals("last name") || dataType.equals("lastname") || dataType.equals("last")) {
                dataType = "LAST_NAME";
            } else if (dataType.equals("credit card no") || dataType.equals("creditcard no") || dataType.equals("creditcardno") || dataType.equals("credit cardno") ||
                    dataType.equals("credit card nnumber") || dataType.equals("creditcard number") || dataType.equals("creditcardnumber") || dataType.equals("credit cardnumber") ||
                    dataType.equals("creditcard") || dataType.equals("credit card") || dataType.equals("creditno") || dataType.equals("creditnumber") ||
                    dataType.equals("credit no") || dataType.equals("credit number") || dataType.equals("credit")) {
                dataType = "CREDIT_CARD_NO";
            } else if (dataType.equals("phone no") || dataType.equals("phone number") || dataType.equals("phoneno") || dataType.equals("phonenumber") ||
                    dataType.equals("phone")) {
                dataType = "CUST_PHONE";
            } else if (dataType.equals("email")) {
                dataType = "CUST_EMAIL";
            } else if (dataType.equals("x")) {
                dataType = "x";
            } else {
                System.out.println("Invalid input, please try again");
                validUserInput = false;
            }
        }
        System.out.println("Enter your new info:");
        newData = new ReadInput().Input();

        while(!validInput && !dataType.equals("x")){
            System.out.println("Enter your SSN");
            ssn = new ReadInput().Input();
            ssn = ssn.toLowerCase();
            if (ssn.equals("x")) {
                break;
            }
            intSSN = Integer.parseInt(ssn);
            CustomerDetailsModule customerDetailsModule = new CustomerDetailsModule();
            customerDetailsModule.ModifyDetails(dataType, newData, intSSN);
            validInput = customerDetailsModule.isValidSSN();
        }
    }

    private void MonthlyBills() throws SQLException{
        while(!validInput){

            System.out.println("Please enter a year");
            year = new ReadInput().Input();
            year = year.toLowerCase();
            if (year.equals("x")) {
                break;
            }
            System.out.println("Please enter a month:");
            month = new ReadInput().Input();
            month = month.toLowerCase();
            if (month.equals("x")) {
                break;
            }

            System.out.println("Enter your SSN");
            ssn = new ReadInput().Input();
            ssn = ssn.toLowerCase();
            if (ssn.equals("x")) {
                break;
            }
            intSSN = Integer.parseInt(ssn);
            CustomerDetailsModule customerDetailsModule = new CustomerDetailsModule();
            customerDetailsModule.MonthlyBills(year, month, intSSN);
            validInput = customerDetailsModule.isValidSSN();
        }
    }

    private void BetweenDate() throws SQLException{
        while (!validUserInput) {

            try {
                System.out.println("Please enter first date:");
                System.out.println("Year");
                yearInt = new ReadInput().IntInput();
                year = Integer.toString(yearInt);

                System.out.println("Month");
                monthInt = new ReadInput().IntInput();
                month = Integer.toString(monthInt);

                System.out.println("Day");
                dayInt = new ReadInput().IntInput();
                day = Integer.toString(dayInt);

                date1 = day + "/" + month + "/" + year;

                System.out.println("Please enter second date:");
                System.out.println("Year");
                yearInt2 = new ReadInput().IntInput();
                year2 = Integer.toString(yearInt2);

                System.out.println("Month");
                monthInt2 = new ReadInput().IntInput();
                month2 = Integer.toString(monthInt2);

                System.out.println("Day");
                dayInt2 = new ReadInput().IntInput();
                day2 = Integer.toString(dayInt2);

                date2 = day2 + "/" + month2 + "/" + year2;
                validUserInput = validatingYMD(date1, date2, dayInt, monthInt, yearInt, dayInt2, monthInt2, yearInt2);
            } catch (InputMismatchException exception){
                System.out.println("Date must be integer.");
            }

        }
        while(!validInput){
            System.out.println("Enter your SSN");
            ssn = new ReadInput().Input();
            ssn = ssn.toLowerCase();
            if (ssn.equals("x")) {
                break;
            }
            intSSN = Integer.parseInt(ssn);
            CustomerDetailsModule customerDetailsModule = new CustomerDetailsModule();
            customerDetailsModule.BetweenDate(day, month, year, day2, month2, year2, intSSN);
            validInput = customerDetailsModule.isValidSSN();
        }
    }

    private boolean validatingYMD(String date1, String date2, int d1, int m1, int y1, int d2, int m2, int y2) throws SQLException{
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        try {
            format.parse(date1);
        } catch (ParseException a){
            System.out.println("First date :" + date1 + "is not in valid format. Please try again.");
            return false;
        }
        try {
            format.parse(date2);
        } catch (ParseException a){
            System.out.println("Second date :" + date2 + "is not in valid format. Please try again.");
            return false;
        }
        if ( y1 > y2   || ( y1 == y2  && m1 > m2) || ( y1 == y2 && m1 == m2 && d1 > d2)){
            System.out.println("Second date must be after first date. Please try again");
            return false;
        }
        return true;
    }

}
/*
    private void AccountDetails() throws SQLException {
        boolean validSSN = false, complete = false;
        String ssn;
        String validSSNString = "a";

        while (!complete) {
            System.out.println("Please enter your SSN");
            ssn = new ReadInput().Input();
            ssn = ssn.toLowerCase();
            if (ssn.equals("x")) {
                break;
            }

            Initial initial = new Initial();
            myStmt = initial.getMyStmt();
            while (!validSSN) {
                if (validSSNString.equals("0")) {
                    System.out.println("Please verify your SSN");
                    ssn = new ReadInput().Input();
                    ssn = ssn.toLowerCase();
                    if (ssn.equals("x")) {
                        break;
                    }
                    initial.Reconnect();
                    myStmt = initial.getMyStmt();
                }
                String ssnSQL = "SELECT *, COUNT(SSN) FROM dataengineering.cdw_sapp_customer " +
                        "WHERE SSN = '" + ssn + "';";
                myRs = myStmt.executeQuery(ssnSQL);
                while (myRs.next()) {
                    validSSNString = myRs.getString("COUNT(SSN)");
                }
                if (validSSNString.equals("0") || validSSNString.equals("a")) {
                    System.out.println("No transaction found.");
                    validSSNString = "0";
                    CloseConnection();
                    validSSN = false;
                } else {
                    validSSN = true;

                    System.out.println("#################################################################################");
                    System.out.println("Below is your account details:");
                    String sql = "SELECT *, COUNT(SSN) FROM dataengineering.cdw_sapp_customer " +
                            "WHERE SSN = '" + ssn + "';";

                    myRs = myStmt.executeQuery(sql);
                    while (myRs.next()) {
                        System.out.println("Name:" + myRs.getString("FIRST_NAME") + myRs.getString("LAST_NAME") +
                                "  |  Credit Card No: " + myRs.getString("CREDIT_CARD_NO") + "  |  Email: " +
                                myRs.getString("CUST_EMAIL") + "  |  Phone No: " + myRs.getString("CUST_PHONE"));
                    }

                    complete = true;
                    CloseConnection();
                    break;
                }
            }
        }
    }

    private void ModifyAccount() throws SQLException {
        boolean validSSN = false, complete = false;
        String ssn;
        String modifyingData, newString;
        String name = null;
        String validSSNString = "a";

        modifyingData = ModifyingData();
        if (modifyingData.equals("FIRST_NAME")){
            name = "First Name";
        } else if (modifyingData.equals("LAST_NAME")){
            name = "Last Name";
        } else if (modifyingData.equals("CREDIT_CARD_NO")){
            name = "Credit Card Number";
        } else if (modifyingData.equals("CUST_PHONE")){
            name = "Phone Number";
        } else if (modifyingData.equals("CUST_EMAIL")){
            name = "Email";
        } else if (modifyingData.equals("x")){
            complete = true;
        }

        while (!complete) {
            System.out.println("Please enter your SSN");
            ssn = new ReadInput().Input();
            ssn = ssn.toLowerCase();
            if (ssn.equals("x")) {
                break;
            }

            Initial initial = new Initial();
            myStmt = initial.getMyStmt();
            while (!validSSN) {
                if (validSSNString.equals("0")) {
                    System.out.println("Please verify your SSN");
                    ssn = new ReadInput().Input();
                    ssn = ssn.toLowerCase();
                    if (ssn.equals("x")) {
                        break;
                    }
                    initial.Reconnect();
                    myStmt = initial.getMyStmt();
                }
                String ssnSQL = "SELECT *, COUNT(SSN) FROM dataengineering.cdw_sapp_customer " +
                        "WHERE SSN = '" + ssn + "';";
                myRs = myStmt.executeQuery(ssnSQL);
                while (myRs.next()) {
                    validSSNString = myRs.getString("COUNT(SSN)");
                }
                if (validSSNString.equals("0") || validSSNString.equals("a")) {
                    System.out.println("No transaction found.");
                    validSSNString = "0";
                    CloseConnection();
                    validSSN = false;
                } else {
                    validSSN = true;
                    System.out.println("Please enter yout new value for " + name + ":");
                    newString = new ReadInput().Input();
                    System.out.println("#################################################################################");
                    System.out.println("Below is your account details:");
                    String sql = "SELECT * FROM dataengineering.cdw_sapp_customer " +
                            "WHERE SSN = '" + ssn + "';";

                    myRs = myStmt.executeQuery(sql);
                    while (myRs.next()) {
                        System.out.println("You current " + name + " is: " + myRs.getString(modifyingData));
                    }
                    System.out.println("You new "+ name + " is: " + newString);
                    System.out.println("Please enter Y or Yes to proceed or any other key to cancel");
                    String decision = new ReadInput().Input();
                    decision = decision.toLowerCase();
                    if (decision.equals("y") || decision.equals("yes")) {
                        String updateSQL = "UPDATE dataengineering.cdw_sapp_customer " +
                                "SET " + modifyingData + " = '" + newString +
                                "' WHERE SSN = '" + ssn + "';";
                        myStmt.executeUpdate(updateSQL);
                        myRs = myStmt.executeQuery(sql);
                        while (myRs.next()) {
                            System.out.println("You have succesfully changing your " + name + " to " + myRs.getString(modifyingData));
                        }
                    } else {
                        System.out.println("Process have been canceled.");
                    }
                    complete = true;
                    CloseConnection();
                    break;
                }
            }
        }
    }

    private String ModifyingData() {
        while (true) {
            System.out.println("Please select the details you like to modify:");
            System.out.println("First/Last name, Credit Card Number, Email, Phone number");
            String dataType = new ReadInput().Input();
            dataType = dataType.toLowerCase();
            if (dataType.equals("first name") || dataType.equals("firstname") || dataType.equals("first")) {
                return "FIRST_NAME";
            } else if (dataType.equals("last name") || dataType.equals("lastname") || dataType.equals("last")) {
                return "LAST_NAME";
            } else if (dataType.equals("credit card no") || dataType.equals("creditcard no") || dataType.equals("creditcardno") || dataType.equals("credit cardno") ||
                    dataType.equals("credit card nnumber") || dataType.equals("creditcard number") || dataType.equals("creditcardnumber") || dataType.equals("credit cardnumber") ||
                    dataType.equals("creditcard") || dataType.equals("credit card") || dataType.equals("creditno") || dataType.equals("creditnumber") ||
                    dataType.equals("credit no") || dataType.equals("credit number") || dataType.equals("credit")) {
                return "CREDIT_CARD_NO";
            } else if (dataType.equals("phone no") || dataType.equals("phone number") || dataType.equals("phoneno") || dataType.equals("phonenumber") ||
                    dataType.equals("phone")) {
                return "CUST_PHONE";
            } else if (dataType.equals("email")) {
                return "CUST_EMAIL";
            } else if (dataType.equals("x")) {
                return "x";
            } else {
                System.out.println("Invalid input, please try again");
            }
        }
    }

    private void GenerateMonthlyBills() throws SQLException {
        boolean validSSN = false, complete = false;
        String ssn;
        String month, year;
        String validSSNString = "a";


        while (!complete) {
            System.out.println("Please enter a month:");
            month = new ReadInput().Input();
            month = month.toLowerCase();
            if (month.equals("x")) {
                break;
            }
            System.out.println("Please enter a year");
            year = new ReadInput().Input();
            year = year.toLowerCase();
            if (year.equals("x")) {
                break;
            }

            System.out.println("Please enter your SSN");
            ssn = new ReadInput().Input();
            ssn = ssn.toLowerCase();
            if (ssn.equals("x")) {
                break;
            }

            Initial initial = new Initial();
            myStmt = initial.getMyStmt();
            while (!validSSN) {
                if (validSSNString.equals("0")) {
                    System.out.println("Please verify your SSN");
                    ssn = new ReadInput().Input();
                    ssn = ssn.toLowerCase();
                    if (ssn.equals("x")) {
                        break;
                    }
                    initial.Reconnect();
                    myStmt = initial.getMyStmt();
                }
                String ssnSQL = "SELECT *, COUNT(MONTH) FROM cdw_sapp_creditcard creditcard " +
                        "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
                        "WHERE SSN = '" + ssn + "' AND YEAR = '" + year + "' AND MONTH = '" + month +
                        "' ORDER BY   MONTH DESC, DAY DESC;";
                myRs = myStmt.executeQuery(ssnSQL);
                while (myRs.next()) {
                    validSSNString = myRs.getString("COUNT(MONTH)");
                }
                if (validSSNString.equals("0") || validSSNString.equals("a")) {
                    System.out.println("No transaction found.");
                    validSSNString = "0";
                    CloseConnection();
                    validSSN = false;
                } else {
                    validSSN = true;
                    System.out.println("Below is list of transaction for " + month + "/" + year +":");
                    System.out.println("#################################################################################");
                    String sql =  "SELECT * FROM cdw_sapp_creditcard creditcard " +
                            "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
                            "WHERE SSN = '" + ssn + "' AND YEAR = '" + year + "' AND MONTH = '" + month +
                            "' ORDER BY   MONTH DESC, DAY DESC;";
                    myRs = myStmt.executeQuery(sql);
                    while (myRs.next()) {
                        System.out.println("Name:" + myRs.getString("FIRST_NAME") + myRs.getString("LAST_NAME") +
                                "  |  Date: " + month + "-" + myRs.getString("DAY") + "-" + year + "  |  Transaction Amount: " +
                                myRs.getString("TRANSACTION_VALUE") + "  |  Transaction ID: " + myRs.getString("TRANSACTION_ID"));
                    }
                    complete = true;
                    CloseConnection();
                    break;
                }
            }
        }
    }

    private void TransactionBetweenDate() throws SQLException{
        boolean validSSN = false, complete = false, validDate = true;
        String ssn;
        String name = null;
        String validSSNString = "1", validSSNString2 = "0";



        while (!complete) {
            System.out.println("Please enter first date:");
            System.out.println("Year");
            year1 = new ReadInput().Input();
            year1 = year1.toLowerCase();
            if (year1.equals("x")) {
                break;
            }
            System.out.println("Month");
            month1 = new ReadInput().Input();
            month1 = month1.toLowerCase();
            if (month1.equals("x")) {
                break;
            }
            System.out.println("Day");
            day1 = new ReadInput().Input();
            day1 = day1.toLowerCase();
            if (day1.equals("x")) {
                break;
            }
            date1 = day1 +"/" + month1 + "/" + year1;

            System.out.println("Please enter second date:");
            System.out.println("Year");
            year2 = new ReadInput().Input();
            year2 = year2.toLowerCase();
            if (year2.equals("x")) {
                break;
            }
            System.out.println("Month");
            month2 = new ReadInput().Input();
            month2 = month2.toLowerCase();
            if (month2.equals("x")) {
                break;
            }
            System.out.println("Day");
            day2 = new ReadInput().Input();
            day2 = day2.toLowerCase();
            if (day2.equals("x")) {
                break;
            }
            date2 = day2 +"/" + month2 + "/" + year2;


            validDate = validatingYMD();
            if (validDate == true) {


                System.out.println("Please enter your SSN");
                ssn = new ReadInput().Input();
                ssn = ssn.toLowerCase();
                if (ssn.equals("x")) {
                    break;
                }

                Initial initial = new Initial();
                myStmt = initial.getMyStmt();
                while (!validSSN) {
                    if (validSSNString.equals("0")) {
                        System.out.println("Please verify your SSN");
                        ssn = new ReadInput().Input();
                        ssn = ssn.toLowerCase();
                        if (ssn.equals("x")) {
                            break;
                        }
                        initial.Reconnect();
                        myStmt = initial.getMyStmt();
                    }
                    validSSNString = "0";

                    if (year1.equals(year2)) {
                        if (month1.equals(month2)) {
                            String ssnSQL = "SELECT *, COUNT(CUST_SSN) FROM cdw_sapp_creditcard creditcard " +
                                    "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
                                    "WHERE SSN = '" + ssn + "' AND YEAR = '" + year1 + "' AND MONTH = '" + month1 + "' AND DAY > '" + day1 + "' AND DAY < '" + day2 +
                                    "' ORDER BY MONTH DESC, DAY DESC;";

                            myRs = myStmt.executeQuery(ssnSQL);
                            while (myRs.next()) {
                                validSSNString = myRs.getString("COUNT(CUST_SSN)");
                            }
                        } else { //same year but not month
                            String ssnSQL = "SELECT *, COUNT(CUST_SSN) FROM cdw_sapp_creditcard creditcard " +
                                    "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
                                    "WHERE SSN = '" + ssn + "' AND YEAR = '" + year1 + "' AND MONTH = '" + month1 + "' AND DAY > '" + day1 +
                                    "' ORDER BY MONTH DESC, DAY DESC;";
                            myRs = myStmt.executeQuery(ssnSQL);
                            while (myRs.next()) {
                                validSSNString = myRs.getString("COUNT(CUST_SSN)");
                            }

                            String ssnSQL2 = "SELECT *, COUNT(CUST_SSN) FROM cdw_sapp_creditcard creditcard " +
                                    "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
                                    "WHERE SSN = '" + ssn + "' AND YEAR = '" + year1 + "' AND MONTH > '" + month1 + "' AND MONTH < '" + month2 +
                                    "' ORDER BY MONTH DESC, DAY DESC;";
                            myRs = myStmt.executeQuery(ssnSQL2);
                            while (myRs.next()) {
                                validSSNString2 = myRs.getString("COUNT(CUST_SSN)");
                            }
                            if (!validSSNString.equals("0") || validSSNString2.equals("0")) {
                                validSSNString = "1";
                            }

                            String ssnSQL3 = "SELECT *, COUNT(CUST_SSN) FROM cdw_sapp_creditcard creditcard " +
                                    "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
                                    "WHERE SSN = '" + ssn + "' AND YEAR = '" + year1 + "' AND MONTH = '" + month2 + "' AND DAY < '" + day2 +
                                    "' ORDER BY MONTH DESC, DAY DESC;";
                            myRs = myStmt.executeQuery(ssnSQL3);
                            while (myRs.next()) {
                                validSSNString2 = myRs.getString("COUNT(CUST_SSN)");
                            }
                            if (!validSSNString.equals("0") || validSSNString2.equals("0")) {
                                validSSNString = "1";
                            }
                        }
                    } else {
                        String ssnSQL = "SELECT *, COUNT(CUST_SSN) FROM cdw_sapp_creditcard creditcard " +
                                "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
                                "WHERE SSN = '" + ssn + "' AND YEAR = '" + year1 + "' AND MONTH = '" + month1 + "' AND DAY > '" + day1 +
                                "' ORDER BY MONTH DESC, DAY DESC;";
                        myRs = myStmt.executeQuery(ssnSQL);
                        while (myRs.next()) {
                            validSSNString = myRs.getString("COUNT(CUST_SSN)");
                        }

                        String ssnSQL2 = "SELECT *, COUNT(CUST_SSN) FROM cdw_sapp_creditcard creditcard " +
                                "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
                                "WHERE SSN = '" + ssn + "' AND YEAR = '" + year1 + "' AND MONTH > '" + month1 +
                                "' ORDER BY MONTH DESC, DAY DESC;";
                        myRs = myStmt.executeQuery(ssnSQL2);
                        while (myRs.next()) {
                            validSSNString2 = myRs.getString("COUNT(CUST_SSN)");
                        }
                        if (!validSSNString.equals("0") || validSSNString2.equals("0")) {
                            validSSNString = "1";
                        }

                        String ssnSQL3 = "SELECT *, COUNT(CUST_SSN) FROM cdw_sapp_creditcard creditcard " +
                                "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
                                "WHERE SSN = '" + ssn + "' AND YEAR > '" + year1 + "' AND YEAR < '" + year2 +
                                "' ORDER BY MONTH DESC, DAY DESC;";
                        myRs = myStmt.executeQuery(ssnSQL3);
                        while (myRs.next()) {
                            validSSNString2 = myRs.getString("COUNT(CUST_SSN)");
                        }
                        if (!validSSNString.equals("0") || validSSNString2.equals("0")) {
                            validSSNString = "1";
                        }

                        String ssnSQL4 = "SELECT *, COUNT(CUST_SSN) FROM cdw_sapp_creditcard creditcard " +
                                "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
                                "WHERE SSN = '" + ssn + "' AND YEAR = '" + year2 + "' AND MONTH < '" + month2 +
                                "' ORDER BY MONTH DESC, DAY DESC;";
                        myRs = myStmt.executeQuery(ssnSQL4);
                        while (myRs.next()) {
                            validSSNString2 = myRs.getString("COUNT(CUST_SSN)");
                        }
                        if (!validSSNString.equals("0") || validSSNString2.equals("0")) {
                            validSSNString = "1";
                        }

                        String ssnSQL5 = "SELECT *, COUNT(CUST_SSN) FROM cdw_sapp_creditcard creditcard " +
                                "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
                                "WHERE SSN = '" + ssn + "' AND YEAR = '" + year2 + "' AND MONTH = '" + month2 + "' AND DAY < '" + day2 +
                                "' ORDER BY MONTH DESC, DAY DESC;";
                        myRs = myStmt.executeQuery(ssnSQL5);
                        while (myRs.next()) {
                            validSSNString2 = myRs.getString("COUNT(CUST_SSN)");
                        }
                        if (!validSSNString.equals("0") || validSSNString2.equals("0")) {
                            validSSNString = "1";
                        }
                    }

                    if (validSSNString.equals("0")) {
                        System.out.println("No transaction found.");
                        CloseConnection();
                        validSSN = false;
                    } else {
                        validSSN = true;
                        System.out.println("Below is all your transaction between your " + date1 + " and " + date2 + ":");
                        System.out.println("#################################################################################");
                        if (!month1.equals(month2)) {
                            if (!year1.equals(year2)) {
                                //before end of day
                                String ssnSQL5 = "SELECT * FROM cdw_sapp_creditcard creditcard " +
                                        "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
                                        "WHERE SSN = '" + ssn + "' AND YEAR = '" + year2 + "' AND MONTH = '" + month2 + "' AND DAY < '" + day2 +
                                        "' ORDER BY MONTH DESC, DAY DESC;";
                                myRs = myStmt.executeQuery(ssnSQL5);
                                while (myRs.next()) {
                                    System.out.println("Date:" + myRs.getString("MONTH") + "/" + myRs.getString("DAY") + "/" + myRs.getString("YEAR") +
                                            "  |  Full Name: " + myRs.getString("FIRST_NAME") + myRs.getString("LAST_NAME") + "  |  Transaction Amount: " +
                                            myRs.getString("TRANSACTION_VALUE") + "  |  Transaction ID: " + myRs.getString("TRANSACTION_ID"));
                                }

                                //Before end of the month
                                String ssnSQL4 = "SELECT * FROM cdw_sapp_creditcard creditcard " +
                                        "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
                                        "WHERE SSN = '" + ssn + "' AND YEAR = '" + year2 + "' AND MONTH < '" + month2 +
                                        "' ORDER BY MONTH DESC, DAY DESC;";
                                myRs = myStmt.executeQuery(ssnSQL4);
                                while (myRs.next()) {
                                    System.out.println("Date:" + myRs.getString("MONTH") + "/" + myRs.getString("DAY") + "/" + myRs.getString("YEAR") +
                                            "  |  Full Name: " + myRs.getString("FIRST_NAME") + myRs.getString("LAST_NAME") + "  |  Transaction Amount: " +
                                            myRs.getString("TRANSACTION_VALUE") + "  |  Transaction ID: " + myRs.getString("TRANSACTION_ID"));
                                }

                                //Between the year
                                String ssnSQL3 = "SELECT * FROM cdw_sapp_creditcard creditcard " +
                                        "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
                                        "WHERE SSN = '" + ssn + "' AND YEAR > '" + year1 + "' AND YEAR < '" + year2 +
                                        "' ORDER BY MONTH DESC, DAY DESC;";
                                myRs = myStmt.executeQuery(ssnSQL3);
                                while (myRs.next()) {
                                    System.out.println("Date:" + myRs.getString("MONTH") + "/" + myRs.getString("DAY") + "/" + myRs.getString("YEAR") +
                                            "  |  Full Name: " + myRs.getString("FIRST_NAME") + myRs.getString("LAST_NAME") + "  |  Transaction Amount: " +
                                            myRs.getString("TRANSACTION_VALUE") + "  |  Transaction ID: " + myRs.getString("TRANSACTION_ID"));
                                }
                                //Rest of this year
                                String ssnSQL2 = "SELECT * FROM cdw_sapp_creditcard creditcard " +
                                        "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
                                        "WHERE SSN = '" + ssn + "' AND YEAR = '" + year1 + "' AND MONTH > '" + month1 +
                                        "' ORDER BY MONTH DESC, DAY DESC;";
                                myRs = myStmt.executeQuery(ssnSQL2);
                                while (myRs.next()) {
                                    System.out.println("Date:" + myRs.getString("MONTH") + "/" + myRs.getString("DAY") + "/" + myRs.getString("YEAR") +
                                            "  |  Full Name: " + myRs.getString("FIRST_NAME") + myRs.getString("LAST_NAME") + "  |  Transaction Amount: " +
                                            myRs.getString("TRANSACTION_VALUE") + "  |  Transaction ID: " + myRs.getString("TRANSACTION_ID"));
                                }

                                //Rest of this month
                                String ssnSQL = "SELECT * FROM cdw_sapp_creditcard creditcard " +
                                        "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
                                        "WHERE SSN = '" + ssn + "' AND YEAR = '" + year1 + "' AND MONTH = '" + month1 + "' AND DAY > '" + day1 +
                                        "' ORDER BY MONTH DESC, DAY DESC;";
                                myRs = myStmt.executeQuery(ssnSQL);
                                while (myRs.next()) {
                                    System.out.println("Date:" + myRs.getString("MONTH") + "/" + myRs.getString("DAY") + "/" + myRs.getString("YEAR") +
                                            "  |  Full Name: " + myRs.getString("FIRST_NAME") + myRs.getString("LAST_NAME") + "  |  Transaction Amount: " +
                                            myRs.getString("TRANSACTION_VALUE") + "  |  Transaction ID: " + myRs.getString("TRANSACTION_ID"));
                                }
                            } else {
                                String ssnSQL3 = "SELECT * FROM cdw_sapp_creditcard creditcard " +
                                        "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
                                        "WHERE SSN = '" + ssn + "' AND YEAR = '" + year1 + "' AND MONTH = '" + month2 + "' AND DAY < '" + day2 +
                                        "' ORDER BY MONTH DESC, DAY DESC;";
                                myRs = myStmt.executeQuery(ssnSQL3);
                                while (myRs.next()) {
                                    System.out.println("Date:" + myRs.getString("MONTH") + "/" + myRs.getString("DAY") + "/" + myRs.getString("YEAR") +
                                            "  |  Full Name: " + myRs.getString("FIRST_NAME") + myRs.getString("LAST_NAME") + "  |  Transaction Amount: " +
                                            myRs.getString("TRANSACTION_VALUE") + "  |  Transaction ID: " + myRs.getString("TRANSACTION_ID"));
                                }
                                String ssnSQL2 = "SELECT * FROM cdw_sapp_creditcard creditcard " +
                                        "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
                                        "WHERE SSN = '" + ssn + "' AND YEAR = '" + year1 + "' AND MONTH > '" + month1 + "' AND MONTH < '" + month2 +
                                        "' ORDER BY MONTH DESC, DAY DESC;";

                                myRs = myStmt.executeQuery(ssnSQL2);
                                while (myRs.next()) {
                                    System.out.println("Date:" + myRs.getString("MONTH") + "/" + myRs.getString("DAY") + "/" + myRs.getString("YEAR") +
                                            "  |  Full Name: " + myRs.getString("FIRST_NAME") + myRs.getString("LAST_NAME") + "  |  Transaction Amount: " +
                                            myRs.getString("TRANSACTION_VALUE") + "  |  Transaction ID: " + myRs.getString("TRANSACTION_ID"));
                                }
                                String ssnSQL = "SELECT * FROM cdw_sapp_creditcard creditcard " +
                                        "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
                                        "WHERE SSN = '" + ssn + "' AND YEAR = '" + year1 + "' AND MONTH = '" + month1 + "' AND DAY > '" + day1 +
                                        "' ORDER BY MONTH DESC, DAY DESC;";
                                myRs = myStmt.executeQuery(ssnSQL);
                                while (myRs.next()) {
                                    System.out.println("Date:" + myRs.getString("MONTH") + "/" + myRs.getString("DAY") + "/" + myRs.getString("YEAR") +
                                            "  |  Full Name: " + myRs.getString("FIRST_NAME") + myRs.getString("LAST_NAME") + "  |  Transaction Amount: " +
                                            myRs.getString("TRANSACTION_VALUE") + "  |  Transaction ID: " + myRs.getString("TRANSACTION_ID"));
                                }
                            }
                        } else {
                            String ssnSQL = "SELECT * FROM cdw_sapp_creditcard creditcard " +
                                    "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
                                    "WHERE SSN = '" + ssn + "' AND YEAR = '" + year1 + "' AND MONTH = '" + month1 + "' AND DAY > '" + day1 + "' AND DAY < '" + day2 +
                                    "' ORDER BY MONTH DESC, DAY DESC;";

                            myRs = myStmt.executeQuery(ssnSQL);
                            while (myRs.next()) {
                                System.out.println("Date:" + myRs.getString("MONTH") + "/" + myRs.getString("DAY") + "/" + myRs.getString("YEAR") +
                                        "  |  Full Name: " + myRs.getString("FIRST_NAME") + myRs.getString("LAST_NAME") + "  |  Transaction Amount: " +
                                        myRs.getString("TRANSACTION_VALUE") + "  |  Transaction ID: " + myRs.getString("TRANSACTION_ID"));
                            }
                        }

                        complete = true;
                        CloseConnection();
                        break;
                    }
                }
            }
        }
    }

    private boolean validatingYMD() throws SQLException{
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        try {
            format.parse(date1);
        } catch (ParseException a){
            System.out.println("First date :" + date1 + "is not in valid format. Please try again.");
            return false;
        }
        try {
            format.parse(date2);
        } catch (ParseException a){
            System.out.println("Second date :" + date2 + "is not in valid format. Please try again.");
            return false;
        }
        if (year1.compareTo(year2) > 0 || (year1.compareTo(year2) <= 0 && (month1.compareTo(month2) > 0 || (month1.compareTo(month2) == 0 && day1.compareTo(day2) > 0 )))){
                System.out.println("Second date must be after first date. Please try again");
                return false;
        }
        return true;
    }

    private void CloseConnection() throws SQLException{
        myStmt.close();
        System.out.println("Connection is now closed!");
    }

}
*/

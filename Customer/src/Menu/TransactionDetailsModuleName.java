
package Menu;//This class stored the method to display transaction base on one of the following three filters:
//1. Display transaction made by customer living in a given "Zipcode", given "month", and given "year". Order by Day in descending order.
//2. Display the number and total values of transaction for given "Type".
//3. Display the number of total values of transaction for branches in given "state".

import Module.TransactionDetailsModule;
import UserfulJava.ReadInput;

import java.sql.SQLException;

public class TransactionDetailsModuleName {
    String zip;
    String year;
    String month;
    String ssn;
    String transactionType;
    String state;
    String type;
    int intSSN;
    boolean validInput = false;
    boolean validSSN = false;

    public TransactionDetailsModuleName() throws SQLException {

        while (!validInput) {
            System.out.println("***********************************************************");
            System.out.println("**       Welcome to Transaction Detail Module.           **");
            System.out.println("**       Please select one of the following option.      **");
            System.out.println("***********************************************************");
            System.out.println("** 1. Display All Transaction base on Zip, Month & Year  **");
            System.out.println("** 2. Display the number and total values of transaction **");
            System.out.println("**    for a given type.                                  **");
            System.out.println("** 3. Display the number and total values of transaction **");
            System.out.println("**    for branches in a given state                      **");
            System.out.println("***********************************************************");

            String input = new ReadInput().Input();

            if (input.equals("1")) {
                ZipMonthYear();
                validInput = true;
            } else if (input.equals("2")) {
                TotalBasedOnType();
                validInput = true;
            } else if (input.equals("3")) {
                BranchByState();
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

    private void ZipMonthYear() throws SQLException {
        while(!validInput){
            System.out.println("Enter a zip code:");
            zip = new ReadInput().Input();
            zip = zip.toLowerCase();
            if (zip.equals("x")){
                break;
            }
            System.out.println("Enter a year:");
            year = new ReadInput().Input();
            year = year.toLowerCase();
            if (year.equals("x")){
                break;
            }
            System.out.println("Enter a month:");
            month = new ReadInput().Input();
            month = month.toLowerCase();
            if (month.equals("x")){
                break;
            }
            System.out.println("Please verify your SSN");
            ssn = new ReadInput().Input();
            ssn = ssn.toLowerCase();
            if (ssn.equals("x")) {
                break;
            }
            intSSN = Integer.parseInt(ssn);
            TransactionDetailsModule transactionDetailsModule = new TransactionDetailsModule();
            transactionDetailsModule.MonthYear(zip, month, year, intSSN);
            if (transactionDetailsModule.isValidSSN() && transactionDetailsModule.isValidUserInput()) {
                validInput = true;
            }
        }
    }

    private void TotalBasedOnType() throws SQLException{
        while (!validInput) {
            System.out.println("Select one of the following type: Gas, Bills, Healthcare, Grocery, Test, Entertainment, Education or All)");
            type = new ReadInput().Input();
            type = type.toLowerCase();
            if (type.equals("gas")) {
                transactionType = "Gas";
                validInput = true;
            } else if (type.equals("bills")) {
                transactionType = "Bills";
                validInput = true;
            } else if (type.equals("healthcare")) {
                transactionType = "Healthcare";
                validInput = true;
            } else if (type.equals("grocery")) {
                transactionType = "Grocery";
                validInput = true;
            } else if (type.equals("test")) {
                transactionType = "Test";
                validInput = true;
            } else if (type.equals("entertainment")) {
                transactionType = "Entertainment";
                validInput = true;
            } else if (type.equals("education")) {
                transactionType = "Education";
                validInput = true;
            } else if (type.equals("all")) {
                transactionType = "All";
                validInput = true;
            } else if (type.equals("x")) {
                break;
            } else {
                System.out.println("Invalid input, please try again.");
                validInput = false;
            }
        }
        while(!validSSN && !type.equals("x")){
            System.out.println("Please verify your SSN");
            ssn = new ReadInput().Input();
            ssn = ssn.toLowerCase();
            if (ssn.equals("x")) {
                break;
            }
            intSSN = Integer.parseInt(ssn);
            TransactionDetailsModule transactionDetailsModule = new TransactionDetailsModule();
            transactionDetailsModule.ByType(transactionType, intSSN);
            if (transactionDetailsModule.isValidSSN() && transactionDetailsModule.isValidUserInput()) {
                validSSN = true;
            }
        }
    }

    private void BranchByState() throws SQLException {
        System.out.println("Please enter a State:");
        while (!validInput) {

            state = new ReadInput().Input();
            state = state.toLowerCase();
            state = CheckState(state);
            if (state.equals("x")) {
                break;
            } else if (state.equals("0")) {
                validInput = false;
                System.out.println("Invalid State, please enter your state");
            } else {
                validInput = true;
            }
        }
        while(!validSSN && !state.equals("x")){
            System.out.println("Please verify your SSN");
            ssn = new ReadInput().Input();
            ssn = ssn.toLowerCase();
            if (ssn.equals("x")) {
                break;
            }
            try {
                intSSN = Integer.parseInt(ssn);
                TransactionDetailsModule transactionDetailsModule = new TransactionDetailsModule();
                transactionDetailsModule.BranchState(state, intSSN);
                if (transactionDetailsModule.isValidSSN() && transactionDetailsModule.isValidUserInput()) {
                    validSSN = true;
                }
            } catch(NumberFormatException exception) {
                System.out.println("Invalid format, expecting numerical input. Try again:");
                validSSN = false;
            }
        }
    }

    private String CheckState(String state) {
        if (state.equals("alabama") || state.equals("al")) {
            return "AL";
        } else if (state.equals("alaska") || state.equals("ak")) {
            return "AK";
        } else if (state.equals("arizona") || state.equals("az")) {
            return "AZ";
        } else if (state.equals("arkansas") || state.equals("ar")) {
            return "AR";
        } else if (state.equals("california") || state.equals("ca")) {
            return "CA";
        } else if (state.equals("colorado") || state.equals("co")) {
            return "CO";
        } else if (state.equals("connecticut") || state.equals("ct")) {
            return "CT";
        } else if (state.equals("delaware") || state.equals("de")) {
            return "DE";
        } else if (state.equals("florida") || state.equals("fl")) {
            return "FL";
        } else if (state.equals("georgia") || state.equals("ga")) {
            return "GA";
        } else if (state.equals("hawaii") || state.equals("hi")) {
            return "HI";
        } else if (state.equals("idaho") || state.equals("id")) {
            return "ID";
        } else if (state.equals("illinois") || state.equals("il")) {
            return "IL";
        } else if (state.equals("indiana") || state.equals("in")) {
            return "IN";
        } else if (state.equals("iowa") || state.equals("ia")) {
            return "IA";
        } else if (state.equals("kansas") || state.equals("ks")) {
            return "KS";
        } else if (state.equals("louisiana") || state.equals("la")) {
            return "LA";
        } else if (state.equals("maine") || state.equals("me")) {
            return "ME";
        } else if (state.equals("maryland") || state.equals("md")) {
            return "MD";
        } else if (state.equals("massachusetts") || state.equals("ma")) {
            return "MA";
        } else if (state.equals("michigan") || state.equals("mi")) {
            return "MI";
        } else if (state.equals("minnesota") || state.equals("mn")) {
            return "MN";
        } else if (state.equals("mississippi") || state.equals("ms")) {
            return "MS";
        } else if (state.equals("missouri") || state.equals("mo")) {
            return "MO";
        } else if (state.equals("montana") || state.equals("mt")) {
            return "MT";
        } else if (state.equals("nebraska") || state.equals("ne")) {
            return "NE";
        } else if (state.equals("nevada") || state.equals("nv")) {
            return "NV";
        } else if (state.equals("new hampshire") || state.equals("newhamsphire") || state.equals("nh")) {
            return "NH";
        } else if (state.equals("new jersey") || state.equals("newjersey") || state.equals("nj")) {
            return "NJ";
        } else if (state.equals("new mexico") || state.equals("newmexico") || state.equals("nm")) {
            return "NM";
        } else if (state.equals("new york") || state.equals("newyork") || state.equals("ny")) {
            return "NY";
        } else if (state.equals("north carolina") || state.equals("northcarolina") || state.equals("nc")) {
            return "NC";
        } else if (state.equals("north dakota") || state.equals("northdakota") || state.equals("nd")) {
            return "ND";
        } else if (state.equals("ohio") || state.equals("oh")) {
            return "OH";
        } else if (state.equals("oklahoma") || state.equals("ok")) {
            return "OK";
        } else if (state.equals("oregon") || state.equals("or")) {
            return "OR";
        } else if (state.equals("pennsylvania") || state.equals("pa")) {
            return "PA";
        } else if (state.equals("rhode island") || state.equals("rhodeisland") || state.equals("ri")) {
            return "RI";
        } else if (state.equals("south carolina") || state.equals("southcarolina") || state.equals("sc")) {
            return "SC";
        } else if (state.equals("south dakota") || state.equals("southdakota") || state.equals("sd")) {
            return "SD";
        } else if (state.equals("tennessee") || state.equals("tn")) {
            return "TN";
        } else if (state.equals("texas") || state.equals("tx")) {
            return "TX";
        } else if (state.equals("utah") || state.equals("ut")) {
            return "UT";
        } else if (state.equals("vermont") || state.equals("vt")) {
            return "VT";
        } else if (state.equals("virginia") || state.equals("va")) {
            return "VA";
        } else if (state.equals("washington") || state.equals("wa")) {
            return "WA";
        } else if (state.equals("west virginia") || state.equals("westvirginia") || state.equals("wv")) {
            return "WV";
        } else if (state.equals("wisconsin") || state.equals("wi")) {
            return "WI";
        } else if (state.equals("wyoming") || state.equals("wy")) {
            return "WY";
        } else if (state.equals("x")) {
            return "x";
        } else {
            return "0";
        }


    /*public boolean inRange(String lowerBound, String upperBound, String input) {
        return input.compareToIgnoreCase(lowerBound) >= 0 && input.compareToIgnoreCase(upperBound) <= 0
    }*/
    }
}
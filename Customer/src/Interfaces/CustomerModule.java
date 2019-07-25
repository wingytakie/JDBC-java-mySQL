package Interfaces;

import java.sql.SQLException;

public interface CustomerModule {

    public void AccountDetails(int ssn) throws SQLException;
    public void ModifyDetails(String type, String newInput, int ssn) throws SQLException;
    public void MonthlyBills(String year, String month, int ssn) throws SQLException;
    public void BetweenDate(String day, String month, String year, String day2, String month2, String year2, int ssn) throws SQLException;

    public boolean isValidUserInput();
    public boolean isValidSSN();
}

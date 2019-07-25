package Interfaces;

import java.sql.SQLException;

public interface TransactionModule {


    public void MonthYear(String zip, String month, String year, int ssn) throws SQLException;
    public void ByType(String type, int ssn) throws SQLException;
    public void BranchState(String state, int ssn) throws SQLException;

    public boolean isValidUserInput();
    public boolean isValidSSN();

}

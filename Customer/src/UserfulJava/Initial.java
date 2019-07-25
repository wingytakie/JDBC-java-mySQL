package UserfulJava;

import java.sql.*;

public class Initial {

    private Connection myConn;
    private Statement myStmt;
    private ResultSet myRs;
    private String sql;
    boolean validSSNString= false;

    public Initial() throws SQLException {
        System.out.println("Please wait while we attempt to make connection to the database >>>>>>>");
        myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dataengineering?useSSL=false", "wing", "1126") ;
        myStmt = myConn.createStatement();
        System.out.println("You have successfully connect to the database!");
    }

    public Statement getMyStmt() {
        return myStmt;
    }

    public void CloseConnection() throws SQLException{
        myStmt.close();
        System.out.println("Connection is now closed!");
    }

    public void checkSSN(int ssn) throws SQLException{
        myRs = myStmt.executeQuery(String.format(SQLQuery.ssnValidation,ssn));
        while (myRs.next()) {
            validSSNString = true;
        }
        if (validSSNString == false){
            System.out.println("Invalid SSN. Please try again.");
        }
    }

    public boolean isValidSSNString() {
        return validSSNString;
    }
}


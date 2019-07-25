# JDBC-java-mySQL

This project mimic an transaction system, including two main module.

Transaction - Retrieving transaction information for a specific customer.

Customer - Retrieving customer personal information.


File Structure:
-src
 -Interfaces  //Interfaces for the module
 -Menu  //Contain Menu for the main 3 menus and userinput algorithm
  -JDBCTest.java  //Mainmenu for the project.
  -CustomerDetailsModuleName.java  //Main Menu after you select Customer Menu.
  -TransactionDetailsModuleName.java  //Main Menu after you select Transaction Menu.
 -Module  //Contain all the algorithm for each module
 -UserfulJava
  -Initial.java  //Initiation for connection/disconnection to database and method to check valid SSN
  -ReadyInput.java  //Using this as a method for input to shorten code.
  -SQLQuery.java  //Store all the SQL query/update within this file as String.
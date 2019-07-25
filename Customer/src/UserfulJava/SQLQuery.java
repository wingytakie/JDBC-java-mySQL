package UserfulJava;

public class SQLQuery {

    public static final String ssnValidation = "SELECT * FROM cdw_sapp_creditcard creditcard " +
                "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
                "LEFT JOIN cdw_sapp_branch branch ON creditcard.BRANCH_CODE = branch.BRANCH_CODE WHERE SSN = %d;";

    public static final String ZipMonthYear = "SELECT * FROM cdw_sapp_creditcard creditcard " +
                "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
                "LEFT JOIN cdw_sapp_branch branch ON creditcard.BRANCH_CODE = branch.BRANCH_CODE " +
                "WHERE CUST_ZIP = '%s' AND MONTH = '%s' AND YEAR = '%s' AND CUST_SSN = %d ORDER BY YEAR DESC, MONTH DESC, DAY DESC;";

    public static final String ByType = "SELECT * , SUM(TRANSACTION_VALUE), COUNT(TRANSACTION_VALUE) FROM cdw_sapp_creditcard creditcard " +
                "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
                "WHERE TRANSACTION_TYPE = '%s' AND CUST_SSN = '%d' GROUP BY TRANSACTION_TYPE ORDER BY YEAR DESC, MONTH DESC, DAY DESC;";

    public static final String AllType = "SELECT * , SUM(TRANSACTION_VALUE), COUNT(TRANSACTION_VALUE) FROM cdw_sapp_creditcard creditcard " +
                "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
                "WHERE CUST_SSN = %d GROUP BY TRANSACTION_TYPE ORDER BY YEAR DESC, MONTH DESC, DAY DESC;";

    public static final String ByBranchState = "SELECT * FROM cdw_sapp_creditcard creditcard " +
                "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
                "LEFT JOIN cdw_sapp_branch branch ON creditcard.BRANCH_CODE = branch.BRANCH_CODE " +
                "WHERE branch.BRANCH_STATE = '%s' AND customer.SSN = %d;";

    public static final String ByBranchStateTotal = "SELECT COUNT(TRANSACTION_ID), SUM(TRANSACTION_VALUE) FROM cdw_sapp_creditcard creditcard " +
                "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
                "LEFT JOIN cdw_sapp_branch branch ON creditcard.BRANCH_CODE = branch.BRANCH_CODE " +
                "WHERE BRANCH_STATE = '%s' AND SSN = %d;";

    public static final String AccountDetails = "SELECT *, COUNT(SSN) FROM dataengineering.cdw_sapp_customer " +
            "WHERE SSN = %d;";

    public static final String ModifyDetails = "UPDATE dataengineering.cdw_sapp_customer SET %s = '%s' WHERE SSN = %d;";

    public static final String MonthlyBills =  "SELECT * FROM cdw_sapp_creditcard creditcard " +
            "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
            "WHERE YEAR = '%s' AND MONTH = '%s' AND SSN = %d " +
            "ORDER BY MONTH DESC, DAY DESC;";

    public static final String DateSameYearMonth = "SELECT * FROM cdw_sapp_creditcard creditcard " +
            "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
            "WHERE SSN = %d AND YEAR = '%s' AND MONTH = '%s' AND DAY > '%s' AND DAY < '%s' ORDER BY MONTH DESC, DAY DESC;";

    public static final String DateSameYearNotMonth = "SELECT * FROM cdw_sapp_creditcard creditcard " +
            "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
            "WHERE SSN = %d AND YEAR = '%s' AND MONTH = '%s' AND DAY > '%s' ORDER BY MONTH DESC, DAY DESC;";

    public static final String DateSameYearNotMonth2 = "SELECT * FROM cdw_sapp_creditcard creditcard " +
            "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
            "WHERE SSN = %d AND YEAR = '%s' AND MONTH > '%s' AND MONTH < '%s' ORDER BY MONTH DESC, DAY DESC;";

    public static final String DateSameYearNotMonth3 = "SELECT * FROM cdw_sapp_creditcard creditcard " +
            "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
            "WHERE SSN = %d AND YEAR = '%s' AND MONTH = '%s' AND DAY < '%s' ORDER BY MONTH DESC, DAY DESC;";

    public static final String DateAllDiff = "SELECT * FROM cdw_sapp_creditcard creditcard " +
            "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
            "WHERE SSN = %d AND YEAR = '%s' AND MONTH = '%s' AND DAY > '%s' ORDER BY MONTH DESC, DAY DESC;";

    public static final String DateAllDiff2 = "SELECT * FROM cdw_sapp_creditcard creditcard " +
            "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
            "WHERE SSN = %d AND YEAR = '%s' AND MONTH > '%s' ORDER BY MONTH DESC, DAY DESC;";

    public static final String DateAllDiff3 = "SELECT * FROM cdw_sapp_creditcard creditcard " +
            "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
            "WHERE SSN = %d AND YEAR > '%s' AND YEAR < '%s' ORDER BY MONTH DESC, DAY DESC;";

    public static final String DateAllDiff4 = "SELECT * FROM cdw_sapp_creditcard creditcard " +
            "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
            "WHERE SSN = %d AND YEAR = '%s' AND MONTH < '%s' ORDER BY MONTH DESC, DAY DESC;";

    public static final String DateAllDiff5 = "SELECT * FROM cdw_sapp_creditcard creditcard " +
            "LEFT JOIN cdw_sapp_customer customer ON creditcard.CREDIT_CARD_NO = customer.CREDIT_CARD_NO " +
            "WHERE SSN = %d AND YEAR = '%s' AND MONTH = '%s' AND DAY < '%s' ORDER BY MONTH DESC, DAY DESC;";

}

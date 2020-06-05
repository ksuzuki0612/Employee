import java.io.IOException;
import java.util.function.Supplier;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
//貸し出された本
public class checkOutBook{
	 Logger logger = Logger.getLogger(checkOutBook.class.getName());
    private int checkOutNumber;
    private long ISBN;
    private String title;
    private int employeeID;
    private String employeeName; //いる?確認
    private Date borrowedFrom;
    private Date borrowedUntil;

    public checkOutBook(int checkOutNumber,long ISBN,String title,int employeeID,String employeeName,Date borrowedFrom,Date borrowedUntil){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        this.checkOutNumber = checkOutNumber;
        this.ISBN = ISBN;
        this.title = title;
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.borrowedFrom = borrowedFrom;
        this.borrowedUntil = borrowedUntil;
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }

    public int getCheckOutNumber(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return this.checkOutNumber;
    }

    public long getISBN(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return this.ISBN;
    }

    public String getTitle(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return this.title;
    }

    public int getEmployeeID(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return this.employeeID;
    }

    public String getEmployeeName(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return this.employeeName;
    }

    public Date getBorrowedFrom(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return this.borrowedFrom;
    }

    public String getBorrowedUntil(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return this.borrowedUntil;
    }

    public void setBorrowedUntil(String newBorrowedUntil){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        this.borrowedUntil = newBorrowedUntil;
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }

}
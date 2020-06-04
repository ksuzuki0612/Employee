import java.io.IOException;
import java.util.function.Supplier;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
//予約された本
public class reservedBook{
	Logger logger = Logger.getLogger(reservedBook.class.getName());
    private int resevationNumber;
    private long ISBN;
    private String title;
    private String employeeName;
    private int resevationOrder;
    public reservedBook(int resevationNumber,long ISBN,String title,String employeeName,int resevationOrder){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        this.resevationNumber = resevationNumber;
        this.ISBN = ISBN;
        this.title = title;
        this.employeeName = employeeName;
        this.resevationOrder = resevationOrder;
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }

    public int  getResevationNumber(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return this.resevationNumber;
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

    public int getResavationOrder(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return this.resevationOrder;
    }

}
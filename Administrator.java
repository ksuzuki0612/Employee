import java.io.IOException;
import java.util.function.Supplier;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
public class Administrator{
	Logger logger = Logger.getLogger(LoggerSample.class.getName());
    private int employeeID;
    private String password;

    public Administrator(int employeeID,String password){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        this.employeeID = employeeID;
        this.password = password;
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }

    public int getEmployeeID(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return this.employeeID;
    }

    public String getPassword(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return this.password;
    }

    public void setNewPassword(String newPassword){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        this.password = newPassword;
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }

}
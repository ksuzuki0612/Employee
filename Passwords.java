import java.io.IOException;
import java.util.function.Supplier;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Passwords{
	  Logger logger = Logger.getLogger(Passwords.class.getName());
    private int employeeID;
    private String password;

    public  Passwords(int employeeID, String password) {
    	  logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        this.employeeID = employeeID;
        this.password = password;
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }

    public int getEmployeeID(){
        return this.employeeID;
    }

    public String getPassword(){
        return this.password;
    }

    public void setNewPassword(String newPassword){
        this.password = newPassword;
    }

}

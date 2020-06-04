import java.io.IOException;
import java.util.function.Supplier;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
public class User{
	Logger logger = Logger.getLogger(User.class.getName());
    private int employeeID;
    private String employeeName;
    private int phoneNumber;
    private String email;
    private boolean administratorRight;

    public User(int employeeID,String employeeName,int phoneNumber,String email,boolean administratorRight){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.administratorRight = administratorRight;
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
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

    public int getPhoneNumber(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return this.phoneNumber;
    }

    public String getEmail(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return this.email;
    }

    public boolean getAdministratorRight(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return this.administratorRight;
    }

    public void setnewEmployeeName(String newEmployeeName){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	this.employee = newEmployeeName;
    	logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        
    }

    public void setnewPhonenumber(int newPhoneNumber){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	this.phoneNumber = newPhoneNumber;
    	logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }

    public void setNewEmail(String newEmail){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	this.email = newEmail;
    	logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        
    }

    public void setNewAdministratorRight(boolean newAdministaratorRight){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	this.administratorRight = newAdministaratorRight;
    	logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        
    }
}
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

    public User(
		    int employeeID,
		    String employeeName,
		    int phoneNumber,
        String email,
		    boolean administratorRight){
    	  logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.administratorRight = administratorRight;
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }

    public int getEmployeeID(){
        return this.employeeID;
    }

    public String getEmployeeName(){
        return this.employeeName;
    }

    public int getPhoneNumber(){
        return this.phoneNumber;
    }

    public String getEmail(){
        return this.email;
    }

    public boolean getAdministratorRight(){
        return this.administratorRight;
    }

    public void setnewEmployeeName(String newEmployeeName){
    	  this.employeeName = newEmployeeName;
    }

    public void setnewPhonenumber(int newPhoneNumber){
    	  this.phoneNumber = newPhoneNumber;
    }

    public void setNewEmail(String newEmail){
    	  this.email = newEmail;
		}

    public void setNewAdministratorRight(boolean newAdministaratorRight){
      	this.administratorRight = newAdministaratorRight;
    }

}

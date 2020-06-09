

public class Passwords{
	 
    private int employeeID;
    private String password;

    public  Passwords(int employeeID, String password) {
    	 
        this.employeeID = employeeID;
        this.password = password;
    
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

public class User{
    private int employeeID;
    private String employeeName;
    private int phoneNumber;
    private String email;
    private boolean administratorRight;

    public User(int employeeID,String employeeName,int phoneNumber,String email,boolean administratorRight){
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.administratorRight = administratorRight;
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
        this.employee = newEmployeeName;
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
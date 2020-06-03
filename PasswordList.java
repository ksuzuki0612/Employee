public class PasswordList{
    private int employeeID;
    private String password;

    public PasswordList(int employeeID,String password){
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
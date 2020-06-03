//貸し出された本
public class checkOutBook{
    private int checkOutNumber;
    private long ISBN;
    private String title;
    private int employeeID;
    private String employeeName; //いる?確認
    private Date borrowedFrom;
    private Date borrowedUntil;

    public checkOutBook(int checkOutNumber,long ISBN,String title,int employeeID,String employeeName,Date borrowedFrom,Date borrowedUntil){
        this.checkOutNumber = checkOutNumber;
        this.ISBN = ISBN;
        this.title = title;
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.borrowedFrom = borrowedFrom;
        this.borrowedUntil = borrowedUntil;
    }

    public int getCheckOutNumber(){
        return this.checkOutNumber;
    }

    public long getISBN(){
        return this.ISBN;
    }

    public String getTitle(){
        return this.Title;
    }

    public int getEmployeeID(){
        return this.employeeID;
    }

    public String getEmployeeName(){
        return this.employeeName;
    }

    public Date getBorrowedFrom(){
        return this.borrowedFrom;
    }

    public Date getBorrowedUntil(){
        return this.borrowedUntil;
    }

    public void setBorrowedUntil(){
        this.borrowedUntil = borrowedUntil;
    }

}
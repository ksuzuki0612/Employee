//予約された本
public class ReservedBook{
    private int resevationNumber;
    private long ISBN;
    private String title;
    private String employeeName;
    private int resevationOrder;

    public reservedBook(int resevationNumber, long ISBN, String title, String employeeName, int resevationOrder) {
        this.resevationNumber = resevationNumber;
        this.ISBN = ISBN;
        this.title = title;
        this.employeeName = employeeName;
        this.resevationOrder = resevationOrder;

    }

    public int  getResevationNumber(){
        return this.resevationNumber;
    }

    public long getISBN(){
        return this.ISBN;
    }

    public String getTitle(){
        return this.title;
    }

    public int getResavationOrder(){
        return this.resevationOrder;
    }

}
import java.util.*;

public class Book {
    private long ISBN;
    private String title;
    private String publisher;
    private Date publishDate;
    private String field;
    private List<String> authors;
    private int inventory; //在庫数
    private int borrowedAmount; //貸出数　初期値：0
    
    public Book(long ISBN,String title,String publisher,Date publishDate,String field,List<String>authors,int inventory){
        this.ISBN = ISBN;
        this.title = title;
    	this.publisher = publisher;
        this.publishDate = publishDate;
        this.field = field;
        this.authors = authors;
        this.inventory = inventory;
        this.borrowedAmount = 0; //初期値：0
    }
    
    //getter
    public long getISBN(){
    	return this.ISBN;
    }

    public String getTitle(){
    	return this.title;
    }
    
    public String getPublisher(){
    	return this.publisher;
    }
    
    public Date getPublishDate(){
    	return this.publishDate;
    }
    
    public String getField(){
    	return this.field;
    }

    public List<String> getAuthors(){
    	return this.authors;
    }
    
    public int getInventory(){
    	return this.inventory;
    }

    public int getBorrowedAmount(){
        return this.borrowedAmount;
    }
	
	//setter
    public void setInventory(int numOfInventory){
        this.inventory = numOfInventory;
    }

    public void setBorrowedAmount(int numOfBorrowed){
        this.borrowedAmount = numOfBorrowed;
    }

}
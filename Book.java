import java.util.*;
import java.io.IOException;
import java.util.function.Supplier;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
public class Book {
	Logger logger = Logger.getLogger(Book.class.getName());
    private long ISBN;
    private String title;
    private String publisher;
    private Date publishDate;
    private String field;
    private List<String> authors;
    private int inventory; //在庫数
    private int borrowedAmount; //貸出数　初期値：0

    public Book(long ISBN,String title,String publisher,Date publishDate,String field,List<String>authors,int inventory){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        this.ISBN = ISBN;
        this.title = title;
    	this.publisher = publisher;
        this.publishDate = publishDate;
        this.field = field;
        this.authors = authors;
        this.inventory = inventory;
        this.borrowedAmount = 0; //初期値：0
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }

    //getter
    public long getISBN(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    	return this.ISBN;
    }

    public String getTitle(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    	return this.title;
    }

    public String getPublisher(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    	return this.publisher;
    }

    public Date getPublishDate(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    	return this.publishDate;
    }

    public String getField(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    	return this.field;
    }

    public List<String> getAuthors(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    	return this.authors;
    }

    public int getInventory(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    	return this.inventory;
    }

    public int getBorrowedAmount(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return this.borrowedAmount;
    }

	//setter
    public void setInventory(int numOfInventory){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	this.inventory = numOfInventory;
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }

    public void setBorrowedAmount(int numOfBorrowed){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        this.borrowedAmount = numOfBorrowed;
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }

  //ISBNのlong値を文字列に変換
    public String ISBNToString(long ISBN){
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        String s = Long.toString(this.ISBN);
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return s;
    }

  //ISBNのlong値を文字列に変換したものを取り出す
    public String getStringISBN(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return ISBNToString(this.ISBN);
    }

  //著者名のリストを文字列に変換
    public String authorsListToString(List<String> list){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        StringBuilder sb = new StringBuilder();
        for (String s : list){
            sb.append(s);
            sb.append(",");
            sb.setLength(sb.length()-1);
        }
      //著者のリストを一つの文字列にする。
        String s = sb.toString();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return s;
    }

  //著者のリストを文字列に変換したものを取り出す
    public String getStringAuthors(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return authorsListToString(this.authors);
        
    }

}

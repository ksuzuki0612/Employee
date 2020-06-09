import java.util.*;

/**
 * ブッククラス
 * @author　平松、渡邉
 *
 */

public class Book {
    private long ISBN;
    private String title;
    private String publisher;
    private Date publishDate;
    private String field;
    private List<String> authors;
    private int inventory; //在庫数
    private int borrowedAmount; //貸出数　初期値：0

    public Book(long ISBN,String title,String publisher,Date publishDate,
                String field,List<String>authors,int inventory){
        this.ISBN = ISBN;
        this.title = title;
    	  this.publisher = publisher;
        this.publishDate = publishDate;
        this.field = field;
        this.authors = authors;
        this.inventory = inventory;
        this.borrowedAmount = 0; //初期値：0
    }

  /**
   * getterメソッド
   */
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

	/**
   * setterメソッド
   */
    public void setInventory(int numOfInventory){
    	  this.inventory = numOfInventory;
    }

    public void setBorrowedAmount(int numOfBorrowed){
        this.borrowedAmount = numOfBorrowed;
    }

  /**
   * ISBNのlong値を文字列に変換
   */
    public String ISBNToString(long ISBN){
        String s = Long.toString(this.ISBN);
        return s;
    }

  /**
   * ISBNのlong値を文字列に変換したものを取り出す
   */
    public String getStringISBN(){
        return ISBNToString(this.ISBN);
    }

  /**
   * 著者名のリストを文字列に変換
   */
    public String authorsListToString(List<String> list){
        StringBuilder sb = new StringBuilder();
        for (String s : list){
            sb.append(s);
            sb.append(",");
            sb.setLength(sb.length()-1);
        }
      /**
       * 著者のリストを一つの文字列にする。
       */
        String s = sb.toString();
        return s;
    }

  /**
   * 著者のリストを文字列に変換したものを取り出す
   */
    public String getStringAuthors(){
        return authorsListToString(this.authors);
    }

}

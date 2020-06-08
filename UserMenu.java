import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.*;
import java.text.*;
import java.io.*;


public class UserMenu{
    Logger logger = Logger.getLogger(UserMenu.class.getName());
    SqlMethod sql =new SqlMethod();

  //カンマ
    private final String COMMA = ",";

  //エラーの番号
    private int errorNum = 0;

  //書籍名で書籍を検索
    public void searchBooksByTitle(String bookTitle) {
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        try{
            sql.sqlSearch();
        }catch(Exception e){
            logger.severe("SEVERE");
        }
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }

  //著者名で書籍を検索
    public void searchBooksByAuthor(String bookAuthor) {
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        try{
            sql.sqlSearchAuthor();
        }catch(Exception e){
            logger.severe("SEVERE");
        }
            logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }

  //分野で書籍を検索
    public void searchBooksByField(String bookField) {
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        try{
        sql.sqlSearchField();
        }catch(Exception e){
            logger.severe("SEVERE");
        }
            logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }

  //書籍の保存(書籍名の検索結果)
    public void saveBooksByTitle(String saveFile) {
       logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
       try{
           File csv = new File(saveFile);
           BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));
           List<Book> titleList = new ArrayList<>();
           titleList = sql.getSearchRecordTitle();
           for(Book t : titleList){
               bw.write("ISBN");
               bw.write(COMMA);
               bw.write(t.getStringISBN());
               bw.write(COMMA);
               bw.write("Title");
               bw.write(COMMA);
               bw.write(t.getTitle());
               bw.write(COMMA);
               bw.write("Publisher");
               bw.write(COMMA);
               bw.write(t.getPublisher());
               bw.write(COMMA);
               bw.write("PublishDate");
               bw.write(COMMA);
               bw.write(new SimpleDateFormat("yyyy/MM/dd").format(t.getPublishDate()));
               bw.write(COMMA);
               bw.write("Authors");
               bw.write(COMMA);
               bw.write(t.getStringAuthors());
               bw.write(COMMA);
               bw.write("Field");
               bw.write(COMMA);
               bw.write(t.getField());
               bw.write(COMMA);
               bw.write("Inventory");
               bw.write(COMMA);
               bw.write(t.getInventory());
               bw.write(COMMA);
               bw.write("BorrowedAmount");
               bw.write(COMMA);
               bw.write(t.getBorrowedAmount());
               bw.write("\n");
           }
           bw.close();
       }catch(IOException e){
         errorNum = 1;    //日付の型が正しくありません
           e.printStackTrace();
           logger.severe("SEVERE");
       }
           logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
   }

  //書籍の保存(著者名の検索結果)
    public void saveBooksByAuthors(String saveFile) {
      logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
      try{
          File csv = new File(saveFile);
          BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));
          List<Book> authorList = new ArrayList<>();
          authorList = sql.getSearchRecordAuthor();
          for(Book a : authorList){
              bw.write("ISBN");
              bw.write(COMMA);
              bw.write(a.getStringISBN());
              bw.write(COMMA);
              bw.write("Title");
              bw.write(COMMA);
              bw.write(a.getTitle());
              bw.write(COMMA);
              bw.write("Publisher");
              bw.write(COMMA);
              bw.write(a.getPublisher());
              bw.write(COMMA);
              bw.write("PublishDate");
              bw.write(COMMA);
              bw.write(new SimpleDateFormat("yyyy/MM/dd").format(a.getPublishDate()));
              bw.write(COMMA);
              bw.write("Authors");
              bw.write(COMMA);
              bw.write(a.getStringAuthors());
              bw.write(COMMA);
              bw.write("Field");
              bw.write(COMMA);
              bw.write(a.getField());
              bw.write(COMMA);
              bw.write("Inventory");
              bw.write(COMMA);
              bw.write(a.getInventory());
              bw.write(COMMA);
              bw.write("BorrowedAmount");
              bw.write(COMMA);
              bw.write(a.getBorrowedAmount());
              bw.write("\n");
          }
          bw.close();
      }catch(IOException e){
        errorNum = 1;    //日付の型が正しくありません
          e.printStackTrace();
          logger.severe("SEVERE");
      }
          logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
  }

  //書籍の保存(分野の検索結果)
    public void saveBooksByField(String saveFile) {
       logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
       try{
           File csv = new File(saveFile);
           BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));
           List<Book> fieldList = new ArrayList<>();
           fieldList = sql.getSearchRecordField();
           for(Book f : fieldList){
               bw.write("ISBN");
               bw.write(COMMA);
               bw.write(f.getStringISBN());
               bw.write(COMMA);
               bw.write("Title");
               bw.write(COMMA);
               bw.write(f.getTitle());
               bw.write(COMMA);
               bw.write("Publisher");
               bw.write(COMMA);
               bw.write(f.getPublisher());
               bw.write(COMMA);
               bw.write("PublishDate");
               bw.write(COMMA);
               bw.write(new SimpleDateFormat("yyyy/MM/dd").format(f.getPublishDate()));
               bw.write(COMMA);
               bw.write("Authors");
               bw.write(COMMA);
               bw.write(f.getStringAuthors());
               bw.write(COMMA);
               bw.write("Field");
               bw.write(COMMA);
               bw.write(f.getField());
               bw.write(COMMA);
               bw.write("Inventory");
               bw.write(COMMA);
               bw.write(f.getInventory());
               bw.write(COMMA);
               bw.write("BorrowedAmount");
               bw.write(COMMA);
               bw.write(f.getBorrowedAmount());
               bw.write("\n");
           }
           bw.close();
       }catch(IOException e){
         errorNum = 1;    //日付の型が正しくありません
           e.printStackTrace();
           logger.severe("SEVERE");
       }
           logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
   }

}

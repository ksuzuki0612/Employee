import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.*;
import java.text.*;
import java.io.*;

/**
 *利用者メニュークラス
 *@author 渡邉香穂
 */

public class UserMenu{
    Logger logger = Logger.getLogger(UserMenu.class.getName());
    SqlMethod sql =new SqlMethod();

  //カンマ
    private final String COMMA = ",";

  //エラーの番号
    private int errorNum = 0;

  /**
   *書籍名で書籍を検索し表示するメソッドの呼び出し
   *
   */
    public void searchBooksByTitle() {
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        try{
            sql.sqlSearch();
        }catch(Exception e){
            logger.severe("SEVERE");
        }
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }

  /**
   *著者名で書籍を検索し表示するメソッドの呼び出し
   *
   */
    public void searchBooksByAuthor() {
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        try{
            sql.sqlSearchAuthor();
        }catch(Exception e){
            logger.severe("SEVERE");
        }
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }

  /**
   *分野で書籍を検索し表示するメソッドの呼び出し
   *
   */
    public void searchBooksByField() {
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        try{
        sql.sqlSearchField();
        }catch(Exception e){
            logger.severe("SEVERE");
        }
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }

  /**
   *書籍を保存するメソッド
   *@param saveFile
   */
    public void saveBooksByTitle(String saveFile) {
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        try{
            File csv = new File(saveFile);
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));
            List<Book> titleList = new ArrayList<>();
            titleList = sql.getSearchRecordTitle();
            for(Book t : titleList){
                bw.write(
                    String.format(
                        "ISBN, %d,"+
                        "Title, %s,"+
                        "Publisher, %s,"+
                        "PublishDate, %s,"+
                        "Authors, %s,"+
                        "Field, %s,"+
                        "Inventory, %d,"+
                        "BorrowedAmount, %d"+
                        ","+
                        t.getStringISBN(),
                        t.getTitle(),
                        t.getPublisher(),
                        new SimpleDateFormat("yyyy/MM/dd").format(t.getPublishDate()),
                        t.getStringAuthors(),
                        t.getField(),
                        t.getInventory(),
                        t.getBorrowedAmount())+
                        "\n");
            }
            bw.close();
        }catch(IOException e){
            errorNum = 1;    //日付の型が正しくありません
            e.printStackTrace();
            logger.severe("SEVERE");
        }
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }

    public void saveBooksByAuthors(String saveFile) {
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        try{
            File csv = new File(saveFile);
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));
            List<Book> authorList = new ArrayList<>();
            authorList = sql.getSearchRecordAuthor();
            for(Book a : authorList){
                bw.write(
                    String.format(
                        "ISBN, %d,"+
                        "Title, %s,"+
                        "Publisher, %s,"+
                        "PublishDate, %s,"+
                        "Authors, %s,"+
                        "Field, %s,"+
                        "Inventory, %d,"+
                        "BorrowedAmount, %d"+
                        ","+
                        a.getStringISBN(),
                        a.getTitle(),
                        a.getPublisher(),
                        new SimpleDateFormat("yyyy/MM/dd").format(a.getPublishDate()),
                        a.getStringAuthors(),
                        a.getField(),
                        a.getInventory(),
                        a.getBorrowedAmount())+
                        "\n");
            }
            bw.close();
        }catch(IOException e){
            errorNum = 1;    //日付の型が正しくありません
            e.printStackTrace();
            logger.severe("SEVERE");
        }
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }

    public void saveBooksByField(String saveFile) {
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        try{
            File csv = new File(saveFile);
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));
            List<Book> fieldList = new ArrayList<>();
            fieldList = sql.getSearchRecordField();
            for(Book f : fieldList){
                bw.write(
                    String.format(
                        "ISBN, %d,"+
                        "Title, %s,"+
                        "Publisher, %s,"+
                        "PublishDate, %s,"+
                        "Authors, %s,"+
                        "Field, %s,"+
                        "Inventory, %d,"+
                        "BorrowedAmount, %d"+
                        ","+
                        f.getStringISBN(),
                        f.getTitle(),
                        f.getPublisher(),
                        new SimpleDateFormat("yyyy/MM/dd").format(f.getPublishDate()),
                        f.getStringAuthors(),
                        f.getField(),
                        f.getInventory(),
                        f.getBorrowedAmount())+
                        "\n");
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

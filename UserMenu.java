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
    List<Book> titleList = new ArrayList<>();
    UI ui =new UI();

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
            titleList = sql.searchTitle();
           
            for(Book t : titleList){
                System.out.println(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s",
                                            "ISBN","Title","Publisher","Publishdate","Field",
                                            "Author","Inventory","Lent out"));
                System.out.println(  String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s",
                                        t.getISBN() ,t.getTitle() , t.getPublisher() , new SimpleDateFormat("yyyy/MM/dd").format(t.getPublishDate()) ,
                                        t.getStringAuthors() , t.getField() , t.getInventory(), t.getBorrowedAmount() ));
            
            }
            System .out.println("検索結果を保存しますか？");
            System.out.println("1.はい");
            System.out.println("2.前の画面に戻る");
            String s1 = new java.util.Scanner(System.in).nextLine();
            int selected = Integer.parseInt(s1);
            if(selected == 1){
                String saveFile =ui.saveBooksByTitleUI();
                saveBooks(saveFile,titleList);
            }
        }
        catch(Exception e){
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
            titleList = sql.searchAuthor();
            for(Book t : titleList){
                System.out.println(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s",
                                            "ISBN","Title","Publisher","Publishdate","Field",
                                            "Author","Inventory","Lent out"));
                System.out.println(  String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s",
                                        t.getISBN() ,t.getTitle() , t.getPublisher() , new SimpleDateFormat("yyyy/MM/dd").format(t.getPublishDate()) ,
                                        t.getStringAuthors() , t.getField() , t.getInventory(), t.getBorrowedAmount() ));
            
            }
            System .out.println("検索結果を保存しますか？");
            System.out.println("1.はい");
            System.out.println("2.前の画面に戻る");
            String s1 = new java.util.Scanner(System.in).nextLine();
            int selected = Integer.parseInt(s1);
            if(selected == 1){
                String saveFile =ui.saveBooksByTitleUI();
                saveBooks(saveFile,titleList);
            }
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
            titleList = sql.searchField();
            for(Book t : titleList){
                System.out.println(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s",
                                            "ISBN","Title","Publisher","Publishdate","Field",
                                            "Author","Inventory","Lent out"));
                System.out.println( String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s",
                                        t.getISBN() ,t.getTitle() , t.getPublisher() , new SimpleDateFormat("yyyy/MM/dd").format(t.getPublishDate()) ,
                                        t.getStringAuthors() , t.getField() , t.getInventory(), t.getBorrowedAmount() ));
            }
        }catch(Exception e){
            logger.severe("SEVERE");
        }
        System .out.println("検索結果を保存しますか？");
            System.out.println("1.はい");
            System.out.println("2.前の画面に戻る");
            String s1 = new java.util.Scanner(System.in).nextLine();
            int selected = Integer.parseInt(s1);
            if(selected == 1){
                String saveFile =ui.saveBooksByTitleUI();
                saveBooks(saveFile,titleList);
            }
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }

  /**
   *書籍を保存するメソッド
   *@param saveFile
   */
   public void saveBooks(String saveFile,List<Book> titleList) {
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        try{
            File csv = new File(saveFile);
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv));
            for(Book t : titleList){
                bw.write("ISBN,"+t.getISBN()+",Title,"+ t.getTitle()+",Publisher,"+t.getPublisher()+",PublishDate,"
                +new SimpleDateFormat("yyyy/MM/dd").format(t.getPublishDate())+",Authors,"+ t.getStringAuthors()+",Field, "
                + t.getField()+",Inventory,"+ t.getInventory()+",BorrowedAmount," +t.getBorrowedAmount());
                bw.newLine();
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
   

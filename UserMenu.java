import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.lang.model.element.Element;

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
   *書籍を検索し表示するメソッド
   *
   */
    public void searchBooks(int selected) {
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        try{
            if(selected ==1){
                titleList = sql.searchTitle();
            }
            else if(selected ==2){
                titleList =  sql.searchAuthor();
            }
            else if(selected ==3){
                titleList = sql.searchField();
            }
            else{
                return;
            }
            for(Book t : titleList){
                System.out.println(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s",
                    "ISBN","Title","Publisher","Publishdate","Author","category","Inventory","Lent out"));
                System.out.println(  String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s",
                    t.getISBN() ,t.getTitle() , t.getPublisher() , new SimpleDateFormat("yyyy/MM/dd").format(t.getPublishDate()),
                    t.getStringAuthors() , t.getField() , t.getInventory(), t.getBorrowedAmount() ));
            
            }
            System .out.println("検索結果を保存しますか？");
            System.out.println("1.はい");
            System.out.println("2.前の画面に戻る");
            String s1 = new java.util.Scanner(System.in).nextLine();
            int select = Integer.parseInt(s1);
            if(select == 1){
                String saveFile =ui.saveBooksByTitleUI();
                this.saveBooks(saveFile,titleList);
            }
        }
        catch(Exception e){
            logger.severe("SEVERE");
        }
        finally{
            logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        }
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
                +new SimpleDateFormat("yyyy/MM/dd").format(t.getPublishDate())+",Authors,"+ t.getStringAuthors()+
                ",category, "+ t.getField()+",Inventory,"+ t.getInventory()+",BorrowedAmount," +t.getBorrowedAmount());
                bw.newLine();
            }
            bw.close();
        }catch(IOException e){
            errorNum = 1;    //日付の型が正しくありません
            e.printStackTrace();
            logger.severe("SEVERE");
        }
        finally{
            logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        }
    }
}
   

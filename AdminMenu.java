import java.io.IOException;
import java.util.function.Supplier;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.*;
import java.text.*;
import java.io.*;
public class AdminMenu{
	Logger logger = Logger.getLogger(AdminMenu.class.getName());
	 SQL_method sql =new SQL_method();
	 UI ui =new UI();
     public void registerBook(){
     	 logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
         try{ 
    	     List<String> authorList = new ArrayList<String>();
    	     String strDate = ui.strDate();
    	     SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");
             Date publishDate = sdFormat.parse(strDate);
             do{
                 int i = 0;
                 String str4 =ui.str4();
                 if(authorList.contains(str4)){
                 System.out.println("既にその著者名は登録されています。");
                 i += 1;
                 }
                 else{
                     authorList.add(str4);
                     int authorAdd = ui.authorAdd();
                     i += authorAdd;
                 }
             }    
             while(i == 1);
             int borrowedAmount = 0;
             sql.DBregisterBook(ui.isbnUi(),ui.titleUi(),ui.publisher(), publishDate,ui.field(),authorList,ui.inventory(),borrowedAmount);
    	 }
    	 catch(ParseException e){
    		 e.printStackTrace();
	 	 }
	 	 logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
     }
     public void deleteBook() {
     	 logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
         String deleteBook = ui.deleteBook();
    	 sql.DBdeleteBook(deleteBook);
    	 logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
     }
     public void updataBook(){
     	 logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
         loop:while (true){
			 int selected = ui.selectedUi();
		     switch(selected){
			     case 1:
                     long allowISBN = ui.isbnUi();
                     int select = ui.selectUi();
                     if(select==1){
                     int addInventory = ui.addInventoryUi(); 
                     sql.DBupdataInventory( allowISBN,addInventory );
                     }
    	             else if (select ==2){
    	             	 int deInventory = ui.deInventoryUi();
    	                 int deleteInventory;
    	                 deleteInventory -= deInventory;
    	                 sql.DBupdataInventory( allowISBN,deleteInventory );
    	             }else{
    	             	 System.out.println("最初からやり直してください");
                     }
                     break;
                     
                 case 2:
                     long allowISBN = ui.isbnUi();
                     int addBorrowedAmount =ui.addBorrowedAmountUi();
                     sql.DBaddBorrowedAmount( allowISBN,addBorrowedAmount);
                     break;
                 case 3:
                     break loop;        
             }
         }
         logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
     }    
     //貸出承認
     public void allowBorrowBook(){
     	 logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
         long allowISBN = ui.isbnUi();
         int employee = ui.employee();
         int bookPeriod = ui.bookPeriod();
         int theBorrowedAmount =sql./**/;
         int theInventory =sql./**/;
    	 if(theInventory > theBorrowedAmount){
    		 System.out.println("貸出OK");
         }
         else{
         	  System.out.println("貸出NG");
         }
         logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }
    //返却申請
    public void returnBook(){
    	 logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
         long allowISBN = ui.isbnUi();
         int employee = ui.employee();
         ui./*sqlメソッド */(allowISBN,employee);
         logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }
}

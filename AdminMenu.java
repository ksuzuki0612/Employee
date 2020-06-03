import java.util.*;
import java.text.*;
import java.io.*;
public class AdminMenu{
	 SQL_method sql =new SQL_method();
	 AdminMenuUi ui =new AdminMenuUi();
     public void registerBook(){
         try{ 
    	     List<String> authorList = new ArrayList<String>();
    	　　 String strDate = ui.strDate();
    	　　 SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMdd")
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
             sql.DBregisterBook(ui.isbnUi(),ui.titleUi(),ui.publisher(), publishDate,ui.field(),authorList,ui.inventory(),borrowedAmount)
    	 }
    	 catch(ParseException e){
    		 e.printStackTrace();
	 	 }
     }
     public void deleteBook() {
         String deleteBook = ui.deleteBook();
    	 sql.DBdeleteBook(deleteBook);
     }
     public void updataBook(){
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
    	                 int deleteInventory -= deInventory;
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
     }    
     public void allowBorrowBook(){//貸出承認
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
    }
    public void returnBook(){//返却申請
         long allowISBN = ui.isbnUi();
         int employee = ui.employee();
        ui./*sqlメソッド */(allowISBN,employee);
    }
}

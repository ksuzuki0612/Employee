import java.util.*;
import java.text.*;
import java.io.*;
public class AdminMenu{
	 SQL_method sql =new SQL_method();
	 AdminMenuUi ui =new AdminMenuUi();
     public void registerBook(){
         try{ 
    	     List<String> authorList = new ArrayList<String>();
             long ISBN = ui.isbnUi();
             String title = ui.titleUi();
             String publisher = ui.publisher();
    	　　 String strDate = ui.strDate();
    	　　 SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMdd")
             Date publishDate = sdFormat.parse(strDate);
             String field =ui.field();
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
             int inventory = ui.inventory();         
//           int borrowedAmount = ui.inventory();
             sql.DBregisterBook( ISBN,title,publisher, publishDate,field,authorList,inventory/*,borrowedAmount*/)
    	 }
    	 catch(ParseException e){
    		 e.printStackTrace();
	 	 }
     }
     public void deleteBook() {
    	//タイトルを指定して削除
         String deleteBook = ui.deleteBook();
    	 sql.DBdeleteBook(deleteBook);
     }
     public void updataBook(){
         loop:while (true){
			 int selected = ui.selectedUi();
		     switch(selected){
			     case 1:
                     long allowISBN = ui.isbnUi();
                     break;
                 case 2:
                     long allowISBN = ui.isbnUi();
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
    	 if(){
    		 System.out.println("貸出OK");
         }
         else{
         	  System.out.println("貸出NG");
         }
    }
    public void returnBook(){//返却申請
         long allowISBN = ui.isbnUi();
          int employee = ui.employee();
          
    }   
}

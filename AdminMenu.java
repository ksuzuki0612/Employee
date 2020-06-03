import java.util.*;
import java.text.*;
import java.io.*;
public class AdminMenu{
	 SQL_method sql =new SQL_method();
    
   
     public void registerBook(){
    	 try{ 
    	     List<String> authorList = new ArrayList<String>();
    	 	 System.out.println("ISBNを入力してください。");
             long ISBN = new java.util.Scanner(System.in).nextlong();
    	     System.out.println("書籍名をを入力してください。");
             String title = new java.util.Scanner(System.in).nextLine();
             System.out.println("出版社を入力してください。");
             String publisher = new java.util.Scanner(System.in).nextLine();
             System.out.println("登録する書籍の出版日をyyyyMMdd形式で入力してください");
    	　　 String strDate = new java.util.Scanner(System.in).nextLine();
    	　　 SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMdd")
             Date publishDate = sdFormat.parse(strDate);
             System.out.println("fieldを入力してください。");
             String field = new java.util.Scanner(System.in).nextLine();
             do{
             	int i = 0;
             	System.out.println("著者を入力してください。");
                String str4 = new java.util.Scanner(System.in).nextLine();
                if(authorList.contains(str4)){
                	System.out.println("既にその著者名は登録されています。");
                	i += 1;
                }else{
                    authorList.add(str4);
                    System.out.println("著者を追加する場合は１を入力してください");
                    int authorAdd = new java.util.Scanner(System.in).nextInt();
                    i += authorAdd;
                }
             }while(i == 1);
    		 System.out.println("inventoryを入力してください。");
             int inventory = new java.util.Scanner(System.in).nextInt();
//             System.out.println("borrowedAmountを入力してください。");
//             int borrowedAmount = new java.util.Scanner(System.in).nextInt();

             sql.DBregisterBook( ISBN,title,publisher, publishDate,field,authorList,inventory/*,borrowedAmount*/)
    	 }
    	 catch(ParseException e){
    		 e.printStackTrace();
	 	 }
    
     }
     public void deleteBook() {
    	//タイトルを指定して削除
         System.out.println("削除する本のISBMを入力してください");
         String deleteBook = new java.util.Scanner(System.in).nextLine();
    	 sql.DBdeleteBook(deleteTitle);
    }


    public void updataBook(){
    	System.out.println("更新する本のISBMを入力してください");
         String isbn = new java.util.Scanner(System.in).nextLine();
    	List<Book> updataBook  =new ArrayList<Book>();
    	updataBook =sql.メソッド名(isbn)//ここで指定されたBookの情報をArrayList型（Book）でほしい
    	if(updataBook = null){
    	    System.out.println("一致する本がありません");
    	}
    	else{
    		for(int i = 0 ; i < updataBook.size() ; i++){
                Book upBook =new Book(updataBook.get(i).getISBN(),updataBook.get(i).getTitle(),updataBook.get(i).getPublisher(),
                	                  updataBook.get(i).getPublishDate(),updataBook.get(i).getField(),updataBook.get(i).getAuthors(),
                                      updataBook.get(i).getInventory());
            }    
    	    loop:while (true){
    	    	System.out.println("編集項目を選択してください");
    	    	System.out.println("1.タイトル");
    	    	System.out.println("2.出版社");
    	    	System.out.println("3.出版日");
    	    	System.out.println("4.分野");
    	    	System.out.println("5.著者");
    	    	System.out.println("6.終了");
			    int selected = new java.util.Scanner(System.in).nextInt();
		        switch(selected){
			        case 1:
                        System.out.println("1.タイトル");
                        bb.showAllBooks(); 
                        break;
                    case 2:
                        System.out.println("2.出版社");
                        bb.showAllBooksGroupByAuthor();
                        break;
                    case 3:
                        System.out.println("3.出版日");
                        bb.searchBooksByTitle();
                        break;
                    case 4:
                        System.out.println("4.分野");
                        bb.searchBooksByAuthor();
                        break;
                    case 5:
                        System.out.println("5.著者");
                        bb.addBook();
                        break;
                    case 6:
                        System.out.println("6.終了");
                        break loop;
                }
        }
    	
    }
    
    public void allowBorrowBook(){
    	
    	
    }
    public void returnBook(){
    	
    	
    }   
}
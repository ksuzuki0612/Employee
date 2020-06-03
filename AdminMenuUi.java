import java.util.*;
import java.text.*;
import java.io.*;
public class AdminMenuUi{
    public long isbnUi(){
	    System.out.println("ISBNを入力してください。");
        long ISBN = new java.util.Scanner(System.in).nextlong();
        return ISBN;
    }
    public String titleUi(){
	    System.out.println("書籍名をを入力してください。");
        String title = new java.util.Scanner(System.in).nextLine();
        return title;
    }
    public String publisherUi(){
    	System.out.println("出版社を入力してください。");
        String publisher = new java.util.Scanner(System.in).nextLine();
	    return publisher;
    }
    public String strDateUi(){
    	System.out.println("登録する書籍の出版日をyyyyMMdd形式で入力してください");
        String strDate = new java.util.Scanner(System.in).nextLine();
	    return strDate;
    }
    public String fieldUi(){
    	System.out.println("fieldを入力してください。");
        String field = new java.util.Scanner(System.in).nextLine();
	    return field
    }
    public String isbnUi(){
    	System.out.println("著者を入力してください。");
        String str4 = new java.util.Scanner(System.in).nextLine();
	    return str4;
    }
    public int authorAddUi(){
    	System.out.println("著者を追加する場合は１を入力してください");
        int authorAdd = new java.util.Scanner(System.in).nextInt();
	    return authorAdd;
    }
     public int inventoryUi(){
     	System.out.println("inventoryを入力してください。");
        int inventory = new java.util.Scanner(System.in).nextInt();
	    return inventory;
    }
     public int borrowedAmountUi(){
     	System.out.println("borrowedAmountを入力してください。");
        int borrowedAmount = new java.util.Scanner(System.in).nextInt();
	    return borrowedAmount;
    }
    //updata
    public int selectedUi(){
        System.out.println("編集項目を選択してください");
    	System.out.println("1.在庫変更");
    	System.out.println("2.貸出本の更新");
    	System.out.println("3.終了");
    	int selected = new java.util.Scanner(System.in).nextInt();
	    return selected;
    }
    
    //delete
     public String deleteBookUi(){
     	System.out.println("削除する本のISBMを入力してください");
        String deleteBook = new java.util.Scanner(System.in).nextLine();
	    return deleteBook;
    }
    //貸入出
     public long employeeUi(){
     	System.out.println("従業員IDを入力してください");
        int employee = new java.util.Scanner(System.in).nextInt();
	    return employee;
    }
     public long bookPeriodUi(){
     	System.out.println("貸出期限を入力してください");
        int bookPeriod = new java.util.Scanner(System.in).nextInt();
	    return bookPeriod;
    }
}
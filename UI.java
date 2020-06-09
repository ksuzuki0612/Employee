import java.util.*;
import java.io.IOException;
import java.util.function.Supplier;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
public class UI{
	Logger logger = Logger.getLogger(UI.class.getName());
    public void loginUI(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	System.out.println("ログイン画面");
        System.out.println("ログインしますか？それともパスワードの再設定をしますか？");
        System.out.println("1.ログイン  2.再設定");
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }

    public int resetPassUI(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        System.out.println("パスワードを再設定しますか？");
        System.out.println("1,はい　2,いいえ");
        int ans = new java.util.Scanner(System.in).nextInt();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return ans;
    }

    public int getEmpID(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        System.out.print("従業員ID:");
        int empID = new java.util.Scanner(System.in).nextInt();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return empID;
    }

    public String getPassword(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        System.out.print("パスワード:");
        String password = new java.util.Scanner(System.in).nextLine();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return password;
    }

    public String getCheckPassword(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        System.out.print("確認用パスワード:");
        String checkPassword = new java.util.Scanner(System.in).nextLine();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return checkPassword;
    }
    //MainMenuUI
     public int choiceMenuUI(){
     	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        System.out.println("機能を選択してください");
        System.out.println("1,図書館利用者機能");
        System.out.println("2,図書館管理者機能");

        int choice = new java.util.Scanner(System.in).nextInt();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return choice;
    }

    public int adminMenuUI(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        System.out.println("メニュー画面");
            
		System.out.println("1，図書登録");
		System.out.println("2，図書削除");
		System.out.println("3，登録変更");
		System.out.println("4，貸出承認");
		System.out.println("5，返却受取");
		System.out.println("6，終了");
			
		System.out.println("メニュー番号を入力してください。");
		
        int selected = new java.util.Scanner(System.in).nextInt();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return selected;
    }

    public int userMenuUI(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        System.out.println("メニュー画面");
            
		System.out.println("1，図書検索");
        System.out.println("2，予約取消");
        System.out.println("3，終了");
			
		System.out.println("メニュー番号を入力してください。");
		
		int selected = new java.util.Scanner(System.in).nextInt();
		logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
		return selected;
    }
    //UserMenuUi.java
//インスタンスの生成
    private static UserMenu userMenu = new UserMenu();

    public  void userMenu(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        int selected=0;
        System.out.println("検索する項目を選んでください");
        System.out.println("1.タイトル");
        System.out.println("2.著者");
        System.out.println("3.分野");
        String str = new java.util.Scanner(System.in).nextLine();
        selected = Integer.parseInt(str);
        switch(selected){
            case 1:
               // searchBooksByTitleUI();
                System.out.println("検索結果を保存しますか？");
                System.out.println("1.はい");
                System.out.println("2.前の画面に戻る");
                String s1 = new java.util.Scanner(System.in).nextLine();
                selected = Integer.parseInt(s1);
                if(selected == 1){
                    saveBooksByTitleUI();
                }else{
                    userMenu();
                }
                logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
                break;
            case 2:
                //searchBooksByAuthorUI();
                System.out.println("検索結果を保存しますか？");
                System.out.println("1.はい");
                System.out.println("2.前の画面に戻る");
                String s2 = new java.util.Scanner(System.in).nextLine();
                selected = Integer.parseInt(s2);
                if(selected == 1){
                    saveBooksByAuthorsUI();
                }else{
                    userMenu();
                }
                logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
                break;
            case 3:
                //searchBooksByFieldUI();
                System.out.println("検索結果を保存しますか？");
                System.out.println("1.はい");
                System.out.println("2.前の画面に戻る");
                String s3 = new java.util.Scanner(System.in).nextLine();
                selected = Integer.parseInt(s3);
                if(selected == 1){
                    saveBooksByFieldUI();
                }else{
                    userMenu();
                }
                logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
                break;
        }
        
    }

  //書籍名で書籍の検索

/*
   public  void searchBooksByTitleUI(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        System.out.println("検索したいタイトル名を入力してください");
        String bookTitle = new java.util.Scanner(System.in).nextLine();
        for(int i = 0 ; i < userMenu.searchBooksByTitle(bookTitle).size() ; i++){
        	  System.out.println(userMenu.searchBooksByTitle(bookTitle).get(i).toString());
        }
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }

//著者名で書籍の検索
    public  void searchBooksByAuthorUI(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        System.out.println("検索したい著者名を入力してください。");
        String bookAuthor = new java.util.Scanner(System.in).nextLine();
        ArrayList<Book> booksByAuthor = new ArrayList<Book>();
        booksByAuthor = userMenu.searchBooksByAuthor(bookAuthor);
        for(int i = 0 ; i < booksByAuthor.size() ; i++){
        	System.out.println(booksByAuthor.get(i).toString());
        }
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }

//分野で書籍の検索
    public  void searchBooksByFieldUI(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        System.out.println("検索したい分野名を入力してください");
        String bookField = new java.util.Scanner(System.in).nextLine();
        for(int i = 0 ; i < userMenu.searchBooksByField(bookField).size() ; i++){
             System.out.println(userMenu.searchBooksByField(bookField).get(i).toString());
        }
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }
*/
//ファイルの保存(書籍名)
    public  void saveBooksByTitleUI(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        System.out.println("書籍を保存するファイル名を入力してください。");
        String saveFile = new java.util.Scanner(System.in).nextLine();
        userMenu.saveBooksByTitle(saveFile);
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        }

//ファイルの保存(著者名)
    public  void saveBooksByAuthorsUI(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        System.out.println("書籍を保存するファイル名を入力してください。");
        String saveFile = new java.util.Scanner(System.in).nextLine();
        userMenu.saveBooksByAuthors(saveFile);
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        }

//ファイルの保存(分野)
    public  void saveBooksByFieldUI(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        System.out.println("書籍を保存するファイル名を入力してください。");
        String saveFile = new java.util.Scanner(System.in).nextLine();
        userMenu.saveBooksByField(saveFile);
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        }
//AdminMenuUi
     public long isbnUi(){
     	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
	    System.out.println("ISBNを入力してください。");
        String isbn = new java.util.Scanner(System.in).nextLine();
        long ISBN = Long.parseLong(isbn);
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return ISBN;
    }
    public String titleUi(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
	    System.out.println("書籍名をを入力してください。");
        String title = new java.util.Scanner(System.in).nextLine();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return title;
    }
    public String publisherUi(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	System.out.println("出版社を入力してください。");
        String publisher = new java.util.Scanner(System.in).nextLine();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
	    return publisher;
    }
    public String strDateUi(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	System.out.println("登録する書籍の出版日をyyyyMMdd形式で入力してください");
        String strDate = new java.util.Scanner(System.in).nextLine();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
	    return strDate;
    }
    public String fieldUi(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	System.out.println("fieldを入力してください。");
        String field = new java.util.Scanner(System.in).nextLine();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
	    return field;
    }
    public String str4Ui(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	System.out.println("著者を入力してください。");
        String str4 = new java.util.Scanner(System.in).nextLine();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
	    return str4;
    }
    public int authorAddUi(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	System.out.println("著者を追加する場合は１を入力してください");
        int authorAdd = new java.util.Scanner(System.in).nextInt();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
	    return authorAdd;
    }
     public int inventoryUi(){
     	 logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
     	System.out.println("inventoryを入力してください。");
        int inventory = new java.util.Scanner(System.in).nextInt();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
	    return inventory;
    }
     public int borrowedAmountUi(){
     	 logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
     	System.out.println("borrowedAmountを入力してください。");
        int borrowedAmount = new java.util.Scanner(System.in).nextInt();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
	    return borrowedAmount;
    }
    //updata
    public int selectedUi(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        System.out.println("編集項目を選択してください");
    	System.out.println("1.在庫変更");
    	System.out.println("2.貸出本の更新");
    	System.out.println("3.終了");
    	int selected = new java.util.Scanner(System.in).nextInt();
    	logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
	    return selected;
    }
    
    //delete
     public long deleteBookUi(){
     	 logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
     	System.out.println("削除する本のISBMを入力してください");
        String deleteISBN = new java.util.Scanner(System.in).nextLine();
        long deleteBook = Long.parseLong(deleteISBN);
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
	    return deleteBook;
    }
    //貸入出
     public int employeeUi(){
     	 logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
     	System.out.println("従業員IDを入力してください");
        int employee = new java.util.Scanner(System.in).nextInt();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
	    return employee;
    }
     public int bookPeriodUi(){
     	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
     	System.out.println("貸出期限を入力してください");
        int bookPeriod = new java.util.Scanner(System.in).nextInt();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
	    return bookPeriod;
    }
     public int selectUi(){
     	 logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
     	System.out.println("書籍を追加する場合は１、削除する場合は２を入力してください。");
        int select = new java.util.Scanner(System.in).nextInt();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
	    return select;
    }
    
    public int addInventoryUi(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
     	System.out.println("追加する書籍数を入力してください");
    	int addInventory = new java.util.Scanner(System.in).nextInt();
    	logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
	    return addInventory;
	    
    }
    public int deInventoryUi(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
     	System.out.println("削除する書籍数を入力してください");
    	int deInventory = new java.util.Scanner(System.in).nextInt();
    	logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
	    return deInventory;
	    
    }
    public int addBorrowedAmountUi(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
     	System.out.println("2.その書籍の貸出数を入力してください");
        int addBorrowedAmount = new java.util.Scanner(System.in).nextInt();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
	    return addBorrowedAmount;
	    
    }
    public int returnMenuUi(){

    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        System.out.println("編集メニューに戻る場合は１、編集・更新を始める場合は２を入力してください");
        int returnMainMenu = new java.util.Scanner(System.in).nextInt();
        switch(returnMainMenu){
            case 1:
                logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
                return returnMainMenu;
            case 2:
                logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
                return returnMainMenu;
            default:
                System.out.println("再度入力してください");
            break; 
        }
        
        
    }

}

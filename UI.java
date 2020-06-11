import java.util.*;
import java.io.IOException;
import java.util.function.Supplier;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * UIクラス
 * @author 鈴木戒生
 * @see LibarayMain,AdminMain,MainMenu,UserMenu,
 * @version 2.2
 */
public class UI{
	  Logger logger = Logger.getLogger(UI.class.getName());

/**
* ログイン画面を表示するメソッド。
*/
    public void loginUI(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	System.out.println("ログイン画面");
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }
/**
*パスワード再設定行為の是非メソッド。
*@return ans
*/
    public int resetPassUI(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        System.out.println("パスワードを再設定しますか？");
        System.out.println("1,はい　2,いいえ");
        int ans = new java.util.Scanner(System.in).nextInt();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return ans;
    }
/**
*従業員IDの入力を促すメソッド。
*@return empID
*/
    public int getEmpID(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        System.out.print("従業員ID:");
        int empID = new java.util.Scanner(System.in).nextInt();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return empID;
    }
/**
*パスワードの入力を促すメソッド。
*@return password
*/
    public String getPassword(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        System.out.print("パスワード:");
        String password = new java.util.Scanner(System.in).nextLine();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return password;
    }
/**
*新しいパスワードの入力を促すメソッド。
*@return password
*/
    public String getNewPassword(){
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        System.out.print("新しいパスワード:");
        String newPassword = new java.util.Scanner(System.in).nextLine();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return newPassword;
    }
/**
*確認用パスワードの入力を促すメソッド。
*@return ans
*/
    public String getCheckPassword(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        System.out.print("確認用パスワード:");
        String checkPassword = new java.util.Scanner(System.in).nextLine();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return checkPassword;
    }
//MainMenuUI
/**
*管理者機能か利用者機能の利用を選択させるメソッド。
*@return choice
*/
    public int choiceMenuUI(){
     	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        System.out.println("機能を選択してください");
        System.out.println("1,図書館利用者機能");
        System.out.println("2,図書館管理者機能");
        System.out.println("3,パスワードの再設定");
        System.out.println("4,終了");

        int choice = new java.util.Scanner(System.in).nextInt();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return choice;
    }

    public void resultChangePass(boolean result){
        if(result == true){
            System.out.println("パスワードが更新されました");
        }
        else{
            System.out.println("パスワードの更新に失敗しました");
        }
    }
/**
*各管理者機能の選択を促すメソッド。
*@return selected
*/
    public int adminMenuUI(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        System.out.println("メニュー画面");
        System.out.println(String.format("%d, 図書登録", AdminMenuNum.RegisterBook));
		System.out.println(String.format("%d, 図書削除", AdminMenuNum.DeleteBook));
		System.out.println(String.format("%d, 登録変更", AdminMenuNum.ChangeBookInfo));
		System.out.println(String.format("%d, 貸出承認", AdminMenuNum.LoanAproval));
		System.out.println(String.format("%d, 返却受取", AdminMenuNum.ReturnApplication));
		System.out.println(String.format("%d, 終了", AdminMenuNum.EndProgram));
	    System.out.println("メニュー番号を入力してください。");
        int selected = new java.util.Scanner(System.in).nextInt();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return selected;
    }
/**
*各利用者機能の選択を促すメソッド。
*@return selected
*/
    public int userMenuUI(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        System.out.println("メニュー画面");
		System.out.println(String.format("%d, 検索", UserMenuNum.SearchBook));
        System.out.println(String.format("%d, 予約取消", UserMenuNum.CancelReservation));
        System.out.println(String.format("%d, 終了", UserMenuNum.EndProgram));
      	System.out.println("メニュー番号を入力してください。");
        int selected = new java.util.Scanner(System.in).nextInt();
	 	logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
		return selected;
    }

    //UserMenuUi.java
    private static UserMenu userMenu = new UserMenu();
/**
*図書検索機能の選択を促すメソッド。
*/
        
    public  void userMenu(){
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        int selected=0;
        loop:while (true){
            System.out.println("検索する項目を選んでください");
            System.out.println("1.タイトル");
            System.out.println("2.著者");
            System.out.println("3.分野");
            System.out.println("4.前の画面に戻る");
            String str = new java.util.Scanner(System.in).nextLine();
            selected = Integer.parseInt(str);
            switch(selected){
                case 1:
                    userMenu.searchBooksByTitle();
                    logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
                    break;
                case 2:
                    userMenu.searchBooksByAuthor();
                    
                    logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
                    break;
                case 3:
                    userMenu.searchBooksByField();
                    
                    logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
                    break;
                case 4:
                    break loop;
                default:
                    System.out.println("再度入力してください");
                    break;
            }
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
    public  String saveBooksByTitleUI(){
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        System.out.println("書籍を保存するファイル名を入力してください。");
        String saveFile = new java.util.Scanner(System.in).nextLine();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return saveFile;
}




//AdminMenuUi
/**
*ISBNの入力を促すメソッド。
*@return ISBN
*/
    public String isbnUi(){
     	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
	    System.out.println("ISBNを入力してください。");
        String isbn = new java.util.Scanner(System.in).nextLine();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return isbn;
    }
/**
*タイトルの入力を促すメソッド。
*@return title
*/
    public String titleUi(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
	    System.out.println("書籍名をを入力してください。");
        String title = new java.util.Scanner(System.in).nextLine();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return title;
    }
/**
*出版社の入力を促すメソッド。
*@return publisher
*/
    public String publisherUi(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	System.out.println("出版社を入力してください。");
        String publisher = new java.util.Scanner(System.in).nextLine();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
	    return publisher;
    }
/**
*出版日の入力を促すメソッド。
*@return strDate
*/
    public String strDateUi(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	System.out.println("登録する書籍の出版日をyyyyMMdd形式で入力してください");
        String strDate = new java.util.Scanner(System.in).nextLine();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
	    return strDate;
    }
/**
*分野の入力を促すメソッド。
*@return  field
*/
    public String fieldUi(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	System.out.println("分野を入力してください。");
        String field = new java.util.Scanner(System.in).nextLine();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
	    return field;
    }
/**
*著者の入力を促すメソッド。
*@return  str4
*/
    public String str4Ui(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	System.out.println("著者を入力してください。");
        String str4 = new java.util.Scanner(System.in).nextLine();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
	    return str4;
    }
/**
*著者の追加の是非メソッド。
*@return  authorAdd
*/
    public int authorAddUi(){
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        int authorAdd=0;
        do{
            authorAdd = 0;
            System.out.println("著者を追加する場合は１、行わない場合は２を入力してください");
             authorAdd = new java.util.Scanner(System.in).nextInt();
        }
        while(!(authorAdd ==1 ||authorAdd ==2));
            logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
            return authorAdd;

    }
/**
*在庫数の入力を促すメソッド。
*@return  inventory
*/
    public int inventoryUi(){
     	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
     	System.out.println("在庫数を入力してください。");
        int inventory = new java.util.Scanner(System.in).nextInt();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
	    return inventory;
    }
/**
*貸出数の入力を促すメソッド。
*@return  inventory
*/
    public int borrowedAmountUi(){
     	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
     	System.out.println("貸出数を入力してください。");
        int borrowedAmount = new java.util.Scanner(System.in).nextInt();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
	    return borrowedAmount;
    }
/**
*編集項目の選択を促すメソッド。
*@return  selected
*/
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
/**
*削除する本のISBMの入力を促すメソッド。
*@return deleteBook
*/
    //delete
    public String deleteBookUi(){
     	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
     	System.out.println("削除する本のISBMを入力してください");
        String deleteISBN = new java.util.Scanner(System.in).nextLine();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
	    return deleteISBN;
    }
/**
*削除する本のISBMの入力を促すメソッド。
*@return deleteBook
*/
    //貸入出
    public int employeeUi(){
     	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
     	System.out.println("従業員IDを入力してください");
        int employee = new java.util.Scanner(System.in).nextInt();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
	    return employee;
    }
/**
*貸出期限の入力を促すメソッド。
*@return bookPeriod
*/
    public int bookPeriodUi(){
     	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
     	System.out.println("貸出期限を入力してください");
        int bookPeriod = new java.util.Scanner(System.in).nextInt();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
	    return bookPeriod;
    }
/**
*書籍数の入力を促すメソッド。
*@return addInventory
*/
    public int addInventoryUi(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
     	System.out.println("書籍数を入力してください");
    	int addInventory = new java.util.Scanner(System.in).nextInt();
    	logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
	    return addInventory;
    }
/**
*書籍の貸出数の入力を促すメソッド。
*@return addBorrowedAmount
*/
    public int addBorrowedAmountUi(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
     	System.out.println("2.その書籍の貸出数を入力してください");
        int addBorrowedAmount = new java.util.Scanner(System.in).nextInt();
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
	    return addBorrowedAmount;
    }
/**
*ひとつ前のメニューに戻るか作業を続けるか選択するメソッド。
*@return returnMainMenu
*/
    public int returnMenuUi(){
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        int returnMainMenu = 0;
        int count = 0;
        do{
            count++;
            if(count>1){
                System.out.println("再度入力してください");
            }
            System.out.println("ひとつ前のメニューに戻る場合は１、作業を始める場合は２を入力してください");
            returnMainMenu = new java.util.Scanner(System.in).nextInt();
        }
        while(!(returnMainMenu == 1||returnMainMenu == 2));
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return returnMainMenu;
    }
}

import java.util.*;

public class UI{
	
    public void loginUI(){
        System.out.pritnln("ログイン画面");
        System.out.println("ログインしますか？それともパスワードの再設定をしますか？");
        System.out.println("1.ログイン  2.再設定");
    }

    public int resetPassUI(){
        System.out.println("パスワードを再設定しますか？");
        System.out.println("1,はい　2,いいえ");
        int ans = new java.util.Scanner(System.in).nextInt();
        return ans;
    }

    public int getEmpID(){
        System.out.print("従業員ID:");
        int empID = new java.util.Scanner(System.in).nextInt();
        return empID;
    }

    public String getPassword(){
        System.out.print("パスワード:");
        String empID = new java.util.Scanner(System.in).nextLine();
        return password;
    }

    public String getCheckPassword(){
        System.out.print("確認用パスワード:");
        String empID = new java.util.Scanner(System.in).nextLine();
        return checkPassword;
    }
    //MainMenuUI
     public int choiceMenuUI(){
        System.out.println("機能を選択してください");
        System.out.println("1,図書館利用者機能");
        System.out.println("2,図書館管理者機能");

        int choice = new java.util.Scanner(System.in).nextInt();
    }

    public int adminMenuUI(){
        System.out.println("メニュー画面");
            
		System.out.println("1，図書登録");
		System.out.println("2，図書削除");
		System.out.println("3，登録変更");
		System.out.println("4，貸出承認");
		System.out.println("5，返却受取");
		System.out.println("6，終了");
			
		System.out.println("メニュー番号を入力してください。");
		
        int selected = new java.util.Scanner(System.in).nextInt();
        
        return selected;
    }

    public int userMenuUI(){
        System.out.println("メニュー画面");
            
		System.out.println("1，図書検索");
        System.out.println("2，予約取消");
        System.out.println("3，終了");
			
		System.out.println("メニュー番号を入力してください。");
		
		int selected = new java.util.Scanner(System.in).nextInt();
    }
    //UserMenuUi.java
//インスタンスの生成
    private static UserMenu userMenu = new UserMenu();

    public static void userMenu(){
        int selected=0;
        System.out.println("検索する項目を選んでください");
        System.out.println("1.タイトル");
        System.out.println("2.著者");
        System.out.println("3.分野");
        String str = new java.util.Scanner(System.in).nextLine();
        selected = Integer.parseInt(str);
        switch(selected){
            case 1:
                searchBooksByTitleUI();
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
                break;
            case 2:
                searchBooksByAuthorUI();
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
                break;
            case 3:
                searchBooksByFieldUI();
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
                break;
        }
    }

  //書籍名で書籍の検索
    public static void searchBooksByTitleUI(){
        System.out.println("検索したいタイトル名を入力してください");
        String bookTitle = new java.util.Scanner(System.in).nextLine();
        for(int i = 0 ; i < userMenu.searchBooksByTitle(bookTitle).size() ; i++){
        	  System.out.println(userMenu.searchBooksByTitle(bookTitle).get(i).toString());
        }
    }

//著者名で書籍の検索
    public static void searchBooksByAuthorUI(){
        System.out.println("検索したい著者名を入力してください。");
        String bookAuthor = new java.util.Scanner(System.in).nextLine();
        ArrayList<Book> booksByAuthor = new ArrayList<Book>();
        booksByAuthor = userMenu.searchBooksByAuthor(bookAuthor);
        for(int i = 0 ; i < booksByAuthor.size() ; i++){
        	System.out.println(booksByAuthor.get(i).toString());
        }
    }

//分野で書籍の検索
    public static void searchBooksByFieldUI(){
        System.out.println("検索したい分野名を入力してください");
        String bookField = new java.util.Scanner(System.in).nextLine();
        for(int i = 0 ; i < userMenu.searchBooksByField(bookField).size() ; i++){
             System.out.println(userMenu.searchBooksByField(bookField).get(i).toString());
        }
    }

//ファイルの保存(書籍名)
    public static void saveBooksByTitleUI(){
        System.out.println("書籍を保存するファイル名を入力してください。");
        String saveFile = new java.util.Scanner(System.in).nextLine();
        userMenu.saveBooksByTitle(saveFile);
        }

//ファイルの保存(著者名)
    public static void saveBooksByAuthorsUI(){
        System.out.println("書籍を保存するファイル名を入力してください。");
        String saveFile = new java.util.Scanner(System.in).nextLine();
        userMenu.saveBooksByAuthors(saveFile);
        }

//ファイルの保存(分野)
    public static void saveBooksByFieldUI(){
        System.out.println("書籍を保存するファイル名を入力してください。");
        String saveFile = new java.util.Scanner(System.in).nextLine();
        userMenu.saveBooksByField(saveFile);
        }
//AdminMenuUi
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
     public int selectUi(){
     	System.out.println("書籍を追加する場合は１、削除する場合は２を入力してください。");
        int select = new java.util.Scanner(System.in).nextInt();
	    return select;
    }
    
    public int addInventoryUi(){
     	System.out.println("追加する書籍数を入力してください");
    	int addInventory = new java.util.Scanner(System.in).nextInt();
	    return addInventory;
	    
    }public int deInventoryUi(){
     	System.out.println("削除する書籍数を入力してください");
    	int deInventory = new java.util.Scanner(System.in).nextInt();
	    return deInventory;
	    
    }public long addBorrowedAmountUi(){
     	System.out.println("2.その書籍の貸出数を入力してください");
        int addBorrowedAmount = new java.util.Scanner(System.in).nextInt();
	    return addBorrowedAmount;
	    
    }
}

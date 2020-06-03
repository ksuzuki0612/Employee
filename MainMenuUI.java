import java.util.*;

public void MainMenuUI{

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

}
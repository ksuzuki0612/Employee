public class MainMenu{
    MainMenuUI menuUI = new MainMenu();
    AdminMenu adminMenu = new AdminMenu();
    UserMenu userMenu = new UserMenu();

    public void choiceMenu(){
        int choice = menuUI.choiceMenuUI();
        //1,利用者メニュー 2,管理者メニュー
        if(choice == 1){
            userMainMenu();
        }
        else if(choice == 2){
            adminMainMenu();
        }
        else{
            System.out.println("1か2を入力してください");
            choiceMenu();
        }
    }

    public void adminMainMenu(){
        //メニュー番号
		private static final int selectedAdmin1 = 1;
		private static final int selectedAdmin2 = 2;
		private static final int selectedAdmin3 = 3;
		private static final int selectedAdmin4 = 4;
		private static final int selectedAdmin5 = 5;
		private static final int selectedAdmin6 = 6;
		private static final int selectedAdmin7 = 7;
		private static final int selectedAdmin8 = 8;
        
        loop:while(true){
            int selected = menuUI.adminMenuUI();
			
		switch(selected){
			
        case selectedAdmin1:
            //図書登録
            adminMenu.resisterBook();            
            break;
        
        case selectedAdmin2:
            //図書削除
            adminMenu.deleteBook();
            break;
        
        case selectedAdmin3:
            //登録変更
            adminMenu.updataBook();
            break;
        
            case selectedAdmin4:
            //貸出承認
            adminMenu.allowBorrowBook();
            break;
        
        case selectedAdmin5:
            //返却申請
            adminMenu.returnBook();
            break;
        
        case selectedAdmin6:
            System.out.println("終了");
            break loop;
      	  }
 	   }
    }

    public void userMainMenu(){
        //メニュー番号
		private static final int selectedUser1 = 1;
		private static final int selectedUser2 = 2;
		private static final int selectedUser3 = 3;
        
        loop:while(true){
			int selected = menuUI.userMenuUI();
		switch(selected){
			
        case selectedUser1:
            System.out.println("1,図書検索");
            
            break;
        
        case selectedUser2:
            System.out.println("2，予約取消");
            break;
         
        case selectedUser3:
            System.out.println("終了");
            break loop;
      	  }
 	   }
    }
}
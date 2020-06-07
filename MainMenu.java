import java.text.ParseException;
import java.util.logging.Logger;

public class MainMenu{
	Logger logger = Logger.getLogger(PasswordList.class.getName());
    static UI menuUI = new UI();
    static AdminMenu adminMenu = new AdminMenu();
    static UserMenu userMenu = new UserMenu();

    public void choiceMenuAdmin() {
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        try {
            int choice = menuUI.choiceMenuUI();
            // 1,利用者メニュー 2,管理者メニュー
            if (choice == 1) {
                userMainMenu();
            } else if (choice == 2) {
                adminMainMenu();
            } else {
                System.out.println("1か2を入力してください");
                choiceMenuAdmin();
            }
        } 
        finally {
            logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        }
    }

    public void choiceMenuUser() {
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        try {
            int choice = menuUI.choiceMenuUI();
            // 1,利用者メニュー 2,管理者メニュー
            if (choice == 1) {
                userMainMenu();
            } else if (choice == 2) {
                System.out.println("管理者権限がありません");
                choiceMenuUser();
            } else {
                System.out.println("1か2を入力してください");
                choiceMenuUser();
            }
        } finally {
            logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        }
    }

    public static void adminMainMenu() {
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        try {
            // 管理者メニュー番号
            final int selectedAdmin1 = 1;
            final int selectedAdmin2 = 2;
            final int selectedAdmin3 = 3;
            final int selectedAdmin4 = 4;
            final int selectedAdmin5 = 5;
            final int selectedAdmin6 = 6;

            loop: while (true) {
                int selected = menuUI.adminMenuUI();

                switch (selected) {

                    case selectedAdmin1:
                        // 図書登録
                    adminMenu.registerBook();
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
        finally{
            logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        }
    }

    public static void userMainMenu(){
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        
        try{
            //メニュー番号
		    final int selectedUser1 = 1;
		    final int selectedUser2 = 2;
		    final int selectedUser3 = 3;
        
            loop:while(true){
			    int selected = menuUI.userMenuUI();
		        switch(selected){
                    case selectedUser1:
           	            menuUI.userMenu();
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
        finally{
            logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        }
    }
    
}
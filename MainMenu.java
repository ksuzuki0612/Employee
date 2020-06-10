
import java.util.logging.Logger;

/**
 * メインメニュークラス
 * @author 平松和貴
 * @see Login
 */
public class MainMenu{
	static Logger logger = Logger.getLogger( MainMenu.class.getName());
    static UI menuUI = new UI();
    static AdminMenu adminMenu = new AdminMenu();
    static UserMenu userMenu = new UserMenu();
    //static AdminMenuNum adMenu = new AdminMenuNum();
    
    /**
     * 管理者がメニューを選択するメソッド
     */
    public void choiceMenuAdmin() {
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        try {
            final int choice = menuUI.choiceMenuUI();
            // 1,利用者メニュー 2,管理者メニュー
            if (choice == 1) {
                userMainMenu();
            } else if (choice == 2) {
                adminMainMenu();
            } else {
                System.out.println("1か2を入力してください");
                menuUI.loginUI();
            }
        } finally {
            logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        }
    }

    /**
     * 一般利用者がメニューを選択するメソッド 利用者メニューのみ選択可能
     */
    public void choiceMenuUser() {
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        try {
            final int choice = menuUI.choiceMenuUI();
            // 1,利用者メニュー 2,管理者メニュー
            if (choice == 1) {
                userMainMenu();
            } else if (choice == 2) {
                System.out.println("管理者権限がありません");
                return;
            } else {
                System.out.println("1か2を入力してください");
                menuUI.loginUI();
            }
        } finally {
            logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        }
    }

    /**
     * 管理者メニューを選択するメソッド
     */
    public static void adminMainMenu() {
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        try {
            // 管理者メニュー番号
            /*
             * final int selectedAdmin1 = 1; final int selectedAdmin2 = 2; final int
             * selectedAdmin3 = 3; final int selectedAdmin4 = 4; final int selectedAdmin5 =
             * 5; final int selectedAdmin6 = 6;
             */

            loop: while (true) {
                final int selected = menuUI.adminMenuUI();

                switch (selected) {
                    case AdminMenuNum.RegisterBook:
                        // 図書登録
                        final int rb = menuUI.returnMenuUi();
                        if (rb == 1) {
                            break;
                        } else {
                            adminMenu.registerBook();
                            break;
                        }
                    case AdminMenuNum.DeleteBook:
                        // 図書削除
                        final int db = menuUI.returnMenuUi();
                        if (db == 1) {
                            break;
                        } else {
                            adminMenu.deleteBook();
                            break;
                        }
                    case AdminMenuNum.ChangeBookInfo:
                        // 登録変更
                        final int ub = menuUI.returnMenuUi();
                        if (ub == 1) {
                            break;
                        } else {
                            adminMenu.updataBook();
                            break;
                        }
                    case AdminMenuNum.LoanAproval:
                        // 貸出承認
                        final int abb = menuUI.returnMenuUi();
                        if (abb == 1) {
                            break;
                        } else {
                            adminMenu.allowBorrowBook();
                            break;
                        }
                    case AdminMenuNum.ReturnApplication:
                        // 返却申請
                        final int reb = menuUI.returnMenuUi();
                        if (reb == 1) {
                            break;
                        } else {
                            adminMenu.returnBook();
                            break;
                        }
                    case AdminMenuNum.EndProgram:
                        System.out.println("終了");
                        break loop;
                    default:
                        System.out.println("再度入力してください");
                        break;
                }
            }
        } finally {
            logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        }
    }

    /**
     * 利用者メニューを選択するメソッド
     */
    public static void userMainMenu() {
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());

        try {
            loop: while (true) {
                final int selected = menuUI.userMenuUI();
		        switch(selected){
                    case UserMenuNum.SearchBook:
                        final int sb = menuUI.returnMenuUi();
                        if (sb == 1) {
                        break;
                        } 
                        else {
                            menuUI.userMenu();
                            break;
                    }
                    case UserMenuNum.CancelReservation:
                        System.out.println("2，予約取消");
                        break;
         
                    case UserMenuNum.EndProgram:
                        System.out.println("終了");
                        break loop;
                    default:
                        System.out.println("再度入力してください");
                    break; 
      	            }
                }
        }
        finally{
            logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        }
    }
    
}
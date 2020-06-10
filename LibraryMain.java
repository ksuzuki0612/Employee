import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * メインクラス
 * 
 * @author 平松和貴
 * @see Login MainMenu
 */
public class LibraryMain {
    static Logger logger = Logger.getLogger(LibraryMain.class.getName());
    static UI mainUI = new UI();
    static Login login = new Login();
    static MainMenu mainMenu = new MainMenu();

    public static void main(final String[] args) throws SecurityException, IOException, SQLException {
        // Create a file handler object
        try {
            final FileHandler handler = new FileHandler("log.txt");
            handler.setFormatter(new SimpleFormatter());
            logger.addHandler(handler);
            // ログレベルの設定
            logger.setLevel(Level.FINER);

            final int loginChoice = login.begin();

            if (loginChoice == 1) {
                // login.loginCheck();
            } else if (loginChoice == 2) {
                boolean passChangeResult = login.resetPassword();
                login.resultChangePassword(passChangeResult);

            } else {
                System.out.println("1か2を選択してください");
                login.begin();
            }
            //二回目にloginCheck()を呼び出せてない
            final int checkEmpID = login.loginCheck();

            if (checkEmpID == 0) {
                System.out.println("IDとパスワードが一致していません");
                login.begin();
            }
            else{
                final boolean checkRight = login.checkRight(checkEmpID);
                
                if (checkRight == true) {
                    mainMenu.choiceMenuAdmin();
                } else {
                    mainMenu.choiceMenuUser();
                }
            }
        } catch (final ParseException e) {
            e.printStackTrace();
        }
        finally{
            logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        }
    }
}
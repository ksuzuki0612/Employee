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

    public static void main(final String[] args) throws SecurityException, IOException, SQLException,
            ClassNotFoundException {
        // Create a file handler object
        try {
            final FileHandler handler = new FileHandler("log.txt");
            handler.setFormatter(new SimpleFormatter());
            logger.addHandler(handler);
            // ログレベルの設定
            logger.setLevel(Level.FINER);

            int loginChoice = login.begin();
            int checkEmpID = login.menuResult(loginChoice);

            if (checkEmpID == 0) {
                System.out.println("ログインし直してください");
                login.begin();
            }
            else{
                boolean checkRight = login.checkRight(checkEmpID);
                
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
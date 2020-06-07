import java.io.IOException;
import java.util.function.Supplier;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
public class LibraryMain{
    static Logger logger = Logger.getLogger(LibraryMain.class.getName());
   

    public static void main(String[] args){
    	 // Create a file handler object 
        try{
            FileHandler handler 
            = new FileHandler("log.txt"); 
            handler.setFormatter(new SimpleFormatter()); 
            logger.addHandler(handler); 
            // ログレベルの設定
            logger.setLevel(Level.FINER);
        
            Login login = new Login();
            MainMenu mainMenu = new MainMenu();
            
            int loginChoice = login.login();

            if(loginChoice == 1){
                login.loginCheck();
            }
            else if(loginChoice == 2){
                login.resetPassword();
            }
            else{
                System.out.println("1か2を選択してください");
            }

            int checkEmpID = login.loginCheck();

            if(checkEmpID == 0){
                System.out.println("IDとパスワードが一致していません");
                login.loginCheck();
            }
            
            boolean checkRight = login.checkRight(checkEmpID);

            if(checkRight == true){
                mainMenu.choiceMenuAdmin();
            }
            else{
                mainMenu.choiceMenuUser();
            }

        }catch(IOException e){
        }
        finally{
            logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        }
    }
}
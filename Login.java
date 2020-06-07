import java.text.ParseException;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Login{
	Logger logger = Logger.getLogger(AdminMenu.class.getName());
    UI uiLogin = new UI();
	SqlMethod sqlmethod = new SqlMethod();
	
    public int login() throws ParseException {
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        try {
            uiLogin.loginUI();
            int loginChoice = new java.util.Scanner(System.in).nextInt();
            // ログイン=1,パスワードの再設定=2
            return loginChoice;
        }
        finally{
            logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        }
    }

    public int loginCheck(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        try{
            int empID = uiLogin.getEmpID();
            String password = uiLogin.getPassword();
            int checkEmpID = sqlmethod.dbCheckLogin(empID,password);

            return checkEmpID;
        }
        finally{
            logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        }
    }

    public boolean checkRight(int empID){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        try{
            int checkID = empID;
            boolean adminRight = sqlmethod.dbCheckRight(checkID);
            return adminRight;
        }
        finally{
            logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        }
    }

    public void resetPassword(){
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        try{
            System.out.println("パスワード再設定画面");
            int empID = uiLogin.getEmpID();
            String password = uiLogin.getPassword();
            String checkPassword = uiLogin.getCheckPassword();

            int ans = uiLogin.resetPassUI();
            //ans = 1 パスワードを再設定する
            if(ans == 1){
                if(password.equals(checkPassword)){
                    sqlmethod.dbUpdataPassword(empID,password);
                    System.out.println("パスワードが更新されました。");
                    login();
                }
            else{
                System.out.println("入力されたパスワードが一致していません。");
                login();
                }
            }
            //ans = 2:パスワードを再設定しない
            else if(ans == 2){
                login();
            }
            else{
                System.out.println("1か2を入力してください");
                resetPassword();
            }
        }
        catch(ParseException e){
    		e.printStackTrace();
	 	}
        finally{
            logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        }
    }


}
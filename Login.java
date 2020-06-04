import java.util.*;
import java.io.IOException;
import java.util.function.Supplier;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
public class Login{
	Logger logger = Logger.getLogger(AdminMenu.class.getName());
    UI uiLogin = new UI();
    MainMenu mainMenu = new MainMenu();
	SQL_method sqlmethod = new SQL_method();
	
    public void login(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        uiLogin.loginUI();

        int loginChoice = new java.util.Scanner(System.in).nextInt();
        //ログイン=1,パスワードの再設定=2
        if(loginChoice == 1){
            loginCheck();
        }
        else if(loginChoice == 2){
            resetPassword();
        }
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }

    public void loginCheck(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        int empID = uiLogin.getEmpID();
        String password = uiLogin.getPassword();
        int checkEmpID = sqlmethod.DBcheckLogin();

        if(checkEmpID == 0){
            System.out.println("IDとパスワードが一致していません");
        }
        else{
            checkRight(checkEmpID);
        }
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());

    }

    public void checkRight(int empID){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        int checkID = empID;
        //従業員リスト SQL
        int adminRight = sqlmethod.DBcheckRight();
        if(adminRight == 0){
            mainMenu.choiceMenuAdmin();
        }
        else{
            mainMenu.choiceMenuUser();
        }
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());

    }

    public void resetPassword(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        System.out.println("パスワード再設定画面");
        int empID = uiLogin.getEmpID();
        String password = uiLogin.getPassword();
        String checkPassword = uiLogin.getCheckPassword();

        int ans = uiLogin.resetPassword();
        //ans = 1 パスワードを再設定する
        if(ans == 1){
            if(password.equals(checkPassword)){
                //SQL文 パスワードを更新する
            }
            else{
                System.out.println("入力されたパスワードが一致していません");
                login();
            }
        }
        //ans = 2:パスワードを再設定しない
        else if(ans == 2){
            login();
        }
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }


}
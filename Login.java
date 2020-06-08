import java.text.ParseException;
import java.util.*;
import java.util.logging.Logger;

/**
 * ログインクラス
 * @author 平松和貴
 * @see LibarayMain
 */

public class Login{
	Logger logger = Logger.getLogger(AdminMenu.class.getName());
    UI uiLogin = new UI();
    SqlMethod sqlmethod = new SqlMethod();

    /**
     * このプログラムの最初のメソッド
     * ログインかパスワードの再設定を選択する
     * @return　loginChoice
     * @throws ParseException
     */
    public int begin() throws ParseException {
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
    /**
     * ログインのための従業員IDとパスワードを確認するメソッド
     * @return checkEmpId
     */
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

    /**
     * ユーザーが管理者権限を持っているかを確認するメソッド
     * @param empID
     * @return boolean adminRight
     */
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

    /**
     * パスワードをリセットするメソッド
     * パスワードの再設定が終わるとbegin()に戻る
     */
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
                    sqlmethod.dbUpdatePassword(empID, password);
                    System.out.println("パスワードが更新されました。");
                    begin();
                }
                else{
                    System.out.println("入力されたパスワードが一致していません。");
                    begin();
                    }
            }
            //ans = 2:パスワードを再設定しない
            else if(ans == 2){
                begin();
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
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Logger;

/**
 * ログインクラス
 * 
 * @author 平松和貴
 * @see LibarayMain
 */

public class Login {
    Logger logger = Logger.getLogger(AdminMenu.class.getName());
    UI uiLogin = new UI();
    SqlMethod sqlmethod = new SqlMethod();

    /**
     * このプログラムの最初のメソッド ログインかパスワードの再設定を選択する
     * 
     * @return loginChoice
     * @throws ParseException
     */
    public int begin() throws ParseException {
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        try {
            uiLogin.loginUI();
            final int loginChoice = new java.util.Scanner(System.in).nextInt();
            // ログイン=1,パスワードの再設定=2
            return loginChoice;
        } finally {
            logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        }
    }

    /**
     * ログインのための従業員IDとパスワードを確認するメソッド
     * 
     * @return checkEmpId
     * @throws SQLException
     */
    public int loginCheck() throws SQLException {
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        try{
            final int empID = uiLogin.getEmpID();
            final String password = uiLogin.getPassword();
            final int checkEmpID = sqlmethod.dbCheckLogin(empID,password);
//test
            return checkEmpID;
        }
        finally{
            logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        }
    }

    /**
     * ユーザーが管理者権限を持っているかを確認するメソッド
     * 
     * @param empID
     * @return boolean adminRight
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean checkRight(final int empID) throws ClassNotFoundException, SQLException {
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        try{
            final int checkID = empID;
            final boolean adminRight = sqlmethod.dbCheckRight(checkID);
            return adminRight;
        }
        finally{
            logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        }
    }

    /**
     * パスワードをリセットするメソッド パスワードの再設定が終わるとbegin()に戻る
     * 
     * @throws ParseException
     */
    public boolean resetPassword(){
        System.out.println("パスワード再設定画面");
        final int ans = uiLogin.resetPassUI();

        if(ans == 1){
            final int empID = uiLogin.getEmpID();
            final String password = uiLogin.getNewPassword();
            final String checkPassword = uiLogin.getCheckPassword();
            final boolean checkResult = checkResetPass(empID, password, checkPassword);
            return checkResult;
        }
        else{
            boolean checkResult = false;
            return checkResult;
        } 
    }

    public boolean checkResetPass(final int ID,final String pass,final String checkPass){
        final int empID = ID;
        final String password = pass;
        final String checkPassword = checkPass;

        if(password.equals(checkPassword)){
            sqlmethod.dbUpdatePassword(empID, password);
            return true;
        }
        else{
            return false;
            }
        }

        public void resultChangePassword(boolean checkResult) throws ParseException {
            boolean passChangeResult = checkResult;

            if(passChangeResult == true ){
                System.out.println("パスワードが更新されました"); //UI化
                begin();
            }
            else{
                System.out.println("パスワードは更新されていません");
                begin();
            }
        }
    }
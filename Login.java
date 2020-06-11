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
     * @throws SQLException
     */
    public int begin() throws SQLException {
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        try {
            uiLogin.loginUI(); //ログイン画面
            int ID = loginCheck();
            return ID;
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
            final int checkID = sqlmethod.dbCheckLogin(empID,password);
            int checkEmpID = checkResult(checkID);
            return checkEmpID;
        }
        finally{
            logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        }
    }

    public int checkResult(int ID) throws SQLException {
        if(ID == 0){
            System.out.println("IDまたはパスワードが間違っています");
            System.out.println("続ける場合は1,終了する場合は2を押してください");
            int choice = new java.util.Scanner(System.in).nextInt();

            if(choice == 1){
                loginCheck();
            }
            else{
                System.exit(0);
            }
        }
        return ID;
    }

    /**
     * ユーザーが管理者権限を持っているかを確認するメソッド
     * 
     * @param empID
     * @return boolean adminRight
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean checkRight(int empID) throws ClassNotFoundException, SQLException {
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
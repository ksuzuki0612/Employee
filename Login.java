import java.util.*;

public class Login{
    UI uiLogin = new LoginUI();
    MainMenu mainMenu = new MainMenu();

    public void login(){
        uiLogin.loginUI();

        int loginChoice = new java.util.Scanner(System.in).nextInt();
        //ログイン=1,パスワードの再設定=2
        if(loginChoice == 1){
            loginCheck();
            mainMenu.choiceMenu();
        }
        else if(loginChoice == 2){
            resetPassword();
        }

    }

    public void loginCheck(){
        int empID = uiLogin.getEmpID();
        String password = uiLogin.getPassword();
        //SQLからパスワードリストを受取
        //List PasswordList = SQL
        for(PasswordList p : passwordList){
            int compareEmpID = p.getEmpID();
            if(empID == compareEmpID){
                comparePass = p.getPassword();
                if(comparePass.equals(password)){
                    checkRight(empID);
                    break;
                }
                else{
                    System.out.println("IDとパスワードが一致しません");
                    break;
                }
            }
        }

    }

    public void checkRight(int empID){
        int empID = empID;
        //従業員リスト
        if(adminRight = true){
            mainMenu.choiceMenuAdmin();
        }
        else{
            mainMenu.choiceMenuUser();
        }

    }

    public void resetPassword(){
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
    }


}
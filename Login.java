import java.util.*;

public void Login{
    LoginUI uiLogin = new LoginUI();
    MainMenu mainMenu = new MainMenu();

    List<PasswordList> passwordList = new ArrayList<PasswordList>();

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
        
        for(PasswordList p : passwordList){
            int compareEmpID = p.getEmpID();
            if(empID == compareEmpID){
                checkID++;
                comparePass = p.getPassword();
                if(comparePass.equals(password)){
                    //機能選択
                    break;
                }
                else{
                    System.out.println("IDとパスワードが一致しません");
                    break;
                }
            }
        }

    }

    public void resetPassword(){
        System.out.println("パスワード再設定画面");
        int empID = uiLogin.getEmpID();
        String password = uiLogin.getPassword();
        String checkPassword = uiLogin.getCheckPassword();

        int ans = uiLogin.resetPassword();

        if(ans == 1){
            if(password.equals(checkPassword)){
                //SQL文
            }
            else{
                System.out.println("入力されたパスワードが一致していません");
                login();
            }
        }
        else if(ans == 2){
            login();
        }
    }


}
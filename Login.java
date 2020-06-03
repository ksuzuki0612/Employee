import java.util.*;

public void Login{
    LoginUI uiForMainMenu = new LoginUI();
    public void login(){
        uiForMainMenu.loginUI();

        int loginChoice = new java.util.Scanner(System.in).nextInt();

        if(loginChoice == 1){
            loginCheck();
        }

    }

    public void loginCheck(){
        int empID = uiForMainMenu.getEmpID();
        String password = uiForMainMenu.getPassword();

        

    }

    public void resetPassword(){
        //
    }


}
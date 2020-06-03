import java.util.*;

public void LoginUI{
    public void loginUI(){
        System.out.pritnln("ログイン画面");
        System.out.println("ログインしますか？それともパスワードの再設定をしますか？");
        System.out.println("1.ログイン  2.再設定");
    }

    public int resetPassUI(){
        System.out.println("パスワードを再設定しますか？");
        System.out.println("1,はい　2,いいえ");
        int ans = new java.util.Scanner(System.in).nextInt();
        return ans;
    }

    public int getEmpID(){
        System.out.print("従業員ID:");
        int empID = new java.util.Scanner(System.in).nextInt();
        return empID;
    }

    public String getPassword(){
        System.out.print("パスワード:");
        String empID = new java.util.Scanner(System.in).nextLine();
        return password;
    }

    public String getCheckPassword(){
        System.out.print("パスワード:");
        String empID = new java.util.Scanner(System.in).nextLine();
        return checkPassword;
    }

}
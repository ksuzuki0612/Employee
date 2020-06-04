import java.util.*;
import java.text.*;
import java.io.*;

public class UserMenuUI{
  //インスタンスの生成
    private static UserMenu userMenu = new UserMenu();

    public static void userMenu(){
        System.out.println("検索する項目を選んでください");
        System.out.println("1.タイトル");
        System.out.println("2.著者");
        System.out.println("3.分野");
        String str = new java.util.Scanner(System.in).nextLine();
        selected = Integer.parseInt(str);
        switch(selected){
            case 1:
                searchBooksByTitleUI();
                break;
            case 2:
                searchBooksByAuthorUI();
                break;
            case 3:
                searchBooksByFieldUI();
                break;
        }
    }

  //書籍名で書籍の検索
    public static void searchBooksByTitleUI(){
        System.out.println("検索したいタイトル名を入力してください");
        String bookTitle = new java.util.Scanner(System.in).nextLine();
        for(int i = 0 ; i < userMenu.searchBooksByTitle(bookTitle).size() ; i++){
        	  System.out.println(userMenu.searchBooksByTitle(bookTitle).get(i).toString());
        }
    }

//著者名で書籍の検索
    public static void searchBooksByAuthorUI(){
        System.out.println("検索したい著者名を入力してください。");
        String bookAuthor = new java.util.Scanner(System.in).nextLine();
        ArrayList<Book> booksByAuthor = new ArrayList<Book>();
        booksByAuthor = userMenu.searchBooksByAuthor(bookAuthor);
        for(int i = 0 ; i < booksByAuthor.size() ; i++){
        	System.out.println(booksByAuthor.get(i).toString());
        }
    }

//分野で書籍の検索
    public static void searchBooksByUI(){
        System.out.println("検索したい分野名を入力してください");
        String bookField = new java.util.Scanner(System.in).nextLine();
        for(int i = 0 ; i < userMenu.searchBooksByField(bookField).size() ; i++){
             System.out.println(userMenu.searchBooksByField(bookField).get(i).toString());
        }
    }

//ファイルの保存(書籍名)
    public static void saveBooksUI(){
        System.out.println("書籍を保存するファイル名を入力してください。");
        String saveFile = new java.util.Scanner(System.in).nextLine();
        userMenu.saveBooksByTitle(saveFile);
        }

//ファイルの保存(著者名)
    public static void saveBooksUI(){
        System.out.println("書籍を保存するファイル名を入力してください。");
        String saveFile = new java.util.Scanner(System.in).nextLine();
        userMenu.saveBooksByAuthors(saveFile);
        }

//ファイルの保存(分野)
    public static void saveBooksUI(){
        System.out.println("書籍を保存するファイル名を入力してください。");
        String saveFile = new java.util.Scanner(System.in).nextLine();
        userMenu.saveBooksByField(saveFile);
        }

}

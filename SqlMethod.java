import java.io.IOException;
import java.util.function.Supplier;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.*;
import java.sql.*;
import java.text.*;
/**
 * @ Sql methods for 書籍管理システム
 * @author Engler Mate Janos
 * @version 2.0
 * @since 1.0
 *
 */

public class SqlMethod{

    Logger logger = Logger.getLogger(AdminMenu.class.getName());
    final String url = "jdbc:mysql://localhost:3306/librarysystem" +
                        "?useUnicode=true&useJDBCCompliantTimezoneShift" +
                        "=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    final String userName = "MateEngler";
    final String pwd = "keyblade24";

    public void InitializeDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (Exception e) {

        }
    }


    /**
     * 書籍を登録するメソッド。
     * 各変数をDBのbookinfoに入れる
     *
     */

    public  void registerBook(String ISBN, String title, String publisher,
                                    String publishDate, String field, List<String> authors,
                                    int inventory, int borrowedAmount){

        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());

        try{

            String query =
            "INSERT INTO bookinfo (ISBN," +
            "title,"+
            "publisher,"+
            "publish_date,"+
            "category," +
            "author,"+
            "inventory," +
            "borrowed)"+
            "VALUES" +
            "('" + ISBN + "',"+
            " '" + title + "',"+
            " '" + publisher + "',"+
            " '" + publishDate + "',"+
            " '" + field + "',"+
            " '" + authors + "',"+
            " '" + inventory + "',"+
            " '" + borrowedAmount + "');";

            
            Connection con = DriverManager.getConnection(url, userName, pwd);
            Statement st = con.createStatement();
            int count = st.executeUpdate(query);

            System.out.println("書籍は登録されました。");
            st.close();
            con.close();
            }catch(Exception e) { System.out.println(e);}

            finally{
                    logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
                }

    }
    /**
     * 書籍を貸出承認メソッド
     * 書籍が全部貸出されたら終わる。
     * 従業員は既に10冊を貸出しているなら貸出不可能
     *

     */

     public void borrowBook(String isbn){

        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	Scanner keyboard = new Scanner(System.in);
        try{

            String query = "SELECT title, borrowed, inventory "+
                            "FROM bookinfo "+
                            "WHERE"+
                            " ISBN = '" + isbn + "'";
            String query2 = "SELECT COUNT('ISBN') FROM bookinfo"+
                            " WHERE"+
                            " ISBN ='" + isbn + "'  ";
            
            
            Connection con = DriverManager.getConnection(url, userName, pwd);
            
            Statement st2 = con.createStatement();
            ResultSet rs2 = st2.executeQuery(query2);
            rs2.next();
            int isbncheck = rs2.getInt(1);

            if(isbncheck == 0){
                System.out.println("探している本がありません。");
            }else{

                Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            int inv = rs.getInt("inventory");
            int out = rs.getInt("borrowed");
            String title =rs.getString("title");

            if (inv <= out){
                System.out.println("探している図書は貸出中です。 ");
            }else {
                System.out.println("従業員IDを入力してください。");
                int id = keyboard.nextInt();
                keyboard.nextLine();
                System.out.println("貸出開始日を入力してください(YYYY-MM-dd)。");
                String start = keyboard.nextLine();
                //keyboard.nextLine();
                System.out.println("貸出終了日を入力してください(YYYY-MM-dd)。");
                String end = keyboard.nextLine();
                //keyboard.close();

                String query3 = "SELECT employee_name FROM employee"+
                                " WHERE"+
                                " employee_id = '" + id + "'";
                Statement st3 = con.createStatement();
                ResultSet rs3 = st3.executeQuery(query3);
                rs3.next();
                String ename = rs3.getString("employee_name");

                String query4 ="SELECT COUNT('employee_name') FROM checkout WHERE employee_id='" + id + "'  ";
                Statement st4 = con.createStatement();
                ResultSet rs4 = st4.executeQuery(query4);
                rs4.next();
                int empcount = rs4.getInt(1);

                if(empcount == 10){
                    System.out.println("One employee can only borrow 10 books maximum!");
                }else{
                    String query5 =
                    "INSERT INTO checkout (ISBN,"+
                    " title,"+
                    " employee_id,"+
                    " employee_name,"+
                    " borrowed_from,"+
                    " borrowed_until)"+
                    " VALUES"+
                    " ('" + isbn + "',"+
                    " '" + title + "', "+
                    "'" + id + "', "+
                    "'" + ename + "',"+
                    " '" + start + "', '" + end + "')";

                    Statement st5 = con.createStatement();
                    int count = st5.executeUpdate(query5);

                    String query6 ="UPDATE bookinfo SET borrowed =borrowed+1 WHERE ISBN='" + isbn + "'";
                    Statement st6 = con.createStatement();
                    int count2 = st6.executeUpdate(query6);

                    System.out.println("書籍の貸出は承認されました。");
                    }

                }

            st.close();
            con.close();
            }

            
            
            
            }catch(Exception e) { System.out.println(e);}

            finally{
                    logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
                }

    }
    /**
     * @author Kazutaka Hiramatsu
     * ログインする時従業員IDとパスワードを確認するメソッド
     *
     */

    public int dbCheckLogin(int empID, String password) throws SQLException {
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        
    try{
        Connection con = DriverManager.getConnection(url, userName, pwd); 
         
        int ID = empID;
        String pass = password;

        String query = "SELECT COUNT('employee_id') FROM passwords WHERE"+
                        " employee_id='" + ID + "'&& password = '"+ pass + "'  ";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();
        int empcount = rs.getInt(1);
        st.close();
        con.close();

        if(empcount == 0){
            return 0;
        }
        else{
            return ID;
        }         
    }
    finally{
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }
}

    /**
     * @author Kazutaka Hiramatsu
     * ログインの後、利用者は管理者権限があるか否確認するメソッド
     *
    */

    public boolean dbCheckRight(int empID) throws ClassNotFoundException, SQLException {
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    try{
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, userName, pwd); 

        int checkID = empID;

        String query = "SELECT administrator_right FROM employee WHERE"+
                        " employee_id='" + checkID + "'";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();
        String admin = rs.getString("administrator_right");
        String check = "Y";
        st.close();
        con.close();
        if(admin.equals(check)){
            return true;
        }
        else{
            return false;
        }
    }
    finally{
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }
}
    /**
     * 書籍を著者ごと検索するメソッド
     *
     */

    public List<Book> searchAuthor(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        Scanner keyboard = new Scanner(System.in);
        System.out.println("著者名を入力してください。");
        String author = keyboard.nextLine();
        List<Book> books = new ArrayList<Book>();
        
        try{

            String query =  "SELECT ISBN, title, publisher, publish_date, category, author, inventory, borrowed"+
                            " FROM bookinfo "+
                            "WHERE"+
                            " author LIKE '%"+ author +"%'";
            String query2 = "SELECT COUNT('author') FROM bookinfo"+
                            " WHERE"+
                            " author LIKE '%"+ author +"%'";

            
            Connection con = DriverManager.getConnection(url, userName, pwd);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            Statement st2 = con.createStatement();
            ResultSet rs2 = st2.executeQuery(query2);
            rs2.next();
            int authorCount = rs2.getInt(1);
            
            if(authorCount == 0){
                System.out.println("探している著者の本がありません。");
            }else{

                String bookData = "";
            
            while(rs.next()){
                Book book = new Book(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getDate(4),
                    rs.getString(5),
                    this.splitList(rs.getString(6)),
                    rs.getInt(7),
                    rs.getInt(8));
                books.add(book);
               }
            }
            
            

        }catch(Exception e) { 
            System.out.println(e);
        }finally{
            logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        }
        return books;

    }


    /**
     * 書籍を分野ごと検索メソッド
     *
     */

     public List<Book> searchField(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        Scanner keyboard = new Scanner(System.in);
        System.out.println("分野を入力してください。");
        String searchField = keyboard.nextLine();
        List<Book> books = new ArrayList<Book>();

        try{

            String query = "SELECT * FROM bookinfo "+
                            "WHERE"+
                            " category LIKE '%"+ searchField +"%'";
            String query2 = "SELECT COUNT('category') FROM bookinfo"+
                            " WHERE"+
                            " category LIKE '%"+ searchField +"%'";
            

            
            Connection con = DriverManager.getConnection(url, userName, pwd);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            Statement st2 = con.createStatement();
            ResultSet rs2 = st2.executeQuery(query2);
            rs2.next();
            int categoryCount = rs2.getInt(1);

            if(categoryCount == 0){
                System.out.println("探している分野の本がありません。");
            }else{

                String bookData = "";

            while(rs.next()){
                Book book = new Book(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getDate(4),
                    rs.getString(5),
                    this.splitList(rs.getString(6)),
                    rs.getInt(7),
                    rs.getInt(8));
                books.add(book);
               }
            }
            
            

        }catch(Exception e) { 
            System.out.println(e);
        }finally{
            logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        }
        return books;
    }

    
    /**
     * 書籍をタイトルごと検索メソッド
     *
     */

     public List<Book> searchTitle(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());

        Scanner keyboard = new Scanner(System.in);
        System.out.println("タイトルを入力してください。");
        String searchtitle = keyboard.nextLine();
        List<Book> books = new ArrayList<Book>();
        //keyboard.close();

        try{
            String query = "SELECT * FROM bookinfo"+
                            " WHERE"+
                            " title LIKE '%"+ searchtitle +"%'";
            String query2 = "SELECT COUNT('title') FROM bookinfo"+
                            " WHERE"+
                            " title LIKE '%"+ searchtitle +"%'";

            
            Connection con = DriverManager.getConnection(url, userName, pwd);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            Statement st2 = con.createStatement();
            ResultSet rs2 = st2.executeQuery(query2);
            rs2.next();
            int titleCount = rs2.getInt(1);

            if(titleCount == 0){
                System.out.print("探している本がありません。");
            }else{

                //String bookData = "";

            while(rs.next()){
                Book book = new Book(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getDate(4),
                    rs.getString(5),
                    this.splitList(rs.getString(6)),
                    rs.getInt(7),
                    rs.getInt(8));
                books.add(book);
              }
            }
            
            

        } catch(Exception e) {
            System.out.println(e);
        
        } finally {
            logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());

        }

        return books;
    }

    public List<String> splitList(String authors){
        String str = authors;
        String[] authorsArray = str.split(",",0);
        List<String> authorsList = Arrays.asList(authorsArray);
        return authorsList;
    }

    /*public List getSearchRecordTitle(){
        return searchRecordTitle;
    }
    */
    /**
     * 貸出書籍を返却するメソッド
     * 入力されたISBNと従業員IDと一致する行を貸出中のDBから削除する
     *
     */

     public void returnBook(String isbn,int id){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());

        try{

            String query = "DELETE FROM checkout "+
                            "WHERE"+
                            " employee_id = " + id + " && ISBN = " + isbn + ";";

            String query2 ="UPDATE bookinfo SET borrowed = borrowed -1 "+
                            "WHERE "+
                            "ISBN = " + isbn + ";";

            
            Connection con = DriverManager.getConnection(url, userName, pwd);
            Statement st = con.createStatement();
            int count = st.executeUpdate(query);

            Statement st2 = con.createStatement();
            int count2 = st.executeUpdate(query2);

            System.out.println("書籍の貸出は削除されました。");

            st.close();
            con.close();
            }catch(Exception e) { System.out.println(e);}

            finally{
                    logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
                }

    }

    public void deleteBook(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        Scanner keyboard = new Scanner(System.in);
        System.out.println("削除したい書籍のISBNを入力してください。 ");
        String isbn = keyboard.nextLine();
        keyboard.nextLine();

        try{

            
            String query = "SELECT COUNT('ISBN') FROM bookinfo"+
                            " WHERE"+
                            " ISBN='" + isbn + "'  ";
            String query2 = "DELETE FROM bookinfo "+
                            "WHERE"+
                            " ISBN = '" + isbn + "'";
            
            Connection con = DriverManager.getConnection(url, userName, pwd);
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            int delete = rs.getInt(1);
            
            if(delete == 0){
                System.out.println("削除したい本がありません。");
            }else{

                Statement st2 = con.createStatement();
            int count = st2.executeUpdate(query2);

            System.out.println("書籍は削除されました。");
            st.close();
            con.close();
            }                       
                }catch(Exception e) { System.out.println(e);}

            finally{
                    logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        }
    }

    /**
     * 書籍の在庫数を更新するメソッド
     *
     */

      public void dbUpdataInventory(String ISBN,int Inventory ){
      	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        try{

            
            String query = "SELECT COUNT('title') FROM bookinfo"+
                            " WHERE"+
                            " ISBN='" + ISBN + "'  ";
            String query2 = "UPDATE bookinfo SET inventory = '" + Inventory + "' "+
                            "WHERE"+
                            " ISBN = '" + ISBN +"'";
            
            Connection con = DriverManager.getConnection(url, userName, pwd);
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            int update = rs.getInt(1);

            if(update == 0){
                System.out.println("更新したい本がありません。");
            }else{

                Statement st2 = con.createStatement();
                int count = st2.executeUpdate(query2);

                System.out.println("在庫数は更新されました。");
                st.close();
                con.close();
                }
            
            
            }catch(Exception e) { System.out.println(e);}

            finally{
                    logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
                }
    }
    /**
     * 書籍の貸出数を更新するメソッド
     *
     */

     public void dbAddBorrowedAmount(String ISBN,int addBorrowedAmount ){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());

        try{

            String query = "SELECT COUNT('title') FROM bookinfo"+
                            " WHERE"+
                            " ISBN='" + ISBN + "'  ";
            String query2 = "UPDATE bookinfo SET borrowed = '" + addBorrowedAmount + "' "+
                            "WHERE"+
                            " ISBN = '" + ISBN +"'";

            
            Connection con = DriverManager.getConnection(url, userName, pwd);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            int update = rs.getInt(1);

            if(update == 0){
                System.out.println("更新したい本がありません。");
            }else{

                Statement st2 = con.createStatement();
                int count = st.executeUpdate(query2);

                System.out.println("貸出数は更新されました。");
                st.close();
                con.close();
                }

            
            }catch(Exception e) { System.out.println(e);}

            finally{
                    logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
                }

    }
    /**
     * パスワードを更新するメソッド
     *
     */

     public void dbUpdatePassword(int empID,String password){

        try{

            String query = "SELECT COUNT('employee_id') FROM passwords"+
                            " WHERE"+
                            " employee_id = '" + empID + "'  ";
            String query2 = "UPDATE passwords SET password = '" + password + "'"+
                            " WHERE"+
                            " employee_id = '" + empID +"'";

        
        Connection con = DriverManager.getConnection(url, userName, pwd);
        
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();
        int update = rs.getInt(1);

        if(update == 0){
            System.out.println("従業員が存在しません。");
        }else{

            Statement st2 = con.createStatement();
            int count = st2.executeUpdate(query2);


            st.close();
            con.close();
            }

        
        
        }catch(Exception e) { System.out.println(e);}
    }

}

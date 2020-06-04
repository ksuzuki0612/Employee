import java.util.*;
import java.sql.*;
import java.text.*;

public class SQL_method{
    public static void sqlRegister(){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter ISBN");
        long isbn = keyboard.nextLong();
        keyboard.nextLine();
        System.out.println("Enter title");
        String title = keyboard.nextLine();
        System.out.println("Enter publisher");
        String publisher = keyboard.nextLine();
        
        System.out.println("Enter publish date (as YYYY-MM-dd)");
        String pubdate = keyboard.nextLine(); 
        System.out.println("Enter field");
        String field = keyboard.nextLine();
        System.out.println("Enter authors(s)");
        String author = keyboard.nextLine();
        System.out.println("Enter inventory number");
        int inventory = keyboard.nextInt();
        int borrowed = 0;
        keyboard.close();
        

        try{
            String url = "jdbc:mysql://localhost:3306/書籍管理システム?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String userName = "root";
            String pwd = "password1234";
            String query = "INSERT INTO bookinfo (ISBN, title, publisher, publish_date, field_, author, inventory, borrowed) VALUES ('" + isbn + "', '" + title + "', '" + publisher + "', '" + strDate + "', '" + field + "', '" + author + "', '" + inventory + "', '" + borrowed + "');";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, pwd); 
            Statement st = con.createStatement();
            int count = st.executeUpdate(query);

            System.out.println(count + " row(s) affected");
            st.close();
            con.close();
            }catch(Exception e) { System.out.println(e);}
    }

    public static void borrowbook(){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter ISBN.");
        long isbn = keyboard.nextLong();
        keyboard.nextLine();
        

        try{
            String url = "jdbc:mysql://localhost:3306/書籍管理システム?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String userName = "root";
            String pwd = "password1234";
            String query = "SELECT * FROM bookinfo WHERE ISBN = '" + isbn + "'";
            //String query2 ="SELECT * FROM employee WHERE employee_id = '" + empid + "'";
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, pwd); 
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            int inv = rs.getInt("inventory");
            int out = rs.getInt("borrowed");
            String title =rs.getString("title");

            if (inv <= out){
                System.out.println("No copy available to borrow ");
            }else {
                System.out.println("Please enter employee id.");
                int id = keyboard.nextInt();
                keyboard.nextLine();
                System.out.println("Please enter start date.");
                String start = keyboard.nextLine();
                //keyboard.nextLine();
                System.out.println("Please enter end date.");
                String end = keyboard.nextLine();
                keyboard.close();
                
                String query2 ="SELECT * FROM employee WHERE employee_id = '" + id + "'";
                Statement st2 = con.createStatement();
                ResultSet rs2 = st2.executeQuery(query2);
                rs2.next();
                String ename = rs2.getString("employee_name");
                
                String query3 ="INSERT INTO checkout (ISBN, title, employee_id, employee_name, borrowed_from, borrowed_until) VALUES ('" + isbn + "', '" + title + "', '" + id + "', '" + ename + "', '" + start + "', '" + end + "')";
                Statement st3 = con.createStatement();
                int count = st3.executeUpdate(query3);
                
                String query4 ="UPDATE bookinfo SET borrowed =borrowed+1 WHERE ISBN='" + isbn + "'";
                Statement st4 = con.createStatement();
                int count2 = st4.executeUpdate(query4);                                                 
            }
                     
            st.close();
            con.close();
            }catch(Exception e) { System.out.println(e);}
    }
    public static void DBcheckLogin(int empID,String password){
            
        try{
            String url = "jdbc:mysql://localhost:3306/書籍管理システム?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String userName = "root";
            String pwd = "password1234";
            Connection con = DriverManager.getConnection(url, userName, pwd); 
            Statement st = con.createStatement();
            
            int empID = empID;
            String password = password;
    
            PreparedStatement pstmt = con.PreparedStatement("SELECT*FROM passwordlist WHERE emmployee_id=?,password = ?");
            pstmt.setInt(1,empID);
            pstmt.setString(2,password);
    
            ResultSet rs = pstmt.executeQuery();
    
            if(rs == null){
                return 0;
            }
            else{
                return empID;
            }


            System.out.println(count + " row(s) affected");
            keyboard.close();
            st.close();
            con.close();
            }catch(Exception e) { System.out.println(e);}



    }
    public static boolean DBcheckRight(int empID){
            
        try{
            String url = "jdbc:mysql://localhost:3306/書籍管理システム?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String userName = "root";
            String pwd = "password1234";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, pwd); 

            int checkID = empID;

            PreparedStatement pstmt = con.PreparedStatement("SELECT administrator right FROM employee WHERE emmployee_id=?");
            pstmt.setInt(1,checkID);

            ResultSet right = pstmt.executeQuery();

            if(right == Y){
                return true;
            }
            else{
                return false;
            }

            st.close();
            con.close();
            }catch(Exception e) { System.out.println(e);}
    }
    public static void SQLsearchAuthor(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter author.");
        String author = keyboard.nextLine();
        keyboard.close();

        try{
            String url = "jdbc:mysql://localhost:3306/書籍管理システム?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String userName = "root";
            String pwd = "password1234";
            String query = "SELECT * FROM bookinfo WHERE author = '" + author + "'";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, pwd); 
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            String bookData = "";

            List searchRecord = new ArrayList<>();

            while(rs.next()){
                List values = new ArrayList<>();
                values.add(rs.getLong(1));//isbn
                values.add(rs.getString(2));//title
                values.add(rs.getString(3));//publisher
                values.add(rs.getDate(4));//publish date
                values.add(rs.getString(5));//field
                values.add(rs.getString(6));//author
                values.add(rs.getInt(7));//inventory
                values.add(rs.getInt(8));//lent out
                searchRecord.add(values);
                System.out.println("ISBN   Title   Publisher   Publishdate    Field    Author   Inventory   Lent out");
                bookData =  rs.getLong(1) +  rs.getString(2) + rs.getString(3) + rs.getDate(4) + rs.getString(5) + rs.getString(6) + rs.getInt(7) + rs.getInt(8) ;
                System.out.println(bookData);
            }

        }catch(Exception e) { System.out.println(e);}

    }
    public static void SQLsearchField(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter field.");
        String searchField = keyboard.nextLine();
        keyboard.close();

        try{
            String url = "jdbc:mysql://localhost:3306/書籍管理システム?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String userName = "root";
            String pwd = "password1234";
            String query = "SELECT * FROM bookinfo WHERE field_ = '" + searchField + "'";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, pwd); 
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            String bookData = "";

            List searchRecord = new ArrayList<>();

            while(rs.next()){
                List values = new ArrayList<>();
                values.add(rs.getLong(1));//isbn
                values.add(rs.getString(2));//title
                values.add(rs.getString(3));//publisher
                values.add(rs.getDate(4));//publish date
                values.add(rs.getString(5));//field
                values.add(rs.getString(6));//author
                values.add(rs.getInt(7));//inventory
                values.add(rs.getInt(8));//lent out
                searchRecord.add(values);
                System.out.println("ISBN   Title   Publisher   Publishdate    Field    Author   Inventory   Lent out");
                bookData =  rs.getLong(1) +  rs.getString(2) + rs.getString(3) + rs.getDate(4) + rs.getString(5) + rs.getString(6) + rs.getInt(7) + rs.getInt(8) ;
                System.out.println(bookData);
            }

        }catch(Exception e) { System.out.println(e);}


    }
    public static void SQLsearch(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter title.");
        String searchtitle = keyboard.nextLine();
        keyboard.close();
        
        try{
            String url = "jdbc:mysql://localhost:3306/書籍管理システム?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String userName = "root";
            String pwd = "password1234";
            String query = "SELECT * FROM bookinfo WHERE title = '" + searchtitle + "'";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, pwd); 
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            String bookData = "";

            List searchRecord = new ArrayList<>();

            while(rs.next()){
                List values = new ArrayList<>();
                values.add(rs.getLong(1));//isbn
                values.add(rs.getString(2));//title
                values.add(rs.getString(3));//publisher
                values.add(rs.getDate(4));//publish date
                values.add(rs.getString(5));//field
                values.add(rs.getString(6));//author
                values.add(rs.getInt(7));//inventory
                values.add(rs.getInt(8));//lent out
                searchRecord.add(values);
                System.out.println("ISBN   Title   Publisher   Publishdate    Field    Author   Inventory   Lent out");
                bookData =  rs.getLong(1) +  rs.getString(2) + rs.getString(3) + rs.getDate(4) + rs.getString(5) + rs.getString(6) + rs.getInt(7) + rs.getInt(8) ;
                System.out.println(bookData);
            }

        }catch(Exception e) { System.out.println(e);}


    }
    public static void returnbook(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter ISBN");
        long isbn = keyboard.nextLong();
        keyboard.nextLine();
        System.out.println("Enter id");
        int id = keyboard.nextInt();
        try{
            String url = "jdbc:mysql://localhost:3306/書籍管理システム?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String userName = "root";
            String pwd = "password1234";
            String query = "DELETE FROM checkout WHERE employee_id = " + id + " && ISBN = " + isbn + ";";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, pwd); 
            Statement st = con.createStatement();
            int count = st.executeUpdate(query);

            System.out.println(count + " row(s) affected");
            keyboard.close();
            st.close();
            con.close();
            }catch(Exception e) { System.out.println(e);}
    }
    public static deleteBook(){ 
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter ISBN you wish to delete. ");
        long isbn = keyboard.nextLong();
        keyboard.close();
        
        try{
            String url = "jdbc:mysql://localhost:3306/書籍管理システム?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String userName = "root";
            String pwd = "password1234";
            String query = "DELETE FROM bookinfo WHERE ISBN = '" + isbn + "'";
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, pwd); 
            Statement st = con.createStatement();
            int count = st.executeUpdate(query);  
        
            System.out.println(count + " row(s) affected");
            st.close();
            con.close();
            }catch(Exception e) { System.out.println(e);}  


    }

}
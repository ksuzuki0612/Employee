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

public class SqlMethod{
	Logger logger = Logger.getLogger(AdminMenu.class.getName());
	List searchRecordTitle = new ArrayList<>();
	List searchRecordField = new ArrayList<>();
	List searchRecordAuthor = new ArrayList<>();
    final String url = "jdbc:mysql://localhost:3306/librarysystem" +
                        "?useUnicode=true&useJDBCCompliantTimezoneShift" + 
                        "=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    final String userName = "MateEngler";
    final String pwd = "password1234";
    
    //Class.forName("com.mysql.cj.jdbc.Driver");
   
    public  void sqlRegister(long ISBN, String title, String publisher, 
                                    String publishDate, String field, List<String> authors,
                                    int inventory, int borrowedAmount){
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        try{
            
            String query = "INSERT INTO bookinfo (ISBN," +
                                                "title,"+ 
                                                "publisher,"+
                                                "publish_date,"+ 
                                                "field_," +
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

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, pwd); 
            Statement st = con.createStatement();
            int count = st.executeUpdate(query);

            System.out.println(count + " row(s) affected");
            st.close();
            con.close();
            }catch(Exception e) { System.out.println(e);}
            logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }

    public void borrowBook(long isbn){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	Scanner keyboard = new Scanner(System.in);
        try{
            
            String query = "SELECT * FROM bookinfo "+
                            "WHERE"+
                            " ISBN = '" + isbn + "'";
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
                
                String query2 ="SELECT * FROM employee"+
                                 "WHERE"+
                                 " employee_id = '" + id + "'";
                Statement st2 = con.createStatement();
                ResultSet rs2 = st2.executeQuery(query2);
                rs2.next();
                String ename = rs2.getString("employee_name");
                
                String query3 ="INSERT INTO checkout (ISBN,"+
                                                    " title,"+
                                                    " employee_id,"+
                                                    " employee_name,"+
                                                    " borrowed_from,"+
                                                    " borrowed_until) "+
                                                    "VALUES "+
                                                    "('" + isbn + "',"+
                                                    " '" + title + "',"+
                                                    " '" + id + "',"+
                                                    " '" + ename + "',"+
                                                    " '" + start + "',"+
                                                    " '" + end + "')";
                Statement st3 = con.createStatement();
                int count = st3.executeUpdate(query3);
                
                String query4 ="UPDATE bookinfo SET borrowed =borrowed+1 "+
                                "WHERE "+
                                "ISBN='" + isbn + "'";
                Statement st4 = con.createStatement();
                int count2 = st4.executeUpdate(query4);                                                 
            }
                     
            st.close();
            con.close();
            }catch(Exception e) { System.out.println(e);}
            logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }
    public int dbCheckLogin(int empID,String password){
            logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
            Scanner keyboard = new Scanner(System.in);
        try{
            
            Connection con = DriverManager.getConnection(url, userName, pwd); 
            Statement st = con.createStatement();
            
            int ID = empID;
            String pass = password;
    
            PreparedStatement pstmt = con.PreparedStatement("SELECT*FROM passwordlist "+
                                                            "WHERE"+
                                                            " emmployee_id=?,password = ?");
            pstmt.setInt(1,ID);
            pstmt.setString(2,pass);
    
            ResultSet rs = pstmt.executeQuery();
    
            if(rs == null){
                return 0;
            }
            else{
                return ID;
            }


            System.out.println(count + " row(s) affected");
            keyboard.close();
            st.close();
            con.close();
            }catch(Exception e) { System.out.println(e);}
            logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());



    }
    public boolean dbCheckRight(int empID){
            logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, pwd); 

            int checkID = empID;

            PreparedStatement pstmt = con.PreparedStatement("SELECT administrator_right FROM employee"+
                                                            " WHERE"+
                                                            " employee_id=?");
            pstmt.setInt(1,checkID);

            ResultSet right = pstmt.executeQuery();
            String check = "Y";

            if(right.equals(check)){
                return true;
            }
            else{
                return false;
            }

            st.close();
            con.close();
            }catch(Exception e) { System.out.println(e);}
            logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }
    public void sqlSearchAuthor(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter author.");
        String author = keyboard.nextLine();
        keyboard.close();

        try{
           
            String query = "SELECT * FROM bookinfo "+
                            "WHERE"+
                            " author = '" + author + "'";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, pwd); 
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            String bookData = "";

           

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
                searchRecordAuthor.add(values);
                System.out.println("ISBN   Title   Publisher   Publishdate    "+
                                    "Field    Author   Inventory   Lent out");
                bookData =  rs.getLong(1) +  rs.getString(2) + rs.getString(3) + rs.getDate(4) + 
                            rs.getString(5) + rs.getString(6) + rs.getInt(7) + rs.getInt(8) ;
                System.out.println(bookData);
            }

        }catch(Exception e) { System.out.println(e);}
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());

    }

    public List getSearchRecordAuthor(){
        return searchRecordAuthor;
    }

    public void sqlSearchField(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter field.");
        String searchField = keyboard.nextLine();
        keyboard.close();

        try{
           
            String query = "SELECT * FROM bookinfo "+
                            "WHERE"+
                            " field_ = '" + searchField + "'";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, pwd); 
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            String bookData = "";

         

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
                searchRecordField.add(values);
                System.out.println("ISBN   Title   Publisher   Publishdate   "+
                                    " Field    Author   Inventory   Lent out");
                bookData =  rs.getLong(1) +  rs.getString(2) + rs.getString(3) + rs.getDate(4) +
                            rs.getString(5) + rs.getString(6) + rs.getInt(7) + rs.getInt(8) ;
                System.out.println(bookData);
            }

        }catch(Exception e) { System.out.println(e);}
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());


    }

    public List getSearchRecordField(){
        return searchRecordField;
    }

    public void sqlSearch(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	 
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter title.");
        String searchtitle = keyboard.nextLine();
        keyboard.close();
        
        try{
            
            String query = "SELECT * FROM bookinfo"+
                            " WHERE"+
                            " title = '" + searchtitle + "'";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, pwd); 
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            String bookData = "";

           

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
                searchRecordTitle.add(values);
                System.out.println("ISBN   Title   Publisher   Publishdate "+
                                    "   Field    Author   Inventory   Lent out");
                bookData =  rs.getLong(1) +  rs.getString(2) + rs.getString(3) + rs.getDate(4) + 
                            rs.getString(5) + rs.getString(6) + rs.getInt(7) + rs.getInt(8) ;
                System.out.println(bookData);
            }

        }catch(Exception e) { System.out.println(e);}
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());

    }

    public List getSearchRecordTitle(){
        return searchRecordTitle;
    }

    public void sqlReturnbook(long isbn,int id){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	Scanner keyboard = new Scanner(System.in);
        try{
           
            String query = "DELETE FROM checkout "+
                            "WHERE"+
                            " employee_id = " + id + " && ISBN = " + isbn + ";";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, pwd); 
            Statement st = con.createStatement();
            int count = st.executeUpdate(query);

            System.out.println(count + " row(s) affected");
            keyboard.close();
            st.close();
            con.close();
            }catch(Exception e) { System.out.println(e);}
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }
    public void sqlDeleteBook(){ 
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter ISBN you wish to delete. ");
        long isbn = keyboard.nextLong();
        keyboard.close();
        
        try{
            
            String query = "DELETE FROM bookinfo "+
                            "WHERE"+
                            "ISBN = '" + isbn + "'";
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, pwd); 
            Statement st = con.createStatement();
            int count = st.executeUpdate(query);  
        
            System.out.println(count + " row(s) affected");
            st.close();
            con.close();
            }catch(Exception e) { System.out.println(e);}  
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());

    }
    
    
      
      public void dbUpdataInventory(long ISBN,int Inventory ){
      	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        try{
            
            String query = "UPDATE bookinfo SET inventory += '" + Inventory + "' "+
                            "WHERE"+
                            " ISBN = '" + ISBN +"'"; 
            	
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, pwd); 
            Statement st = con.createStatement();
            int count = st.executeUpdate(query);  
        
            System.out.println(count + " row(s) affected");
            st.close();
            con.close();
            }catch(Exception e) { System.out.println(e);}
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }
    
    public void dbAddBorrowedAmount(long ISBN,int addBorrowedAmount ){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        try{
            
            String query = "UPDATE bookinfo SET borrowed += '" + addBorrowedAmount + "' "+
                            "WHERE"+ 
                            "ISBN = '" + ISBN +"'"; 
            	
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, pwd); 
            Statement st = con.createStatement();
            int count = st.executeUpdate(query);  
        
            System.out.println(count + " row(s) affected");
            st.close();
            con.close();
            }catch(Exception e) { System.out.println(e);}
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }
    
    public void dbUpdatePassword(int empID,String password){
    try{
       
        String query = "UPDATE passwordlist SET employee_id = '" + empID + "'"+
                        " WHERE"+
                        " password = '" + password +"'"; 
            
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
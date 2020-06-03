public class SQL_method {

    public static void DBdeleteBook(long ISBN){
        try{
            String url = "jdbc:mysql://localhost:3306/書籍管理システム?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String userName = "root";
            String pwd = "password1234";
            String query = "DELETE FROM bookinfo WHERE ISBN = ISBN"; //note have to modify code to work
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, pwd); 
            Statement st = con.createStatement();
            int count = st.executeUpdate(query);  
        
            System.out.println(count + " row(s) affected");
            st.close();
            con.close();
            }catch(Exception e) { System.out.println(e);}
    }
    public static void DBregisterBook(long ISBN, String title, String publisher, 
                                    Date publishDate, String field, List<String> authors,
                                    int inventory, int borrowedAmount){
         try{
            String url = "jdbc:mysql://localhost:3306/書籍管理システム?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String userName = "root";
            String pwd = "password1234";
            String query = "INSERT INTO bookinfo (ISBN, title, publisher, publish_date, field_, author, inventory, borrowed) 
                            VALUES ('ISBN', 'Title', 'publisher', 'publishDate', 'field', 
                            'authors', 'inventory', 'borrowedAmount'); ";
                                            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, pwd); //Obtains connection to DB
            Statement st = con.createStatement();
            int count = st.executeUpdate(query);  //Statement and Result model data result sets and SQL statements.
                                        
            System.out.println(count + "row(s) affected");
            st.close();
            con.close();
            }catch(Exception e) { System.out.println(e);}

    }
    public static void DBsearchBookTitle(String title){
        try{
            String url = "jdbc:mysql://localhost:3306/書籍管理システム?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String userName = "root";
            String pwd = "password1234";
            String query = "SELECT * FROM bookinfo WHERE title = 'title'";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, pwd); //Obtains connection to DB
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);  //Statement and Result model data result sets and SQL statements.
        
            String bookData = "";
            while(rs.next()){
                System.out.println("ISBN       Title      Publisher       Publishdate    Genre     Author    Inventory    Lent out");
                bookData =  rs.getLong(1) +  rs.getString(2) + rs.getString(3) + rs.getDate(4) + rs.getString(5) + rs.getString(6) + rs.getInt(7) + rs.getInt(8) ;
                System.out.println (bookData);

           
            

            st.close();
            con.close();
            }catch(Exception e) { System.out.println(e);}  

    }
    public static void DBsearchBookField(String field){
        try{
            String url = "jdbc:mysql://localhost:3306/書籍管理システム?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String userName = "root";
            String pwd = "password1234";
            String query = "SELECT * FROM bookinfo WHERE field = 'field'";
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, pwd); //Obtains connection to DB
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);  //Statement and Result model data result sets and SQL statements.
                
            String bookData = "";
                while(rs.next()){
                    System.out.println("ISBN       Title      Publisher       Publishdate    Genre     Author    Inventory    Lent out");
                    bookData =  rs.getLong(1) +  rs.getString(2) + rs.getString(3) + rs.getDate(4) + rs.getString(5) + rs.getString(6) + rs.getInt(7) + rs.getInt(8) ;
                    System.out.println (bookData);
        
                    }
                    
        
                    st.close();
                    con.close();
                    }catch(Exception e) { System.out.println(e);}
    }

    public static void DBsearchBookAuthor(List<String> authors){
        try{
            String url = "jdbc:mysql://localhost:3306/書籍管理システム?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String userName = "root";
            String pwd = "password1234";
            String query = "SELECT * FROM bookinfo WHERE author = 'authors'";
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, pwd); //Obtains connection to DB
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);  //Statement and Result model data result sets and SQL statements.
                
            String bookData = "";
                while(rs.next()){
                    System.out.println("ISBN       Title      Publisher       Publishdate    Genre     Author    Inventory    Lent out");
                    bookData =  rs.getLong(1) +  rs.getString(2) + rs.getString(3) + rs.getDate(4) + rs.getString(5) + rs.getString(6) + rs.getInt(7) + rs.getInt(8) ;
                    System.out.println (bookData);
        
                    }
                    
        
                    st.close();
                    con.close();
                    }catch(Exception e) { System.out.println(e);}

    }

    
        public static void DBreturnBook{
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
        try{
            String url = "jdbc:mysql://localhost:3306/書籍管理システム?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String userName = "root";
            String pwd = "password1234";
            String query = "INSERT INTO bookinfo (ISBN, title, publisher, publish_date, field_, author, inventory, borrowed) VALUES ('" + isbn + "', '" + title + "', '" + publisher + "', '" + pubdate + "', '" + field + "', '" + author + "', '" + inventory + "', '" + borrowed + "');";

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
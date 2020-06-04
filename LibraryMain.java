import java.io.IOException;
import java.util.function.Supplier;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
public class LibraryMain{
	static Logger logger = Logger.getLogger(LibraryMain.class.getName());
    public static void main(String[] args){
    	 // Create a file handler object 
        FileHandler handler 
            = new FileHandler("log.txt"); 
        handler.setFormatter(new SimpleFormatter()); 
        logger.addHandler(handler); 
        // ログレベルの設定
        logger.setLevel(Level.FINER);
    	
        Login login = new Login();
        login.login();
    }
}
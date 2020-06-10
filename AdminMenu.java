import java.util.logging.Logger;
import java.util.*;

/**a
 * アドミンメニュークラス
 * @author　鈴木戒生
 * @see MainMenu
 * @version 2.0
 */

public class AdminMenu{
	Logger logger = Logger.getLogger(AdminMenu.class.getName());
	SqlMethod sql =new SqlMethod();
	UI ui =new UI();
     /**
     * 著者の入力を促し、その情報を同クラスのregisterBookメソッドに返す。
     * @return authorsList
     */
    public List<String> registerauthors(int i){
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        List<String> authorsList = new ArrayList<String>();
        do{
            i = 0;
            String str4 =ui.str4Ui();
            if(authorsList.contains(str4)){
                System.out.println("既にその著者名は登録されています。");
                i += 1;
            }
            else{
                authorsList.add(str4);
                int authorAdd = ui.authorAddUi();
                i += authorAdd;
            }
        }
        while(i == 1);
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        return authorsList ;
    }

    /**
     * 本の詳細の入力を促しSqlMethodクラスのsqlRegisterメソッドを呼び出し
     　て入力した情報をDBに登録する。
     */
    public void registerBook(){
        logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        try{
            List<String> authorList = new ArrayList<String>();
    	    String publishDate = ui.strDateUi();
            int i = 0;
            authorList = this.registerauthors(i);
            int borrowedAmount = 0;
            sql.registerBook(ui.isbnUi(),ui.titleUi(),ui.publisherUi(), 
                publishDate,ui.fieldUi(),authorList,ui.inventoryUi(),borrowedAmount);
        }
        catch(Exception e){
    		e.printStackTrace();
        }
	 	finally{
	 	    logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
        }
    }

     /**
     * DBにある書籍を削除するメソッド
     */
    public void deleteBook() {
     	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        sql.deleteBook();
    	logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }

     /**
     * DBにある書籍の在庫を変更するメソッド
     */
    public void updataBook(){
     	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        loop:while (true){
			int selected = ui.selectedUi();
		    switch(selected){
			    case 1:
                    long allowISBN = ui.isbnUi();
                    int addInventory = ui.addInventoryUi();
                    sql.dbUpdataInventory( allowISBN,addInventory );
                    break;
                case 2:
                    long aISBN = ui.isbnUi();
                    int addBorrowedAmount =ui.addBorrowedAmountUi();
                    sql.dbAddBorrowedAmount( aISBN,addBorrowedAmount);
                    break;
                case 3:
                    logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
                    break loop;
                default:
                    System.out.println("再度入力してください");
                    break;
            }
        }    
    }

    /**
     *貸出可能かどうか判定するメソッド
     */
    public void allowBorrowBook(){
     	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        long allowISBN = ui.isbnUi();
        sql.borrowBook(allowISBN);
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }

    /**
     *返却処理するメソッド
     *返却された書籍のISBN、従業員IDの入力を促しsqlmethodクラスのreturnBookメソッド
     　に与える。
     */
    public void returnBook(){
    	logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	int id = ui.employeeUi();
    	long isbn =ui.isbnUi();
        sql.returnBook(isbn,id);
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }		
}

import java.util.logging.Logger;
import java.util.*;

/**s
 * アドミンメニュークラス
 * @author　鈴木戒生
 * @see MainMenu
 */

public class AdminMenu{
	  Logger logger = Logger.getLogger(AdminMenu.class.getName());
	  SqlMethod sql =new SqlMethod();
	  UI ui =new UI();

     /**
     * 著者の入力を促し、その情報を同クラスのregisterBookメソッドに返す。
     */
    public List<String> registerauthors(int i){
        List<String> authorsList = new ArrayList<String>();
        do{
            i = 0;
            String str4 =ui.str4Ui();
            if(authorsList.contains(str4)){
                System.out.println("既にその著者名は登録されています。");
                i += 1;
            }else{
                authorsList.add(str4);
                int authorAdd = ui.authorAddUi();
                i += authorAdd;
            }
        }
        while(i == 1);
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
            sql.registerBook(ui.isbnUi(),ui.titleUi(),ui.publisherUi(), publishDate,ui.fieldUi(),authorList,ui.inventoryUi(),borrowedAmount);
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
                    int select = ui.selectUi();
                    if(select==1){
                        int addInventory = ui.addInventoryUi();
                        sql.dbUpdataInventory( allowISBN,addInventory );
                    }else if (select ==2){
    	             	    int deInventory = ui.deInventoryUi();
    	                  int deleteInventory = 0;
    	                  deleteInventory -= deInventory;
    	                  sql.dbUpdataInventory( allowISBN,deleteInventory );
    	              }else{
    	             	    System.out.println("最初からやり直してください");
                    }
                    break;

                case 2:
                    long aISBN = ui.isbnUi();
                    int addBorrowedAmount =ui.addBorrowedAmountUi();
                    sql.dbAddBorrowedAmount( aISBN,addBorrowedAmount);
                    break;
                case 3:
                    break loop;
                default:
                    System.out.println("再度入力してください");
                break;
            }
        }
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }

    /**
     *貸出可能かどうか判定するメソッド
     */
    public void allowBorrowBook(){
     	  logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
        long allowISBN = ui.isbnUi();
        sql.borrowBook(allowISBN);
    }

    /**
     *返却処理するメソッド
     */
    public void returnBook(){
    	  logger.entering(LogUtil.getClassName(), LogUtil.getMethodName());
    	  int id = ui.employeeUi();
    	  long isbn =ui.isbnUi();
        sql.returnBook(isbn,id);
        logger.exiting(LogUtil.getClassName(), LogUtil.getMethodName());
    }
		
}

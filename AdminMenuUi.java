import java.util.*;
import java.text.*;
import java.io.*;
public class AdminMenuUi{
    public long isbnUi(){
	    System.out.println("ISBN����͂��Ă��������B");
        long ISBN = new java.util.Scanner(System.in).nextlong();
        return ISBN;
    }
    public String titleUi(){
	    System.out.println("���Ж�������͂��Ă��������B");
        String title = new java.util.Scanner(System.in).nextLine();
        return title;
    }
    public String publisherUi(){
    	System.out.println("�o�ŎЂ���͂��Ă��������B");
        String publisher = new java.util.Scanner(System.in).nextLine();
	    return publisher;
    }
    public String strDateUi(){
    	System.out.println("�o�^���鏑�Ђ̏o�œ���yyyyMMdd�`���œ��͂��Ă�������");
        String strDate = new java.util.Scanner(System.in).nextLine();
	    return strDate;
    }
    public String fieldUi(){
    	System.out.println("field����͂��Ă��������B");
        String field = new java.util.Scanner(System.in).nextLine();
	    return field
    }
    public String isbnUi(){
    	System.out.println("���҂���͂��Ă��������B");
        String str4 = new java.util.Scanner(System.in).nextLine();
	    return str4;
    }
    public int authorAddUi(){
    	System.out.println("���҂�ǉ�����ꍇ�͂P����͂��Ă�������");
        int authorAdd = new java.util.Scanner(System.in).nextInt();
	    return authorAdd;
    }
     public int inventoryUi(){
     	System.out.println("inventory����͂��Ă��������B");
        int inventory = new java.util.Scanner(System.in).nextInt();
	    return inventory;
    }
     public int borrowedAmountUi(){
     	System.out.println("borrowedAmount����͂��Ă��������B");
        int borrowedAmount = new java.util.Scanner(System.in).nextInt();
	    return borrowedAmount;
    }
    //updata
    public int selectedUi(){
        System.out.println("�ҏW���ڂ�I�����Ă�������");
    	System.out.println("1.�݌ɕύX");
    	System.out.println("2.�ݏo�{�̍X�V");
    	System.out.println("3.�I��");
    	int selected = new java.util.Scanner(System.in).nextInt();
	    return selected;
    }
    
    //delete
     public String deleteBookUi(){
     	System.out.println("�폜����{��ISBM����͂��Ă�������");
        String deleteBook = new java.util.Scanner(System.in).nextLine();
	    return deleteBook;
    }
    //�ݓ��o
     public long employeeUi(){
     	System.out.println("�]�ƈ�ID����͂��Ă�������");
        int employee = new java.util.Scanner(System.in).nextInt();
	    return employee;
    }
     public long bookPeriodUi(){
     	System.out.println("�ݏo��������͂��Ă�������");
        int bookPeriod = new java.util.Scanner(System.in).nextInt();
	    return bookPeriod;
    }
}
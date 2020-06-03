public class MainMenu{
    public void adminMainMenu(){
        //メニュー番号
		private static final int selectedAdmin1 = 1;
		private static final int selectedAdmin2 = 2;
		private static final int selectedAdmin3 = 3;
		private static final int selectedAdmin4 = 4;
		private static final int selectedAdmin5 = 5;
		private static final int selectedAdmin6 = 6;
		private static final int selectedAdmin7 = 7;
		private static final int selectedAdmin8 = 8;
        
        loop:while(true){
            System.out.println("メニュー画面");
            
			System.out.println("1，図書登録");
			System.out.println("2，図書削除");
			System.out.println("3，登録変更");
			System.out.println("4，貸出承認");
			System.out.println("5，返却受取");
			System.out.println("6，期限切れ図書一覧");
			System.out.println("7，延長の承認");
			System.out.println("8，終了");
			
			System.out.println("メニュー番号を入力してください。");
		
			int selected = new java.util.Scanner(System.in).nextInt();
			
		switch(selected){
			
        case selectedAdmin1:
            System.out.println("図書登録");
            
            break;
        
        case selectedAdmin2:
            System.out.println("図書削除");
            
            break;
        
        case selectedAdmin3:
                System.out.println("登録変更");
            
            break;
        
            case selectedAdmin4:
            System.out.println("貸出承認");

            break;
        
        case selectedAdmin5:
            System.out.println("返却受取");
            
            break;
        
        case selectedAdmin6:
            System.out.println("期限切れ図書一覧");
            
            break;
               
        case selectedAdmin7:
            System.out.println("延長の承認");
            
            break;
               
        case selectedAdmin8:
            System.out.println("終了");
                
            break loop;
      	  }
 	   }
        

    }

    public void userMainMenu(){
        //メニュー番号
		private static final int selectedUser1 = 1;
		private static final int selectedUser2 = 2;
		private static final int selectedUser3 = 3;
        
        loop:while(true){
            System.out.println("メニュー画面");
            
			System.out.println("1，図書検索");
            System.out.println("2，予約取消");
            System.out.println("3，終了");
			
			System.out.println("メニュー番号を入力してください。");
		
			int selected = new java.util.Scanner(System.in).nextInt();
			
		switch(selected){
			
        case selectedUser1:
            System.out.println("1,図書検索");
            
            break;
        
        case selectedUser2:
            System.out.println("2，予約取消");
            break;
         
        case selectedUser3:
            System.out.println("終了");
                
            break loop;
      	  }
 	   }
    }
}
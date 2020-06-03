import java.util.*;
import java.text.*;
import java.io.*;


public class UserMenu{

  //���Ђ̃��X�g����
    static List<Book> books;

  //�J���}
    private final String COMMA = ",";

  //�ǂݍ��񂾃t�@�C���̗L��
    private boolean exist = false;

  //�G���[�̔ԍ�
    private int errorNum = 0;

  //�{�I�̐���
    public void BookShelf() {
      books = new ArrayList<Book>();
    }

    public List<Book> getAllBooks() {
        return books;
    }

  //���Ж��ŏ��Ђ�����
    public ArrayList<Book> searchBooksByTitle(String bookTitle) {
        exist = false;    //���Ђ����邩�ǂ������f
        ArrayList<Book> numBooks = new ArrayList<Book>();
        for(int i = 0 ; i < this.books.size() ; i++){
            if(bookTitle.equals(this.books.get(i).getTitle())) {
                numBooks.add(this.books.get(i));
                exist = true;
            }else{
            }
        }
        return numBooks;
    }

  //���Җ��ŏ��Ђ�����
    public ArrayList<Book> searchBooksByAuthor(String bookAuthor) {
        exist = false;    //���Ђ����邩�ǂ������f
        ArrayList<Book> numBooks = new ArrayList<Book>();
        for(int i = 0 ; i < this.books.size() ; i++){
            if(this.books.get(i).getAuthors().contains(bookAuthor)) {
                numBooks.add(this.books.get(i));
                exist = true;
            }else{
            }
        }
        return numBooks;
    }

  //����ŏ��Ђ�����
    public ArrayList<Book> searchBooksByField(String bookField) {
        exist = false;    //���Ђ����邩�ǂ������f
        ArrayList<Book> numBooks = new ArrayList<Book>();
        for(int i = 0 ; i < this.books.size() ; i++){
            if(bookField.equals(this.books.get(i).getField())) {
                numBooks.add(this.books.get(i));
                exist = true;
            }else{
            }
        }
        return numBooks;
    }

  //���Ђ̕ۑ�(���Ж��̌�������)
    public void saveBooksByTitle(String saveFile) {
       try{
           File csv = new File(saveFile);
           BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));
           for(Book t : searchBooksByTitle()){
               bw.write("ISBN");
               bw.write(COMMA);
               bw.write(t.getISBN());
               bw.write(COMMA);
               bw.write("Title");
               bw.write(COMMA);
               bw.write(t.getTitle());
               bw.write(COMMA);
               bw.write("Publisher");
               bw.write(COMMA);
               bw.write(t.getPublisher());
               bw.write(COMMA);
               bw.write("PublishDate");
               bw.write(COMMA);
               bw.write(new SimpleDateFormat("yyyy/MM/dd").format(t.getPublishDate()));
               bw.write(COMMA);
               bw.write("Authors");
               bw.write(COMMA);
               bw.write(t.getAuthors());
               bw.write(COMMA);
               bw.write("Field");
               bw.write(COMMA);
               bw.write(t.getField());
               bw.write(COMMA);
               bw.write("Inventory");
               bw.write(COMMA);
               bw.write(t.getInventory());
               bw.write(COMMA);
               bw.write("BorrowedAmount");
               bw.write(COMMA);
               bw.write(t.getBorrowedAmount());
               bw.write("\n");
           }
           bw.close();
       }catch(IOException e){
         errorNum = 1;    //���t�̌^������������܂���
           e.printStackTrace();
       }
   }

  //���Ђ̕ۑ�(���Җ��̌�������)
    public void saveBooksByAuthors(String saveFile) {
      try{
          File csv = new File(saveFile);
          BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));
          for(Book a : searchBooksByAuthor()){
              bw.write("ISBN");
              bw.write(COMMA);
              bw.write(a.getISBN());
              bw.write(COMMA);
              bw.write("Title");
              bw.write(COMMA);
              bw.write(a.getTitle());
              bw.write(COMMA);
              bw.write("Publisher");
              bw.write(COMMA);
              bw.write(a.getPublisher());
              bw.write(COMMA);
              bw.write("PublishDate");
              bw.write(COMMA);
              bw.write(new SimpleDateFormat("yyyy/MM/dd").format(a.getPublishDate()));
              bw.write(COMMA);
              bw.write("Authors");
              bw.write(COMMA);
              bw.write(a.getAuthors());
              bw.write(COMMA);
              bw.write("Field");
              bw.write(COMMA);
              bw.write(a.getField());
              bw.write(COMMA);
              bw.write("Inventory");
              bw.write(COMMA);
              bw.write(a.getInventory());
              bw.write(COMMA);
              bw.write("BorrowedAmount");
              bw.write(COMMA);
              bw.write(a.getBorrowedAmount());
              bw.write("\n");
          }
          bw.close();
      }catch(IOException e){
        errorNum = 1;    //���t�̌^������������܂���
          e.printStackTrace();
      }
  }

  //���Ђ̕ۑ�(����̌�������)
    public void saveBooksByField(String saveFile) {
       try{
           File csv = new File(saveFile);
           BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));
           for(Book f : searchBooksByField()){
               bw.write("ISBN");
               bw.write(COMMA);
               bw.write(f.getISBN());
               bw.write(COMMA);
               bw.write("Title");
               bw.write(COMMA);
               bw.write(f.getTitle());
               bw.write(COMMA);
               bw.write("Publisher");
               bw.write(COMMA);
               bw.write(f.getPublisher());
               bw.write(COMMA);
               bw.write("PublishDate");
               bw.write(COMMA);
               bw.write(new SimpleDateFormat("yyyy/MM/dd").format(f.getPublishDate()));
               bw.write(COMMA);
               bw.write("Authors");
               bw.write(COMMA);
               bw.write(f.getAuthors());
               bw.write(COMMA);
               bw.write("Field");
               bw.write(COMMA);
               bw.write(f.getField());
               bw.write(COMMA);
               bw.write("Inventory");
               bw.write(COMMA);
               bw.write(f.getInventory());
               bw.write(COMMA);
               bw.write("BorrowedAmount");
               bw.write(COMMA);
               bw.write(f.getBorrowedAmount());
               bw.write("\n");
           }
           bw.close();
       }catch(IOException e){
         errorNum = 1;    //���t�̌^������������܂���
           e.printStackTrace();
       }
   }

}

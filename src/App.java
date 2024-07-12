import demon.library.access.BookAccess;
import demon.library.access.BorrowerAccess;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        // BookAccess ba = new BookAccess();
        // ba.handleBookAccess();
        
        BorrowerAccess borrowerAccess = new BorrowerAccess();
        borrowerAccess.accessBorrower();
      

     
    }
}

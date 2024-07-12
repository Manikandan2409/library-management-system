
import demon.library.access.BorrowingHistoryAccess;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        // BookAccess ba = new BookAccess();
        // ba.handleBookAccess();

        // BorrowerAccess borrowerAccess = new BorrowerAccess();
        // borrowerAccess.accessBorrower();

        BorrowingHistoryAccess bHistoryAccess = new BorrowingHistoryAccess();
        bHistoryAccess.accessBorrowingHistory();

    }
}

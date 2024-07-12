package demon.library.access;

import java.util.List;

import demon.library.db.BorrowingHistoryConnection;
import demon.library.entity.BorrowingHistory;
import demon.library.utils.Validation;

public class BorrowingHistoryAccess {

    private final BorrowingHistoryConnection bhc = new BorrowingHistoryConnection();
    private final Validation validate = new Validation();
    public BorrowingHistoryAccess(){}

    //  access borrowing history
    public void accessBorrowingHistory(){
        while (true) {
            System.out.println("\t\t\t ### Borrowing History ###");
            System.out.println("\n1- Get Book \n2- Return Book \n3- View History \n4- Quit ");
            int choice = validate.getNumber();
            switch (choice) {
                case 1:
                    getBook();
                    break;
                case 2: 
                    returnBook();
                    break;
                case 3:
                    viewBorrowedHistory();
                    break;
                case 4:
                    System.out.println("\t\t\t### Quitting Borrowing Access ###");
                    return;
                default:
                System.out.println("... Invalid Option ...");
                    break;
            }
        }
    }

    //to get book
    private void getBook(){
        System.out.println("\t\t --- Get Book ----");
        System.out.println("BorrowerId :");
        int borrowerId = validate.getNumber();
        System.out.println("Book ID :");
        int bookId = validate.getNumber();
        BorrowingHistory bh = new BorrowingHistory(bookId, borrowerId);
        bhc.save(bh);
    }

    // to return book
    private void returnBook(){
        System.out.println("\t\t --- Return Book ----");
        System.out.println("Borrower id :");
        int borrowerId = validate.getNumber();
        System.out.println("Book ID :");
        int bookId = validate.getNumber();
        bhc.updateById(bookId, borrowerId);

    }

    // view Borrowed History
    private void viewBorrowedHistory(){
        List<BorrowingHistory> lists =bhc.findAll();
        printBorrowedHistory(lists);
    }

    //print Borrowing History
    private void printBorrowedHistory(List<BorrowingHistory> list){
        System.out.println(BorrowingHistory.getColumns());
        list.stream().forEach(System.out::println);
    }

    
}

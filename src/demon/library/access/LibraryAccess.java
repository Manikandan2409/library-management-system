package demon.library.access;

import demon.library.utils.Validation;

public class LibraryAccess {
    public LibraryAccess(){accessLibrary();}

    private final Validation validate = new Validation();
    private final BookAccess bookAccess = new BookAccess();
    private final BorrowerAccess borrowerAccess = new BorrowerAccess();
    private final BorrowingHistoryAccess bha = new BorrowingHistoryAccess();
    private  void accessLibrary(){
            while (true) {
                System.out.println("\t\t\t ### LIBRARY MANAGEMENT SYSTEM ###");
                System.out.println("\n1- Manage Book \n2- Membership \n 3- Borrow Books \n4- Quit");
                int choice =validate.getNumber();
                switch (choice) {
                    case 1:
                        bookAccess.handleBookAccess();
                        break;
                    case 2:
                        borrowerAccess.accessBorrower();
                    case 3:
                        bha.accessBorrowingHistory();
                        break;
                    case 4:
                        System.out.println("\t\t\t --- Quitting LIBRARY MANAGEMENT SYSTEM ---");
                        return;
                    default:
                    System.out.println("Invalid Option");
                        break;
                } 
            }
    }
}

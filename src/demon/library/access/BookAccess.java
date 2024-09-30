package demon.library.access;

import java.util.List;

import demon.library.db.BookConnection;
import demon.library.dto.BookDTO;
import demon.library.entity.Book;
import demon.library.utils.Validation;

public class BookAccess {

    private final BookConnection bc = new BookConnection();
    private final Validation validate = new Validation();
    
    // Create
    private void addBooks(){

        System.out.println("Title of the Book :");
        String title=validate.getNames();
        System.out.println(title+" \'s Author name :");
        String auth=validate.getNames();
        System.out.println(title+"\'s Publisher name");
        String publisher =validate.getNames();
        System.out.println(title+" published year :");
        int yearPublished=validate.getNumber();
        System.out.println(title+" Book Category :");
        String category=validate.getNames();
        
        BookDTO dto = new BookDTO(title, auth, publisher, yearPublished, category);

        bc.save(dto);

    }
    // View 
    private void viewBooks(){
        List<Book> stocks = bc.fetchAllBooks();
        printBooks(stocks);
    }

    // view an author
    private  void viewByAutor(){
        viewBooks();
        System.out.println("Enter author name:");
            String author=validate.getNames();
        List<Book> books = bc.findBooksByAuthor(author);
        printBooks(books);
    }

    //view by title
    private void viewByTitle(){
        viewBooks();
        String title=validate.getNames();
        List<Book> books = bc.findBooksByTitle(title);
        printBooks(books);
    }
    
    //Delete
    private void deleteBook(){
        viewBooks();
        System.out.println("BookId to delete a book : ");
        int id = validate.getNumber();
        bc.deleteBookById(id);

    }

    // print books
    private void printBooks(List<Book> books){
        System.out.println(Book.getColumns());
        books.stream().forEach(System.out::println);
    }

    public void handleBookAccess(){
        while (true) {
            System.out.println("\t\t\t ### Book ###");
            System.out.println("Options : \n 1- Add Books\n 2- view Books \n  3- View By Author \n 4- View by title \n 5- Delete Book\n6- Quit Book");
            int choice = validate.getNumber();
            switch (choice) {
                case 1:
                    addBooks();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    viewByAutor();
                    break;
                case 4:
                    viewByTitle();
                    break;
                case 5:
                    deleteBook();
                    break;
                    case 6:
                System.out.println("Quitting Books");
                    return;
                default:
                System.out.println("Invalid option");
                    break;
            }
        }
    }
    
    

}
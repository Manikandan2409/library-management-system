package demon.library.access;

import java.util.List;
import java.util.Scanner;

import demon.library.db.BookConnection;
import demon.library.dto.BookDTO;
import demon.library.entity.Book;

/**
 * BookAccess
 */
public class BookAccess {

    private BookConnection bc = new BookConnection();
    
    // Create
    public void addBooks(){

        
        String title="Programming in Oracle";
        String auth="Oracle Engineers";
        String publisher ="Oracle system";
        int yearPublished=1973;
        String category="CS";
        
        BookDTO dto = new BookDTO(title, auth, publisher, yearPublished, category);

        bc.save(dto);

    }
    // View 
    public void viewBooks(){
        List<Book> stocks = bc.fetchAllBooks();
        printBooks(stocks);
    }

    // view an author
    public  void viewByAutor(){
            String author="";
        List<Book> books = bc.findBooksByAuthor(author);
        printBooks(books);
    }

    
    //Delete
    public void deleteBook(){

        System.out.println("Enter id to delte bookd");
        Scanner in = new Scanner(System.in);
        int id = in.nextInt();
        bc.deleteBookById(id);

    }

    // print books
    private void printBooks(List<Book> books){
        System.out.println(Book.getColumns());
        books.stream().forEach(System.out::println);
    }

}
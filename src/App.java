import java.util.List;

import demon.library.db.BookConnection;
import demon.library.dto.BookDTO;
import demon.library.entity.Book;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        BookConnection bc = new BookConnection();
        String title="Programming in Python";
        String auth="Pythogonist";
        String publisher ="Sun microsytem";
        int yearPublished=1983;
        String category="CS";
        BookDTO dto = new BookDTO(title, auth, publisher, yearPublished, category);
        bc.insertBook(dto);
        List<Book> stocks = bc.fetchAllBooks();
        stocks.stream().forEach(System.out::println);

    }
}

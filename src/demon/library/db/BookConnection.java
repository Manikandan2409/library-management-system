package demon.library.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import demon.library.db.config.DBConfig;
import demon.library.dto.BookDTO;
import demon.library.entity.Book;

public class BookConnection {
    private Connection con = null;
    
    // Database connection
    public BookConnection(){
        try{
            con = DBConfig.getConnection();
            System.out.println("Connection Establised");
        }catch(SQLException e){
           System.out.println("Failed to Connect with db");
       }
    }

    // Create 
    public void save(BookDTO dto){
        Book entity = new Book(dto);

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO books (Title, Author, Publisher, YearPublished,  Category, CopiesAvailable) VALUES (?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, entity.getTitle());
            ps.setString(2, entity.getAuthor());
            ps.setString(3, entity.getPublisher());
            ps.setInt(4, entity.getYearPublished());
            ps.setString(5, entity.getCategory());
            ps.setInt(6, entity.getCopiesAvailable());

            int status = ps.executeUpdate();
            if (status > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        entity.setBookId(generatedKeys.getInt(1));
                    }
                }
                System.out.println(entity + " inserted successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View All the books
     public List<Book> fetchAllBooks() {
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM books");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getInt("BookID"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPublisher(rs.getString("publisher"));
                book.setYearPublished(rs.getInt("yearPublished"));
                book.setCategory(rs.getString("category"));
                book.setCopiesAvailable(rs.getInt("copiesAvailable"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    // Find by author
    public List<Book> findBooksByAuthor(String author) {
        return fetchAllBooks().stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    //find by title
    public List<Book> findBooksByTitle(String title){
        return fetchAllBooks().stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    //find by published
    public List<Book> findBooksByYearPublished(int year){
            return fetchAllBooks().stream()
                    .filter(book-> book.getYearPublished() == year)
                    .collect(Collectors.toList());
    }
    //delete
    public void deleteBookById(int id){
        String q="DELETE FROM books where BookID= ?";
        try (PreparedStatement ps = con.prepareStatement(q)) {
            
            ps.setInt(1,id );
            int affectedRows = ps.executeUpdate();
           
            if (affectedRows >0)     System.out.println(affectedRows +" rows affected");
            else    System.out.println("No rows affected ");
        
        } catch (Exception e) {
            System.out.println("Delete operation on book id= "+id+" failed");
        }
    }
    
    
}

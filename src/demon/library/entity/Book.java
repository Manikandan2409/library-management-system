package demon.library.entity;

import demon.library.dto.BookDTO;

public class Book {
    private static int bookcount = 0;
    private int bookId;
    private String title;
    private String author;
    private String publisher;
    private int yearPublished;
    private String category;
    private int copiesAvailable;

    @Override
    public String toString() {
        return bookId + "\t| " + title + "\t\t|" + author + "\t| " + publisher
                + "\t| " + yearPublished + "\t| " + category
                + "\t |" + copiesAvailable;
    }

    public Book() {
    }

    public Book(BookDTO dto) {
        bookId = ++bookcount;
        this.title = dto.getTitle();
        this.author = dto.getAuthor();
        this.publisher = dto.getPublisher();
        this.yearPublished = dto.getYearPublished();
        this.category = dto.getCategory();
        this.copiesAvailable = 20;
    }

    public static String getColumns() {
        return " BookId |\t title\t\t\t| Author\t| Publisher\t\t| Year\t| category| Copies Available|"+
        "\n==================================================================================================================";
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int id) {
        this.bookId = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

   

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }
}

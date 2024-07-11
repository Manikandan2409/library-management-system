package demon.library.dto;

public class BookDTO{

    private String title;
    private String author;
    private String publisher;
    private int yearPublished;
    private String isbn;
    private String category;

    public BookDTO(String title, String author, String publisher, int yearPublished, String category) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.isbn = String.valueOf(title.hashCode());
        this.category = category;
    }
    @Override
    public String toString() {
        return "BookDTO [title=" + title + ", author=" + author + ", publisher=" + publisher + ", yearPublished="
                + yearPublished + ", isbn=" + isbn + ", category=" + category + "]";
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
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    


}
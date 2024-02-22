public class User {
    private String name;
    public Book book;
    //Constructor
    public User(String name, Book book) {
        this.name = name;
        this.book = book;
    }
    public void returnBook() {
        this.book = null;
    }
}

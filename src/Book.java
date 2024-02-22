public class Book {

    private String title;
    private Author author;
    private boolean isAvailable;

    public Book( String title, Author author, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    public String verifyAvailability() {
        if (isAvailable()) {
            return "Available";
        } else {
            return "Borrowed";

        }
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    public void updateAvailabity() {
        this.isAvailable = !isAvailable;

    }
}

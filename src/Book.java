public class Book {

    private String title;
    private Author author;
    private boolean isAvailable;

    // Constructor
    public Book( String title, Author author, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    //Getters and Setters
    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
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
    public void updateAvailabity() {
        this.isAvailable = !isAvailable;

    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private List<Book> books;
    private List<Author> authors;
    private List<User> users;


    public Library() {
        this.books = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }
    public void addUser(User user) {
        users.add(user);
    }

    public void loanBook(User user, List<Book> books) {
        System.out.println(" --- BORROW BOOK SESSION --- ");
        String title;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter with book title: ");
        title = scanner.nextLine();

        for(Book book : books) {
            if (title.equals(book.getTitle())) {
                if (book.isAvailable() && user.book == null) {
                    user.book = book;
                    book.updateAvailabity();
                    System.out.println("Book loan for " + book.getTitle() + " completed successfully!");
                    break;
                } else if (user.book != null) {
                    System.out.println("You can only borrow one book at a time.");
                    break;
                } else if (!book.isAvailable()) {
                    System.out.println("The book is not available for borrowing at the moment.");
                    break;
                }
            }
        }
    }
    public void devolutionBook(User user, Book book) {
        System.out.println("--- DEVOLUTION BOOK SESSION --- ");
        if(user.book == null) {
            System.out.println("You don't have any book to be returned.");
        } else {
            book.updateAvailabity();
            user.returnBook();
            System.out.println("The book " + book.getTitle() + " was returned successfully.");

        }
    }
    public void showListBook(List<Book> books){
        if(books.isEmpty()) {
            System.out.println("The library doesn't have any books at the moment.");
        } else {

            System.out.println(" -- [ NAME ] -- | - [ AUTHOR ] - | - [ STATUS ] - ");

            for (Book book : books) {
                System.out.format("%15s%15s%15s%n", book.getTitle(), book.getAuthor().getName(), book.verifyAvailability());
            }
        }
    }
    public void donateBook() {
        System.out.println("--- DONATION BOOK SESSION --- ");
        Scanner scanner = new Scanner(System.in);
        String author;
        String title;
        System.out.println("Enter with book title: ");
        title = scanner.nextLine();
        System.out.println("Enter with book author: ");
        author  = scanner.nextLine();
        if(author == null || author.isEmpty()) {
            System.out.println("You need to add the author name.");
        } else if(title== null || title.isEmpty()) {
            System.out.println("You need to add the book title.");
        } else {
            Author newAuthor = new Author(author);
            Book newBook = new Book(title, newAuthor, true);
            addBook(newBook);
            System.out.println("Thank your for the donation!");
        }
    }
    public void menu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter with your name: ");
        var name = scanner.nextLine();
        User user = new User(name, null);
        addUser(user);

        while (true) {
            System.out.println("-------WELCOME TO OUR LIBRARY-------");
            System.out.println("---------------[MENU]---------------");
            System.out.println("1 - Donate book");
            System.out.println("2 - Borrow book");
            System.out.println("3 - Return book");
            System.out.println("4 - Show all books");

            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                donateBook();
            } else if (choice == 2){
                loanBook(user, books);
            } else if (choice == 3){
                devolutionBook(user, user.book);
            } else if (choice == 4) {
                showListBook(books);
            } else {
                System.out.println("The chosen value does not exist among the menu options");
            }
        }
    }
}

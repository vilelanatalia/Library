import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Author author1 = new Author("Suzanne Collins");
        Author author2 = new Author("Jane Austen");
        Author author3 = new Author("Taylor Jenkins Reid");

        Book book1 = new Book("The Hunger Games", author1, true);
        Book book2 = new Book("Pride and Prejudice", author2, true);
        Book book3 = new Book("The seven husbands of Evelyn Hugo", author1, true);

        User user1 = new User("Lucy Gray", book1);

        library.addAuthor(author1);
        library.addBook(book2);
        library.addBook(book1);
        library.addBook(book3);
        library.addUser(user1);
        library.menu();

    }
}


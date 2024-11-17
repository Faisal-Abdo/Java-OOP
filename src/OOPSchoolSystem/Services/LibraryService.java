package OOPSchoolSystem.Services;

import OOPSchoolSystem.Entities.Book;
import OOPSchoolSystem.Entities.Library;

import java.util.List;
import java.util.Scanner;

public class LibraryService {
    static Scanner scanner = new Scanner(System.in);

    public static Library addLibrary() {
        Library library = new Library();
        System.out.println("Enter Library Name");
        String libraryName = scanner.nextLine();
        library.setName(libraryName);
        List<Book> libraryBooks = BookService.addBooks();
        library.setBooks(libraryBooks);
        return library;
    }
}
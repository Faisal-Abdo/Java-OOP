package OOPSchoolSystem.Services;

import OOPSchoolSystem.Entities.Book;
import OOPSchoolSystem.Entities.Library;
import OOPSchoolSystem.Entities.School;
import OOPSchoolSystem.Entities.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookService {
    static Scanner scanner = new Scanner(System.in);
    static List<Book> bookList = new ArrayList<>();
    static School school;
    static Library library;

    public static Book addBook() {
        Book book = new Book();

        System.out.println("Enter book name");
        String bookName = scanner.nextLine();
        book.setName(bookName);
        System.out.println("Enter Author's Name");
        String bookAuthor = scanner.nextLine();
        book.setAuthor(bookAuthor);
        System.out.println("Enter year of publish");
        String yearOfPublishing = scanner.nextLine();
        book.setYearOfPublishing(yearOfPublishing);
        System.out.println("Enter Book ID");
        String bookId = scanner.nextLine();
        book.setId(bookId);
        scanner.next();
        System.out.println("Is the book Available? y/n");
        String availableBook = scanner.nextLine();
        Boolean isBookAvailable = (availableBook.equalsIgnoreCase("y")); //ternary operator
        book.setAvailable(isBookAvailable);

        return book;
    }

    public static List<Book> addBooks() {
        Boolean exitFlag = true;
        while (exitFlag) {
            System.out.println("Enter books? Y/N ");
            String newDataEntry = scanner.nextLine();
            if (newDataEntry.equalsIgnoreCase("y")) {
                bookList.add(BookService.addBook());
            } else if (newDataEntry.equalsIgnoreCase("n")) {
                exitFlag = false;
            } else {
                System.out.println("Invalid input");
            }
        }
        return bookList;
    }

    public static void retrieveBook() {
        System.out.println("Enter Book ID: ");
        String bookId = scanner.nextLine();
        for (Book book : bookList) {
            if (book.getId().equals(bookId)) {
                System.out.println(book);
            } else {
                System.out.println("Book does not exist");
            }
        }
    }

    public static void listAvailableBooks() {
        System.out.println("List of available books are as follows: ");
        List<String> listOfAvailableBooks = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getAvailable()) {
                listOfAvailableBooks.add(book.getName());
            }
        }
        System.out.print(listOfAvailableBooks);
    }

    public static void assignBookToStudent(List<School> listOfSchools) {
        //List<Book> assignBooksToStudent = new ArrayList<>();
        System.out.print("Enter book ID: ");
        String bookID = scanner.nextLine();
        System.out.print("Enter school name: ");
        String schoolName = scanner.nextLine();
        System.out.print("Enter student ID: ");
        String studentID = scanner.nextLine();
        if (!bookID.isBlank() && !schoolName.isBlank() && !studentID.isBlank()) {
            for (Book book : library.getBooks()) {
                if (book.getId().equals(bookID)) {
                    for (School school : listOfSchools) {
                        if (school.getName().equals(schoolName)) {
                            for (Student student : school.getStudents()) {
                                if (student.getId().equals(studentID)) {
                                    List<Book> assignBooksToStudent = student.getAssignedBooks();  //Mutable list
                                    assignBooksToStudent.add(book);
                                    book.setAvailable(false);
                                } else {
                                    System.out.println("Student entered does not exist");
                                }
                            }
                        } else {
                            System.out.println("School does not exist");
                        }
                    }
                } else {
                    System.out.println("Book does not exist");
                }
            }
        } else {
            System.out.println("Invalid data");
        }
        for (Student student : school.getStudents()) {
            if (student.getId().equals(studentID)) {
                System.out.println("List of assigned book to a student" + student.getAssignedBooks());
                break;
            }
        }
    }

    public static void returnBook(){
        System.out.print("Enter ID of the book you want to return: ");
        String bookID = scanner.nextLine();
        for(Book book: library.getBooks()){
            if(book.getId().equals(bookID)){
                book.setAvailable(true);  //Mark a book as returned and update its availability status.
                System.out.println(book.getId()+ " has been returned");
                break;
            }
        }
    }
}
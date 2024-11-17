package OOPSchoolSystem.Services;

import OOPSchoolSystem.Entities.School;
import OOPSchoolSystem.Entities.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuService {

    static Scanner scanner = new Scanner(System.in);
    static List<School> schoolList = new ArrayList<>();


    public static void menuSelection() {
        Boolean exitFlag = true;
        while (exitFlag) {
            System.out.println("Pick an Option: " +
                    "\n" + "1. School Menu" +
                    "\n" + "2. Student Menu" +
                    "\n" + "3. Teacher Menu" +
                    "\n" + "4. Book Menu" +
                    "\n" + "5. Library Menu" +
                    "\n" + "6. Exit");
            String MainMenuInput = scanner.nextLine();
            if (MainMenuInput.equals("1")) {
                schoolMenu();
            } else if (MainMenuInput.equals("2")) {
                studentMenu();
            } else if (MainMenuInput.equals("3")) {
                teacherMenu();
            } else if (MainMenuInput.equals("4")) {
                bookMenu();
            } else if (MainMenuInput.equals("5")) {
                libraryMenu();
            } else if (MainMenuInput.equals("6")) {
                exitFlag = false;
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    public static void schoolMenu() {
        while (true) {
            System.out.println("Pick an Option: " +
                    "\n" + "1. Enter School data" +
                    "\n" + "2. Get school data" +
                    "\n" + "3. Student menu" +
                    "\n" + "4. Teacher menu" +
                    "\n" + "5. Library menu" +
                    "\n" + "6. Main Menu");
            String schoolMenuInput = scanner.nextLine();
            if (schoolMenuInput.equals("1")) {
                schoolList = SchoolService.addSchools();
            } else if (schoolMenuInput.equals("2")) {
                SchoolService.retrieveSchoolData(schoolList);
            } else if (schoolMenuInput.equals("3")) {
                studentMenu();
            } else if (schoolMenuInput.equals("4")) {
                teacherMenu();
            } else if (schoolMenuInput.equals("5")) {
                teacherMenu();
            } else if (schoolMenuInput.equals("6")) {
                break;
            } else {
                System.out.println("Invalid input");
            }
        }

    }

    public static void studentMenu() {
        List<Student> studentList = new ArrayList<>();
        while (true) {
            System.out.println("Pick an Option: " +
                    "\n" + "1. Enter Student Data" +
                    "\n" + "2. Get student Data" +
                    "\n" + "3. Get average for student" +
                    "\n" + "4. Return to Main Menu");
            String studentMenuInput = scanner.nextLine();
            if (studentMenuInput.equals("1")) {
                studentList = StudentService.addStudents();
            } else if (studentMenuInput.equals("2")) {
                StudentService.retrieveStudent(studentList);
            } else if (studentMenuInput.equals("3")) {
                MarkService.calculateMarksAverage(studentList);
            } else if (studentMenuInput.equals("4")) {
                break;
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    public static void teacherMenu() {
        while (true) {
            System.out.println("Pick an Option: " +
                    "\n" + "1. Enter Teacher's Data" +
                    "\n" + "2. Get Teacher's data" +
                    "\n" + "3. Return to Main Menu");
            String teacherMenuInput = scanner.nextLine();
            if (teacherMenuInput.equals("1")) {
                TeacherService.addTeachers();
            } else if (teacherMenuInput.equals("2")) {
                TeacherService.retrieveTeacher();
            } else if (teacherMenuInput.equals("3")) {
                break;
            }
        }
    }

    public static void bookMenu() {
        while (true) {
            System.out.println("Pick an Option: " +
                    "\n" + "1. Enter Book Data" +
                    "\n" + "2. Get Book data" +
                    "\n" + "3. List all available books" +
                    "\n" + "4. Assign book to a student" +
                    "\n" + "5. Return a book" +
                    "\n" + "6. Return to Main Menu");
            String bookMenuInput = scanner.nextLine();
            if (bookMenuInput.equals("1")) {
                BookService.addBooks();
            } else if (bookMenuInput.equals("2")) {
                BookService.retrieveBook();
            } else if (bookMenuInput.equals("3")) {
                BookService.listAvailableBooks();
            } else if (bookMenuInput.equals("4")) {
                BookService.assignBookToStudent(schoolList);
            } else if (bookMenuInput.equals("5")) {
                break;
            }
        }
    }

    public static void libraryMenu() {
        while (true) {
            System.out.println("Pick an Option: " +
                    "\n" + "1. Enter Library data" +
                    "\n" + "2. Book Menu" +
                    "\n" + "3. Return to Main Menu");
            String libraryMenuInput = scanner.nextLine();
            if (libraryMenuInput.equals("1")) {
                LibraryService.addLibrary();
            } else if (libraryMenuInput.equals("2")) {
                bookMenu();
            } else if (libraryMenuInput.equals("3")) {
                break;
            }
        }
    }
}
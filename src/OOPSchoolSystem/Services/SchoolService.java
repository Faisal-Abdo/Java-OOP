package OOPSchoolSystem.Services;

import OOPSchoolSystem.Entities.Library;
import OOPSchoolSystem.Entities.School;
import OOPSchoolSystem.Entities.Student;
import OOPSchoolSystem.Entities.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolService {

    static Scanner scanner = new Scanner(System.in);

    public static School addSchool() {
        School school = new School();
        System.out.println("Enter School Name");
        String name = scanner.nextLine();
        school.setName(name);
        System.out.println("Enter School Address");
        String address = scanner.nextLine();
        school.setAddress(address);
        List<Student> listOfStudents = StudentService.addStudents();
        school.setStudents(listOfStudents);
        List<Teacher> listOfTeachers = TeacherService.addTeachers();
        school.setTeachers(listOfTeachers);
        Library library = LibraryService.addLibrary();
        school.setLibrary(library);

        return school;
    }

    public static List<School> addSchools() {
        Boolean exitFlag = true;
        List<School> schools = new ArrayList<>();
        while (exitFlag) {
            System.out.println("Enter  new school? Y/N");
            String newDataEntry = scanner.nextLine();
            if (newDataEntry.equalsIgnoreCase("y")) {
                schools.add(SchoolService.addSchool());
            } else if (newDataEntry.equalsIgnoreCase("n")) {
                exitFlag = false;
            } else {
                System.out.println("Invalid input");
            }
        }
        return schools;
    }

    public static void retrieveSchoolData(List<School> schoolList) {
        System.out.println("Enter School name: ");
        String schoolName = scanner.nextLine();
        for (School school : schoolList) {
            if (school.getName().equals(schoolName)) {
                System.out.println(school);
            } else {
                System.out.println("School does not exist");
            }
        }
    }
}
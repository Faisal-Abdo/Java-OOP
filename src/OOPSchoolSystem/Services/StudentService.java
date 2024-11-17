package OOPSchoolSystem.Services;

import OOPSchoolSystem.Entities.Student;
import OOPSchoolSystem.Entities.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService {
    static Scanner scanner = new Scanner(System.in);

    public static Student addStudent() {

        Student student = new Student();
        System.out.println("Enter student ID");
        String studentID = scanner.nextLine();
        student.setId(studentID);
        System.out.println("Enter Student Name: ");
        String studentName = scanner.nextLine();
        student.setName(studentName);
        System.out.println("Enter Student Age");
        Short studentAge = scanner.nextShort();
        student.setAge(studentAge);
        scanner.nextLine();
        System.out.println("Enter Grade");
        String studentGrade = scanner.nextLine();
        student.setGrade(studentGrade);
        List<Subject> studentCourses = SubjectService.addSubjects(false);
        student.setCourses(studentCourses);
        return student;

    }

    public static List<Student> addStudents() {

        Boolean exitFlag = true;
        List<Student> studentsList = new ArrayList<>();
        while (exitFlag) {
            System.out.println("Enter student? Y/N");
            String newDataEntry = scanner.nextLine();
            if (newDataEntry.equalsIgnoreCase("y")) {
                studentsList.add(StudentService.addStudent());
            } else if (newDataEntry.equalsIgnoreCase("n")) {
                exitFlag = false;
            } else {
                System.out.println("Invalid input");
            }
        }
        return studentsList;
    }

    public static void retrieveStudent(List<Student> studentList) {
        System.out.println("Enter Student ID: ");
        String studentId = scanner.nextLine();
        for (Student student : studentList) {
            if (student.getId().equals(studentId)) {
                System.out.println(student);
            } else {
                System.out.println("Student does not exist");
            }
        }
    }
}
package OOPSchoolSystem.Services;

import OOPSchoolSystem.Entities.Mark;
import OOPSchoolSystem.Entities.Student;
import OOPSchoolSystem.Entities.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarkService {
    static Scanner scanner = new Scanner(System.in);


    public static Mark addMark() {
        Mark mark = new Mark();
        System.out.println("Enter Test Name: ");
        String markTitle = scanner.nextLine();
        mark.setTitle(markTitle);
        System.out.println("Enter mark");
        Double marks = scanner.nextDouble();
        mark.setMarks(marks);
        scanner.nextLine(); // This line consumes the \n character
        System.out.println("Enter Grade");
        String markGrade = scanner.nextLine();
        mark.setGrade(markGrade);
        System.out.println("Enter comments");
        String comments = scanner.nextLine();
        mark.setComments(comments);

        return mark;
    }

    public static List<Mark> addMarks() {
        List<Mark> markList = new ArrayList<>();
        Boolean exitFlag = true;

        while (exitFlag) {
            System.out.println("Enter marks? y/n");
            String newDataEntry = scanner.nextLine();
            if (newDataEntry.equalsIgnoreCase("y")) {
                markList.add(MarkService.addMark());
            } else if (newDataEntry.equalsIgnoreCase("n")) {
                exitFlag = false;
            } else {
                System.out.println("Invalid input");
            }
        }
        return markList;
    }

    public static void calculateMarksAverage(List<Student> studentList) {
        System.out.println("Enter Student ID: ");
        String studentId = scanner.nextLine();
        for (Student student : studentList) {
            if (student.getId().equals(studentId)) {
                for (Subject course : student.getCourses()) {
                    System.out.println("Enter course name: ");
                    String courseName = scanner.nextLine();
                    try {
                        if (course.getName().equals(courseName)) {
                            Double totalMarks = 0.0;
                            for (Mark mark : course.getMarks()) {
                                totalMarks += mark.getMarks();
                            }
                            Double average = totalMarks / (course.getMarks().size());

                            System.out.println("The average of marks is " + average);
                        } else {
                            System.out.println("Student does not exist");
                        }

                    } catch (Exception e) {
                        System.out.println("Invalid marks");
                    }
                }
            }
        }
    }
}
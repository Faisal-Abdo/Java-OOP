package OOPSchoolSystem.Services;

import OOPSchoolSystem.Entities.Mark;
import OOPSchoolSystem.Entities.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubjectService {
    static Scanner scanner = new Scanner(System.in);

    public static Subject addSubject(Boolean isTeacher) {

        Subject subject = new Subject();
        System.out.println("Enter Subject Name: ");
        String name = scanner.nextLine();
        subject.setName(name);
        System.out.println("Enter Credit hours");
        Short creditHours = scanner.nextShort();
        subject.setCreditHours(creditHours);
        if (!isTeacher) {
            List<Mark> marks = MarkService.addMarks();
            subject.setMarks(marks);
        }

        return subject;
    }

    public static List<Subject> addSubjects(Boolean isTeacher) {
        Boolean exitFlag = true;
        List<Subject> subjectsList = new ArrayList<>();
        while (exitFlag) {
            System.out.println("Enter Subject? Y/N");
            String newDataEntry = scanner.nextLine();
            if (newDataEntry.equalsIgnoreCase("y")) {
                subjectsList.add(SubjectService.addSubject(isTeacher));
            } else if (newDataEntry.equalsIgnoreCase("n")) {
                exitFlag = false;
            } else {
                System.out.println("Invalid input");
            }
        }
        return subjectsList;
    }
}
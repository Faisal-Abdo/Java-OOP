package OOPSchoolSystem.Services;

import OOPSchoolSystem.Entities.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
public class DummyDataService {
    static School school = new School();
    static Student student = new Student();
    static Subject subject = new Subject();
    static Mark mark = new Mark();
    static Teacher teacher = new Teacher();
    static Library library = new Library();
    static Book book = new Book();

    public static List<School> dummyDataService() {
        List<School> listOfSchools = new ArrayList<>();

        school.setName("Tabarak");
        school.setAddress("Hail South");

        library.setName("Qalhat");

        List<Book> listOfBooks = new ArrayList<>();

        book.setName("Meditations");
        book.setAuthor("Kim Jong Un");
        book.setId("272j");
        book.setYearOfPublishing("1993");
        book.setAvailable(true);

        listOfBooks.add(book);

        library.setBooks(listOfBooks);

        school.setLibrary(library);

        List<Student> listOfStudents = new ArrayList<>();

        student.setName("Saeed");
        student.setId("292a");
        student.setGrade("A");
        student.setAge((short) 14);

        List<Subject> listOfSubjects = new ArrayList<>();

        subject.setName("Physics");
        subject.setCreditHours((short) 3);

        List<Mark> listOfMarks = new ArrayList<>();

        mark.setGrade("B");
        mark.setTitle("Midterm");
        mark.setMarks(8.5);
        mark.setComments("very good student, wish him the best");

        listOfMarks.add(mark);

        student.setCourses(listOfSubjects);

        Mark mark1 = new Mark();
        mark1.setGrade("C+");
        mark1.setTitle("Final");
        mark1.setMarks(25.0);
        mark1.setComments("Good, but needs to work harder");

        listOfMarks.add(mark1);

        subject.setMarks(listOfMarks);

        List<Teacher> listOfTeachers = new ArrayList<>();

        teacher.setName("Abdul");
        teacher.setId("92T");
        teacher.setYearsOfExperience((short) 4);

        Subject subject1 = new Subject();
        subject1.setName("Geography");
        subject1.setCreditHours((short) 3);
        subject1.setMarks(listOfMarks);

        Subject subject2 = new Subject();
        subject2.setName("Social studies");
        subject2.setCreditHours((short) 4);

        List<Subject> listOfTeachersSubject = Arrays.asList(subject1,subject2);

        teacher.setSubjectsExpertiseList(listOfTeachersSubject);

        listOfTeachers.add(teacher);



    }
}
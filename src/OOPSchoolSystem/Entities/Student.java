package OOPSchoolSystem.Entities;

import java.util.List;

public class Student {
    private String id;
    private String name;
    private String grade;
    private Short age;
    private List<Subject> courses;
    private List<Book> assignedBooks;

    public List<Book> getAssignedBooks() {
        return assignedBooks;
    }

    public void setAssignedBooks(List<Book> assignedBooks) {
        this.assignedBooks = assignedBooks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public List<Subject> getCourses() {
        return courses;
    }

    public void setCourses(List<Subject> courses) {
        this.courses = courses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", grade='" + grade + '\'' + ", age=" + age + ", courses=" + courses + '}';
    }
}

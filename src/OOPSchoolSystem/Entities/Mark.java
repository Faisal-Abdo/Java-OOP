package OOPSchoolSystem.Entities;

public class Mark {
    private Double marks;
    private String comments;
    private String grade;
    private String title;

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "marks=" + marks +
                ", comments='" + comments + '\'' +
                ", grade='" + grade + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

package ex1;

import java.io.Serializable;
import java.util.Objects;

public class Student extends Person implements Comparable, Serializable {
    private boolean stipend;
    private double averageScore;
    private int numberOfTheRecordBook;

    private static final long SerialVersionUID = 1L;


    /*
    * 1 - lastName за зростанням
    * 2 - lastName за спаданням
    * 3 - age за зростанням
    * 4 - age за спаданням
    * 5 - averageScore за зростанням
    * 6 - averageScore за спаданням
    * */
    private static int sortParam;

    public Student(String firstName, String lastName, boolean sex, int age,
                   boolean stipend, double averageScore, int numberOfTheRecordBook) {
        super(firstName, lastName, sex, age);
        this.stipend = stipend;
        this.averageScore = averageScore;
        this.numberOfTheRecordBook = numberOfTheRecordBook;
    }

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Student() {
    }

    public boolean isStipend() {
        return stipend;
    }

    public void setStipend(boolean stipend) {
        this.stipend = stipend;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public int getNumberOfTheRecordBook() {
        return numberOfTheRecordBook;
    }

    public void setNumberOfTheRecordBook(int numberOfTheRecordBook) {
        this.numberOfTheRecordBook = numberOfTheRecordBook;
    }

    public static int getSortParam() {
        return sortParam;
    }

    public static void setSortParam(int sortParam) {
        Student.sortParam = sortParam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return  this.getFirstName().equals(student.getFirstName()) &&
                this.getLastName().equals(student.getLastName()) &&
                this.getSex() == student.getSex() &&
                this.getAge() == student.getAge() &&
                this.stipend == student.stipend &&
                Double.compare(student.averageScore, this.averageScore) == 0 &&
                this.numberOfTheRecordBook == student.numberOfTheRecordBook;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stipend, averageScore, numberOfTheRecordBook);
    }

    @Override
    public void showInfo() {
        System.out.println("Student{" +
                "firstName=" + getFirstName() +
                ", lastName=" + getLastName() +
                ", sex=" + (getSex() ? "male" : "female") +
                ", age=" + getAge() +
                ", stipend=" + stipend +
                ", averageScore=" + averageScore +
                ", numberOfTheRecordBook=" + numberOfTheRecordBook +
                '}');
    }


    @Override
    public String toString() {
        return "Student{" +
                "firstName=" + getFirstName() +
                ", lastName=" + getLastName() +
                ", sex=" + (getSex() ? "male" : "female") +
                ", age=" + getAge() +
                ", stipend=" + stipend +
                ", averageScore=" + averageScore +
                ", numberOfTheRecordBook=" + numberOfTheRecordBook +
                "}\n";
    }

    @Override
    public int compareTo(Object o) {
        if (o == null) {
            return -1;
        }
        Student student = (Student) o;

        switch (sortParam) {
            case 1:
                return this.getLastName().compareToIgnoreCase(student.getLastName());
            case 2:
                return -(this.getLastName().compareToIgnoreCase(student.getLastName()));
            case 3:
                return this.getAge() - student.getAge();
            case 4:
                return student.getAge() - this.getAge();
            case 5:
                return (int) (this.averageScore - student.getAverageScore());
            case 6:
                return (int) -(this.averageScore - student.getAverageScore());
            default:
                return 0;
        }
    }
}

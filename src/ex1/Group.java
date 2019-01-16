package ex1;

import java.io.Serializable;
import java.util.*;

public class Group implements Voenkom, Serializable, Cloneable {

    private int numberOfGroup;
    private Student[] studentsList;

    private static final long SerialVersionUID = 1L;


    public Group(int numberOfGroup) {
        this.numberOfGroup = numberOfGroup;
        studentsList = new Student[10];
    }

    public Group() {
        studentsList = new Student[10];
    }

    public int getNumberOfGroup() {
        return numberOfGroup;
    }

    public void setNumberOfGroup(int numberOfGroup) {
        this.numberOfGroup = numberOfGroup;
    }

    public Student[] getStudentsList() {
        return studentsList;
    }

    public void addStudentToGroup(Student student) throws ArrayIsFullException {
        if (student == null) {
            System.out.println("This student is null..");
            return;
        }
        boolean isGroupFull = true;
        boolean thisStudentIsAlreadyInTheGroup = false; //для того щоб ми не добавляни 2 раза одного студента
        for (int i = 0; i < studentsList.length; i++) {
            if (studentsList[i] != null) {
                if (studentsList[i].getFirstName().equals(student.getFirstName())
                && studentsList[i].getLastName().equals(student.getLastName())) {
                    thisStudentIsAlreadyInTheGroup = true;
                }
            }
        }
        if (!thisStudentIsAlreadyInTheGroup) {
            for (int i = 0; i < studentsList.length; i++) {
                if (studentsList[i] == null) {
                    isGroupFull = false;
                    studentsList[i] = student;
                    System.out.println(student.getFirstName()+" "+ student.getLastName()+" has added successfully.");
                    break;
                }
            }
            if (isGroupFull) throw new ArrayIsFullException();
        }
        else
            System.out.println("This student is already in the group.");

    }

    public static Student createStudent(){
        Scanner in = new Scanner(System.in);
        Student student = new Student();

        try {
            System.out.print("Input first name: ");
            student.setFirstName(in.nextLine());
            System.out.print("Input last name: ");
            student.setLastName(in.nextLine());
            System.out.print("Input sex: ");
            student.setSex(in.nextBoolean());
            System.out.print("Input age: ");
            student.setAge(in.nextInt());
            System.out.print("Is get stipend: ");
            student.setStipend(in.nextBoolean());
            System.out.print("Input average score: ");
            student.setAverageScore(in.nextDouble());
            System.out.print("Input number of the record book: ");
            student.setNumberOfTheRecordBook(in.nextInt());
        }catch (InputMismatchException e) {
            System.out.println("Error adding student.");
            return null;
        }

        return student;
    }

    public void deleteStudentFromGroup(Student student) {
        if (student != null) {
            boolean thereAreNoThisStudentInGroup = false;
            for (int i = 0; i < studentsList.length; i++) {
                if (studentsList[i] != null) {
                    if (studentsList[i].getFirstName().equals(student.getFirstName())
                            && studentsList[i].getLastName().equals(student.getLastName())) {
                        thereAreNoThisStudentInGroup = true;
                        studentsList[i] = null;
                        System.out.println(student.getFirstName() + " " + student.getLastName() + " has deleted from group.");
                    }
                }
            }
            if (!thereAreNoThisStudentInGroup) {
                System.out.println("Such a student is not in the group.");
            }
        }
    }

    public void deleteStudentByIndex(int index) {
        if (index >= 1 && index <= 10) {
            if (studentsList[index-1] != null){
                Student student = studentsList[index-1];
                studentsList[index-1] = null;
                System.out.println(student +" is delete from the "+ index +" place in the group.");
            }
            else
                System.out.println("This place is empty.");
        }
        else
            System.out.println("No such place in the group.");
    }

    public Student getStudentByLastName(String lastName) {
        for (Student aStudentsList : studentsList) {
            try {
                if (aStudentsList.getLastName().equals(lastName)) {
                    return aStudentsList;
                }
            } catch (NullPointerException e) {
            }
        }
        System.out.println("Such a student is not in the group.");
        return null;
    }

    public void sortStudent(int paremetr) {
        if (paremetr >= 1 && paremetr <= 6) {
            Student.setSortParam(paremetr);
            Arrays.sort(studentsList, Comparator.nullsLast(Student::compareTo));
        }
    }

    @Override
    public Student[] getAdultMaleStudents() {
        int lengthAdultStudents = 0;
        for (int i = 0; i < studentsList.length; i++) {
            try {
                if (studentsList[i].getAge() >= 18 && studentsList[i].getSex())
                    lengthAdultStudents++;
            }catch (NullPointerException e){
            }
        }

        Student[] adultStudents = new Student[lengthAdultStudents];

        int index = 0;
        for (int i = 0; i < studentsList.length; i++) {
            try {
                if (studentsList[i].getAge() >= 18 && studentsList[i].getSex()) {
                    adultStudents[index] = studentsList[i];
                    index++;
                    System.out.println(index);
                }
            }catch (NullPointerException e){
            }
        }

        return adultStudents;
    }

    public void showInfo() {
        System.out.println("Group{\n");
        for (int i = 0; i < studentsList.length; i++) {
            if (studentsList[i] != null) {
                System.out.println(studentsList[i]);
            }
        }
        System.out.println("}");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return this.numberOfGroup == group.numberOfGroup &&
                Arrays.equals(this.studentsList, group.studentsList);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(numberOfGroup);
        result = 31 * result + Arrays.hashCode(studentsList);
        return result;
    }

    @Override
    protected Object clone(){
        try {
            return (Group) super.clone();
        }
        catch (CloneNotSupportedException e){
            return null;
        }
    }

    @Override
    public String toString() {

        return "Group{\n"+ Arrays.toString(studentsList) +"}";
    }

}

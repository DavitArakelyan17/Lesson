package model;

import java.util.Objects;

public class Student implements Comparable<Student>{
    private String fullName;
    private int age;
    private String studentID;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + fullName + '\'' +
                ", age=" + age +
                ", studentID='" + studentID + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(fullName, student.fullName) && Objects.equals(studentID, student.studentID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, age, studentID);
    }

    @Override
    public int compareTo(Student o) {
        int result = this.getFullName()
                .compareToIgnoreCase(o.getFullName());

        if (result == 0) {
            return this.getStudentID().compareTo(o.getStudentID());
        }

        return result;
    }
}
import model.Student;

import java.io.IOException;
import java.util.ArrayList;
import service.StudentService;

public class StudentTest {
    public static void main(String[] args) throws IOException {
        Student student1 = new Student();
        student1.setFullName("Davit Arakelyan");
        student1.setAge(22);
        student1.setStudentID("AD202205092");

        Student student2 = new Student();
        student2.setFullName("Roland Mkhitaryan");
        student2.setAge(22);
        student2.setStudentID("RM202205093");

        Student student3 = new Student();
        student3.setFullName("Petik Harutyunyan");
        student3.setAge(23);
        student3.setStudentID("PH202105000");

        Student student4 = new Student();
        student4.setFullName("Artyom Mkrtchyan");
        student4.setAge(23);
        student4.setStudentID("AM202104999");

        Student student5 = new Student();
        student5.setFullName("Karapet Balagozyan");
        student5.setAge(22);
        student5.setStudentID("KB202205093");



        ArrayList<Student> students = new ArrayList<>();

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        StudentService.createSortedStudentFile(students, "students.txt");
    }
}

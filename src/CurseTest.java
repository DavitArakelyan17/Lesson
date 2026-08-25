import model1.Course;

public class CurseTest {
    public static void main(String[] args) {

        Course course1 = new Course();
        course1.setId(1);
        course1.setTitle("ROI Management");
        course1.setInstructor("Poxos Poxosyan");
        course1.setCategory("BUSINESS");
        course1.setDuration(105);
        course1.setLevel("AMATEUR");
        course1.setRating(4);
        course1.setPrice(7500);
        course1.setMaxStudents(150);
        course1.setActive(true);


        Course course2 = new Course();
        course2.setId(2);
        course2.setTitle("UI/UX Design");
        course2.setInstructor("Petros Poxosyan");
        course2.setCategory("DESIGN");
        course2.setDuration(75);
        course2.setLevel("BEGINNER");
        course2.setRating(5);
        course2.setPrice(5000);
        course2.setMaxStudents(250);
        course2.setActive(false);


        Course course3 = new Course();
        course3.setId(3);
        course3.setTitle("CyberSecurity course");
        course3.setInstructor("Martiros Poxosyan");
        course3.setCategory("PROGRAMMING");
        course3.setDuration(115);
        course3.setLevel("ADVANCED");
        course3.setRating(5);
        course3.setPrice(10000);
        course3.setMaxStudents(300);
        course3.setActive(true);


        Course course4 = new Course();
        course4.setId(4);
        course4.setTitle("Learning French Together");
        course4.setInstructor("Hratsin Poxosyan");
        course4.setCategory("LANGUAGE");
        course4.setDuration(250);
        course4.setLevel("ADVANCED");
        course4.setRating(5);
        course4.setPrice(9500);
        course4.setMaxStudents(350);
        course4.setActive(true);

        course1.printCourseInfo();

    }
}

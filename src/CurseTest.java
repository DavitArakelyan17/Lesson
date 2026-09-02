import model1.Course;
import service.CourseService;

import java.util.Scanner;

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
        course4.setDuration(40);
        course4.setLevel("ADVANCED");
        course4.setRating(5);
        course4.setPrice(490);
        course4.setMaxStudents(350);
        course4.setActive(true);

        //course1.printCourseInfo();
        CourseService service = new CourseService();
        //Task1
        service.isWithinTheBudget(course1, 15000);
        System.out.println("1*****************************");
        //Task2
        Course [] courses = {course1, course2, course3, course4};
        service.getBetterCourse(courses);
        System.out.println("2*****************************");
        //Task3
        service.canStudentEnroll(course2, 17, 10000, 4);
        System.out.println("3*****************************");
        //Task4
        service.calculateFinalPrice(course1, 7500, 45);
        System.out.println("4*****************************");
        //Task5
        System.out.println("5*****************************");
        //Task6
        Course[] courses1 = {course1, course2, course3, course4};
        double diff = service.getPriceDifference(courses, 1, 3);
        System.out.println("6*****************************");
        //Task7
        service.canGetSpecialOffer(course1,true,2,3.5,5000);
        System.out.println("7*****************************");
        //Task8
        service.calculateGroupPrice(course1,15,5000);
        System.out.println("8*****************************");
        //Task9
        Course best = service.getCheaperCourse(course1, course3);
        if (best != null) {
            System.out.println("Recommended course: " + best.getTitle());
        } else {
            System.out.println("No active course available.");
        }
        System.out.println("9*****************************");
        //Task10
        service.isSuitable(course4, "4",6500,75);
        System.out.println("10*****************************");
        //Task11
        service.calculateScore(course4, 10, 5);
        System.out.println("11*****************************");
        Course course = new Course();
        course.printCourseInfo();



        boolean isActive = true;
        while (isActive){
            System.out.println("+_+_+_+_+_+_+_+_+_+_+_+_+_MENU+_+_+_+_+_+_+_+_+_+_+_+_+_+_");
            System.out.println("1: Create Course");
            System.out.println("2: Give The Course Info");
            System.out.println("3: Check Whether your budget corresponds to course");
            System.out.println("4: Course is Available for Enrollment");
            System.out.println("5. Check Discounts and Final Price");
            System.out.println("6: Special Offers check");
            System.out.println("7: EXIT ");
            System.out.println("+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+");

            Scanner sc = new Scanner(System.in);

            int menuChoice = sc.nextInt();

            switch (menuChoice) {
                case 1:
                    course = service.CreateCourse();
                    break;

                case 2:
                    service.printCourseInfo(course);
                    break;

                case 3:
                    System.out.print("Enter your max budget: ");
                    double maxBudget = sc.nextDouble();
                    boolean withinBudget = service.isWithinTheBudget(course, maxBudget);
                    break;

                case 4:
                    System.out.print("Enter your age: ");
                    int studentAge = sc.nextInt();
                    System.out.print("Enter your budget: ");
                    double studentBudget = sc.nextDouble();
                    boolean canEnroll = service.canStudentEnroll(course, studentAge, studentBudget, course.getRating());
                    break;

                case 5:
                    System.out.print("Enter discount percentage: ");
                    double discountPercentage = sc.nextDouble();
                    double finalPrice = service.calculateFinalPrice(course, course.getPrice(), discountPercentage);
                    break;

                case 6:
                    System.out.print("Is the student premium? (true/false): ");
                    boolean isPremiumStudent = sc.nextBoolean();
                    System.out.print("How many courses taken previously? ");
                    int previouslyCoursesTaken = sc.nextInt();
                    boolean specialOffer = service.canGetSpecialOffer(course, isPremiumStudent, previouslyCoursesTaken, course.getRating(), course.getPrice());
                    break;

                case 7:
                    isActive = false;
                    break;

                default:
                    System.out.println("Invalid Input, Please Try Again");
            }
        }






    }
}

package service;

import model1.Course;

import java.sql.SQLOutput;

public class CourseService {




    public void printCourseInfo(Course course){
        System.out.println("Course ID:" + " " + course.getId());
        System.out.println("Course Title:" + " " + course.getTitle());
        System.out.println("Course Instructor:" + " " + course.getInstructor());
        System.out.println("Course Category:" + " " + course.getCategory());
        System.out.println("Course Duration:" + " " + course.getDuration());
        System.out.println("Course Level:" + " " + course.getLevel());
        System.out.println("Course Rating:" + " " + course.getRating());
        System.out.println("Course Price:" + " " +  course.getPrice() + "$");
        System.out.println("Course Student's Amount:" + " " +  course.getMaxStudents());
        System.out.println("Course Active Status:" + " " + (course.isActive() ? "Yes" : "No"));
    }

    public void printAllCourses(Course [] courses){
        for (Course c : courses){
            printCourseInfo(c);
            System.out.println();
        }
    }


    //Task1
    double maxBudget;
    public boolean isWithinTheBudget(Course course, double maxBudget){
        if (course.getPrice() <= maxBudget && course.isActive()){
            System.out.println("This Course is Available for you");
            return true;

        }else{
            System.out.println("This Course is not Available for you");
            return false;
        }
    }

    //Task2
    public double getBetterCourse(Course [] courses){
        Course best = courses[0];
        for (int i = 0; i < courses.length; i++) {
        Course current = courses[i];
        if (current.getRating() > best.getRating()){
            best = current;
         } else if (current.getRating() == best.getRating() && current.getPrice() < best.getPrice()) {
            best = current;
            
         }
        }
        System.out.println("Best course: " + " " + best.getTitle() + " " + " (Rating: " + best.getRating() + ", Price: " + best.getPrice()  +"$" + ")");
        return best.getRating();
    }

    //Task3
    double studentBudget;
    public boolean canStudentEnroll(Course course, int studentAge, double studentBudget, double rating){
        if (course.isActive() && studentBudget >= course.getPrice() && studentAge >= 16 && course.getRating() >= 3.0){
            System.out.println("Yes The Student is Ready to Enroll");
            return true;
        }else {
            System.out.println("No The student Can't Enroll");
            return false;
        }
    }

    //Task4
    double discountPercentage;
    public double calculateFinalPrice(Course course, double price, double discountPercentage){
        double discountedPrice = (course.getPrice() * discountPercentage) / 100;
        course.getPrice();
        if(discountPercentage < 0 || discountPercentage > 50){
            System.out.println("The initial price: " + " " + course.getPrice()+ "$");
        }else {
            System.out.println("The Discounted Price is:" + " " + discountedPrice + "$");
        }
        return price;
    }

    //Task5



    //Task6
        public double getPriceDifference(Course[] courses, int index1, int index2) {
            double difference = courses[index1].getPrice() - courses[index2].getPrice();
            System.out.println("The price difference between courses is: " + difference);
            return difference;
        }

     //Task7
    boolean isPremiumStudent;
    int previouslyCoursesTaken;
    public boolean canGetSpecialOffer(Course course, boolean isPremiumStudent, int previouslyCoursesTaken, double rating, double price){
        if (isPremiumStudent == true && previouslyCoursesTaken >= 2){
            System.out.println("The Student can get the Special Offer");
            return true;
        } else if (rating >= 4.5 && price > 1000) {
            System.out.println("The Student can get The Special Offer");
            return true;
        }else{
            return false;
        }
    }

    //Task8
    int studentCount;
    public double calculateGroupPrice(Course course, int studentCount, double price){
       double totalPrice =  course.getPrice() * studentCount;
       if (studentCount >= 5){
           double dtp1 = (totalPrice * 10)/100;
           System.out.println("Total Final Price is:" + " " + dtp1);
       } else if (studentCount >= 10) {
           double dtp2 = (totalPrice * 20)/100;
           System.out.println("Total Final Price is:" + " " + dtp2);
       }
       return price;
    }

    //Task9
    public Course getCheaperCourse(Course course1, Course course2) {
        boolean active1 = course1.isActive();
        boolean active2 = course2.isActive();

        if (active1 && active2) {
            return (course1.getPrice() <= course2.getPrice()) ? course1 : course2;
        } else if (active1) {

            return course1;
        } else if (active2) {

            return course2;
        } else {

            return null;
        }
    }

    //Task10
    String requiredLevel;
    double maxPrice;
    int maxDuration;

    public boolean isSuitable(Course course, String requiredLevel, double maxPrice, int maxDuration){
        if(course.getLevel() == requiredLevel && course.getPrice() <= maxPrice && course.getDuration() <= maxDuration && course.isActive()){
            System.out.println("The Course is Suitable");
            return true;
        }else{
            System.out.println("The Course is not Suitable");
            return false;
        }
    }

    //Task11
    double ratingWeight;
    double priceWeight;
    public double calculateScore(Course course, double ratingWeight, double priceWeight){
        double score = course.getRating() * ratingWeight;
        if(course.getPrice() < 500){
            priceWeight++;
        } else if (course.isActive() == true) {
            double sca = score + 10;
        } else if (course.getDuration() < 50) {
            double sca1 = score + 5;
        }
        System.out.println(score);
        return score;
    }




}

package model1;

public class Course {
    private int id;
    private String title;
    private String instructor;
    private String category;
    private int duration;
    private String level;
    private double rating;
    private double price;
    private int maxStudents;
    private boolean active;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id > 0) {
            this.id = id;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.length() >= 3 && title.length() <= 120) {
            this.title = title;
        }
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        if(instructor.length() >=2 && instructor.length() <= 100) {
            this.instructor = instructor;
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if(category.equals("PROGRAMMING") || category.equals("BUSINESS") || category.equals("lANGUAGE") || category.equals("DESIGN")) {
            this.category = category;
        }
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if(duration >= 1 && duration <= 500) {
            this.duration = duration;
        }
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        if(level.equals("BEGINNER") || level.equals("AMATEUR") || level.equals("ADVANCED")) {
        this.level = level;
        }
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        if(rating >= 1 && rating <= 5) {
            this.rating = rating;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price >= 0 && price <= 10000) {
            this.price = price;
        }
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        if(maxStudents >= 1 && maxStudents <= 500) {
            this.maxStudents = maxStudents;
        }
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
            this.active = active;
    }

    public void printCourseInfo(){
        System.out.println("Course ID:" + " " + getId());
        System.out.println("Course Title:" + " " + getTitle());
        System.out.println("Course Instructor:" + " " + getInstructor());
        System.out.println("Course Category:" + " " + getCategory());
        System.out.println("Course Duration:" + " " + getDuration());
        System.out.println("Course Level:" + " " + getLevel());
        System.out.println("Course Rating:" + " " + getRating());
        System.out.println("Course Price:" + " " +  getPrice());
        System.out.println("Course Student's Amount:" + " " +  getMaxStudents());
        System.out.println("Course Active Status:" + " " + (isActive() ? "Yes" : "No"));
    }
}

package service;

import model.Employee;

public class EmployeeService {
    //Task1
    public void printEmployeeInfo(Employee employee){
        System.out.println("ID: " +  employee.getId());
        System.out.println("Name: " + employee.getName());
        System.out.println("Age: " + employee.getAge());
        System.out.println("Salary: " + employee.getSalary());
        System.out.println("Department: " + employee.getDepartment());
        System.out.println("Experience in Years: " + employee.getExperienceInYears());
        System.out.println("Performance: " + employee.getPerformanceScore());
        System.out.println("Status: " + employee.isActive());
    }
    //Task1
    public void printAllEmployees(Employee[] employees){
        for (Employee e: employees){
            printEmployeeInfo(e);
            System.out.println();
        }
    }

    //Task2
    public boolean isSeniorEmployee(int experienceInYears){
        if(experienceInYears >= 5 ){
            System.out.println("The Employee is Senior");
            return true;
        }else {
            System.out.println("The Employee is not Senior");
            return false;
        }
    }

    //Task3
    public void getPerformanceLevel(double performanceScore){
        if(performanceScore >= 90){
            System.out.println("Performance Score is Excellent");
        } else if (performanceScore >=70 && performanceScore < 90) {
            System.out.println("Performance Score is Good");
        } else if ((performanceScore >= 50 && performanceScore < 70)) {
            System.out.println("Performance Score is Average");
        }else {
            System.out.println("Performance Score is Poor");
        }
    }

    //Task4
    public void isEligibleForPromotion(boolean active, int experienceInYears, double performanceScore){
        if(active = true && experienceInYears >= 3 && performanceScore >= 80){
            System.out.println("The Employee is eligible for the promotion");
        }else{
            System.out.println("The Employee is not eligible for the promotion");
        }
    }

    //Task5
    public void calculateAnnualSalary(double salary){
         System.out.println("The Annual Salary of The Employee Is:" + salary * 12);
    }

    //Task6
    public void employeeStatus(boolean active){
        if (active){
            System.out.println("Employee is Active");
        }else{
            System.out.println("Employee is not Active");
        }
    }




}

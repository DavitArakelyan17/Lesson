public class Cars {
    String brand;
    String model;
    int year;
    String color;
    String transmission;
    double engine_size;
    String fuel_type;
    int horse_power;
    double accelaration;
    int mileage;
    boolean engine_on;
    boolean Is_SUV;
    boolean Is_Cabriolet;


    public void printInfo(){
        System.out.println("Brand:" + " " + brand);
        System.out.println("Model:" + " " + model);
        System.out.println("Year:" + " " +  year);
        System.out.println("Color:" + " " +  color);
        System.out.println("Transmission:" + " " +  transmission);
        System.out.println("Engine Capacity:" + " " +  engine_size);
        System.out.println("Fuel Type:" + " " +  fuel_type);
        System.out.println("HorsePower:" + " " +  horse_power);
        System.out.println("0-60mph:" + " " +  accelaration);
        System.out.println("Mileage:" + " " +  mileage);
        System.out.println("Engine On:" + " " + (engine_on ? "Yes" : "No"));
        System.out.println("SUV:" + " " + (Is_SUV ? "Yes" : "No"));
        System.out.println("Cabriolet:" + " " + (Is_Cabriolet ? "Yes" : "No"));


    }

}
